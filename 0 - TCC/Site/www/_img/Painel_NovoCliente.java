package view.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import controller.Masks;
import controller.ValidaData;
import model.Cliente;
import model.Localizacao;
import net.miginfocom.swing.MigLayout;
import persist.IGenericDAO;
import persist.JDBCDAO;

@SuppressWarnings("serial")
public class Painel_NovoCliente extends JPanel {

	private JPanel panelBotoes;
	
	private JLabel lblTipoCliente;
	private JLabel lblNome;
	private JLabel lblCep;
	private JLabel lblEndereco;
	private JLabel lblSexo;
	private JLabel lblNum;
	private JLabel lblNasc;
	private JLabel lblBairro;
	private JLabel lblTelefone;
	private JLabel lblCelular;
	private JLabel lblComplemento;
	private JLabel lblEmail;
	private JLabel lblResponsavel;
	private JLabel lblCidade;
	private JLabel lblRegistro;
	
	private JTextField txtRegistro;
	private JTextField txtNome;
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
	
	private JDateChooser txtNascimento;

	@SuppressWarnings("rawtypes")
	private JComboBox cbTipoCliente;
	@SuppressWarnings("rawtypes")
	private JComboBox cbSexo;
	
	private JButton btnLimpar;
	private JButton btnSalvar;
	
	private void limparCampos() {
				
		Component[] comp = this.getComponents();
		for (Component c : comp) {
			if (c.getClass().getSimpleName().contains("JTextField") || c.getClass().getSimpleName().contains("Masks")) {
				((JTextField) c).setText(null);
			}
		}
		
		cbSexo.setSelectedItem("-- selecione --");
		cbTipoCliente.setSelectedItem("-- selecione --");
		txtNascimento.setDate(null);
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
		
		if (new JDBCDAO<Cliente, String>(Cliente.class).read(txtRegistro.getText()) != null) {
			lblRegistro.setForeground(Color.RED);
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
		
		if (cbSexo.getSelectedItem().equals("-- selecione --")) {
			lblSexo.setForeground(Color.RED);
			erro = true;
		}
		
		if (txtNascimento.getDate() == null) {
			lblNasc.setForeground(Color.RED);
			erro = true;
		} else if ((ValidaData.validarData(txtNascimento.getDate()) == false) || (new Date().before(txtNascimento.getDate()))) {
			lblNasc.setForeground(Color.RED);
			erro = true;
		}
		
		if(erro == true) {
			JOptionPane.showMessageDialog(null, "O cadastro contém campos inválidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
		}

		return erro;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_NovoCliente() {
		
		this.setSize(1370, 760);
		
		this.setLayout(new MigLayout("", 
			"[50][87.00][50.00][35.00][50][86.00][60.00][64.00][50][157.00][83.00][117.00][]", 
			"[45][][20][15][][25][15][][25][15][][25][15][][25][15][][25]"));
		
		lblTipoCliente = new JLabel("Tipo de Cliente *");
		this.add(lblTipoCliente, "cell 1 1,grow");
		
		cbTipoCliente = new JComboBox();
		cbTipoCliente.setToolTipText("Selecione um tipo de cliente");
		this.add(cbTipoCliente, "cell 1 2 2 1,grow");
		
		cbTipoCliente.addItem("-- selecione --");
		cbTipoCliente.addItem("Cliente");
		cbTipoCliente.addItem("Aluno");
		cbTipoCliente.addItem("Funcionario");
		cbTipoCliente.addItem("Organização");
		cbTipoCliente.addItem("Professor");
		cbTipoCliente.addItem("Outros");
		
		lblRegistro = new JLabel("Registro *");
		this.add(lblRegistro, "cell 1 4,grow");
		
		lblCep = new JLabel("Cep *");
		this.add(lblCep, "cell 5 4,grow");
		
		lblTelefone = new JLabel("Telefone");
		this.add(lblTelefone, "cell 9 4,grow");
		
		try {
			txtCep = new Masks("#####-###");
			txtCep.setToolTipText("Campo de preenchimento obrigatório");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		txtRegistro = new Masks(15);
		txtRegistro.setToolTipText("Verifique se ja não existe um cliente com o mesmo registro.\nCampo de preenchimento obrigatório");
		this.add(txtRegistro, "cell 1 5 3 1,grow");
		txtRegistro.setColumns(10);
		txtCep.setText("");
		this.add(txtCep, "cell 5 5,grow");
		txtCep.setColumns(10);
		
		try {
			txtTelefone = new Masks("(##) ####-####");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		this.add(txtTelefone, "cell 9 5,grow");
		txtTelefone.setColumns(10);
		
		lblNome = new JLabel("Nome *");
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
		
		this.add(txtCelular, "cell 9 8,grow");
		txtCelular.setColumns(10);
		
		lblSexo = new JLabel("Sexo *");
		this.add(lblSexo, "cell 1 10,grow");
		
		lblComplemento = new JLabel("Complemento");
		this.add(lblComplemento, "cell 5 10,grow");

		lblEmail = new JLabel("Email");
		this.add(lblEmail, "cell 9 10");

		cbSexo = new JComboBox();
		cbSexo.setToolTipText("Selecione uma opção");
		this.add(cbSexo, "cell 1 11 2 1,growx");
		
		cbSexo.addItem("-- selecione --");
		cbSexo.addItem("Masculino");
		cbSexo.addItem("Feminino");

		txtComplemento = new Masks(30);
		this.add(txtComplemento, "cell 5 11 2 1,grow");
		txtComplemento.setColumns(10);
		
		txtEmail = new Masks(50);
		txtEmail.setToolTipText("Exemplo: usuário@provedor.com.br");
		this.add(txtEmail, "cell 9 11 2 1,grow");
		txtEmail.setColumns(10);
		
		panelBotoes = new JPanel();
		this.add(panelBotoes, "cell 12 12 1 6,grow");
		panelBotoes.setLayout(new MigLayout("", "[120]", "[35][35][35]"));
	
		btnSalvar = new JButton("Salvar");
		panelBotoes.add(btnSalvar, "cell 0 0,grow");
		btnSalvar.setMnemonic(KeyEvent.VK_S);
		
		btnLimpar = new JButton("Limpar");
		panelBotoes.add(btnLimpar, "cell 0 1,grow");
		btnLimpar.setMnemonic(KeyEvent.VK_L);
				
		lblNasc = new JLabel("Data Nasc. *");
		this.add(lblNasc, "cell 1 13,grow");
				
		lblBairro = new JLabel("Bairro");
		this.add(lblBairro, "cell 5 13,grow");
		
		txtNascimento = new JDateChooser();
				
		txtNascimento.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtNascimento, "cell 1 14,grow");
		txtNascimento.setDateFormatString("dd/MM/yyyy");
		
		txtBairro = new Masks(40);
		this.add(txtBairro, "cell 5 14 2 1,grow");
		txtBairro.setColumns(10);
		
		lblResponsavel = new JLabel("Responsável");
		this.add(lblResponsavel, "cell 1 16,grow");
				
		lblCidade = new JLabel("Cidade");
		this.add(lblCidade, "cell 5 16,grow");
		
		txtResponsavel = new JTextField();
		this.add(txtResponsavel, "cell 1 17 3 1,grow");
		txtResponsavel.setColumns(10);
		
		txtCidade = new Masks(50);
		this.add(txtCidade, "cell 5 17 2 1,grow");
		txtCidade.setColumns(10);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Localizacao localizacao = new Localizacao();
				localizacao.setCep(txtCep.getText());
				localizacao.setEndereco(txtEndereco.getText());
				localizacao.setBairro(txtBairro.getText());
				localizacao.setCidade(txtCidade.getText());
				
				Cliente cliente = new Cliente();
				cliente.setRegistro(txtRegistro.getText());
				cliente.setNome(txtNome.getText());
				cliente.setCelular(txtCelular.getText());
				cliente.setCep(txtCep.getText());
				cliente.setTipo(cbTipoCliente.getSelectedItem().toString());
				cliente.setComplemento(txtComplemento.getText());
				cliente.setData_nasc(txtNascimento.getDate());
				cliente.setNum_residencia(txtNum.getText());
				cliente.setResponsavel(txtResponsavel.getText());
				cliente.setSexo(cbSexo.getSelectedItem().toString());
				cliente.setTelefone(txtTelefone.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setLocalizacao(localizacao);
						
				boolean teste = validarCampos();
				
				if (teste == false) {
					IGenericDAO<Localizacao, String> jdbcLoc = new JDBCDAO<Localizacao, String>(Localizacao.class);
					
					if (((Localizacao) jdbcLoc.read(cliente.getCep())) == null) {
						jdbcLoc.create(localizacao);
					} else {
						jdbcLoc.update(localizacao, localizacao.getCep());
					}
					
					JDBCDAO<Cliente, String> jdbcCliente = new JDBCDAO<Cliente, String>(Cliente.class);
					jdbcCliente.create(cliente);
					limparCampos();
					
				}
				
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
		
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				limparCampos();
				
			}
		});
	}
}
