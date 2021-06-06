package caixa_ele;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Carregar extends JPanel{
	protected int f, i;
	boolean es=false, ca=true;
	
	private JLabel lblMenu, lblc1, lblc2, lblc3, lblc4, lblc5, lblc6;
	
	private JButton btnVo;
	
	private JScrollPane spBanco;
	private Canvas canvas_1, canvas_2, canvas_3;
	
	public Carregar(int b) {
		this.setLayout(null);
		this.setSize(400, 520);
		this.setVisible(true);
		
		Dados dd = new Dados();
		Color vermelho = new Color(235,0,0);
		lblMenu = new JLabel ("Carregar");                    lblMenu.setFont(new Font("Script MT Bold", Font.BOLD, 70));
		lblc1 = new JLabel ("Cédulas de 100:  "+ dd.c[b][5]); lblc1.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		lblc2 = new JLabel ("Cédulas de 50:   "+ dd.c[b][4]); lblc2.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		lblc3 = new JLabel ("Cédulas de 20:   "+ dd.c[b][3]); lblc3.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		lblc4 = new JLabel ("Cédulas de 10:   "+ dd.c[b][2]); lblc4.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		lblc5 = new JLabel ("Cédulas de 5:    "+ dd.c[b][1]); lblc5.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		lblc6 = new JLabel ("Cédulas de 2:    "+ dd.c[b][0]); lblc6.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnVo = new JButton ("Voltar");                       btnVo.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		btnVo.setContentAreaFilled(false);                    btnVo.setFocusPainted(false);
		
		spBanco = new JScrollPane();
		spBanco.setBorder(null);
		
		add(lblMenu);
		lblMenu.setBounds(50, 15, 300, 100);
		
		add(lblc1);
		lblc1.setBounds(70, 85, 300, 100);
		
		add(lblc2);
		lblc2.setBounds(70, 125, 300, 100);
		
		add(lblc3);
		lblc3.setBounds(70, 165, 300, 100);
		
		add(lblc4);
		lblc4.setBounds(70, 205, 300, 100);
		
		add(lblc5);
		lblc5.setBounds(70, 245, 300, 100);
		
		add(lblc6);
		lblc6.setBounds(70, 285, 300, 100);

		add(btnVo);
		btnVo.setBounds(275, 400, 86, 22);
		btnVo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lblMenu.setVisible(false);
				lblc1.setVisible(false);
				lblc2.setVisible(false);
				lblc3.setVisible(false);
				lblc4.setVisible(false);
				lblc5.setVisible(false);
				lblc6.setVisible(false);
				btnVo.setVisible(false);
				add(spBanco);
				spBanco.setBounds(0, 0, 750, 625);
				spBanco.setViewportView(new Banco(ca, es));
				spBanco.repaint();
			}
		});
		
		Canvas canvas = new Canvas();
		canvas = new Canvas();
		canvas.setBackground(Color.GRAY);
		canvas.setBounds(10, 10, 3, 427);
		add(canvas);
		canvas_1 = new Canvas();
		canvas_1.setBackground(Color.GRAY);
		canvas_1.setBounds(10, 434, 368, 3);
		add(canvas_1);
		canvas_2 = new Canvas();
		canvas_2.setBackground(Color.GRAY);
		canvas_2.setBounds(10, 10, 368, 3);
		add(canvas_2);
		canvas_3 = new Canvas();
		canvas_3.setBackground(Color.GRAY);
		canvas_3.setBounds(375, 10, 3, 427);
		add(canvas_3);
	}
}
