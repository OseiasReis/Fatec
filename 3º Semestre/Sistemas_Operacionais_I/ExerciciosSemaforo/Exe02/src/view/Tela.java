package view;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import control.Carros;

public class Tela extends JFrame{
	
	public JLabel lblFaixa, lblFaixa2, lblFaixa3, lblFaixa4;
	public JButton btnCorrer;
	//public ImageIcon icone;
	public JLabel lblCar1, lblCar2, lblCar3, lblCar4;
	int i = 10;
	

	public Tela()
	{
		super(".: TI :.");

//		lblTitulo = new JLabel("Need for Slow");
//		lblWin = new JLabel("Ganhador:");
//		txtWin = new JTextField();
		lblFaixa = new JLabel("_______                       ________");
		lblFaixa2 = new JLabel("_______                       ________");
		lblFaixa3 = new JLabel(new ImageIcon("src/images/faixa.png"));
		lblFaixa4 = new JLabel(new ImageIcon("src/images/faixa.png"));
		btnCorrer = new JButton("Correr");
		lblCar1 = new JLabel(new ImageIcon("src/images/carro1.png"));
		lblCar2 = new JLabel(new ImageIcon("src/images/carro2.png"));
		lblCar3 = new JLabel(new ImageIcon("src/images/carro3.png"));
		lblCar4 = new JLabel(new ImageIcon("src/images/carro4.png"));
		
		Container tela = getContentPane();
		setSize(750, 750);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

//		icone = new ImageIcon("src/images/ti.png");
//		setIconImage(icone.getImage());

//		tela.add(lblTitulo);
//		lblTitulo.setFont(new Font("Arial", 1, 34));
//		lblTitulo.setBounds(115, 10, 250, 40);
		
//		tela.add(lblWin);
//		lblWin.setFont(new Font("Arial", 1, 14));
//		lblWin.setBounds(180, 425, 80, 20);
		
//		tela.add(txtWin);
//		txtWin.setFont(new Font("Arial", 1, 14));
//		txtWin.setBounds(280, 425, 120, 20);
//		txtWin.setEditable(false);

		tela.add(lblFaixa);
		lblFaixa.setBounds(0, 137, 760, 60);
		lblFaixa.setFont(new Font("Arial", 1, 50));
		//lblFaixa.setVisible(false);
		
		tela.add(lblFaixa2);
		lblFaixa2.setBounds(0, 462, 760, 60);
		lblFaixa2.setFont(new Font("Arial", 1, 50));
		
		tela.add(lblFaixa3);
		lblFaixa3.setBounds(489, -10, 60, 760);		
		
		tela.add(lblFaixa4);
		lblFaixa4.setBounds(165, -10, 60, 760);

		tela.add(lblCar1);
		lblCar1.setBounds(25, 245, 160, 70);
		
		tela.add(lblCar2);
		lblCar2.setBounds(245, 20, 70, 160);	
		
		tela.add(lblCar3);
		lblCar3.setBounds(525, 385, 160, 70);
		
		tela.add(lblCar4);
		lblCar4.setBounds(385, 550, 70, 160);
		
		tela.add(btnCorrer);
		btnCorrer.setBounds(50, 625, 75, 20);
		Carros car = new Carros(lblCar1, lblCar2, lblCar3, lblCar4, btnCorrer);
		btnCorrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCar1.setBounds(25, 245, 160, 70);
				lblCar2.setBounds(245, 20, 70, 160);
				lblCar3.setBounds(525, 385, 160, 70);
				lblCar4.setBounds(385, 550, 70, 160);
				btnCorrer.setEnabled(false);			
			}
		});	
		btnCorrer.addActionListener(car);
	}
	
	public static void main(String[] args){ 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela t = new Tela(); 
					t.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}