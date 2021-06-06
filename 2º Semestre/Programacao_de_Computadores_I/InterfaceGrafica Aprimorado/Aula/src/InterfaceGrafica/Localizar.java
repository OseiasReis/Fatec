package InterfaceGrafica;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Localizar extends JFrame{
	private JLabel lblNome = new JLabel("Nome: ");
	private JTextField txtNome = new JTextField();
	private JButton btnSair = new JButton("Sair");
	
	public Localizar(){
		super(".::Localizar::.");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
	paine.add(btnSair);
	btnSair.setBounds(300, 280, 120, 80);
	btnSair.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int Sair;
			
			Sair = JOptionPane.showConfirmDialog(null, "Você deseja realmente sair?");
			
			if(Sair == 0){
				System.exit(0);
			}
		}
	});
	}
}
