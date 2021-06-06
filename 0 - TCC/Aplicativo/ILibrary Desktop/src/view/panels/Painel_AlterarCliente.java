package view.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import controller.Masks;
import controller.ValidaData;
import model.Cliente;
import model.Localizacao;
import net.miginfocom.swing.MigLayout;
import persist.IGenericDAO;
import persist.JDBCDAO;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Painel_AlterarCliente extends JPanel {

	private JPanel panelButtons;
	
	private JTextField txtRegistro;
	private JTextField txtResponsavel;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtNum;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtNome;
	private JDateChooser txtNascimento;
	
	private JLabel lblResponsavel;
	private JLabel lblCidade;
	private JLabel lblNome;
	private JLabel lblEndereco;
	private JLabel lblNum;
	private JLabel lblCelular;
	private JLabel lblRegistro;
	private JLabel lblBairro;
	private JLabel lblTipoCliente;
	private JLabel lblCep;	
	private JLabel lblTelefone;
	private JLabel lblSexo;
	private JLabel lblComplemento;
	private JLabel lblEmail;
	private JLabel lblNasc;
	
	private JButton btnChecar;
	private JButton btnCancelar;
	private JButton btnAlterar;
		
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipoCliente, cbSexo;
	private JLabel lblSituao;
	private ButtonGroup buttonGroup;
	private JRadioButton rbAtivo;
	private JRadioButton rbDesativo;
	private Double multa_pendente;
	private JLabel lblAsterisco;
	
	private void limparCampos() {
		
		Component[] comp = this.getComponents();
		
		for(Component c : comp) {
			if (c.getClass().getSimpleName().contains("Masks")) {
				((JTextField) c).setText("");
				txtCep.setText("");
				txtTelefone.setText("");
				txtCelular.setText("");
			}
		}
		
		cbSexo.setSelectedItem("-- selecione --");
		cbTipoCliente.setSelectedItem("-- selecione --");
		txtNascimento.setDate(null);
	}
	
	public void desabilitarCampos(boolean opcao) {
		
		Component[] comp = this.getComponents();
		
		if (opcao == true) {
			for (Component c : comp) {
				if (c.getClass().getSimpleName().contains("JTextField") || c.getClass().getSimpleName().contains("Masks")) {
					((JTextField) c).setEnabled(false);
				}
			}
			
			cbSexo.setEnabled(false);
			cbTipoCliente.setEnabled(false);
			txtRegistro.setEnabled(true);
			btnAlterar.setVisible(false);
			txtNascimento.setEnabled(false);
			rbAtivo.setEnabled(false);
			rbDesativo.setEnabled(false);
		} else {
			for (Component c : comp) {
				if (c.getClass().getSimpleName().contains("JTextField") || c.getClass().getSimpleName().contains("Masks")) {
					((JTextField) c).setEnabled(true);
				}
			}
					
			cbSexo.setEnabled(true);
			cbTipoCliente.setEnabled(true);
			txtRegistro.setEnabled(false);
			btnAlterar.setVisible(true);
			txtNascimento.setEnabled(true);
			rbAtivo.setEnabled(true);
			rbDesativo.setEnabled(true);
		}
		
	}
	
	private boolean validarCampos() {
		boolean erro = false;
		
		Component[] comp = this.getComponents();
		for (Component c : comp) {
			if (c.getClass().getSimpleName().contains("JLabel")) {
				((JLabel) c).setForeground(Color.BLACK);
			}
		}
		
		if (txtRegistro.getText().equals("")) {
			lblRegistro.setForeground(Color.RED);
			erro = true;
		}
		
		if (txtNum.getText().equals("")) {
			lblNum.setForeground(Color.RED);
			erro = true;
		}
		
		if (txtEndereco.getText().equals("")) {
			lblEndereco.setForeground(Color.RED);
			erro = true;
		}
				
		if (txtCep.getText().equals("     -   "))  {
			lblCep.setForeground(Color.RED);
			erro = true;
		}
		
		if (txtNome.getText().equals("")) {
			lblNome.setForeground(Color.RED);
			erro = true;
		}
		
		if (cbTipoCliente.getSelectedItem().equals("-- selecione --")) {
			lblTipoCliente.setForeground(Color.RED);
			erro = true;
		}
		
		if (txtNascimento.getDate() == null) {
			lblNasc.setForeground(Color.RED);
			erro = true;
		} else if ((ValidaData.validarData(txtNascimento.getDate()) == false) || (new Date().before(txtNascimento.getDate()))) {
			lblNasc.setForeground(Color.RED);
			erro = true;
		}
				
		if (cbSexo.getSelectedItem().equals("-- selecione --")) {
			lblSexo.setForeground(Color.RED);
			erro = true;
		}
		
		if(erro == true) {
			JOptionPane.showMessageDialog(null, "O cadastro contém campos inválidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
		
		return erro;
	}
	
	private Cliente createClient() {

		Cliente cliente = new Cliente();
		cliente.setRegistro(txtRegistro.getText());
		cliente.setNome(txtNome.getText());
		cliente.setCelular(txtCelular.getText());
		cliente.setCep(txtCep.getText());
		cliente.setTipo(cbTipoCliente.getSelectedItem().toString());
		cliente.setComplemento(txtComplemento.getText());
		cliente.setData_nasc(txtNascimento.getDate());
		cliente.setEmail(txtEmail.getText());
		cliente.setNum_residencia(txtNum.getText());
		cliente.setResponsavel(txtResponsavel.getText());
		cliente.setSexo(cbSexo.getSelectedItem().toString());
		cliente.setTelefone(txtTelefone.getText());
		cliente.setMulta_pendente(multa_pendente);
		if (rbAtivo.isSelected()) {
			cliente.setAtivo(true);
		} else {
			cliente.setAtivo(false);
		}
		Localizacao local = new Localizacao();
		local.setCep(txtCep.getText());
		local.setEndereco(txtEndereco.getText());
		local.setBairro(txtBairro.getText());
		local.setCidade(txtCidade.getText());
		
		cliente.setLocalizacao(local);
		
		return cliente;
		
	}
	
	private void setTextComponent(Cliente cliente) {
		
		txtCelular.setText(cliente.getCelular());
		txtCep.setText(cliente.getCep());
		txtComplemento.setText(cliente.getComplemento());
		txtEmail.setText(cliente.getEmail());
		txtNascimento.setDate(cliente.getData_nasc());;
		txtNome.setText(cliente.getNome());
		txtNum.setText(cliente.getNum_residencia());
		txtResponsavel.setText(cliente.getResponsavel());
		txtTelefone.setText(cliente.getTelefone());
		cbTipoCliente.setSelectedItem(cliente.getTipo());
		cbSexo.setSelectedItem(cliente.getSexo());
		txtEndereco.setText(cliente.getLocalizacao().getEndereco());
		txtBairro.setText(cliente.getLocalizacao().getBairro());
		txtCidade.setText(cliente.getLocalizacao().getCidade());
		multa_pendente = cliente.getMulta_pendente();
		if (cliente.getAtivo() == true) {
			rbAtivo.setSelected(true);
		} else {
			rbDesativo.setSelected(true);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_AlterarCliente() {
			
		this.setSize(1360, 760);
		this.setLayout(new MigLayout("", "[50][87.00][50.00][80.00][50][86.00][60.00][64.00][50][68.00][][83.00][56.00][143.00]", "[45][][25][15][][25][15][][25][15][][25][15][][25][15][][25]"));
		
		lblAsterisco = new JLabel("Os campos com asterisco (*) são de preenchimento obrigatório.");
		lblAsterisco.setVerticalAlignment(SwingConstants.TOP);
		add(lblAsterisco, "cell 1 0 10 1,growx,aligny top");
		
		lblRegistro = new JLabel("Registro *");
		this.add(lblRegistro, "cell 1 1");
		
		txtRegistro = new Masks(15);
		txtRegistro.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtRegistro, "cell 1 2 2 1,grow");
		txtRegistro.setColumns(10);

		btnChecar = new JButton("Checar");
		this.add(btnChecar, "cell 3 2,grow");
		btnChecar.setMnemonic(KeyEvent.VK_C);
		
		lblTipoCliente = new JLabel("Tipo de Cliente *");
		lblTipoCliente.setToolTipText("");
		this.add(lblTipoCliente, "cell 1 4,grow");
		
		lblCep = new JLabel("Cep *");
		this.add(lblCep, "cell 5 4,grow");
		
		lblTelefone = new JLabel("Telefone");
		this.add(lblTelefone, "cell 9 4,grow");
		
		cbTipoCliente = new JComboBox();
		cbTipoCliente.setToolTipText("Selecione um tipo de cliente");
		this.add(cbTipoCliente, "cell 1 5 2 1,grow");
		
		cbTipoCliente.addItem("Cliente");
		cbTipoCliente.addItem("Aluno");
		cbTipoCliente.addItem("Funcionario");
		cbTipoCliente.addItem("Organização");
		cbTipoCliente.addItem("Professor");
		cbTipoCliente.addItem("Outros");
		
		try {
			txtCep = new Masks("#####-###");
			txtCep.setToolTipText("Campo de preenchimento obrigatório");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		txtCep.setText("");
		this.add(txtCep, "cell 5 5,grow");
		txtCep.setColumns(10);
		
		try {
			txtTelefone = new Masks("(##) ####-####");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		this.add(txtTelefone, "cell 9 5 2 1,grow");
		txtTelefone.setColumns(10);
		
		lblNome = new JLabel("Nome *");
		lblNome.setToolTipText("");
		this.add(lblNome, "cell 1 7,grow");
				
		lblEndereco = new JLabel("Endereço *");
		this.add(lblEndereco, "cell 5 7,grow");
		
		lblNum = new JLabel("Nº *");
		this.add(lblNum, "cell 7 7");
		
		lblCelular = new JLabel("Celular");
		this.add(lblCelular, "cell 9 7,grow");
		
		txtNome = new Masks(50);
		txtNome.setToolTipText("Campo de preenchimento obrigatório");
		txtNome.setColumns(10);
		this.add(txtNome, "cell 1 8 3 1,grow");
		
		txtEndereco = new Masks(50);
		txtEndereco.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtEndereco, "cell 5 8 2 1,grow");
		txtEndereco.setColumns(10);
		
		txtNum = new Masks(6);
		txtNum.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtNum, "cell 7 8,grow");
		txtNum.setColumns(10);
		
		try {
			txtCelular = new Masks("(##) #####-####");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		this.add(txtCelular, "cell 9 8 2 1,grow");
		txtCelular.setColumns(10);
		
		lblNasc = new JLabel("Data Nasc. *");
		this.add(lblNasc, "cell 1 10,grow");
				
		lblComplemento = new JLabel("Complemento");
		this.add(lblComplemento, "cell 5 10,grow");
		
		lblEmail = new JLabel("Email");
		this.add(lblEmail, "cell 9 10");
		
		txtNascimento = new JDateChooser();
		txtNascimento.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtNascimento, "cell 1 11,grow");
		txtNascimento.setDateFormatString("dd/MM/yyyy");
		
		txtComplemento = new Masks(30);
		this.add(txtComplemento, "cell 5 11 2 1,grow");
		txtComplemento.setColumns(10);
		
		txtEmail = new Masks(50);
		this.add(txtEmail, "cell 9 11 3 1,grow");
		txtEmail.setColumns(10);
		
		panelButtons = new JPanel();
		this.add(panelButtons, "cell 13 12 1 6,grow");
		panelButtons.setLayout(new MigLayout("", "[120]", "[35][35][35]"));
		
		btnAlterar = new JButton("Alterar");
		panelButtons.add(btnAlterar, "cell 0 1,grow");
		btnAlterar.setVisible(false);
		btnAlterar.setMnemonic(KeyEvent.VK_A);
		
		btnAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (validarCampos() != true) {
					
					Cliente clienteAlterar = createClient();
					
					JDBCDAO<Localizacao, String> jdbcLocal = new JDBCDAO<Localizacao, String>(Localizacao.class);
					if (jdbcLocal.read(txtCep.getText()) != null) {
						jdbcLocal.update(clienteAlterar.getLocalizacao(), txtCep.getText());
					} else {
						jdbcLocal.create(clienteAlterar.getLocalizacao());
					}
					
					JDBCDAO<Cliente, String> jdbcCliente = new JDBCDAO<Cliente, String>(Cliente.class);
					jdbcCliente.update(clienteAlterar, txtRegistro.getText());
					JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					limparCampos();
					desabilitarCampos(true);	
					
				}
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		panelButtons.add(btnCancelar, "cell 0 2,grow");
		btnCancelar.setMnemonic(KeyEvent.VK_N);
		
		lblSexo = new JLabel("Sexo *");
		this.add(lblSexo, "cell 1 13,grow");
		
		lblBairro = new JLabel("Bairro");
		this.add(lblBairro, "cell 5 13,grow");
		
		lblSituao = new JLabel("Situação");
		add(lblSituao, "cell 9 13");
		
		cbSexo = new JComboBox();
		cbSexo.setToolTipText("Selecione uma opção");
		this.add(cbSexo, "cell 1 14 2 1,growx");
		
		cbSexo.addItem("-- selecione --");
		cbSexo.addItem("Masculino");
		cbSexo.addItem("Feminino");
		
		txtBairro = new Masks(40);
		this.add(txtBairro, "cell 5 14 2 1,grow");
		txtBairro.setColumns(10);
				
		rbAtivo = new JRadioButton("Ativado");
		add(rbAtivo, "cell 9 14");
		
		rbDesativo = new JRadioButton("Desativado");
		add(rbDesativo, "cell 10 14");
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rbAtivo);
		buttonGroup.add(rbDesativo);
		
		lblResponsavel = new JLabel("Responsável");
		this.add(lblResponsavel, "cell 1 16,grow");
				
		lblCidade = new JLabel("Cidade");
		this.add(lblCidade, "cell 5 16,grow");
		
		txtResponsavel = new Masks(50);
		this.add(txtResponsavel, "cell 1 17 3 1,grow");
		txtResponsavel.setColumns(10);
		
		txtCidade = new Masks(40);
		this.add(txtCidade, "cell 5 17 2 1,grow");
		txtCidade.setColumns(10);
		
		desabilitarCampos(true);
		
		btnChecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = new JDBCDAO<Cliente, String>(Cliente.class).read(txtRegistro.getText());
				if (cliente != null) {
					setTextComponent(cliente);
					desabilitarCampos(false);
				} else {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
					
			}
			
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				limparCampos();
				desabilitarCampos(true);				
			}
		});	
		
		
		txtCep.addKeyListener(new KeyAdapter() {	
			String cep = null;
			@Override
			public void keyTyped(KeyEvent evt) {
				
				String texto = txtCep.getText().replaceAll(" ", "").replaceAll("-", "") + evt.getKeyChar();

				if(texto.length() == 8) {
					cep = texto.substring(0, 5) + "-" + texto.substring(5);
				}

					txtEndereco.setText("");
					txtBairro.setText("");
					txtCidade.setText("");
		
				if((cep != null) && (cep.length() == 9)) {
					try {

						IGenericDAO<Localizacao, String> jdbcLoc = new JDBCDAO<Localizacao, String>(Localizacao.class);
						Localizacao local = (Localizacao) jdbcLoc.read(cep);
						if (local != null) {
							txtEndereco.setText(local.getEndereco());
							txtBairro.setText(local.getBairro());
							txtCidade.setText(local.getCidade());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}		
			}		
		});
	}
}
