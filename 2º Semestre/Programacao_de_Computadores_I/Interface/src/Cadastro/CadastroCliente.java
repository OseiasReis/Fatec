package Cadastro;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CadastroCliente extends JFrame{ //extends JFrame para fazer interface
	
	public CadastroCliente(){ //para carregar os componentes do JFrame, é preciso por denovo os dados
		super(".:Cadastro Cliente::."); //logo abaixo escrever isso acima, isso ira mudar o nome no canto esquerdo superior
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(20, 20, 100, 20);
		
		JTextField txtNome = new JTextField();
		txtNome.setBounds(20, 60, 300, 20);
		
		JButton btnCadastrar = new JButton();
		txtNome.setBounds(20, 80, 100, 100);
		
		Container pane = this.getContentPane();
		pane.setLayout(null);
		
		pane.add(lblNome);
		pane.add(txtNome);
		pane.add(btnCadastrar);
		
		this.setSize(1024, 768); //tamanho da janela e o this. faz aparecer todos os itens da classe
		this.setVisible(true); //visibilidade da janela
		this.setResizable(false); //com isso o usuario não consegui alterar o tamanho da janela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para encerrar a operação depois que apertar o "X", pois não sempre encerra sem o código
	}
	public static void main(String args[]){
		CadastroCliente cli = new CadastroCliente(); //Para abrir a janela que vc criou, instancie
		
	}
}
