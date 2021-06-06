package control;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

public class CacaNiquel extends Thread{

	private JButton btnJogar;
	private JTextField txtNum;
	private int giro, num=1, cont;
	private String texto;
	Random r = new Random();
	
	public CacaNiquel(JTextField txtNum, JButton btnJogar) {

		this.btnJogar = btnJogar;
		this.txtNum = txtNum;
	}
	
	public void run() {
		cac();
	}

	
	public void cac() {
		giro=r.nextInt(150)+1;
		while (cont <= giro) {
			switch (num) {
			case 1:
				texto = "1";
				break;
			case 2:
				texto = "2";
				break;
			case 3:
				texto = "3";
				break;
			case 4:
				texto = "4";
				break;
			case 5:
				texto = "5";
				break;
			case 6:
				texto = "6";
				break;
			case 7:
				texto = "7";
				break;
			}
			txtNum.setText(texto);
			
			num++;
			if (num == 7) {
				num = 1;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			cont++;
		}
		txtNum.setForeground(Color.GREEN);
		btnJogar.setEnabled(true);
	}

	//	public void cac() {
	//		Rectangle posicao;
//		posicao = lblCar.getBounds();
//		lblCar.setBounds(posicao);
//		while (posicao.x <= 650) {
//			a=r.nextInt(7)+1;
//			posicao.x = posicao.x + a;
//			lblCar.setBounds(posicao);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException ex) {
//				ex.printStackTrace();
//			}
//		}
//		verif = txtWin.getText();
//		if(posicao.x>=650 && posicao.y==85) {
//			if(verif.equals("")) {
//				txtWin.setText("Carro 1");
//				txtLose.setText("Carro 2");
//			}
//		}
//		verif = txtWin.getText();
//		if(posicao.x>=650 && posicao.y==165) {
//			if(verif.equals("")) {
//				txtWin.setText("Carro 2");
//				txtLose.setText("Carro 1");
//			}
//		}
//		btnCorrer.setEnabled(true);
//	}
}
