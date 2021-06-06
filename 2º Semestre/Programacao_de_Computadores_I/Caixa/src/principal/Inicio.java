package principal;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import cadastro.*;
import metodos.Validacao;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import metodos.Validacao;


public class Inicio extends javax.swing.JFrame {
	
	private JMenuBar barMenu = new JMenuBar();
	
	private JMenu opcSistema = new JMenu("Sistema");
	
	private JMenuItem menuSair = new JMenuItem("Sair");
	private JMenuItem menuCadastrar = new JMenuItem("Cadastrar");
	
	private JLabel lblLogin, lblSenha,lblTitulo,lblLogo;
	
	private JLabel esqueciMS = new JLabel("Esqueceu sua senha?");
	
	private JTextField txtLogin, txtSenha;
	private JButton btnLogar, btnCadastrar;
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	
	ImageIcon icone = new ImageIcon("Imagens/si.png");
	
	public Inicio(){
		super(".::Aplicativo CAIXA::.");
		
		lblLogin = new JLabel("Login: ");
		lblSenha = new JLabel("Senha: ");
		lblLogo = new JLabel();				lblLogo.setIcon(new javax.swing.ImageIcon("Imagens/logo.png")); 	
		txtLogin = new JTextField();        lblLogin.setFont(new Font("Arial", Font.BOLD, 16));
		txtSenha = new JPasswordField();    lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogar = new JButton("Logar");	btnLogar.setFont(new Font("Arial", Font.BOLD, 16));		
		btnCadastrar = new JButton("Cadastrar");  btnCadastrar.setFont(new Font("Arial", Font.BOLD, 16));
		
		esqueciMS.setFont(new Font("Arial",Font.ITALIC, 10));	esqueciMS.setForeground(Color.BLUE);
		
		Color azul = new Color(1, 190, 254);
		lblTitulo = new JLabel("SI-VENDAS");	lblTitulo.setFont(new Font("ALGERIAN", Font.BOLD, 50)); lblTitulo.setForeground(azul);
				
		Container paine = getContentPane();
		paine.setLayout(null);
		

		esqueciMS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		esqueciMS.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent a) {
				esqueciMS.setText("Esqueceu sua senha?");
				new Senha();
				
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
		
		setIconImage(icone.getImage());
		
		//Barra de menu
		super.setJMenuBar(barMenu);  
			barMenu.add(opcSistema);
				opcSistema.add(menuSair);				
					menuSair.addActionListener(new ActionListener() {   
					    public void actionPerformed(ActionEvent e) {  
					    	int x = JOptionPane.showConfirmDialog(null, "Deseja mesmo finalizar o programa?");
					    	if(x == 0)
					        	System.exit(0);  
					    }  
					});  
				opcSistema.addSeparator();
				opcSistema.add(menuCadastrar);
					menuCadastrar.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							Cadastro_Inte objCad = new Cadastro_Inte();
						}
					});
			
		paine.add(lblTitulo);
		lblTitulo.setBounds(100, 20, 340, 50);
		paine.add(lblLogo);
		lblLogo.setBounds(20, 100, 210, 140);
		
		paine.add(lblLogin);
		lblLogin.setBounds(280, 100, 100, 30);
		paine.add(txtLogin);
		txtLogin.setBounds(280, 130, 170, 30);
		
		paine.add(lblSenha);
		lblSenha.setBounds(280, 180, 100, 30);
		paine.add(txtSenha);
		txtSenha.setBounds(280, 210, 170, 30);
		
		paine.add(btnLogar);
		btnLogar.setBounds(220, 280, 100, 40);
		btnLogar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String nome;
				String login = txtLogin.getText().trim();
				String senha = txtSenha.getText().trim();
				if(login.equals("") || senha.equals("")){
					JOptionPane.showMessageDialog(null,"É necessario que preencha todos os campos de login!","Erro",JOptionPane.ERROR_MESSAGE);
				}else{
					Validacao objVal = new Validacao();
					File arquivo = new File("Funcionarios/" + login + ".txt");
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
						Menu objMenu = new Menu(login);
											
					}
				}
				
			}
		});
		
		paine.add(btnCadastrar);
		btnCadastrar.setBounds(340, 280, 140, 40);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Cadastro_Inte objCad = new Cadastro_Inte();
			}
		});
		
		paine.add(esqueciMS);
		esqueciMS.setBounds(280, 240, 120, 20);
		
		setLocation((tela.width-this.getSize().width)/4,   
                (tela.height-this.getSize().height)/4);  
	}
	
	public static void main(String[] args){
		Inicio objIni = new Inicio();
		objIni.setDefaultCloseOperation(EXIT_ON_CLOSE);
		objIni.setResizable(false);
		objIni.setSize(500, 400);
		objIni.setVisible(true);
	}

}

