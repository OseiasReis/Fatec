package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;


public class Carros implements ActionListener{
		
		private JLabel lblCar1, lblCar2, lblCar3, lblCar4;
		private JButton btnCorrer;
		int permissao = 4;
		
		Semaphore semaforo = new Semaphore(permissao);
		
		public Carros (JLabel lblCar1, JLabel lblCar2, JLabel lblCar3, JLabel lblCar4, JButton btnCorrer) {
			this.lblCar1 = lblCar1;
			this.lblCar2 = lblCar2;
			this.lblCar3 = lblCar3;
			this.lblCar4 = lblCar4;
			this.btnCorrer = btnCorrer;
		}
		
		private void DispararCarros(){
			Thread c1 = new Controller(semaforo, lblCar1, lblCar2, lblCar3, lblCar4, btnCorrer);
			c1.start();
		}
		
//		private void DispararCarros(){
//			Thread c1 = new Controller(semaforo, lblCar1, btnCorrer);
//			Thread c2 = new Controller(semaforo, lblCar2, btnCorrer);
//			Thread c3 = new Controller(semaforo, lblCar3, btnCorrer);
//			Thread c4 = new Controller(semaforo, lblCar4, btnCorrer);
//			c1.start();
//			c2.start();
//			c3.start();
//			c4.start();
//		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DispararCarros();
		}

}
