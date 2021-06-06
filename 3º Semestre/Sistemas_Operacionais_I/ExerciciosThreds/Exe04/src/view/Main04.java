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
import javax.swing.JTextField;

import control.Controller;

public class Main04 extends JFrame{
	
	public JLabel lblWin, lblLose, lblFaixa, lblTitulo;
	public JTextField txtWin, txtLose;
	public JButton btnCorrer;
	//public ImageIcon icone;
	public JLabel lblCar1, lblCar2;
	int i = 10;
	

	public Main04()
	{
		super(".: TI :.");

		lblTitulo = new JLabel("Need for Slow");
		lblWin = new JLabel("Ganhador:");
		lblLose = new JLabel("Perdedor:");
		txtWin = new JTextField();
		txtLose = new JTextField();
		lblFaixa = new JLabel("___________________________________________________________________________________________________________________");
		btnCorrer = new JButton("Correr");
		lblCar1 = new JLabel(new ImageIcon("src/images/carro1.png"));
		lblCar2 = new JLabel(new ImageIcon("src/images/carro2.png"));
		
		Container tela = getContentPane();
		setSize(850, 500);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

//		icone = new ImageIcon("src/images/ti.png");
//		setIconImage(icone.getImage());

		tela.add(lblTitulo);
		lblTitulo.setFont(new Font("Arial", 1, 34));
		lblTitulo.setBounds(300, 10, 250, 40);
		
		tela.add(lblWin);
		lblWin.setFont(new Font("Arial", 1, 14));
		lblWin.setBounds(450, 300, 80, 20);

		tela.add(lblLose);
		//lblLose.setForeground(new Color(255, 255, 255));
		lblLose.setFont(new Font("Arial", 1, 14));
		lblLose.setBounds(450, 340, 80, 20);
		
		tela.add(txtWin);
		txtWin.setFont(new Font("Arial", 1, 14));
		txtWin.setBounds(530, 300, 120, 20);
		txtWin.setEditable(false);
		
		tela.add(txtLose);
		//lblLose.setForeground(new Color(255, 255, 255));
		txtLose.setFont(new Font("Arial", 1, 14));
		txtLose.setBounds(530, 340, 120, 20);
		txtLose.setEditable(false);

		tela.add(lblFaixa);
		lblFaixa.setBounds(10, 140, 850, 20);
		//lblFaixa.setVisible(false);

		tela.add(lblCar1);
		lblCar1.setBounds(25, 85, 160, 70);
		
		tela.add(lblCar2);
		lblCar2.setBounds(25, 165, 160, 70);	
		
		tela.add(btnCorrer);
		btnCorrer.setBounds(50, 325, 75, 20);
		Controller car = new Controller(lblCar1, lblCar2, btnCorrer, txtWin, txtLose);
		btnCorrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCar1.setBounds(25, 85, 160, 70);
				lblCar2.setBounds(25, 165, 160, 70);
				txtWin.setText("");
				txtLose.setText("");
				btnCorrer.setEnabled(false);
			}
		});	
		btnCorrer.addActionListener(car);
	}

	public static void main(String[] args){ 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main04 m4 = new Main04(); 
					m4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
