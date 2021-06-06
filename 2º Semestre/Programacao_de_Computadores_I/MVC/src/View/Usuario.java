package View;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Controller.UsuarioController;
import Model.UsuarioModel;

public class Usuario extends JFrame{
	
	JLabel lblnome = new JLabel("<html> <p color = red> Nome: </html>");
	JLabel lblendereco = new JLabel("<html> <p color = red> Endereço: </html>");
	JLabel lblbairro = new JLabel("<html> <p color = red> Bairro: </html>");
	JLabel lblcep = new JLabel("<html> <p color = red> Cep: </html>");
	JLabel lblcidade = new JLabel("<html> <p color = red> Cidade: </html>");
	JLabel lblestado = new JLabel("<html> <p color = red> Estado: </html>");
	
	JTextField txtnome = new JTextField();
	JTextField txtendereco = new JTextField();
	JTextField txtbairro = new JTextField();
	JTextField txtcep;
	JTextField txtcidade = new JTextField();
	JTextField txtestado = new JTextField();
	
	JButton btncadastrar = new JButton("Cadastrar");
	
	public Usuario(){
		super("Cadastro de Usuários");
		
		Container pane = this.getContentPane();
		pane.setLayout(null);
		
		pane.add(lblnome);
		lblnome.setBounds(20, 20, 80, 20);
		
		pane.add(txtnome);
		txtnome.setBounds(80, 20, 200, 20);
		
		pane.add(lblendereco);
		lblendereco.setBounds(20, 60, 120, 20);
		
		pane.add(txtendereco);
		txtendereco.setBounds(80, 60, 200, 20);

		pane.add(lblbairro);
		lblbairro.setBounds(20, 100, 80, 20);
		
		pane.add(txtbairro);
		txtbairro.setBounds(80, 100, 200, 20);
		
		try{
			txtcep = new JFormattedTextField(new MaskFormatter("########"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pane.add(lblcep);
		lblcep.setBounds(20, 140, 80, 20);
		
		pane.add(txtcep);
		txtcep.setBounds(80, 140, 200, 20);
		
		pane.add(lblcidade);
		lblcidade.setBounds(20, 180, 80, 20);
		
		pane.add(txtcidade);
		txtcidade.setBounds(80, 180, 200, 20);
		
		pane.add(lblestado);
		lblestado.setBounds(20, 220, 80, 20);
		
		pane.add(txtestado);
		txtestado.setBounds(80, 220, 200, 20);
		
		pane.add(btncadastrar);
		btncadastrar.setBounds(100, 260, 100, 40);
		btncadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UsuarioModel userModel = new UsuarioModel();
				UsuarioController userControl = new UsuarioController();
				
				userModel.setNome(txtnome.getText());
				userModel.setEndereco(txtendereco.getText());
				userModel.setBairro(txtbairro.getText());
				userModel.setCep(Integer.parseInt(txtcep.getText()));
				userModel.setCidade(txtcidade.getText());
				userModel.setEstado(txtestado.getText());
				userControl.inserirCadastro(userModel.getNome(), userModel.getEndereco(), userModel.getBairro(), userModel.getCep(), userModel.getCidade(), userModel.getEstado());
				
			}
		});
		
		
		this.setSize(320, 350);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		Usuario user = new Usuario();
	}
}
