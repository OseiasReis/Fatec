package Cadastro;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class Cadastro_Inte extends JFrame{
	
	private JLabel lblTitulo = new JLabel("Cadastrar-se");
	private JLabel lblEmail = new JLabel("*E-mail:");
	private JLabel lblSenha = new JLabel("*Senha:");
	private JLabel lblSenhaN = new JLabel("*Confirme a Senha:");
	private JLabel lblNome = new JLabel("Nome:");
	private JLabel lblEndereco = new JLabel("Endereço:");
	private JLabel lblBairro = new JLabel("Bairro:");
	private JLabel lblCep = new JLabel("Cep:");
	private JLabel lblCidade = new JLabel("Cidade:");
	private JLabel lblSexo = new JLabel("Sexo:");
	
	private JTextField txtEmail = new JTextField();
	private JTextField txtSenha;
	private JTextField txtSenhaN;
	private JTextField txtNome = new JTextField();
	private JTextField txtEndereco = new JTextField();
	private JTextField txtBairro = new JTextField();
	private JTextField txtCep;
	private JTextField txtCidade = new JTextField();
	
	private JRadioButton[] rbSexo = new JRadioButton[2];
	private ButtonGroup group = new ButtonGroup();
	
	private JButton btnVoltar = new JButton ("Voltar");
	private JButton btnCadastrar = new JButton ("Cadastrar");
	private JButton btnValidar = new JButton ("Validar");
	private JButton btnApagar = new JButton ("Apagar");
	
	public Cadastro_Inte(){
		super (".:Cadastrar:.");
		
		lblTitulo.setFont(new Font("ALGERIAN", Font.BOLD, 26));
		lblTitulo.setForeground(Color.red);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 16));
		lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
		lblSenhaN.setFont(new Font("Arial", Font.BOLD, 16));
		lblNome.setFont(new Font("Arial", Font.BOLD, 16));
		lblEndereco.setFont(new Font("Arial", Font.BOLD, 16));
		lblBairro.setFont(new Font("Arial", Font.BOLD, 16));
		lblCep.setFont(new Font("Arial", Font.BOLD, 16));
		lblCidade.setFont(new Font("Arial", Font.BOLD, 16));
		lblSexo.setFont(new Font("Arial", Font.BOLD, 16));
		
		btnValidar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnApagar.setFont(new Font("Arial", Font.BOLD, 14));
		
		rbSexo[0] = new JRadioButton("Masculino");
		rbSexo[1] = new JRadioButton("Feminino");
		txtSenha = new JPasswordField();
		txtSenhaN = new JPasswordField();
		
		group.add(rbSexo[0]);
		group.add(rbSexo[1]);
		
		Container pane = this.getContentPane();
		pane.setLayout(null);
		
		pane.add(lblTitulo);
		lblTitulo.setBounds(70, 20, 250, 20);
		
		pane.add(lblEmail);
		lblEmail.setBounds(20, 60, 80, 20);
		pane.add(txtEmail);
		txtEmail.setBounds(20, 80, 300, 20);
		
		pane.add(lblSenha);
		lblSenha.setBounds(20, 120, 80, 20);
		pane.add(txtSenha);
		txtSenha.setBounds(20, 140, 300, 20);
		
		pane.add(lblSenhaN);
		lblSenhaN.setBounds(20, 180, 150, 20);
		pane.add(txtSenhaN);
		txtSenhaN.setBounds(20, 200, 300, 20);
		
		pane.add(btnValidar);
		btnValidar.setBounds(120, 235, 90, 20);
		btnValidar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String senha = txtSenha.getText();
				String senhaN = txtSenhaN.getText();

				if (txtEmail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Insira um E-mail");
				}
				if(senha.equals(senhaN)){
					JOptionPane.showMessageDialog(null, "Senhas Iguais");
				}else{
					JOptionPane.showMessageDialog(null, "Senhas Diferentes");
				}
			}
		});
		
		pane.add(lblNome);
		lblNome.setBounds(20, 260, 80, 20);
		pane.add(txtNome);
		txtNome.setBounds(20, 280, 300, 20);
		txtNome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtNome.setText(txtNome.getText());
			}
		});
		
		pane.add(lblEndereco);
		lblEndereco.setBounds(20, 320, 80, 20);
		pane.add(txtEndereco);
		txtEndereco.setBounds(20, 340, 300, 20);
		
		pane.add(lblBairro);
		lblBairro.setBounds(20, 380, 80, 20);
		pane.add(txtBairro);
		txtBairro.setBounds(20, 400, 300, 20);
		
		try{
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pane.add(lblCep);
		lblCep.setBounds(20, 440, 80, 20);
		pane.add(txtCep);
		txtCep.setBounds(20, 460, 300, 20);
		
		pane.add(lblCidade);
		lblCidade.setBounds(20, 500, 80, 20);
		pane.add(txtCidade);
		txtCidade.setBounds(20, 520, 300, 20);
		
		pane.add(lblSexo);
		lblSexo.setBounds(20, 560, 80, 20);
		pane.add(rbSexo[0]);
		rbSexo[0].setBounds(20, 580, 100, 20);
		pane.add(rbSexo[1]);
		rbSexo[1].setBounds(120, 580, 100, 20);

		pane.add(btnCadastrar);
		btnCadastrar.setBounds(20, 620, 105, 20);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (txtEmail.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo E-mail deve ser preenchido"); 
				}
				
				if (txtSenha.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo Senha deve ser preenchido"); 
				}
				
				if (txtSenhaN.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo Confirmar Senha deve ser preenchido"); 
				}
				
				String senha = txtSenha.getText();
				String senhaN = txtSenhaN.getText();
				
				if(txtSenha.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Por favor, digite as senha e valide");
				}else if(senha.equals(senhaN)){
					JOptionPane.showMessageDialog(null, "Obrigado " + txtNome.getText() + ", você foi cadastrado!");
				}else{
					JOptionPane.showMessageDialog(null, "Por favor, valide as senhas");
				}
			}
		});
		
		pane.add(btnApagar);
		btnApagar.setBounds(132, 620, 90, 20);
		btnApagar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int Apagar;
				
				Apagar = JOptionPane.showConfirmDialog(null, "Você deseja realmente Apagar?");
				
				if(Apagar == 0){
					txtEmail.setText("");
					txtSenha.setText("");
					txtSenhaN.setText("");
					txtNome.setText("");
					txtEndereco.setText("");
					txtBairro.setText("");
					txtCep.setText("");
					txtCidade.setText("");
				}
			}
		});
		
		pane.add(btnVoltar);
		btnVoltar.setBounds(230, 620, 80, 20);
		btnVoltar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int Voltar;
				
				Voltar = JOptionPane.showConfirmDialog(null, "Você deseja realmente voltar?");
				
				if(Voltar == 0){
					System.exit(0);
				}
			}
		});
	
		this.setSize(350, 690);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}	
	
	public static void main(String args[]){
		Cadastro_Inte CI = new Cadastro_Inte();
	}
}