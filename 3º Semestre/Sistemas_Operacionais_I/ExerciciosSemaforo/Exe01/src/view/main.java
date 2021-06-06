package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.control;

public class main implements ActionListener{
	
	private JLabel lblCor1, lblCor2, lblCor3, lblCor4;
	private JButton btnCorrer;
	private JTextField txtWin;
	int permissao = 4;
	int id=1;
	
	Semaphore semaforo = new Semaphore(permissao);
	
	public main (JLabel lblCor1, JLabel lblCor2, JLabel lblCor3, JLabel lblCor4, JButton btnCorrer, JTextField txtWin) {
		this.lblCor1 = lblCor1;
		this.lblCor2 = lblCor2;
		this.lblCor3 = lblCor3;
		this.lblCor4 = lblCor4;
		this.btnCorrer = btnCorrer;
		this.txtWin = txtWin;
	}
	private void DispararPessoas(){
		Thread c1 = new control(id, semaforo, lblCor1, btnCorrer, txtWin); id=2;
		Thread c2 = new control(id, semaforo, lblCor2, btnCorrer, txtWin); id=3;
		Thread c3 = new control(id, semaforo, lblCor3, btnCorrer, txtWin); id=4;
		Thread c4 = new control(id, semaforo, lblCor4, btnCorrer, txtWin);
		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		DispararPessoas();
	}
}
