package exercicios.exercicio1;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Principal extends JFrame {
	
	private JLabel lblCompare = new JLabel("Digite uma string: ");
	private JTextField txtCompare = new JTextField();
	
	public Principal(){
		super("..:: Método compareTo");
		
		Container paine = getContentPane();
		paine.setLayout(null);
		
	}
	
	public static void main(String[] args){
		
		
	}

}
