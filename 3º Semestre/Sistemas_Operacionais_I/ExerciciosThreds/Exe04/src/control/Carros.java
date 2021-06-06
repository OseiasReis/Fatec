package control;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Carros extends Thread{
	private JLabel lblCar;
	private JButton btnCorrer;
	private JTextField txtWin, txtLose;
	private int a;
	private String verif;
	Random r = new Random();
	
	public Carros(JLabel lblCar, JButton btnCorrer, JTextField txtWin, JTextField txtLose) {
		this.lblCar = lblCar;
		this.btnCorrer = btnCorrer;
		this.txtWin = txtWin;
		this.txtLose = txtLose;
	}
	
	public void run() {
		car1();
	}

	
	public void car1() {
		Rectangle posicao;
		posicao = lblCar.getBounds();
		lblCar.setBounds(posicao);
		while (posicao.x <= 650) {
			a=r.nextInt(10)+1;
			posicao.x = posicao.x + a;
			lblCar.setBounds(posicao);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		verif = txtWin.getText();
		if(posicao.x>=650 && posicao.y==85) {
			if(verif.equals("")) {
				txtWin.setText("Carro 1");
				txtLose.setText("Carro 2");
			}
		}
		verif = txtWin.getText();
		if(posicao.x>=650 && posicao.y==165) {
			if(verif.equals("")) {
				txtWin.setText("Carro 2");
				txtLose.setText("Carro 1");
			}
		}
		btnCorrer.setEnabled(true);
	}
}
