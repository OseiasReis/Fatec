package BS;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BSexercicio extends JFrame{
	
	private JLabel lbln1 = new JLabel ("1º Número");
	private JLabel lbln2 = new JLabel ("2º Número");
	private JLabel lbln3 = new JLabel ("3º Número");
	private JLabel lbln4 = new JLabel ("4º Número");
	private JLabel lbln5 = new JLabel ("5º Número");
	private JLabel lbln6 = new JLabel ("6º Número");
	private JLabel lbln7 = new JLabel ("7º Número");
	private JLabel lbln8 = new JLabel ("8º Número");
	private JLabel lbln9 = new JLabel ("9º Número");
	private JLabel lbln10 = new JLabel ("10º Número");
	
	private JTextField txtn1 = new JTextField();
	private JTextField txtn2 = new JTextField();
	private JTextField txtn3 = new JTextField();
	private JTextField txtn4 = new JTextField();
	private JTextField txtn5 = new JTextField();
	private JTextField txtn6 = new JTextField();
	private JTextField txtn7 = new JTextField();
	private JTextField txtn8 = new JTextField();
	private JTextField txtn9 = new JTextField();
	private JTextField txtn10 = new JTextField();
	
	private JButton btnEnviar = new JButton("Enviar");
	private JButton btlimpar = new JButton("Limpar");
	private JButton btsair = new JButton("Sair");
	
	public BSexercicio (){
		super (".:Bubble Sort:.");
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(lbln1);
		lbln1.setBounds(20, 20, 80, 20);
		
		paine.add(txtn1);
		txtn1.setBounds(90, 20, 80, 20);
		
		
		paine.add(lbln2);
		lbln2.setBounds(20, 60, 80, 20);
		
		paine.add(txtn2);
		txtn2.setBounds(90, 60, 80, 20);
		
		
		paine.add(lbln3);
		lbln3.setBounds(20, 100, 80, 20);
		
		paine.add(txtn3);
		txtn3.setBounds(90, 100, 80, 20);
		
		
		paine.add(lbln4);
		lbln4.setBounds(20, 140, 80, 20);
		
		paine.add(txtn4);
		txtn4.setBounds(90, 140, 80, 20);
		
		
		paine.add(lbln5);
		lbln5.setBounds(20, 180, 80, 20);
		
		paine.add(txtn5);
		txtn5.setBounds(90, 180, 80, 20);
		
		
		paine.add(lbln6);
		lbln6.setBounds(20, 220, 80, 20);
		
		paine.add(txtn6);
		txtn6.setBounds(90, 220, 80, 20);
		
		
		paine.add(lbln7);
		lbln7.setBounds(20, 260, 80, 20);
		
		paine.add(txtn7);
		txtn7.setBounds(90, 260, 80, 20);
		
		
		paine.add(lbln8);
		lbln8.setBounds(20, 300, 80, 20);
		
		paine.add(txtn8);
		txtn8.setBounds(90, 300, 80, 20);
		
		
		paine.add(lbln9);
		lbln9.setBounds(20, 340, 80, 20);
		
		paine.add(txtn9);
		txtn9.setBounds(90, 340, 80, 20);
		
		
		paine.add(lbln10);
		lbln10.setBounds(20, 380, 80, 20);
		
		paine.add(txtn10);
		txtn10.setBounds(90, 380, 80, 20);
		
		
		paine.add(btnEnviar);
		btnEnviar.setBounds(60, 420, 80, 40);
		btnEnviar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int[] vetor = new int[10];
				int backup;
				int i;
				boolean controle;
				
				vetor[0] = Integer.parseInt(txtn1.getText());
				vetor[1] = Integer.parseInt(txtn2.getText());
				vetor[2] = Integer.parseInt(txtn3.getText());
				vetor[3] = Integer.parseInt(txtn4.getText());
				vetor[4] = Integer.parseInt(txtn5.getText());
				vetor[5] = Integer.parseInt(txtn6.getText());
				vetor[6] = Integer.parseInt(txtn7.getText());
				vetor[7] = Integer.parseInt(txtn8.getText());
				vetor[8] = Integer.parseInt(txtn9.getText());
				vetor[9] = Integer.parseInt(txtn10.getText());
				
				
				do {
					controle = true;
					for (i=0; i<9; i++) {
						if (vetor[i] > vetor[i+1]) {
							backup = vetor[i];
							vetor[i] = vetor[i+1];
							vetor[i+1] = backup;
							controle = false;
						}
					}
				} while (controle == false);
				

				JOptionPane.showMessageDialog(null, "Valores Ordenados:\n\n" + vetor[0] + ", " + vetor[1] + ", " + vetor[2] + ", " + vetor[3] + ", " + vetor[4] + ", " + vetor[5] + ", " + vetor[6] + ", " + vetor[7] + ", " + vetor[8] + ", " + vetor[9]);
			
			}
		});
		
		paine.add(btlimpar);
		btlimpar.setBounds(60, 470, 80, 40);
		btlimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtn1.setText("");
				txtn2.setText("");
				txtn3.setText("");
				txtn4.setText("");
				txtn5.setText("");
				txtn6.setText("");
				txtn7.setText("");
				txtn8.setText("");
				txtn9.setText("");
				txtn10.setText("");
				
			}
		});
		
		paine.add(btsair);
		btsair.setBounds(60, 520, 80, 40);
		btsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair?","Fechar Programa",JOptionPane.YES_NO_OPTION) == 0) {
					System.exit(0);
				}
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(200, 600);
		this.setResizable(false);
	}
	public static void main(String args[]){
		BSexercicio bs = new BSexercicio();
	}
}
