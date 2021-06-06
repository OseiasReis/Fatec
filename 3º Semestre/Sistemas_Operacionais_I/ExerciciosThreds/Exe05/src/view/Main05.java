package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.Controller;

public class Main05 extends JFrame{
	
	public JLabel lblTitulo;
	public JTextField txtNum01, txtNum02, txtNum03;
	public JButton btnJogar;
	public ImageIcon lblAla01, lblAla02, lblAla03, lblAla04, lblAla05, lblAla06;
	int i = 10;
	

	public Main05()
	{
		super(".: TI :.");

		lblTitulo = new JLabel("Caça-Niquel");
		txtNum01 = new JTextField();
		txtNum02 = new JTextField();
		txtNum03 = new JTextField();
		//btnJogar = new JButton("Jogar");
		btnJogar = new JButton(new ImageIcon("src/images/alavanca01.png"));
		lblAla02 = new ImageIcon("src/images/alavanca02.png");
		lblAla03 = new ImageIcon("src/images/alavanca03.png");
		lblAla04 = new ImageIcon("src/images/alavanca04.png");
		lblAla05 = new ImageIcon("src/images/alavanca05.png");
		lblAla06 = new ImageIcon("src/images/alavanca06.png");
		
		Container tela = getContentPane();
		setSize(550, 350);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		tela.add(lblTitulo);
		lblTitulo.setFont(new Font("Arial", 1, 34));
		lblTitulo.setBounds(180, 10, 250, 40);
		
		tela.add(txtNum01);
		txtNum01.setFont(new Font("Arial", 1, 24));
		txtNum01.setHorizontalAlignment(JTextField.CENTER);
		txtNum01.setBounds(50, 150, 70, 40);
		txtNum01.setEditable(false);
		
		tela.add(txtNum02);
		txtNum02.setFont(new Font("Arial", 1, 24));
		txtNum02.setHorizontalAlignment(JTextField.CENTER);
		txtNum02.setBounds(150, 150, 70, 40);
		txtNum02.setEditable(false);
		
		tela.add(txtNum03);
		txtNum03.setFont(new Font("Arial", 1, 24));
		txtNum03.setHorizontalAlignment(JTextField.CENTER);
		txtNum03.setBounds(250, 150, 70, 40);
		txtNum03.setEditable(false);

//		tela.add(lblCar1);
//		lblCar1.setBounds(25, 85, 160, 70);	
		
		tela.add(btnJogar);
		btnJogar.setBounds(380, 100, 84, 140);
		btnJogar.setOpaque(false);
		btnJogar.setContentAreaFilled(false);
		btnJogar.setBorderPainted(false);
		Controller cac = new Controller(txtNum01, txtNum02, txtNum03, btnJogar);
		btnJogar.addActionListener(cac);
		btnJogar.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent a) {
				txtNum01.setForeground(Color.RED);
				txtNum02.setForeground(Color.RED);
				txtNum03.setForeground(Color.RED);
				btnJogar.setIcon(lblAla06);
				repaint();
//				TrocaImag();
//				btnJogar.setIcon(lblAla03);
//				repaint();
//				TrocaImag();
//				btnJogar.setIcon(lblAla04);
//				repaint();
//				TrocaImag();
//				btnJogar.setIcon(lblAla05);
//				repaint();
//				TrocaImag();
//				btnJogar.setIcon(lblAla06);
//				repaint();
				btnJogar.setEnabled(false);
			}
			public void mouseEntered(MouseEvent arg0) {}

			public void mouseExited(MouseEvent arg0) {}

			public void mousePressed(MouseEvent arg0) {}

			public void mouseReleased(MouseEvent arg0) {}
		});
	}

	public void TrocaImag() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args){ 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main05 m5 = new Main05(); 
					m5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
