package principal;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ADM.Admin;
import ADM.Func_Edit;
import ADM.Funcionarios;
import cadastro.*;
import funcao.Caixa;
import funcao.Historico;
import produtos.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Menu extends JFrame{	
		
	private JLabel lblInf, lblInf2, lblTitulo, lblProd, lblAdmin, lblFuncao, lblLinha;
	private JPanel jpProd, jpAdmin, jpVazio;
	
	private JButton btnProdutos, btnAdministracao; 
	
	private JButton btnCadastrar, btnReestocar, btnModificar, btnExcluir, btnSair;
	
	private JButton btnFuncionarios, btnEditar, btnAdmin, btnLogin, btnLogoff;
	private JLabel lblSenha = new JLabel("Senha:");
	private JTextField txtSenha;
	
	private JButton btnHistorico, btnCaixa;
	
	private JMenuBar mnuBarra = new JMenuBar();
	private JMenu mnuSistema = new JMenu("Sistema");
	private JMenuItem itmSair = new JMenuItem("Sair");
	
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	int largura = (tela.width-this.getSize().width);
	int altura = (tela.height-this.getSize().height);
	
	private JLabel lblImagem = new JLabel();
	
	ImageIcon icone = new ImageIcon("Imagens/si.png");
	
	String nome;
	private BufferedReader buffer;
	private File inf;
	
	File arquivo = new File("ADM/senha.txt");
	FileReader reader;
	
	boolean isAdmn = false;
	
	String senhaval = "";
	
	public Menu(String email){
		super(".:MENU PRINCIPAL:.");
		
		lblImagem.setOpaque(true);	lblImagem.setIcon(new ImageIcon("Imagens/banner.png"));
		
		lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
		
		txtSenha = new JPasswordField();
		
		
		try {
			nome = login(email);
		} catch (IOException e) {
			e.printStackTrace();
			nome = "error";
		}
		//Barra de menu
		setJMenuBar(mnuBarra);
			mnuBarra.add(mnuSistema);
				mnuSistema.add(itmSair);
				itmSair.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(isAdmn == false){
							Inicio objIni = new Inicio();
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "Você precisa realizar logoff da conta administrativa antes!", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
			
		//Cabeçalho
		lblInf = new JLabel("Olá sr. " + nome);
		lblInf2 = new JLabel("Seja bem vindo!");
		
		//Painel Vazio
		Color azul = new Color(1, 190, 254);
		jpVazio = new JPanel();	jpVazio.setBackground(Color.GRAY);	jpVazio.setBorder(BorderFactory.createLineBorder(azul, 5));
		jpVazio.setLayout(null);
		
		//Painel dos produtos
		jpProd = new JPanel();	jpProd.setBackground(Color.GRAY);	jpProd.setBorder(BorderFactory.createLineBorder(azul, 5));
		jpProd.setLayout(new GridLayout(0, 1, 10, 15));
		jpProd.setVisible(false);
				
		btnCadastrar = new JButton("CADASTRAR");	btnCadastrar.setFont(new Font("Arial", Font.BOLD, 28));	
		btnCadastrar.setBackground(Color.WHITE);	btnCadastrar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnCadastrar.setForeground(Color.black);
		
		btnReestocar = new JButton("REESTOCAR"); 	btnReestocar.setFont(new Font("Arial", Font.BOLD, 28));	
		btnReestocar.setBackground(Color.WHITE);	btnReestocar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnReestocar.setForeground(Color.black);
		
		btnModificar = new JButton("LISTAR"); 	btnModificar.setFont(new Font("Arial", Font.BOLD, 28));
		btnModificar.setBackground(Color.WHITE);	btnModificar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnModificar.setForeground(Color.black);
		
		btnExcluir = new JButton("EXCLUIR"); 		btnExcluir.setFont(new Font("Arial", Font.BOLD, 28));
		btnExcluir.setBackground(Color.WHITE);		btnExcluir.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnExcluir.setForeground(Color.black);
		
		jpProd.add(btnCadastrar);
		jpProd.add(btnReestocar);
		jpProd.add(btnModificar);
		jpProd.add(btnExcluir);
		//fim Painel dos produtos
		
		//Painel administrativo
		jpAdmin = new JPanel();	jpAdmin.setBackground(Color.GRAY);	jpAdmin.setBorder(BorderFactory.createLineBorder(azul, 5));
		jpAdmin.setLayout(null);	
		jpAdmin.setVisible(false);
		
		btnFuncionarios = new JButton("FUNCIONARIOS");
		
		btnEditar = new JButton("EDITAR");
		
		btnAdmin = new JButton("SENHA");
		
		btnLogin = new JButton("LOGIN");
		
		btnLogoff = new JButton("LOGOUT");
				
		btnFuncionarios.setFont(new Font("Arial", Font.BOLD, 20));
		btnEditar.setFont(new Font("Arial", Font.BOLD, 20));
		btnAdmin.setFont(new Font("Arial", Font.BOLD, 20));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
		btnLogoff.setFont(new Font("Arial", Font.BOLD, 15));
		
		btnFuncionarios.setEnabled(false);
		btnEditar.setEnabled(false);
		btnAdmin.setEnabled(false);
		btnLogoff.setEnabled(false);
		
		jpAdmin.add(lblSenha);
		lblSenha.setBounds(8, 6, 254, 50);    lblSenha.setFont(new Font("Arial", Font.BOLD, 28));
		lblSenha.setForeground(Color.black);
		
		jpAdmin.add(txtSenha);
		txtSenha.setBounds(110, 18, 140, 30);    txtSenha.setFont(new Font("Arial", Font.BOLD, 28));	
		txtSenha.setBackground(Color.WHITE);	
		
		jpAdmin.add(btnLogin);
		btnLogin.setBounds(6, 66, 254, 50);    btnLogin.setFont(new Font("Arial", Font.BOLD, 28));	
		btnLogin.setBackground(Color.WHITE);	btnLogin.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnLogin.setForeground(Color.black);
		
		jpAdmin.add(btnLogoff);
		btnLogoff.setBounds(6, 126, 254, 50);    btnLogoff.setFont(new Font("Arial", Font.BOLD, 28));	
		btnLogoff.setBackground(Color.WHITE);	 btnLogoff.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnLogoff.setForeground(Color.black);
		
		lblLinha = new JLabel();  lblLinha.setBackground(azul);
		lblLinha.setOpaque(true);
		jpAdmin.add(lblLinha);
		lblLinha.setBounds(5, 190, 256, 7);
		
		jpAdmin.add(btnFuncionarios);
		btnFuncionarios.setBounds(6, 210, 254, 70);   btnFuncionarios.setFont(new Font("Arial", Font.BOLD, 28));	
		btnFuncionarios.setBackground(Color.WHITE);	btnFuncionarios.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnFuncionarios.setForeground(Color.black);
		
		jpAdmin.add(btnEditar);
		btnEditar.setBounds(6, 293, 254, 70);    btnEditar.setFont(new Font("Arial", Font.BOLD, 28));	
		btnEditar.setBackground(Color.WHITE);	btnEditar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnEditar.setForeground(Color.black);
		
		jpAdmin.add(btnAdmin);
		btnAdmin.setBounds(6, 376, 254, 70);    btnAdmin.setFont(new Font("Arial", Font.BOLD, 28));
		btnAdmin.setBackground(Color.WHITE);	btnAdmin.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnAdmin.setForeground(Color.black);
		//fim Painel administrativo 
		
		Container paine = getContentPane();
		paine.setLayout(null);
		
		setIconImage(icone.getImage());
		
		//Botões para abrir as tabelas
		btnProdutos = new JButton("PRODUTOS");		      btnProdutos.setFont(new Font("Arial", Font.BOLD, 25));
		btnAdministracao = new JButton("ADMINISTRAÇÃO");  btnAdministracao.setFont(new Font("Arial", Font.BOLD, 35));
		
		paine.add(btnProdutos);
		btnProdutos.setBounds(20, 125, 180, 40);    btnProdutos.setFont(new Font("Arial", Font.BOLD, 28));
		btnProdutos.setBackground(Color.WHITE);	      btnProdutos.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnProdutos.setForeground(Color.black);
		btnProdutos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jpProd.setVisible(true);
				jpAdmin.setVisible(false);
				jpVazio.setVisible(false);
			}
		});
		
		paine.add(btnAdministracao);
		btnAdministracao.setBounds(250, 125, 245, 40);  btnAdministracao.setFont(new Font("Arial", Font.BOLD, 28));
		btnAdministracao.setBackground(Color.WHITE);	 btnAdministracao.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnAdministracao.setForeground(Color.black);
		btnAdministracao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jpAdmin.setVisible(true);
				jpProd.setVisible(false);
				jpVazio.setVisible(false);
			}
		});
		
		btnHistorico = new JButton("HISTORICO");	   btnHistorico.setFont(new Font("Arial", Font.BOLD, 25));			btnHistorico.setEnabled(false);
		btnAdministracao = new JButton("CAIXA");	   btnAdministracao.setFont(new Font("Arial", Font.BOLD, 35));
		//Fim botões para abrir as tabelas
		
		//Caixa	
		paine.add(btnHistorico);
		btnHistorico.setBounds(330, 250, 254, 100);    btnHistorico.setFont(new Font("Arial", Font.BOLD, 28));
		btnHistorico.setBackground(Color.WHITE);	   btnHistorico.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnHistorico.setForeground(Color.black);
		
		btnCaixa = new JButton("CAIXA");
		btnCaixa.setBounds(330, 400, 254, 100);    btnCaixa.setFont(new Font("Arial", Font.BOLD, 28));
		btnCaixa.setBackground(Color.WHITE);	   btnCaixa.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnCaixa.setForeground(Color.black);
		paine.add(btnCaixa);
		//fim Caixa
		
		paine.add(lblImagem);	
		lblImagem.setBounds(20, 10, 400, 100);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Cadastro_Prod();
			}
		});
		btnReestocar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Reestoque();
			}
		});
		btnModificar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Listagem();
			}
		});
		btnExcluir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Exclusao();
			}
		});
		
		btnFuncionarios.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				Funcionarios admf = new Funcionarios();
			}
		});
		
		btnEditar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				Func_Edit admed = new Func_Edit();
				
			}
		});
		btnAdmin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				Admin adm = new Admin();
			}
		});
		
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String senha = txtSenha.getText().trim();
				
				File arquivo = new File("ADM/Senha.txt");
				
				if(senha.equals("")){
					JOptionPane.showMessageDialog(null,"É necessario que preencher o campo!");
				}else{
					senha = txtSenha.getText();
					
					if(arquivo.exists()){
						try {
							reader = new FileReader(arquivo);
							buffer = new BufferedReader(reader);
							
							senhaval = buffer.readLine();
							
							buffer.close();
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					
						
						if(senha.equals(senhaval)){
							JOptionPane.showMessageDialog(null,"Senha Correta\nBem Vindo Administrador");
							btnFuncionarios.setEnabled(true);
							btnEditar.setEnabled(true);
							btnAdmin.setEnabled(true);
							btnLogoff.setEnabled(true);
							btnLogin.setEnabled(false);
							txtSenha.setEditable(false);
							btnHistorico.setEnabled(true);
							isAdmn = true;
						}else{
							JOptionPane.showMessageDialog(null,"Senha invalida");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Arquivo não existe","Erro",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		btnLogoff.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int Sair;
				
				Sair = JOptionPane.showConfirmDialog(null, "Você deseja realmente fazer Logout?","Confirmação",JOptionPane.YES_NO_OPTION);
				
				if(Sair == 0){
					txtSenha.setText("");
					
					
					btnFuncionarios.setEnabled(false);
					btnEditar.setEnabled(false);
					btnAdmin.setEnabled(false);
					btnLogin.setEnabled(true);
					btnLogoff.setEnabled(false);
					txtSenha.setEditable(true);
					
					isAdmn = false;
				}
			}
		});
		
		btnCaixa.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println(email);
				new Caixa(email);
			}
		});
		
		btnHistorico.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Historico ht = new Historico();
			}
		});
		
		paine.add(jpProd);
		jpProd.setBounds(20, 180, 265, 452);
		paine.add(jpAdmin);
		jpAdmin.setBounds(20, 180, 265, 452);
		paine.add(jpVazio);
		jpVazio.setBounds(20, 180, 265, 452);
		
		paine.add(lblInf);
		lblInf.setBounds(450, 0, 400, 40);
		paine.add(lblInf2);
		lblInf2.setBounds(450, 15, 400, 40);
			
		setLocation(400, 10);
		
		setResizable(false);
		setVisible(true);
		setSize(615, 700);
		this.getContentPane().setBackground(Color.WHITE);
		
	}
	
	public String login(String email) throws IOException{
		inf = new File("Funcionarios/"+email+".txt");
		String nome = "";
		try {
			buffer = new BufferedReader(new FileReader(inf));  
			
			nome = buffer.readLine();  
			nome = buffer.readLine();  
			nome = buffer.readLine();  
			nome = buffer.readLine();  

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return nome;
	}
	
}
