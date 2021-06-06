package model;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import reg.Cadastrar;

public class Senha extends JFrame{
	private JLabel lblTitulo = new JLabel("Alterar Senha");
	private JLabel lblEmail = new JLabel("Email do Usuario:");
	private JLabel lblCpf = new JLabel("CPF:");
	
	private JTextField txtEmail = new JTextField();
	private JTextField txtCpf;
	
	private JButton btnConcluir = new JButton("Recuperar");
	
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	
	File arquivo = new File("Pessoa/");
	
	ImageIcon icone = new ImageIcon("Imagens/anonimo.png");
	
	int validar;
	String email, cpf, senha;
	BufferedReader buffer;
	
	public Senha(){
		super(".::ADM - Editar::.");
		
		lblTitulo.setFont(new Font("Colonna MT", Font.BOLD, 40));
		Color azul = new Color(1, 190, 254);
		lblTitulo.setForeground(azul);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblCpf.setFont(new Font("Arial", Font.BOLD, 14));
		btnConcluir.setFont(new Font("Arial", Font.BOLD, 14));
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
	
		setIconImage(icone.getImage());
		
		paine.add(lblTitulo);
		lblTitulo.setBounds(40, 15, 300, 30);
		
		paine.add(lblEmail);
		lblEmail.setBounds(20, 60, 150, 20);
		paine.add(txtEmail);
		txtEmail.setBounds(20, 80, 300, 20);
		
		try{
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		paine.add(lblCpf);
		lblCpf.setBounds(20, 120, 80, 20);
		paine.add(txtCpf);
		txtCpf.setBounds(20, 140, 300, 20);
		txtCpf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
			// código do evento:
			String caracteres="0987654321";
			       if(!caracteres.contains(ev.getKeyChar()+"")){
			              ev.consume();
			       }
			}
		});
					
		
		paine.add(btnConcluir);
		btnConcluir.setBounds(180, 180, 120, 40); 
		btnConcluir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				String email = txtEmail.getText();
				String cpf = txtCpf.getText();
				
				File arquivo = new File("Pessoa/" + email + ".txt");
				
				if(email.isEmpty() || cpf.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
				}else{
					if(!arquivo.exists()){
						JOptionPane.showMessageDialog(null, "Email e/ou CPF incorrecto!","Erro",JOptionPane.ERROR_MESSAGE);
					}else{
						String cpfvdd, senha;
						try {
							buffer = new BufferedReader(new FileReader(arquivo));
							cpfvdd = buffer.readLine();
							senha = buffer.readLine();
							cpfvdd = buffer.readLine();
							cpfvdd = buffer.readLine();
							if(cpf.equals(cpfvdd)){
								JOptionPane.showMessageDialog(null, "Senha cadastrada: " + senha, "Sucesso",JOptionPane.PLAIN_MESSAGE);
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "Email e/ou CPF incorrecto!","Erro",JOptionPane.ERROR_MESSAGE);
							}
							buffer.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}							
					}
				}
			}
		});
		
		setLocation(515, 200); 
	
		this.setSize(350, 280);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String args[]) {
		Senha s = new Senha();
	}
}
