package view.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Masks;
import model.Localizacao;
import model.Operador;
import net.miginfocom.swing.MigLayout;
import persist.IGenericDAO;
import persist.JDBCDAO;

@SuppressWarnings("serial")
public class Painel_NovoOperador extends JPanel {

	private JPanel panelButtons;
	
	private JLabel lblPrivilegio;
	private JLabel lblRegistro;
	private JLabel lblCep;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblEndereco;
	private JLabel lblNum;
	private JLabel lblCelular;
	private JLabel lblBairro;
	private JLabel lblSenha;
	private JLabel lblCidade;
	private JLabel lblConfirmarSenha;
	
	private JTextField txtRegistro;
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtNum;
	private JTextField txtCelular;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cbPrivilegio;
	
	private JPasswordField pwSenha;
	private JPasswordField pwConfSenha;
		
	private JButton btnSalvar;
	private JButton btnLimpar;

	private void limparCampos() {
		
		Component[] comp = this.getComponents();
		for(Component c : comp) {
			if (c.getClass().getSimpleName().contains("JTextField") || c.getClass().getSimpleName().contains("Masks")) {
				((JTextField) c).setText("");
			}
		}

		cbPrivilegio.setSelectedItem("-- selecione --");
		pwSenha.setText("");
		pwConfSenha.setText("");	
	}
	
	@SuppressWarnings("deprecation")
	private boolean validarDados() {
		boolean erro = false;
		
		Component[] comp = this.getComponents();
		for(Component c : comp) {
			if (c.getClass().getSimpleName().contains("JLabel")) {
				((JLabel) c).setForeground(Color.BLACK);
			}
		}
		
		pwSenha.setForeground(Color.BLACK);
		pwConfSenha.setForeground(Color.BLACK);
		
		cbPrivilegio.setForeground(Color.BLACK);
		
		if (cbPrivilegio.getSelectedItem().equals("-- selecione --")) {
			lblPrivilegio.setForeground(Color.RED);
			erro = true;
		}
		
		if(txtRegistro.getText().equals("")) {
			lblRegistro.setForeground(Color.RED);
			erro = true;
		}
		
		if(new JDBCDAO<Operador, String>(Operador.class).read(txtRegistro.getText()) != null) {
			lblRegistro.setForeground(Color.RED);
			erro = true;
		}
		
		if(txtCep.getText().equals("     -   ")) {
			lblCep.setForeground(Color.RED);
			erro = true;
		}
		
		if(txtNome.getText().equals("")) {
			lblNome.setForeground(Color.RED);
			erro = true;
		}
		
		if(!pwSenha.getText().equals(pwConfSenha.getText())) {
			lblSenha.setForeground(Color.RED);
			lblConfirmarSenha.setForeground(Color.RED);
			erro = true;
		}
		
		return erro;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_NovoOperador() {
		
		this.setLayout(new MigLayout("", "[50][87.00][79.00][35.00][50][70][60.00][43.00][82.00][136.00]", "[45][][20][15][][25][15][][25][15][][25][15][][25][15][][25]"));
		
		lblPrivilegio = new JLabel("Privilégio *");
		this.add(lblPrivilegio, "cell 1 1,grow");

		cbPrivilegio = new JComboBox();
		cbPrivilegio.setToolTipText("Selecione uma opção");
		this.add(cbPrivilegio, "cell 1 2 2 1,grow");
		
		cbPrivilegio.addItem("-- selecione --");
		cbPrivilegio.addItem("Atendente");
		cbPrivilegio.addItem("Administrador");
		
		lblRegistro = new JLabel("Registro *");
		this.add(lblRegistro, "cell 1 4,grow");
		
		lblCidade = new JLabel("Cidade");
		this.add(lblCidade, "cell 6 4,grow");
		
		txtRegistro = new Masks(15);
		txtRegistro.setToolTipText("Verifique se já não existe um operador com o mesmo registro.\nCampo de preenchimento obrigatório");
		this.add(txtRegistro, "cell 1 5 2 1,grow");
		txtRegistro.setColumns(10);
				
		txtCidade = new Masks(40);
		this.add(txtCidade, "cell 6 5 2 1,grow");
		txtCidade.setColumns(10);
		
		lblNome = new JLabel("Nome *");
		this.add(lblNome, "cell 1 7,grow");
		
		lblTelefone = new JLabel("Telefone");
		this.add(lblTelefone, "cell 6 7,grow");
				
		txtNome = new Masks(50);
		txtNome.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtNome, "cell 1 8 3 1,grow");
		txtNome.setColumns(10);
		
		try {
			txtTelefone = new Masks("(##) ####-####");
		} catch (ParseException e3) {
			e3.printStackTrace();
		}
		
		this.add(txtTelefone, "cell 6 8,grow");
		txtTelefone.setColumns(10);
		
		lblCep = new JLabel("Cep *");
		this.add(lblCep, "cell 1 10,grow");
		
		lblCelular = new JLabel("Celular");
		this.add(lblCelular, "cell 6 10,grow");
		
		try {
			txtCep = new Masks("#####-###");
			txtCep.setToolTipText("Campo de preenchimento obrigatório");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		txtCep.setText("");
		this.add(txtCep, "cell 1 11,grow");
		txtCep.setColumns(10);
		
		try {
			txtCelular = new Masks("(##) #####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		this.add(txtCelular, "cell 6 11,grow");
		txtCelular.setColumns(10);
		
		lblEndereco = new JLabel("Endereço");
		this.add(lblEndereco, "cell 1 13,grow");
		
		lblNum = new JLabel("Nº");
		this.add(lblNum, "cell 4 13");
		
		lblSenha = new JLabel("Senha");
		this.add(lblSenha, "cell 6 13");
		
		txtEndereco = new Masks(50);
		this.add(txtEndereco, "cell 1 14 3 1,grow");
		txtEndereco.setColumns(10);
		
		txtNum = new Masks(6);
		this.add(txtNum, "cell 4 14,grow");
		txtNum.setColumns(10);
				
		pwSenha = new JPasswordField();
		this.add(pwSenha, "cell 6 14 2 1,grow");
		
		panelButtons = new JPanel();
		this.add(panelButtons, "cell 9 14 1 4,grow");
		panelButtons.setLayout(new MigLayout("", "[120]", "[35][35]"));
		
		btnSalvar = new JButton("Salvar");
		panelButtons.add(btnSalvar, "cell 0 0,grow");
		btnSalvar.setMnemonic(KeyEvent.VK_S);
		
		btnLimpar = new JButton("Limpar");
		panelButtons.add(btnLimpar, "cell 0 1,grow");
		btnLimpar.setMnemonic(KeyEvent.VK_L);
		
		lblBairro = new JLabel("Bairro");
		this.add(lblBairro, "cell 1 16,grow");
		
		lblConfirmarSenha = new JLabel("Confirmar Senha");
		this.add(lblConfirmarSenha, "cell 6 16");
		
		txtBairro = new Masks(40);
		this.add(txtBairro, "cell 1 17 2 1,grow");
		txtBairro.setColumns(10);
		
		pwConfSenha = new JPasswordField();
		this.add(pwConfSenha, "cell 6 17 2 1,grow");
		
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if (validarDados() == false) {
					
					Operador operador = new Operador();
					operador.setRegistro(txtRegistro.getText());
					operador.setPrivilegio(cbPrivilegio.getSelectedItem().toString());
					operador.setSenha(pwSenha.getText());
					operador.setCelular(txtCelular.getText());
					operador.setCep(txtCep.getText());
					operador.setNome(txtNome.getText());
					operador.setNum(txtNum.getText());
					operador.setTelefone(txtTelefone.getText());
					
					Localizacao local = new Localizacao();
					local.setCep(txtCep.getText());
					local.setBairro(txtBairro.getText());
					local.setCidade(txtCidade.getText());
					local.setEndereco(txtEndereco.getText());
						
					IGenericDAO<Localizacao, String> jdbcLocal = new JDBCDAO<Localizacao, String>(Localizacao.class);
					if (jdbcLocal.read(txtCep.getText()) == null) {
						jdbcLocal.create(local);
					} else {
						jdbcLocal.update(local, txtCep.getText());
					}
					
					JDBCDAO<Operador, String> jdbcOperador = new JDBCDAO<Operador, String>(Operador.class);
					jdbcOperador.create(operador);
						
					limparCampos();
				} else {
					JOptionPane.showMessageDialog(null, "Há campos inválidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				limparCampos();
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
