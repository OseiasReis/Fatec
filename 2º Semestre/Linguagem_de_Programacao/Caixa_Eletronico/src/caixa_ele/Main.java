package caixa_ele;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Main extends JFrame{
	private JLabel lblMenu;
	private JButton btnCc, btnEst, btnRc, btnFim;
	public JScrollPane spBanco;
	private Canvas canvas, canvas_1, canvas_2, canvas_3;
	
	protected int menu;
	protected boolean ca, es;
	
	public Main() {
		super(".::CAIXA::.");
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(412, 520);
		this.setLocation(350, 150);
		//this.setLocationRelativeTo(null);
		
		lblMenu = new JLabel ("Caixa");                      lblMenu.setFont(new Font("Script MT Bold", Font.BOLD, 70));
		btnCc = new JButton ("Carregar Cédulas"); 			 btnCc.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnRc = new JButton ("Retirar Cédulas");         	 btnRc.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnEst = new JButton ("Estatística");  				 btnEst.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnFim = new JButton ("Fim");                        btnFim.setFont(new Font("Script MT Bold", Font.BOLD, 30));
		
		getContentPane().setLayout(null);
		
		spBanco = new JScrollPane();
		spBanco.setBorder(null);
		getContentPane().add(spBanco);
		spBanco.setBounds(400, 20, 750, 625);
		
		getContentPane().add(lblMenu);
		lblMenu.setBounds(110, 20, 200, 100);
		
		getContentPane().add(btnCc);
		btnCc.setBounds(40, 150, 330, 60);
		btnCc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setSize(800, 520);
				ca=true;
				es=false;
				spBanco.setViewportView(new Banco(ca, es));
				spBanco.repaint();
			}
		});
		
		getContentPane().add(btnRc);
		btnRc.setBounds(40, 230, 330, 60);
		btnRc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setSize(800, 520);
				ca=false;
				es=false;
				spBanco.setViewportView(new Banco(ca, es));
				spBanco.repaint();
			}
		});
		
		getContentPane().add(btnEst);
		btnEst.setBounds(40, 310, 330, 60);
		btnEst.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setSize(800, 520);
				ca=false;
				es=true;
				spBanco.setViewportView(new Banco(ca, es));
				spBanco.repaint();
			}
		});
		
		getContentPane().add(btnFim);
		btnFim.setBounds(40, 390, 330, 60);
		btnFim.setVisible(true);
		btnFim.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		canvas = new Canvas();
		canvas.setBackground(Color.GRAY);
		canvas.setBounds(393, 10, 3, 461);
		getContentPane().add(canvas);
		
		canvas_1 = new Canvas();
		canvas_1.setBackground(Color.GRAY);
		canvas_1.setBounds(10, 10, 386, 3);
		getContentPane().add(canvas_1);
		
		canvas_2 = new Canvas();
		canvas_2.setBackground(Color.GRAY);
		canvas_2.setBounds(10, 10, 3, 461);
		getContentPane().add(canvas_2);
		
		canvas_3 = new Canvas();
		canvas_3.setBackground(Color.GRAY);
		canvas_3.setBounds(10, 468, 386, 3);
		getContentPane().add(canvas_3);
		
	}
	
	public static void main(String args[]){
		Main m = new Main();
	}
}
