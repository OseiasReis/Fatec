package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Controller implements ActionListener{
	
	private JButton btnJogar;
	private JTextField txtNum01, txtNum02, txtNum03;
	
	public Controller (JTextField txtNum01, JTextField txtNum02, JTextField txtNum03, JButton btnJogar) {
		this.txtNum01 = txtNum01;
		this.txtNum02 = txtNum02;
		this.txtNum03 = txtNum03;
		this.btnJogar = btnJogar;
	}
	private void DispararCarros(){
		Thread c1 = new CacaNiquel(txtNum01, btnJogar);
		Thread c2 = new CacaNiquel(txtNum02, btnJogar);
		Thread c3 = new CacaNiquel(txtNum03, btnJogar);
		c1.start();
		c2.start();
		c3.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		DispararCarros();
	}
}
