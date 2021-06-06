package cadastro;

import java.awt.Color;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class Cadastro_Inte extends JFrame{
	
	private JLabel lblTitulo = new JLabel("Cadastrar-se");
	private JLabel lblEmail = new JLabel("*E-mail:");
	private JLabel lblSenha = new JLabel("*Senha:");
	private JLabel lblSenhaN = new JLabel("*Confirme a Senha:");
	private JLabel lblCpf = new JLabel ("*Cpf:");
	private JLabel lblNome = new JLabel("Nome:");
	private JLabel lblEndereco = new JLabel("Endereço:");
	private JLabel lblBairro = new JLabel("Bairro:");
	private JLabel lblCep = new JLabel("Cep:");
	private JLabel lblCidade = new JLabel("Cidade:");
	private JLabel lblTelefoneR = new JLabel("Telefone:");
	private JLabel lblResidencia = new JLabel("Res:");
	private JLabel lblTelefoneC = new JLabel("Cel:");
	private JLabel lblSexo = new JLabel("Sexo:");
	
	private JLabel lblEmailSit, lblSenhaSit, lblSenhaNSit, lblLogo;
	
	private JTextField txtEmail = new JTextField();
	private JTextField txtSenha;
	private JTextField txtSenhaN;
	private JTextField txtCpf;
	private JTextField txtNome = new JTextField();
	private JTextField txtEndereco = new JTextField();
	private JTextField txtBairro = new JTextField();
	private JTextField txtCep;
	private JTextField txtCidade = new JTextField();
	private JTextField txtTelefoneR;
	private JTextField txtTelefoneC;
	
	private JRadioButton[] rbSexo = new JRadioButton[2];
	private ButtonGroup group = new ButtonGroup();
	
	private JButton btnCadastrar = new JButton ("Cadastrar");
	private JButton btnValidar = new JButton ("Validar");
	private JButton btnApagar = new JButton ("Apagar");
	
	private boolean validacao;
	
	ImageIcon icone = new ImageIcon("Imagens/anonimo.png");
		
	public Cadastro_Inte(){
		super (".:Cadastrar:.");
		
		lblEmailSit = new JLabel();
		lblSenhaSit = new JLabel();
		lblSenhaNSit = new JLabel();
		lblLogo = new JLabel();
		
		lblTitulo.setFont(new Font("Colonna MT", Font.BOLD, 35));
		Color azul = new Color(1, 190, 254);
		lblTitulo.setForeground(azul);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 16));
		lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
		lblSenhaN.setFont(new Font("Arial", Font.BOLD, 16));
		lblCpf.setFont(new Font("Arial", Font.BOLD, 16));
		lblNome.setFont(new Font("Arial", Font.BOLD, 16));
		lblEndereco.setFont(new Font("Arial", Font.BOLD, 16));
		lblBairro.setFont(new Font("Arial", Font.BOLD, 16));
		lblCep.setFont(new Font("Arial", Font.BOLD, 16));
		lblCidade.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefoneR.setFont(new Font("Arial", Font.BOLD, 16));
		lblResidencia.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefoneC.setFont(new Font("Arial", Font.BOLD, 16));
		lblSexo.setFont(new Font("Arial", Font.BOLD, 16));
		
		btnValidar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnApagar.setFont(new Font("Arial", Font.BOLD, 16));
		
		rbSexo[0] = new JRadioButton("Masculino");
		rbSexo[1] = new JRadioButton("Feminino");
		txtSenha = new JPasswordField();
		txtSenhaN = new JPasswordField();
		
		group.add(rbSexo[0]);
		group.add(rbSexo[1]);
		
		lblLogo.setIcon(new ImageIcon("Imagens/prancheta.png"));
		
		Container pane = this.getContentPane();
		pane.setLayout(null);
		
		setIconImage(icone.getImage());
		
		pane.add(lblLogo);
		lblLogo.setBounds(280, -15, 210, 100);
		
		pane.add(lblTitulo);
		lblTitulo.setBounds(50, 10, 250, 40);
		
		pane.add(lblEmail);
		lblEmail.setBounds(20, 60, 80, 20);
		pane.add(lblEmailSit);
		lblEmailSit.setBounds(280, 80, 30, 20);
		
		pane.add(lblSenhaSit);
		lblSenhaSit.setBounds(230, 130, 20, 20);
		pane.add(lblSenhaNSit);
		lblSenhaNSit.setBounds(230, 180, 20, 20);
		
		pane.add(txtEmail);
		txtEmail.setBounds(20, 80, 250, 20);
		
		pane.add(lblSenha);
		lblSenha.setBounds(20, 110, 80, 20);
		pane.add(txtSenha);
		txtSenha.setBounds(20, 130, 200, 20);
		
		pane.add(lblSenhaN);
		lblSenhaN.setBounds(20, 160, 300, 20);
		pane.add(txtSenhaN);
		txtSenhaN.setBounds(20, 180, 200, 20);
		
		pane.add(btnValidar);
		btnValidar.setBounds(120, 215, 90, 20);
		btnValidar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				
				String email = txtEmail.getText();
				String senha = txtSenha.getText();
				String senhaN = txtSenhaN.getText();
				if(senha.isEmpty() || senhaN.isEmpty() || email.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos marcados com *!", "Erro", JOptionPane.ERROR_MESSAGE); 
					lblSenhaSit.setIcon(new ImageIcon("Imagens/erro.png"));
					lblSenhaNSit.setIcon(new ImageIcon("Imagens/erro.png"));
					lblEmailSit.setIcon(new ImageIcon("Imagens/erro.png"));
				}else{
					if(!senha.equals(senhaN)){
						JOptionPane.showMessageDialog(null, "Ambas as senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE); 
						lblSenhaSit.setIcon(new ImageIcon("Imagens/erro.png"));
						lblSenhaNSit.setIcon(new ImageIcon("Imagens/erro.png"));
						//lblEmailSit.setIcon(new ImageIcon("Imagens/certo.png"));
						pane.repaint();
					}else{
						if(email.indexOf("@") < 0 || email.indexOf(".com") < 0){
							JOptionPane.showMessageDialog(null, "Formato de e-mail inválido!", "Erro", JOptionPane.ERROR_MESSAGE); 
							lblEmailSit.setIcon(new ImageIcon("Imagens/erro.png"));
							lblSenhaSit.setIcon(new ImageIcon("Imagens/certo.png"));
							lblSenhaNSit.setIcon(new ImageIcon("Imagens/certo.png"));
							pane.repaint();
						}else{
							File arquivo = new File("Funcionarios/" + email + ".txt");
							if(arquivo.exists()){
								JOptionPane.showMessageDialog(null, "O e-mail digitado já foi cadastrado", "Erro", JOptionPane.ERROR_MESSAGE); 
								lblEmailSit.setIcon(new ImageIcon("Imagens/erro.png"));
								pane.repaint();
							}else{						
								//txtEmail.disable();
								txtEmail.setEditable(false);
								
								txtSenha.setEditable(false);
								txtSenhaN.setEditable(false);
								btnValidar.setEnabled(false);
								lblEmailSit.setIcon(new ImageIcon("Imagens/certo.png"));
								lblSenhaSit.setIcon(new ImageIcon("Imagens/certo.png"));
								lblSenhaNSit.setIcon(new ImageIcon("Imagens/certo.png"));
								JOptionPane.showMessageDialog(null, "Validado com sucesso!");
								validacao = true;
							}
								
						}
					}
					
				}
				lblEmailSit.setVisible(true);
				lblSenhaSit.setVisible(true);
				lblSenhaNSit.setVisible(true);
			}
		});
		
		try{
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pane.add(lblCpf);
		lblCpf.setBounds(20, 250, 80, 20);
		
		pane.add(txtCpf);
		txtCpf.setBounds(70, 250, 100, 20);
		txtCpf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
			// código do evento:
			String caracteres="0987654321";
			       if(!caracteres.contains(ev.getKeyChar()+"")){
			              ev.consume();
			       }
			}
		});
		
		pane.add(lblNome);
		lblNome.setBounds(20, 280, 80, 20);
		pane.add(txtNome);
		txtNome.setBounds(20, 300, 300, 20);
		txtNome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtNome.setText(txtNome.getText());
			}
		});
		
		pane.add(lblEndereco);
		lblEndereco.setBounds(20, 330, 200, 20);
		pane.add(txtEndereco);
		txtEndereco.setBounds(20, 350, 300, 20);
		
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
		lblCep.setBounds(20, 430, 80, 20);
		pane.add(txtCep);
		txtCep.setBounds(20, 450, 300, 20);
		
		pane.add(lblCidade);
		lblCidade.setBounds(20, 480, 80, 20);
		pane.add(txtCidade);
		txtCidade.setBounds(20, 500, 300, 20);
		
		try{
			txtTelefoneR = new JFormattedTextField(new MaskFormatter("(##) ## ####-####"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pane.add(lblTelefoneR);
		lblTelefoneR.setBounds(20, 530, 80, 20);
		
		pane.add(lblResidencia);
		lblResidencia.setBounds(20, 555, 80, 20);
		
		pane.add(txtTelefoneR);
		txtTelefoneR.setBounds(60, 555, 110, 20);
		txtTelefoneR.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
			// código do evento:
			String caracteres="0987654321";
			       if(!caracteres.contains(ev.getKeyChar()+"")){
			              ev.consume();
			       }
			}
		});
		
		try{
			txtTelefoneC = new JFormattedTextField(new MaskFormatter("(##) ## #####-####"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pane.add(lblTelefoneC);
		lblTelefoneC.setBounds(172, 555, 80, 20);
		pane.add(txtTelefoneC);
		txtTelefoneC.setBounds(205, 555, 120, 20);
		txtTelefoneC.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
			// código do evento:
			String caracteres="0987654321";
			       if(!caracteres.contains(ev.getKeyChar()+"")){
			              ev.consume();
			       }
			}
		});
		
		pane.add(lblSexo);
		lblSexo.setBounds(20, 585, 80, 20);
		pane.add(rbSexo[0]);
		rbSexo[0].setBounds(20, 605, 100, 20);
		pane.add(rbSexo[1]);
		rbSexo[1].setBounds(120, 605, 100, 20);

		pane.add(btnCadastrar);
		btnCadastrar.setBounds(40, 640, 125, 40);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String cpf = txtCpf.getText();
			
				if(!validacao == true){
					JOptionPane.showMessageDialog(null, "Erro! Digite e valide todos os campos obrigatórios", "Erro", JOptionPane.ERROR_MESSAGE);
				}else{
					String email = txtEmail.getText();
					String senha = txtSenha.getText();
									
					JOptionPane.showMessageDialog(null, "Obrigado " + txtNome.getText() + ", você foi cadastrado");
					
					//Rodrigo - Gravação das informaçoes no txt
					String nome = txtNome.getText();
					String endereco = txtEndereco.getText();
					String bairro = txtBairro.getText();
					String cep = txtCep.getText();
					String cidade = txtCidade.getText();
					String telefoner = txtTelefoneR.getText();
					String telefonec = txtTelefoneC.getText();
					String sexo;
					if(rbSexo[0].isSelected())
						sexo = "Masculino";
					else{ 
						if(rbSexo[1].isSelected())
							sexo = "Feminino";
						else
							sexo = "Indefinido";
					}
					File arquivo = new File("Funcionarios/" + email + ".txt");
					
					try( FileWriter fw = new FileWriter(arquivo, true) ){
					    fw.write(email);
					    fw.write("\r\n");
					    fw.write(senha);
					    fw.write("\r\n\r\n");
					    fw.write(cpf);
					    fw.write("\r\n");
					    fw.write(nome);
					    fw.write("\r\n");
					    fw.write(endereco);
					    fw.write("\r\n");
					    fw.write(bairro);
					    fw.write("\r\n");
					    fw.write(cep);
					    fw.write("\r\n");
					    fw.write(cidade);
					    fw.write("\r\n");
					    fw.write(telefoner);
					    fw.write("\r\n");
					    fw.write(telefonec);
					    fw.write("\r\n");
					    fw.write(sexo);
					    fw.flush();
					    fw.close();
					    
					}catch(IOException ex){
					  ex.printStackTrace();
					}
					dispose();
				}	
			}
		});
		
		pane.add(btnApagar);
		btnApagar.setBounds(182, 640, 90, 40);
		btnApagar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int Apagar;
				
				Apagar = JOptionPane.showConfirmDialog(null, "Você deseja realmente Apagar?","Confirmação",JOptionPane.YES_NO_OPTION);
				
				if(Apagar == 0){
					txtEmail.setText("");
					txtSenha.setText("");
					txtSenhaN.setText("");
					txtCpf.setText("");
					txtNome.setText("");
					txtEndereco.setText("");
					txtBairro.setText("");
					txtCep.setText("");
					txtCidade.setText("");
					txtTelefoneR.setText("");
					txtTelefoneC.setText("");
					
					txtEmail.setEditable(true);
					txtSenha.setEditable(true);
					txtSenhaN.setEditable(true);
					btnValidar.setEnabled(true);
					validacao = false;
					
					lblEmailSit.setVisible(false);
					lblSenhaSit.setVisible(false);
					lblSenhaNSit.setVisible(false);;
				}
			}
		});

		
		this.setSize(350, 720);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}