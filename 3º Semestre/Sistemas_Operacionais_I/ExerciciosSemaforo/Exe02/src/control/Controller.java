package control;

import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Controller extends Thread {
	private JLabel lblCar1, lblCar2, lblCar3, lblCar4;
	private JButton btnCorrer;
	private Semaphore semaforo;
	Random r = new Random();
	int distFinal = 525; 
	int distPerc = 0;
	int tempo = 10;
	String sent;

	public Controller(Semaphore semaforo, JLabel lblCar1, JLabel lblCar2, JLabel lblCar3, JLabel lblCar4, JButton btnCorrer) {
		this.semaforo = semaforo; 
		this.lblCar1 = lblCar1;
		this.lblCar2 = lblCar2;
		this.lblCar3 = lblCar3;
		this.lblCar4 = lblCar4;
		this.btnCorrer = btnCorrer;

	}

	@Override
	public void run() {
		
		carro1();
		try {
			semaforo.acquire();
			carro2();
			carro3();
			carro4();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		btnCorrer.setEnabled(true);
	}

	private void carro1() {
		Rectangle posicao;
		posicao = lblCar1.getBounds();
		lblCar1.setBounds(posicao);
		int distPerc = 0;
		while (distPerc < distFinal) {
			int desloc = 5;
			distPerc += desloc;
			posicao.x = posicao.x + desloc;
			sent = "Leste";
			lblCar1.setBounds(posicao);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Sentido: " + sent);
	}
	
	private void carro2() {
		Rectangle posicao;
		posicao = lblCar2.getBounds();
		lblCar2.setBounds(posicao);
		int distPerc = 0;
		while (distPerc < distFinal) {
			int desloc = 5;
			distPerc += desloc;
			posicao.y = posicao.y + desloc;
			sent = "Sul";
			lblCar2.setBounds(posicao);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Sentido: " + sent);
	}
	
	private void carro3() {
		Rectangle posicao;
		posicao = lblCar3.getBounds();
		lblCar3.setBounds(posicao);
		int distPerc = 0;
		while (distPerc < distFinal) {
			int desloc = 5;
			distPerc += desloc;
			posicao.x = posicao.x - desloc;
			sent = "Oeste";
			lblCar3.setBounds(posicao);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Sentido: " + sent);
	}
	
	private void carro4() {
		Rectangle posicao;
		posicao = lblCar4.getBounds();
		lblCar4.setBounds(posicao);
		int distPerc = 0;
		while (distPerc < distFinal) {
			int desloc = 5;
			distPerc += desloc;
			posicao.y = posicao.y - desloc;
			sent = "Norte";
			lblCar4.setBounds(posicao);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Sentido: " + sent);
	}
		
//	private void carroAndando() {
//		Rectangle posicao, pfixa;
//		posicao = lblCar.getBounds();
//		pfixa = lblCar.getBounds();
//		lblCar.setBounds(posicao);
//		System.out.println(posicao);
//		int distFinal = 525; 
//		int distPerc = 0;
//		int tempo = 50;
//		while (distPerc < distFinal) {
//			int desloc = 5;
//			distPerc += desloc;
//			
//			if(pfixa.x == 25 && pfixa.y == 245) {
//				posicao.x = posicao.x + desloc;
//				sent = "Leste";
//			}
//			if(pfixa.x == 245 && pfixa.y == 20){
//				posicao.y = posicao.y + desloc;
//				sent = "Sul";
//			}
//			if(pfixa.x == 385 && pfixa.y == 550){
//				posicao.y = posicao.y - desloc;
//				sent = "Norte";
//			}
//			if(pfixa.x == 525 && pfixa.y == 385){
//				posicao.x = posicao.x - desloc;
//				sent = "Oeste";
//			}
//			
//			lblCar.setBounds(posicao);
//			try {
//				Thread.sleep(tempo);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("Sentido: " + sent);
//		btnCorrer.setEnabled(true);
//	}

}