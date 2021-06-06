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
	
	private JLabel lblTitulo = new JLabel("Cadastrar");
	private JLabel lblEmail = new JLabel("E-mail:");
	private JLabel lblSenha = new JLabel("Senha:");
	private JLabel lblSenhaN = new JLabel("Confirme a Senha:");
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
		
		rbSexo[0] = new JRadioButton("Masculino");
		rbSexo[1] = new JRadioButton("Feminino");
		txtSenha = new JPasswordField();
		txtSenhaN = new JPasswordField();
		
		group.add(rbSexo[0]);
		group.add(rbSexo[1]);
		
		Container pane = this.getContentPane();
		pane.setLayout(null);
		
		pane.add(lblTitulo);
		lblTitulo.setBounds(100, 20, 180, 20);
		
		pane.add(lblEmail);
		lblEmail.setBounds(20, 60, 80, 20);
		
		pane.add(txtEmail);
		txtEmail.setBounds(20, 80, 300, 20);
		txtEmail.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (txtEmail.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo deve ser preenchido"); 
				}
			}
		});
		
		pane.add(lblSenha);
		lblSenha.setBounds(20, 120, 80, 20);
		
		pane.add(txtSenha);
		txtSenha.setBounds(20, 140, 300, 20);
		
		pane.add(lblSenhaN);
		lblSenhaN.setBounds(20, 180, 150, 20);
		
		pane.add(txtSenhaN);
		txtSenhaN.setBounds(20, 200, 300, 20);
		
		pane.add(lblNome);
		lblNome.setBounds(20, 240, 80, 20);
		
		pane.add(txtNome);
		txtNome.setBounds(20, 260, 300, 20);
		
		pane.add(lblEndereco);
		lblEndereco.setBounds(20, 300, 80, 20);
		
		pane.add(txtEndereco);
		txtEndereco.setBounds(20, 320, 300, 20);
		
		pane.add(lblBairro);
		lblBairro.setBounds(20, 360, 80, 20);
		
		pane.add(txtBairro);
		txtBairro.setBounds(20, 380, 300, 20);
		
		try{
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pane.add(lblCep);
		lblCep.setBounds(20, 420, 80, 20);
		
		pane.add(txtCep);
		txtCep.setBounds(20, 440, 300, 20);
		
		pane.add(lblCidade);
		lblCidade.setBounds(20, 480, 80, 20);
		
		pane.add(txtCidade);
		txtCidade.setBounds(20, 500, 300, 20);
		
		pane.add(lblSexo);
		lblSexo.setBounds(20, 540, 80, 20);
		
		pane.add(rbSexo[0]);
		rbSexo[0].setBounds(20, 560, 100, 20);
		
		pane.add(rbSexo[1]);
		rbSexo[1].setBounds(120, 560, 100, 20);

		pane.add(btnCadastrar);
		btnCadastrar.setBounds(40, 600, 95, 20);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Obrigado, você foi cadastrado!");
			}
		});
		
		pane.add(btnVoltar);
		btnVoltar.setBounds(200, 600, 80, 20);
		btnVoltar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int Sair;
				
				Sair = JOptionPane.showConfirmDialog(null, "Você deseja realmente sair?");
				
				if(Sair == 0){
					System.exit(0);
				}
			}
		});
		
		this.setSize(350, 715);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}	
	
	public static void main(String args[]){
		Cadastro_Inte CI = new Cadastro_Inte();
	}
}
