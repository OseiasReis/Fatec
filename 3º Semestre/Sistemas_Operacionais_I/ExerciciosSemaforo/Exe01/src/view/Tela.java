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

public class Tela extends JFrame{
	
	public JLabel lblWin, lblFaixa, lblFaixa2, lblFaixa3, lblTitulo, lblprimeiro, lblsegundo, lblterceiro, lblquarto;
	public JTextField txtWin;
	public JButton btnCorrer;
	//public ImageIcon icone;
	public JLabel lblCor1, lblCor2, lblCor3, lblCor4;
	int i = 10;
	

	public Tela()
	{
		super(".: TI :.");

		lblTitulo = new JLabel("Need for Slow");
		lblWin = new JLabel("Ganhador:");
		txtWin = new JTextField();
		lblFaixa = new JLabel("________________________________________");
		lblFaixa2 = new JLabel("________________________________________");
		lblFaixa3 = new JLabel("________________________________________");
		lblprimeiro = new JLabel("1º");
		lblsegundo = new JLabel("2º");
		lblterceiro = new JLabel("3º");
		lblquarto = new JLabel("4º");
		btnCorrer = new JButton("Correr");
		lblCor1 = new JLabel(new ImageIcon("src/image/corredor1.png"));
		lblCor2 = new JLabel(new ImageIcon("src/image/corredor1.png"));
		lblCor3 = new JLabel(new ImageIcon("src/image/corredor1.png"));
		lblCor4 = new JLabel(new ImageIcon("src/image/corredor1.png"));
		
		Container tela = getContentPane();
		setSize(450, 500);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

//		icone = new ImageIcon("src/images/ti.png");
//		setIconImage(icone.getImage());

		tela.add(lblTitulo);
		lblTitulo.setFont(new Font("Arial", 1, 34));
		lblTitulo.setBounds(115, 10, 250, 40);
		
		tela.add(lblWin);
		lblWin.setFont(new Font("Arial", 1, 14));
		lblWin.setBounds(180, 425, 80, 20);

		
		tela.add(txtWin);
		txtWin.setFont(new Font("Arial", 1, 14));
		txtWin.setBounds(280, 425, 120, 20);
		txtWin.setEditable(false);

		tela.add(lblFaixa);
		lblFaixa.setBounds(80, 140, 850, 20);
		//lblFaixa.setVisible(false);
		
		tela.add(lblFaixa2);
		lblFaixa2.setBounds(80, 220, 850, 20);
		
		tela.add(lblFaixa3);
		lblFaixa3.setBounds(80, 300, 850, 20);

		tela.add(lblprimeiro);
		lblprimeiro.setBounds(35, 85, 160, 70);
		
		tela.add(lblsegundo);
		lblsegundo.setBounds(35, 165, 160, 70);	
		
		tela.add(lblterceiro);
		lblterceiro.setBounds(35, 245, 160, 70);
		
		tela.add(lblquarto);
		lblquarto.setBounds(35, 325, 160, 70);
		
		tela.add(lblCor1);
		lblCor1.setBounds(25, 85, 160, 70);
		
		tela.add(lblCor2);
		lblCor2.setBounds(25, 165, 160, 70);	
		
		tela.add(lblCor3);
		lblCor3.setBounds(25, 245, 160, 70);
		
		tela.add(lblCor4);
		lblCor4.setBounds(25, 325, 160, 70);
		
		tela.add(btnCorrer);
		btnCorrer.setBounds(50, 425, 75, 20);
		
		main m = new main(lblCor1, lblCor2, lblCor3, lblCor4, btnCorrer, txtWin);
		btnCorrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCor1.setBounds(25, 85, 160, 70);
				lblCor2.setBounds(25, 165, 160, 70);
				lblCor3.setBounds(25, 245, 160, 70);
				lblCor4.setBounds(25, 325, 160, 70);
				txtWin.setText("");
				btnCorrer.setEnabled(false);			
			}
		});	
		btnCorrer.addActionListener(m);
	}

	public static void main(String[] args){ 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela m4 = new Tela(); 
					m4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}