package ADM;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Admin extends JFrame{

	private JLabel lblTitulo = new JLabel("Alterar Senha ADM");
	private JLabel lblSenha = new JLabel("Nova Senha:");
	private JTextField txtSenha;
	private JButton btnConcluir = new JButton("Concluir");
	
	public Admin(){
		super(".::Administração::.");
		
		lblTitulo.setFont(new Font("Colonna MT", Font.BOLD, 30));
		Color azul = new Color(1, 190, 254);
		lblTitulo.setForeground(azul);
		btnConcluir.setFont(new Font("Arial", Font.BOLD, 16));
		lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
		
		txtSenha = new JPasswordField();
		
	Container paine = getContentPane();
	paine.setLayout(null);
		
	paine.add(lblTitulo);
	lblTitulo.setBounds(40, 20, 300, 40); 
	
	paine.add(lblSenha);
	lblSenha.setBounds(20, 80, 150, 30); 
	paine.add(txtSenha);
	txtSenha.setBounds(130, 80, 180, 30); 
	
	paine.add(btnConcluir);
	btnConcluir.setBounds(100, 130, 120, 40); 
	btnConcluir.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		
			File arquivo = new File("ADM/Senha.txt");

				String senha = txtSenha.getText();
				
				arquivo.delete();
				
				File arquivoN = new File("ADM/Senha.txt");
				
				try( FileWriter fw = new FileWriter(arquivoN, true) ){
				    fw.write(senha);
				    fw.flush();
				    fw.close();
				    
				    JOptionPane.showMessageDialog(null, "Concluido, os dados foram alterados!");
				    
				}catch(IOException ex){
				  ex.printStackTrace();
				}
				dispose();
				
		}
	});
	
	setLocation(515, 200); 
	this.setSize(350, 220);
	//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setVisible(true);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
