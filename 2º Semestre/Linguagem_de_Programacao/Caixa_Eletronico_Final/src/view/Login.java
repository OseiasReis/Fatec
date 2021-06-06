package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Validacao;
import reg.Cadastrar;

//import cadastro.Cadastro_Inte;
//import metodos.Validacao;
//import principal.Menu;
//import principal.Senha;

public class Login extends JFrame{
	
	private JMenuBar barMenu;
	private JMenu opcSistema;
	private JMenuItem menuSair;
	private JLabel lblLogin, lblSenha,lblTitulo,lblLogo, esqueciMS;
	private JTextField txtLogin, txtSenha;
	private JButton btnLogar, btnCadastrar;
	//Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	
	//ImageIcon icone = new ImageIcon("Imagens/si.png");
	
	public Login() {
		super(".::CAIXA::.");
		
		barMenu = new JMenuBar();
		esqueciMS = new JLabel("Esqueceu sua senha?"); esqueciMS.setFont(new Font("Arial",Font.ITALIC, 10)); esqueciMS.setForeground(Color.BLUE);
		//menuCadastrar = new JMenuItem("Cadastrar");
		menuSair = new JMenuItem("Sair");
		opcSistema = new JMenu("Sistema");
		lblLogin = new JLabel("Login: ");
		lblSenha = new JLabel("Senha: ");
		//lblLogo = new JLabel(new ImageIcon("src/images/logo.png"));
		txtLogin = new JTextField();                lblLogin.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		txtSenha = new JPasswordField();            lblSenha.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		btnLogar = new JButton("Logar");	        btnLogar.setFont(new Font("Script MT Bold", Font.BOLD, 16));		
		btnCadastrar = new JButton("Cadastrar");    btnCadastrar.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		Color azul = new Color(1, 190, 254);
		lblTitulo = new JLabel("Caixa Eletronico"); lblTitulo.setFont(new Font("Script MT Bold", Font.BOLD, 60)); lblTitulo.setForeground(azul);
		lblLogo = new JLabel();                     lblLogo.setIcon(new ImageIcon("Imagens/logo.png"));
		
		Container tela = getContentPane();
		tela.setLayout(null);
		
		esqueciMS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		esqueciMS.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent a) {
				esqueciMS.setText("Esqueceu sua senha?");
				//new Senha();
			}
			public void mouseEntered(MouseEvent arg0) {
				esqueciMS.setText("<html><u>" + esqueciMS.getText() + "</u></html>");
			}
			public void mouseExited(MouseEvent arg0) {
				esqueciMS.setFont(new Font("Arial",Font.ITALIC, 10));
				esqueciMS.setText("Esqueceu sua senha?");
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent arg0) {
			}			
		});
		super.setJMenuBar(barMenu);  
		barMenu.add(opcSistema);
			opcSistema.add(menuSair);				
				menuSair.addActionListener(new ActionListener() {   
				    public void actionPerformed(ActionEvent e) {  
				    	System.exit(0);  
				    }  
				});
		
		tela.add(lblTitulo);
		lblTitulo.setBounds(30, 20, 450, 50);
		tela.add(lblLogo);
		lblLogo.setBounds(50, 100, 196, 169);
		
		tela.add(lblLogin);
		lblLogin.setBounds(280, 100, 100, 30);
		tela.add(txtLogin);
		txtLogin.setBounds(280, 130, 170, 30);
		
		tela.add(lblSenha);
		lblSenha.setBounds(280, 180, 100, 30);
		tela.add(txtSenha);
		txtSenha.setBounds(280, 210, 170, 30);
		
		tela.add(btnLogar);
		btnLogar.setBounds(220, 280, 100, 40);
		btnLogar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String login = txtLogin.getText().trim();
				String senha = txtSenha.getText().trim();
				if(login.equals("") || senha.equals("")){
					JOptionPane.showMessageDialog(null,"É necessario que preencha todos os campos de login!","Erro",JOptionPane.ERROR_MESSAGE);
				}else{
					Validacao objVal = new Validacao();
					File arquivo = new File("Pessoa/" + login + ".txt");
					boolean validou = false;
					try {
						validou = objVal.verificarRegistro(login, senha);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if(validou == false)
					{
						JOptionPane.showMessageDialog(null, "Login ou senha invalido(s)!", "Erro", JOptionPane.ERROR_MESSAGE);
					}else{
						
						//Main m = new Main(login);				
					}
				}
				
			}
		});
		
		tela.add(btnCadastrar);
		btnCadastrar.setBounds(340, 280, 140, 40);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setSize(750, 625);
				lblTitulo.setVisible(false);
				txtLogin.setVisible(false);
				txtSenha.setVisible(false);
				lblLogin.setVisible(false);
				lblSenha.setVisible(false);
				btnLogar.setVisible(false);
				btnCadastrar.setVisible(false);
				lblLogo.setVisible(false);
				esqueciMS.setVisible(false);
				Cadastrar c = new Cadastrar();
				tela.add(c);
			}
		});
		
		tela.add(esqueciMS);
		esqueciMS.setBounds(280, 240, 120, 20);
	}
	public static void main(String args[]) {
		Login l = new Login();
		l.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		l.setResizable(false);
		l.setSize(500, 400);
		l.setVisible(true);
		l.setLocation(300, 100);
	}
}
