package BooubleSort;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Interface extends JFrame {
	
	Object obj;
	JLabel lbrotulo = new JLabel("Insira 10 números naturais");
	JLabel lbnum1 = new JLabel("1º Número");
	JLabel lbnum2 = new JLabel("2º Número");
	JLabel lbnum3 = new JLabel("3º Número");
	JLabel lbnum4 = new JLabel("4º Número");
	JLabel lbnum5 = new JLabel("5º Número");
	JLabel lbnum6 = new JLabel("6º Número");
	JLabel lbnum7 = new JLabel("7º Número");
	JLabel lbnum8 = new JLabel("8º Número");
	JLabel lbnum9 = new JLabel("9º Número");
	JLabel lbnum10 = new JLabel("10º Número");
	
	JTextField txtnum1 = new JTextField();
	JTextField txtnum2 = new JTextField();
	JTextField txtnum3 = new JTextField();
	JTextField txtnum4 = new JTextField();
	JTextField txtnum5 = new JTextField();
	JTextField txtnum6 = new JTextField();
	JTextField txtnum7 = new JTextField();
	JTextField txtnum8 = new JTextField();
	JTextField txtnum9 = new JTextField();
	JTextField txtnum10 = new JTextField();
	
	JButton btapresentar = new JButton("Apresentar");
	JButton btlimpar = new JButton("Limpar");
	JButton btsair = new JButton("Sair");
	
	
	public Interface() {
		
		super(" **** Técnica Boouble Sort **** ");
		
		Container pane = getContentPane();
		setSize(400, 750);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pane.add(lbrotulo);
		lbrotulo.setBounds(150, 20, 500, 30);
		pane.add(lbnum1);
		lbnum1.setBounds(20, 100, 100, 30);
		pane.add(txtnum1);
		txtnum1.setBounds(130, 100, 150, 30);
		
		pane.add(lbnum2);
		lbnum2.setBounds(20, 150, 100, 30);
		pane.add(txtnum2);
		txtnum2.setBounds(130, 150, 150, 30);
		
		pane.add(lbnum3);
		lbnum3.setBounds(20, 200, 100, 30);
		pane.add(txtnum3);
		txtnum3.setBounds(130, 200, 150, 30);
		
		pane.add(lbnum4);
		lbnum4.setBounds(20, 250, 100, 30);
		pane.add(txtnum4);
		txtnum4.setBounds(130, 250, 150, 30);
		
		pane.add(lbnum5);
		lbnum5.setBounds(20, 300, 100, 30);
		pane.add(txtnum5);
		txtnum5.setBounds(130, 300, 150, 30);
		
		pane.add(lbnum6);
		lbnum6.setBounds(20, 350, 100, 30);
		pane.add(txtnum6);
		txtnum6.setBounds(130, 350, 150, 30);
		
		pane.add(lbnum7);
		lbnum7.setBounds(20, 400, 100, 30);
		pane.add(txtnum7);
		txtnum7.setBounds(130, 400, 150, 30);
		
		pane.add(lbnum8);
		lbnum8.setBounds(20, 450, 100, 30);
		pane.add(txtnum8);
		txtnum8.setBounds(130, 450, 150, 30);
		
		pane.add(lbnum9);
		lbnum9.setBounds(20, 500, 100, 30);
		pane.add(txtnum9);
		txtnum9.setBounds(130, 500, 150, 30);
		
		pane.add(lbnum10);
		lbnum10.setBounds(20, 550, 100, 30);
		pane.add(txtnum10);
		txtnum10.setBounds(130, 550, 150, 30);
		
		pane.add(btapresentar);
		btapresentar.setBounds(20, 630, 130, 40);
		
		pane.add(btlimpar);
		btlimpar.setBounds(160, 630, 100, 40);
		
		pane.add(btsair);
		btsair.setBounds(270, 630, 100, 40);
		
		btapresentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int[] vetor = new int[10];
				int backup;
				int i;
				boolean controle;
				
				vetor[0] = Integer.parseInt(txtnum1.getText());
				vetor[1] = Integer.parseInt(txtnum2.getText());
				vetor[2] = Integer.parseInt(txtnum3.getText());
				vetor[3] = Integer.parseInt(txtnum4.getText());
				vetor[4] = Integer.parseInt(txtnum5.getText());
				vetor[5] = Integer.parseInt(txtnum6.getText());
				vetor[6] = Integer.parseInt(txtnum7.getText());
				vetor[7] = Integer.parseInt(txtnum8.getText());
				vetor[8] = Integer.parseInt(txtnum9.getText());
				vetor[9] = Integer.parseInt(txtnum10.getText());
				
				
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
				

				JOptionPane.showMessageDialog(null, "valores Ordenados:\n\n" + vetor[0] + ", " + vetor[1] + ", " + vetor[2] + ", " + vetor[3] + ", " + vetor[4] + ", " + vetor[5] + ", " + vetor[6] + ", " + vetor[7] + ", " + vetor[8] + ", " + vetor[9]);
			
			}
		});
		
		btlimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtnum1.setText("");
				txtnum2.setText("");
				txtnum3.setText("");
				txtnum4.setText("");
				txtnum5.setText("");
				txtnum6.setText("");
				txtnum7.setText("");
				txtnum8.setText("");
				txtnum9.setText("");
				txtnum10.setText("");
				
			}
		});
		
		btsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair?","Fechar Programa",JOptionPane.YES_NO_OPTION) == 0) {
					System.exit(0);
				}
			}
		});
		
	}
	
	
	
	public static void main(String[] args) {
		
		Interface objinterface = new Interface();
		
	}
	
}
