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

import controller.Data;
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
public class Painel_Emprestimo extends JPanel {

	private JPanel panelInf;

	private JLabel lblRegistro;
	private JLabel lblNumEx;
	private JLabel lblTempo;
	private JLabel lblNome;
	private JLabel lblNomeResult;
	private JLabel lblClasse;
	private JLabel lblClasseResult;

	private JTextField txtNumEx;
	private JTextField txtRegistro;
	private JButton btnValidar;
	private JButton btnRealizarEmprestimo;
	private JTable jtEmprestimos;
	private DefaultTableModel modelo;
	private JScrollPane scrollEmprestimos;

	private static Cliente eCheck;
	private static Exemplar exCheck;

	private String erro = "";
	private JDateChooser txtTempo;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Boolean multa;
	private Boolean emprestimoSuspenso;
	private Boolean emprestimoMultado;
	
	private Operador operador = null;

	private void carregarTable() {
		int qtdeRegistro = 0;
		modelo.setNumRows(0);

		ArrayList<Emprestimo> list_emprestimos = (ArrayList<Emprestimo>) ((new JDBCDAO<Emprestimo, String>(
				Emprestimo.class))
						.readAll("select * from emprestimo where registro_cliente='" + txtRegistro.getText() + "' and devolvido=false"));

		for (Emprestimo ex : list_emprestimos) {
			if(ex.getDevolvido().equals(false))
				modelo.addRow(new Object[] { ex.getCod_exemplar(), ex.getData_retirada(), ex.getHora_retirada(),
						ex.getData_devolucao() });
			qtdeRegistro++;
		}

		if (qtdeRegistro >= 3) {
		}

		jtEmprestimos.removeAll();
		jtEmprestimos.repaint();

	}

	public Painel_Emprestimo(Operador operador) {

		this.operador = operador;
		
		this.setSize(1360, 760);
		this.setLayout(new MigLayout("", 
			"[50][80.00][50.00][80.00][86.00][60.00][64.00][50][370.00]",
				"[45][][25.00][15][][25][24.00][][24.00][35.00][][27.00][30.00][][25]"));

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
		
		panelInf = new JPanel();
		panelInf.setVisible(false);
		this.add(panelInf, "cell 4 2 5 13,grow");
		panelInf.setLayout(new MigLayout("", "[][528.00,grow]", "[][][][][][][287.00]"));

		lblNome = new JLabel("Nome:");
		panelInf.add(lblNome, "cell 0 1,alignx left");

		lblNomeResult = new JLabel("New Label");
		panelInf.add(lblNomeResult, "cell 1 1");

		lblClasse = new JLabel("Tipo:");
		panelInf.add(lblClasse, "cell 0 3");

		lblClasseResult = new JLabel("New label");
		panelInf.add(lblClasseResult, "cell 1 3");

		modelo = new DefaultTableModel();
		modelo.addColumn("Cod. Exemplar");
		modelo.addColumn("Data de Retirada");
		modelo.addColumn("Hora de Retirada");
		modelo.addColumn("Data para Devoluçao");

		jtEmprestimos = new JTable(modelo);
		jtEmprestimos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		jtEmprestimos.getColumnModel().getColumn(0).setPreferredWidth(149);
		jtEmprestimos.getColumnModel().getColumn(1).setPreferredWidth(155);
		jtEmprestimos.getColumnModel().getColumn(2).setPreferredWidth(155);
		jtEmprestimos.getColumnModel().getColumn(3).setPreferredWidth(165);

		scrollEmprestimos = new JScrollPane(jtEmprestimos);
		panelInf.add(scrollEmprestimos, "cell 0 6 2 1,grow");
		scrollEmprestimos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollEmprestimos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		scrollEmprestimos.setViewportView(jtEmprestimos);

		btnRealizarEmprestimo = new JButton("Realizar Empréstimo");
		btnRealizarEmprestimo.setEnabled(false);
		
		lblNumEx = new JLabel("Cod. Exemplar *");
		lblNumEx.setEnabled(false);
		this.add(lblNumEx, "cell 1 7,grow");

		txtNumEx = new Masks(true);
		txtNumEx.setToolTipText("Campo de preenchimento obrigatório");
		txtNumEx.setEnabled(false);
		this.add(txtNumEx, "cell 1 8,grow");
		txtNumEx.setColumns(10);

		lblTempo = new JLabel("Data para Devolução *");
		lblTempo.setToolTipText("Digitar o valor numérico em dias");
		lblTempo.setEnabled(false);
		this.add(lblTempo, "cell 1 10,grow");

		txtTempo = new JDateChooser();
		txtTempo.setToolTipText("Formato da data (dd/mm/aaaa)");
		this.add(txtTempo, "cell 1 11,grow");
		txtTempo.setEnabled(false);
		btnRealizarEmprestimo.setFont(new Font("Arial", Font.PLAIN, 15));
		this.add(btnRealizarEmprestimo, "cell 1 13");

		verificarConfiguracoes();
		
		btnValidar = new JButton("Validar");
		this.add(btnValidar, "cell 2 2");
		
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificarConfiguracoes();
				if (validarRegistro() == true) {
					apresentarComponentes();
					carregarTable();
					if (liberarEmprestimo() == true) {
						if (verificarEmprestimoPendente() == true) {
							habilitarComponentes();	
						} else {
							JOptionPane.showMessageDialog(null, "Realização de empréstimo cancelada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Realização de empréstimo cancelada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Registro inexistente ou cliente desativado!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		
		btnRealizarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validarCampos() == false) {

					if (verificarExemplar(txtNumEx.getText()) != false) {

						if (verificarData(txtTempo.getDate()) != false) {

							Emprestimo e = new Emprestimo();

							e.setRegistro_cliente(txtRegistro.getText());
							e.setCod_exemplar(txtNumEx.getText());
							e.setRegistro_operador(operador.getRegistro());

							e.setData_retirada(capturarData());
							e.setHora_retirada(capturarHora());

							e.setData_devolucao(sdf.format(txtTempo.getDate()));

							IGenericDAO<Emprestimo, String> jdbcEmp = new JDBCDAO<Emprestimo, String>(Emprestimo.class);
							jdbcEmp.create(e);
							JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

							atualizarDisponibilidade();

							carregarTable();
							txtNumEx.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Impossível realizar empréstimo com esta data!", 
									"Aviso", JOptionPane.WARNING_MESSAGE);
							lblTempo.setForeground(Color.RED);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Exemplar " + erro, "Aviso", JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "O cadastro contém campos inválidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
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

		lblTempo.setForeground(Color.BLACK);

		return erro;
	}

	public boolean verificarExemplar(String exemplar) {
		boolean verif = true;

		JDBCDAO<Exemplar, String> jdbcDao = new JDBCDAO<Exemplar, String>(Exemplar.class);

		exCheck = (Exemplar) jdbcDao.read(exemplar);

		if (exCheck == null) {
			verif = false;
			erro = "inexistente";
		} else {
			if (exCheck.getEmprestado().equals(true) || !exCheck.getDisponibilidade().equals("Empréstimo")) {
				verif = false;
				erro = "indisponível para empréstimo";
			}
		}

		return verif;
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
		lblTempo.setEnabled(false);
		txtTempo.setEnabled(false);

		btnRealizarEmprestimo.setEnabled(false);
		btnValidar.setEnabled(true);

	}

	public Boolean validarRegistro() {
		boolean verif = false;

		JDBCDAO<Cliente, String> jdbcDao = new JDBCDAO<Cliente, String>(Cliente.class);

		eCheck = (Cliente) jdbcDao.read(txtRegistro.getText());

		if (eCheck != null) {
			if(!eCheck.getAtivo() == false){
				lblNomeResult.setText(eCheck.getNome());
				lblClasseResult.setText(eCheck.getTipo());
				verif = true;
			}
		}

		return verif;
	}

	public void apresentarComponentes() {
		panelInf.setVisible(true);
	}

	public void atualizarDisponibilidade() {
		Exemplar ex = new Exemplar();

		JDBCDAO<Exemplar, String> jdbcDaoEx = new JDBCDAO<Exemplar, String>(Exemplar.class);

		ex = (Exemplar) jdbcDaoEx.read(txtNumEx.getText());

		ex.setEmprestado(true);

		jdbcDaoEx.update(ex, txtNumEx.getText());

	}

	public boolean verificarData(Date dataCap) {
		Date dataAt = new Date();

		if(dataCap != null){
			if (dataCap.after(dataAt))
				return true;
		}
		return false;
	}

	private boolean liberarEmprestimo() {
		boolean continuar = false;
		Date dataAt = new Date();
		String termino_suspencao = "";
		Double valor_multa = 0.00;

		JDBCDAO<Cliente, String> jdbcDaoCli = new JDBCDAO<Cliente, String>(Cliente.class);
		Cliente cliente = (Cliente) jdbcDaoCli.read(txtRegistro.getText());
		valor_multa = cliente.getMulta_pendente();

		ArrayList<Emprestimo> list_emprestimos = (ArrayList<Emprestimo>) ((new JDBCDAO<Emprestimo, String>(Emprestimo.class))
				.readAll("select * from emprestimo where registro_cliente='" + txtRegistro.getText() + "' && devolvido=true"));
		
		for (Emprestimo e : list_emprestimos){
			ArrayList<Devolucao> list_devolucoes = (ArrayList<Devolucao>) ((new JDBCDAO<Devolucao, String>(Devolucao.class))
					.readAll("select * from devolucao where cod_emprestimo='" + e.getCod_emprestimo() + "'"));
	
			for (Devolucao d : list_devolucoes) {
				if (Data.convertDate(d.getTermino_suspensao()).compareTo(dataAt) > 0) {
					dataAt = Data.convertDate(d.getTermino_suspensao());
					termino_suspencao = d.getTermino_suspensao();
				}
			}
		}
		

		if (!termino_suspencao.equals("")) {
			if (emprestimoSuspenso.equals(false) && operador.getPrivilegio().equals("Atendente")) {
				if ((valor_multa > 0) && (multa.equals(true))) {
						JOptionPane.showMessageDialog(null,
								"O Cliente possui suspensão e multa pendente!\n" + "Término da suspensão: "
										+ termino_suspencao + "\n" + "Valor da multa: " + valor_multa,
								"Aviso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"O Cliente possui suspensão pendente!\n" + "Término da suspensão: " + termino_suspencao,
							"Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				if (emprestimoMultado.equals(false) && operador.getPrivilegio().equals("Atendente")) {
					if ((valor_multa > 0) && (multa.equals(true))) {
						JOptionPane.showMessageDialog(null,
								"O Cliente possui suspensão e multa pendente!\n" + "Término da suspensão: "
										+ termino_suspencao + "\n" + "Valor da multa: " + valor_multa + "\n",
								"Aviso", JOptionPane.INFORMATION_MESSAGE);
					}else{
						int resp = JOptionPane.showConfirmDialog(null,
								"O Cliente possui suspensão pendente!\n" + "Término da suspensão: "
										+ termino_suspencao + "\n"
										+ "Deseja continuar mesmo assim?",
								"Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (resp == 0) {
							continuar = true;
						}
					}
				} else {
					if ((valor_multa > 0) && (multa.equals(true))) {
						int resp = JOptionPane.showConfirmDialog(null,
								"O Cliente possui suspensão e multa pendente!\n" + "Término da suspensão: "
										+ termino_suspencao + "\n" + "Valor da multa: " + valor_multa + "\n"
										+ "Deseja continuar mesmo assim?",
								"Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (resp == 0) {
							continuar = true;
						}			
					}else{
						int resp = JOptionPane.showConfirmDialog(null,
								"O Cliente possui suspensão pendente!\n" + "Término da suspensão: "
										+ termino_suspencao + "\n"
										+ "Deseja continuar mesmo assim?",
								"Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (resp == 0) {
							continuar = true;
						}			
					}
				}				
			}
		} else {
			if ((valor_multa > 0) && (!multa.equals(false))) {
				if (emprestimoMultado.equals(false) && operador.getPrivilegio().equals("Atendente")) {					
					JOptionPane.showMessageDialog(null,
							"O Cliente possui multa pendente!\n" + "Valor da multa: " + valor_multa + "\n", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					int resp = JOptionPane.showConfirmDialog(null,
							"O Cliente possui multa pendente!\n" + "Valor da multa: " + valor_multa + "\n"
									+ "Deseja continuar mesmo assim?",
							"Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (resp == 0) {
						continuar = true;
					}
				}
			} else {
				continuar = true;
			}
		}
		return continuar;
	}

	public boolean verificarEmprestimoPendente() {
		boolean continuar = false;
		ArrayList<Emprestimo> list_emprestimos = (ArrayList<Emprestimo>) ((new JDBCDAO<Emprestimo, String>(
				Emprestimo.class))
						.readAll("select * from emprestimo where registro_cliente='" + txtRegistro.getText() + "'"));
		Date dataAt2 = new Date();
		String prazo_determinado = "";
		String cod_exemplar = "";
		for (Emprestimo e : list_emprestimos) {
			if (Data.convertDate(e.getData_devolucao()).compareTo(dataAt2) < 0 && e.getDevolvido().equals(false)) {
				dataAt2 = Data.convertDate(e.getData_devolucao());
				prazo_determinado = e.getData_devolucao();
				cod_exemplar = e.getCod_exemplar();
			}
		}

		if (!prazo_determinado.equals("")) {
			if (emprestimoSuspenso.equals(false) && operador.getPrivilegio().equals("Atendente")) {				
				JOptionPane.showMessageDialog(null,
						"O cliente possui exemplar(es) com prazo de devolução\nultrapassado e ainda não realizou a devolução!\nCódigo do Exemplar: " + cod_exemplar,
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
			} else {				
				int opcao = JOptionPane.showConfirmDialog(null,
						"O cliente possui exemplar(es) com prazo de devolução\nultrapassado e ainda não realizou a devolução.\nCódigo do Exemplar: " + cod_exemplar + "\nDeseja continuar mesmo assim?",
						"Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (opcao == 0) {
					continuar = true;
				}
			}
		} else {
			continuar= true;
		}
		return continuar;
	}

	public void verificarConfiguracoes() {
		IGenericDAO<Penalidade, String> jdbcPenalidade = new SerDAO<Penalidade, String>(Penalidade.class);
		Penalidade penalidade = jdbcPenalidade.read(null);
		multa = penalidade.getMulta();
		emprestimoMultado = penalidade.getEmprestar_multado();
		emprestimoSuspenso = penalidade.getEmprestar_suspenso();
	}
}
