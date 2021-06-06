package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Controller implements ActionListener{
	
	private JLabel lblCar1, lblCar2;
	private JButton btnCorrer;
	private JTextField txtWin, txtLose;
	
	public Controller (JLabel lblCar1, JLabel lblCar2, JButton btnCorrer, JTextField txtWin, JTextField txtLose) {
		this.lblCar1 = lblCar1;
		this.lblCar2 = lblCar2;
		this.btnCorrer = btnCorrer;
		this.txtWin = txtWin;
		this.txtLose = txtLose;
	}
	private void DispararCarros(){
		Thread c1 = new Carros(lblCar1, btnCorrer, txtWin, txtLose);
		Thread c2 = new Carros(lblCar2, btnCorrer, txtWin, txtLose);
		c1.start();
		c2.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		DispararCarros();
	}
}
