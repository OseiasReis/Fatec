package view.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import controller.Masks;
import model.Cliente;
import model.Devolucao;
import model.Emprestimo;
import model.Exemplar;
import model.Operador;
import model.Penalidade;
import net.miginfocom.swing.MigLayout;
import persist.IGenericDAO;
import persist.JDBCDAO;
import persist.SerDAO;

@SuppressWarnings("serial")
public class Painel_Devolucao extends JPanel {

	private JLabel lblRegistro;
	private JLabel lblNumEx;

	private JPanel panelInf;

	private JLabel lblNome;
	private JLabel lblNomeResult;
	private JLabel lblClasse;
	private JLabel lblClasseResult;

	private JTextField txtNumEx;
	private JTextField txtRegistro;
	private JButton btnValidar;
	private JButton btnRealizarDevolucao;

	private JTable jtDevolucao;
	private DefaultTableModel modelo;
	private JScrollPane scrollDevolucao;

	private static Cliente eCheck;

	private int atraso = 0;
	private double multa;
	private boolean aplicarmulta = false;

	boolean atrasado = false, cancelar = false;
	String codigoemprestimo = "";
	private JDateChooser txtTerminoMulta;
	private JLabel lblTerminoMulta;

	private Cliente cliente = null;
	private Penalidade penalidade = null;
	
	private Operador operador = null;

	private void carregarTable() throws Exception {

		modelo.setNumRows(0);
		
		ArrayList<Emprestimo> list_emprestimos_devolvidos = (ArrayList<Emprestimo>) ((new JDBCDAO<Emprestimo, String>(Emprestimo.class))
				.readAll("select * from emprestimo where registro_cliente='" + txtRegistro.getText() + "' and devolvido=true"));
		
		String verif_multa;
		String verif_susp;
		for(Emprestimo e : list_emprestimos_devolvidos) {
			Devolucao dev = (Devolucao) new JDBCDAO<Devolucao, String>(Devolucao.class).read(e.getCod_emprestimo());
			
			if(dev.getPreco_multa() == 0) {
				verif_multa = "N/A";
			} else {
				verif_multa = "R$ " + String.format("%.2f", dev.getPreco_multa());
			}
			verif_susp = verificarSuspensao(dev.getCod_emprestimo(), dev.getData_entrega(), dev.getTermino_suspensao());
			modelo.addRow(new Object[] {operador.getRegistro(), e.getCod_exemplar(), e.getData_devolucao(),dev.getData_entrega(), verif_susp, verif_multa});
		}
		
		
		jtDevolucao.removeAll();
		jtDevolucao.repaint();

	}
	
	public boolean validarCampos() {
		boolean erro = false;
		Component[] comp = this.getComponents();
		for (Component c : comp) {
			if (c.getClass().getSimpleName().contains("JLabel")) {
				((JLabel) c).setForeground(Color.BLACK);
			}
		}

		if (txtRegistro.getText().equals("")) {
			erro = true;
			lblRegistro.setForeground(Color.RED);
		}

		if (txtNumEx.getText().equals("")) {
			erro = true;
			lblNumEx.setForeground(Color.RED);
		}

		return erro;
	}
	
	private String verificarSuspensao(String cod_emprestimo, String data_entrega, String term_susp){
		
		if(data_entrega.equals(term_susp))
			term_susp = "N/A";
			
		return term_susp;
	}

	private String capturarData() {
		Date dataAt = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		return sd.format(dataAt).toString();
	}

	private String capturarHora() {
		Date horaAt = new Date();
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		return st.format(horaAt).toString();
	}

	private boolean verificarAtraso(String dtaDevolucao, String dtaEntrega) throws Exception {
		SimpleDateFormat sdFormato = new SimpleDateFormat("dd/MM/yyyy");

		Date dataDevo = (Date) sdFormato.parse(dtaDevolucao);
		Date dataEntrega = (Date) sdFormato.parse(dtaEntrega);

		if (dataEntrega.compareTo(dataDevo) == 1)
			atrasado = true;

		return atrasado;

	}

	private String calcularAtraso(String dtaDevolucao, String dtaEntrega) throws Exception {
		SimpleDateFormat sdFormato = new SimpleDateFormat("dd/MM/yyyy");

		Date dataDevo = (Date) sdFormato.parse(dtaDevolucao);
		Date dataEntrega = (Date) sdFormato.parse(dtaEntrega);

		String numDias = "" + ((dataEntrega.getTime() - dataDevo.getTime()) + 3600000) / 86400000L;

		return numDias;
	}

	private void habilitarComponentes() {
		Component[] comp = this.getComponents();
		for (Component c : comp) {
			if (c.isEnabled() == false) {
				c.setEnabled(true);
			}
		}
		btnValidar.setEnabled(false);
	}

	private void desabilitarComponentes() {
		lblNumEx.setEnabled(false);
		txtNumEx.setEnabled(false);

		btnRealizarDevolucao.setEnabled(false);
		btnValidar.setEnabled(true);

		txtTerminoMulta.setVisible(false);
		lblTerminoMulta.setVisible(false);

		txtRegistro.setEnabled(true);

	}

	private Boolean validarRegistro() {
		boolean verif = false;

		JDBCDAO<Cliente, String> jdbcDao = new JDBCDAO<Cliente, String>(Cliente.class);

		eCheck = (Cliente) jdbcDao.read(txtRegistro.getText());

		if (eCheck != null) {
			lblNomeResult.setText(eCheck.getNome());
			lblClasseResult.setText(eCheck.getTipo());
			verif = true;
		}

		return verif;
	}

	private void apresentarComponentes() {
		panelInf.setVisible(true);
	}

	private void limparCampos() {
		txtNumEx.setText("");
		multa = 0;
		atraso = 0;
		atrasado = false;
	}

	private boolean checarEmprestimo(String codigoExemplar, String registroCliente) {
		ArrayList<Emprestimo> list_empCheck = (ArrayList<Emprestimo>) ((new JDBCDAO<Emprestimo, String>(Emprestimo.class))
				.readAll("select * from emprestimo where registro_cliente='" + registroCliente + "' and cod_exemplar='" + codigoExemplar + "'"));
		
		for(Emprestimo empCheck : list_empCheck){
			if(empCheck.getDevolvido().equals(false)){
				codigoemprestimo = empCheck.getCod_emprestimo();
				return true;
			}
		}

		return false;
	}

	public void alterarDisponibilidade(String codigo_exemplar) {
		Exemplar exemp = new Exemplar();
		JDBCDAO<Exemplar, String> jdbcDao = new JDBCDAO<Exemplar, String>(Exemplar.class);
		exemp = (Exemplar) jdbcDao.read(codigo_exemplar);

		exemp.setEmprestado(false);

		jdbcDao.update(exemp, exemp.getCodigo_Exemplar());

	}

	public void desativarEmprestimo(String registroCliente, String codigoExemplar) {
		ArrayList<Emprestimo> list_empDesat = (ArrayList<Emprestimo>) ((new JDBCDAO<Emprestimo, String>(Emprestimo.class))
				.readAll("select * from emprestimo where registro_cliente='" + registroCliente + "' and cod_exemplar='" + codigoExemplar + "'"));
		
		for(Emprestimo empDesat : list_empDesat){
			if(empDesat.getDevolvido().equals(false)){
				empDesat.setDevolvido(true);
				new JDBCDAO<Emprestimo, String>(Emprestimo.class).update(empDesat, empDesat.getCod_emprestimo());
			}
		}
		
	}

	@SuppressWarnings("deprecation")
	public String calcularTerminoSuspensao(int atraso) {
		IGenericDAO<Penalidade, String> jdbcPenalidade = new SerDAO<Penalidade, String>(Penalidade.class);
		penalidade = jdbcPenalidade.read(null);
		int qtdeDias = Integer.parseInt(penalidade.getDias_suspensao()) * atraso;

		Date dateTermino = new Date();

		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

		dateTermino.setDate(dateTermino.getDate() + qtdeDias);

		return sd.format(dateTermino).toString();
	}

	public boolean verificarData(Date dataCap) {
		Date dataAt = new Date();

		if(dataCap != null){
			if (dataCap.after(dataAt))
				return true;
		}
		return false;
	}

	private double calcularMulta(Double multaAt) {
		JDBCDAO<Cliente, String> jdbcDao = new JDBCDAO<Cliente, String>(Cliente.class);
		cliente = (Cliente) jdbcDao.read(txtRegistro.getText());
		if (cliente.getMulta_pendente().equals(null))
			return multaAt;
		return cliente.getMulta_pendente() + multaAt;
	}

	private void aplicarMulta(double multa) {

		if(multa > 0){
			JDBCDAO<Cliente, String> jdbcDao = new JDBCDAO<Cliente, String>(Cliente.class);
			cliente = (Cliente) jdbcDao.read(txtRegistro.getText());
	
			cliente.setMulta_pendente(multa);
	
			jdbcDao.update(cliente, txtRegistro.getText());
		}
	}

	public Painel_Devolucao(Operador operador) {
		this.operador = operador;
		
		this.setSize(1360, 760);
		this.setLayout(
				new MigLayout("", "[50][80][50.00][80][657.00]", "[45][][25.00][15][][25][27.00][][25][29.00][][25.00][15][][114.00]"));

		lblRegistro = new JLabel("Registro do Cliente *");
		this.add(lblRegistro, "cell 1 1,grow");

		txtRegistro = new Masks(true);
		txtRegistro.setToolTipText("Campo de preenchimento obrigatório");
		txtRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				desabilitarComponentes();
			}
		});

		this.add(txtRegistro, "cell 1 2,grow");
		txtRegistro.setColumns(10);

		btnValidar = new JButton("Validar");
		this.add(btnValidar, "cell 2 2");

		panelInf = new JPanel();
		panelInf.setVisible(false);
		this.add(panelInf, "cell 4 2 1 13,grow");
		panelInf.setLayout(new MigLayout("", "[][589.00]", "[][][][][][][287.00]"));

		lblNome = new JLabel("Nome:");
		panelInf.add(lblNome, "cell 0 1,alignx left");

		lblNomeResult = new JLabel("New Label");
		panelInf.add(lblNomeResult, "cell 1 1");

		lblClasse = new JLabel("Tipo:");
		panelInf.add(lblClasse, "cell 0 3");

		lblClasseResult = new JLabel("New label");
		panelInf.add(lblClasseResult, "cell 1 3");

		modelo = new DefaultTableModel();
		modelo.addColumn("Operador Responsável");
		modelo.addColumn("Código do Exemplar");
		modelo.addColumn("Data para Devolução");
		modelo.addColumn("Data de Entrega");
		modelo.addColumn("Término da Suspensão");
		modelo.addColumn("Preço da Multa");

		jtDevolucao = new JTable(modelo);
		jtDevolucao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		jtDevolucao.getColumnModel().getColumn(0).setPreferredWidth(150);
		jtDevolucao.getColumnModel().getColumn(1).setPreferredWidth(135);
		jtDevolucao.getColumnModel().getColumn(2).setPreferredWidth(165);
		jtDevolucao.getColumnModel().getColumn(3).setPreferredWidth(145);
		jtDevolucao.getColumnModel().getColumn(4).setPreferredWidth(160);
		jtDevolucao.getColumnModel().getColumn(5).setPreferredWidth(140);

		scrollDevolucao = new JScrollPane(jtDevolucao);
		panelInf.add(scrollDevolucao, "cell 0 6 2 1,grow");
		scrollDevolucao.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollDevolucao.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		scrollDevolucao.setViewportView(jtDevolucao);

		lblNumEx = new JLabel("Cod. Exemplar *");
		lblNumEx.setEnabled(false);
		this.add(lblNumEx, "cell 1 5,grow");

		txtNumEx = new Masks(true);
		txtNumEx.setToolTipText("Campo de preenchimento obrigatório");
		txtNumEx.setEnabled(false);
		this.add(txtNumEx, "cell 1 6,grow");
		txtNumEx.setColumns(10);

		btnRealizarDevolucao = new JButton("Realizar Devolução");
		btnRealizarDevolucao.setEnabled(false);

		lblTerminoMulta = new JLabel("Termino da Suspensão:");
		lblTerminoMulta.setVisible(false);
		this.add(lblTerminoMulta, "cell 1 8,grow");

		txtTerminoMulta = new JDateChooser();
		txtTerminoMulta.setVisible(false);
		txtTerminoMulta.setToolTipText("Formato da data (dd/mm/aaaa)");
		txtTerminoMulta.setEnabled(false);
		this.add(txtTerminoMulta, "cell 1 9,grow");

		btnRealizarDevolucao.setFont(new Font("Arial", Font.PLAIN, 15));
		this.add(btnRealizarDevolucao, "cell 1 11");

		btnRealizarDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validarCampos() == false) {

					if (checarEmprestimo(txtNumEx.getText(), txtRegistro.getText()) == true) {

						Devolucao d = new Devolucao();

						Emprestimo e = new Emprestimo();

						e = buscarEmprestimo();

						String data_devolucao = e.getData_devolucao();
						d.setData_entrega(capturarData());
						d.setTermino_suspensao(capturarData());
						d.setPreco_multa(0.0);

						try {
							if (verificarAtraso(data_devolucao, d.getData_entrega()) == true) {
								atraso = Integer.parseInt(calcularAtraso(e.getData_devolucao(), d.getData_entrega()));

								IGenericDAO<Penalidade, String> jdbcPenalidade = new SerDAO<Penalidade, String>(Penalidade.class);
								Penalidade verif_penalidade = jdbcPenalidade.read(null);
								
								if (operador.getPrivilegio().equals("Administrador")) {
									if (!txtTerminoMulta.isVisible()) {

										int confirm = JOptionPane.showConfirmDialog(null,
												"O Cliente possui um atraso de " + atraso + " Dia(s)!\n"
														+ "Data prevista para devolução: " + e.getData_devolucao() + "\n"
														+ "Deseja aplicar suspensão manualmente?",
												"Devolução atrasada", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

										if (confirm == 0) {
											desabilitarComponentes();
											lblTerminoMulta.setVisible(true);
											txtTerminoMulta.setVisible(true);
											btnValidar.setEnabled(false);
											btnRealizarDevolucao.setEnabled(true);
											txtRegistro.setEnabled(false);
											aplicarmulta = true;
										}

										if (confirm == 1
												&& verif_penalidade.getSuspensao_automatica().equals(true)) {
											d.setTermino_suspensao(calcularTerminoSuspensao(atraso));
										}

										if (confirm != 0 && confirm != 1) {
											cancelar = true;
										}

									} else {
										if (verificarData(txtTerminoMulta.getDate()) == true) {
											SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
											d.setTermino_suspensao(sdf.format(txtTerminoMulta.getDate()));
											aplicarmulta = false;
										} else {
											JOptionPane.showMessageDialog(null, "Selecione uma data válida!", "Aviso",
													JOptionPane.WARNING_MESSAGE);
										}
									}
								} else {
									if (verif_penalidade.getSuspensao_manual().equals(true)) {
										if (!txtTerminoMulta.isVisible()) {
											int confirm = JOptionPane.showConfirmDialog(null,
													"O Cliente possui um atraso de " + atraso + " Dia(s)!\n"
															+ "Data prevista para devolução: " + e.getData_devolucao() + "\n"
															+ "Deseja aplicar suspensão manualmente?",
													"Devolução atrasada", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
											
											
											if (confirm == 0) {
												desabilitarComponentes();
												lblTerminoMulta.setVisible(true);
												txtTerminoMulta.setVisible(true);
												btnValidar.setEnabled(false);
												btnRealizarDevolucao.setEnabled(true);
												txtRegistro.setEnabled(false);
												aplicarmulta = true;
											}

											if (confirm == 1
													&& verif_penalidade.getSuspensao_automatica().equals(true)) {
												d.setTermino_suspensao(calcularTerminoSuspensao(atraso));
											}

											if (confirm != 0 && confirm != 1) {
												cancelar = true;
											}

											/*if (verif_penalidade.getSuspensao_automatica().equals(true)) {
												d.setTermino_multa(calcularTerminoSuspensao(atraso));
											}*/
											
										} else {
											if (verificarData(txtTerminoMulta.getDate()) == true) {
												SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
												d.setTermino_suspensao(sdf.format(txtTerminoMulta.getDate()));
												aplicarmulta = false;
											} else {
												JOptionPane.showMessageDialog(null, "Selecione uma data válida!",
														"Aviso", JOptionPane.WARNING_MESSAGE);
											}
										}
									}else{
										if(verif_penalidade.getSuspensao_automatica().equals(true)){
											d.setTermino_suspensao(calcularTerminoSuspensao(atraso));
											JOptionPane.showMessageDialog(null, "Suspensão calculada com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
										}else{
											JOptionPane.showMessageDialog(null, "Suspensão não aplicada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
										}
									}
								}
								atrasado = true;

								if (verif_penalidade.getMulta().equals(true)) {
									d.setPreco_multa(atraso * verif_penalidade.getValor_multa());
									multa = calcularMulta(d.getPreco_multa());
								}
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						if (aplicarmulta == false) {
							if (cancelar == false) {
								d.setCod_emprestimo(e.getCod_emprestimo());

								d.setHora_entrega(capturarHora());
								d.setRegistro_operador(operador.getRegistro());

								IGenericDAO<Devolucao, String> jdbcEmp = new JDBCDAO<Devolucao, String>(
										Devolucao.class);
								jdbcEmp.create(d);
								alterarDisponibilidade(txtNumEx.getText());
								aplicarMulta(multa);
								desativarEmprestimo(txtRegistro.getText(), txtNumEx.getText());

								if(atrasado == false)
									JOptionPane.showMessageDialog(null, "Devolucao realizada sem atraso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
								else
									if(d.getTermino_suspensao().equals(capturarData())){
										if(d.getPreco_multa() > 0)
											JOptionPane.showMessageDialog(null, "Devolucao realizada com atraso de " + atraso + " dias!\nSuspensão não aplicada!"
													+ "\nMulta aplicada no valor de R$" + d.getPreco_multa() + "\nTotal a ser pago pelo cliente: R$" + multa, "Aviso", JOptionPane.INFORMATION_MESSAGE);
										else
											JOptionPane.showMessageDialog(null, "Devolucao realizada com atraso de " + atraso + " dias!\nSuspensão não aplicada!"
												+ "\nMulta não aplicada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
																					
									}else{	
										if(d.getPreco_multa() > 0)
											JOptionPane.showMessageDialog(null, "Devolução realizada com atraso de " + atraso + " dias!\nTérmino da suspensão: " + d.getTermino_suspensao()
											+ "\nMulta aplicada no valor de R$" + d.getPreco_multa() + "\nTotal a ser pago pelo cliente: R$" + multa, "Aviso", JOptionPane.INFORMATION_MESSAGE);
										else
											JOptionPane.showMessageDialog(null, "Devolução realizada com atraso de " + atraso + " dias!\nTérmino da suspensão: " + d.getTermino_suspensao()
											+ "\nMulta não aplicada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
										
									}
								
								/*
								IGenericDAO<Cliente, String> clienteDAO = new JDBCDAO<Cliente,String>(Cliente.class);
								Cliente cliente = new Cliente();
								cliente = clienteDAO.read(txtRegistro.getText());
								cliente.setMulta_pendente(multa);
								clienteDAO.update(cliente, cliente.getRegistro());
								*/
								try {
									carregarTable();
									limparCampos();
									desabilitarComponentes();
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							} else {
								JOptionPane.showMessageDialog(null, "Devolução Cancelada!", "Aviso",
										JOptionPane.INFORMATION_MESSAGE);
								desabilitarComponentes();
								cancelar = false;
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Exemplar não sofreu empréstimo/inexistente!", "Aviso",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "O cadastro contém campos inválidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}

			private Emprestimo buscarEmprestimo() {
				ArrayList<Emprestimo> list_emprestimos = (ArrayList<Emprestimo>) ((new JDBCDAO<Emprestimo, String>(
						Emprestimo.class))
								.readAll("select * from emprestimo where registro_cliente='" + txtRegistro.getText() + "' and devolvido=false and cod_exemplar='" + txtNumEx.getText() + "'"));

				for(Emprestimo e : list_emprestimos){
					return e;
				}
				
				return null;
			}
		});

		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validarRegistro() == true) {
					habilitarComponentes();
					apresentarComponentes();
					try {
						carregarTable();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Registro inexistente!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
	}

}
