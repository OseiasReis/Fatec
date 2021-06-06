package aula;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Principal extends JFrame{
	JLabel lblNome = new JLabel("Nome: ");
	JTextField txtNome = new JTextField();
	JButton btnCadastrar = new JButton("Cadastrar");
	JButton btnSair = new JButton("Sair");
	
	public Principal(){ 
		//para carregar os componentes do JFrame, é preciso por denovo os dados
		super(".:Sistema::.");
		//logo abaixo escrever isso acima, isso ira mudar o nome no canto esquerdo superior
		
		Container pane = this.getContentPane(); //permite fixar objetos na tela
		pane.setLayout(null);
		
		pane.add(lblNome);
		lblNome.setBounds(20, 20, 80, 20);
		
		pane.add(txtNome);
		txtNome.setBounds(100, 20, 250, 20);
		
		pane.add(btnCadastrar);
		btnCadastrar.setBounds(20, 60, 100, 30);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ //dar uma ação ao click
				JOptionPane.showMessageDialog(null, txtNome.getText());
			}
		});
		
		pane.add(btnSair);
		btnSair.setBounds(140, 60, 100, 30);
		btnSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int Sair;
				
				Sair = JOptionPane.showConfirmDialog(null, "Você deseja realmente sair?");
				
				if(Sair == 0){
					System.exit(0);
				}
			}
		});
		
		this.setSize(600, 400);
		this.setVisible(true);
		
		this.setSize(1024, 768); 
		//tamanho da janela e o this. faz aparecer todos os itens da classe
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//para encerrar a operação depois que apertar o "X", pois não sempre encerra sem o código
		
		this.setVisible(true); 
		//visibilidade da janela
		
		
	}
	public static void main(String[] args) {
		Principal objPrincipal = new Principal();
	}

}
