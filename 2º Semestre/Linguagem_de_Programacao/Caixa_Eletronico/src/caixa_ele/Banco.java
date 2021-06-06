package caixa_ele;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Banco extends JPanel{
	protected int ban, b=0;
	protected JLabel lblMenu;
	protected JButton btnBb, btnSt, btnIt, btnCx, btnVo;
	private JScrollPane spRetirada, spCarregar;
	private Canvas canvas_1, canvas_2, canvas_3;
	
	
	public Banco(boolean ca, boolean es) {
		this.setLayout(null);
		this.setSize(400, 520);
		this.setVisible(true);
		
		lblMenu = new JLabel ("Banco");                      lblMenu.setFont(new Font("Script MT Bold", Font.BOLD, 70));
		btnBb = new JButton ("Banco do Brasil"); 			 btnBb.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnSt = new JButton ("Santander");         	 		 btnSt.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnIt = new JButton ("Itaú");  						 btnIt.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnCx = new JButton ("Caixa");                       btnCx.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnVo = new JButton ("Voltar");                      btnVo.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		btnVo.setContentAreaFilled(false);                   btnVo.setFocusPainted(false);
		
		spRetirada = new JScrollPane();
		spRetirada.setBorder(null);
		spCarregar = new JScrollPane();
		spCarregar.setBorder(null);
		
		
		add(lblMenu);
		lblMenu.setBounds(100, 15, 200, 80);
		
		add(btnBb);
		btnBb.setBounds(90, 125, 215, 50);
		btnBb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lblMenu.setVisible(false);
				btnBb.setVisible(false);
				btnSt.setVisible(false);
				btnIt.setVisible(false);
				btnCx.setVisible(false);
				btnVo.setVisible(false);
				b=1;
				if(ca == true && es == false) {
					add(spCarregar);
					spCarregar.setBounds(0, 0, 750, 625);
					spCarregar.setViewportView(new Carregar(b));
					spCarregar.repaint();
				}
				if(ca == false && es == false) {
					add(spRetirada);
					spRetirada.setBounds(0, 0, 750, 625);
					spRetirada.setViewportView(new Retirada(es, b));
					spRetirada.repaint();
				}
				if(ca == false && es == true) {
					add(spRetirada);
					spRetirada.setBounds(0, 0, 750, 625);
					spRetirada.setViewportView(new Retirada(es, b));
					spRetirada.repaint();
				}
			}
		});
		
		add(btnSt);
		btnSt.setBounds(90, 192, 215, 50);
		btnSt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lblMenu.setVisible(false);
				btnBb.setVisible(false);
				btnSt.setVisible(false);
				btnIt.setVisible(false);
				btnCx.setVisible(false);
				btnVo.setVisible(false);
				b=2;
				if(ca == true && es == false) {
					add(spCarregar);
					spCarregar.setBounds(0, 0, 750, 625);
					spCarregar.setViewportView(new Carregar(b));
					spCarregar.repaint();
				}
				if(ca == false && es == false) {
					add(spRetirada);
					spRetirada.setBounds(0, 0, 750, 625);
					spRetirada.setViewportView(new Retirada(es, b));
					spRetirada.repaint();
				}
				if(ca == false && es == true) {
					add(spRetirada);
					spRetirada.setBounds(0, 0, 750, 625);
					spRetirada.setViewportView(new Retirada(es, b));
					spRetirada.repaint();
				}
			}
		});
		
		add(btnIt);
		btnIt.setBounds(90, 265, 215, 50);
		btnIt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lblMenu.setVisible(false);
				btnBb.setVisible(false);
				btnSt.setVisible(false);
				btnIt.setVisible(false);
				btnCx.setVisible(false);
				btnVo.setVisible(false);
				b=3;
				if(ca == true && es == false) {
					add(spCarregar);
					spCarregar.setBounds(0, 0, 750, 625);
					spCarregar.setViewportView(new Carregar(b));
					spCarregar.repaint();
				}
				if(ca == false && es == false) {
					add(spRetirada);
					spRetirada.setBounds(0, 0, 750, 625);
					spRetirada.setViewportView(new Retirada(es, b));
					spRetirada.repaint();
				}
				if(ca == false && es == true) {
					add(spRetirada);
					spRetirada.setBounds(0, 0, 750, 625);
					spRetirada.setViewportView(new Retirada(es, b));
					spRetirada.repaint();
				}
			}
		});
		
		add(btnCx);
		btnCx.setBounds(90, 331, 215, 50);
		btnCx.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lblMenu.setVisible(false);
				btnBb.setVisible(false);
				btnSt.setVisible(false);
				btnIt.setVisible(false);
				btnCx.setVisible(false);
				btnVo.setVisible(false);
				b=4;
				if(ca == true && es == false) {
					add(spCarregar);
					spCarregar.setBounds(0, 0, 750, 625);
					spCarregar.setViewportView(new Carregar(b));
					spCarregar.repaint();
				}
				if(ca == false && es == false) {
					add(spRetirada);
					spRetirada.setBounds(0, 0, 750, 625);
					spRetirada.setViewportView(new Retirada(es, b));
					spRetirada.repaint();
				}
				if(ca == false && es == true) {
					add(spRetirada);
					spRetirada.setBounds(0, 0, 750, 625);
					spRetirada.setViewportView(new Retirada(es, b));
					spRetirada.repaint();
				}
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
		
		add(btnVo);
		btnVo.setBounds(280, 400, 85, 22);
		btnVo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lblMenu.setVisible(false);
				btnBb.setVisible(false);
				btnSt.setVisible(false);
				btnIt.setVisible(false);
				btnCx.setVisible(false);
				btnVo.setVisible(false);
				canvas_1.setVisible(false);
				canvas_2.setVisible(false);
				canvas_3.setVisible(false);
			}
		});
	}
}
