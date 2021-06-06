package controller;

import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class control extends Thread {
	private JLabel lblCor;
	private JButton btnCorrer;
	private JTextField txtWin;
	private Semaphore semaforo;
	private int id;
	private static int posChegada;
	Random r = new Random();

	public control(int id, Semaphore semaforo, JLabel lblCor, JButton btnCorrer, JTextField txtWin) {
		this.id = id;
		this.semaforo = semaforo; 
		this.lblCor = lblCor;
		this.btnCorrer = btnCorrer;
		this.txtWin = txtWin;

	}

	@Override
	public void run() {
		
		pessoaandando();
		try {
			semaforo.acquire();
//			pessoaParado();
//			pessoaSaindo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void pessoaandando() {
		posChegada=0;
		Rectangle posicao;
		posicao = lblCor.getBounds();
		lblCor.setBounds(posicao);
		int distFinal = 200; 
		int distPerc = 0;
		int tempo = 50;
		while (distPerc < distFinal) {
			int desloc = r.nextInt(3)+4;
			distPerc += desloc;
			posicao.x = posicao.x + desloc;
			lblCor.setBounds(posicao);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("pessoa #" + id + " andou " + distPerc + "m. ");
		}
		posChegada++;
		System.out.println("pessoa #" + id + " cruzou a porta em " + posChegada + " lugar");
		btnCorrer.setEnabled(true);
	}

//	private void pessoaParado() {
//		System.out.println("pessoa #" + id + " estacionou.");
//		int tempoParado = r.nextInt(2)+2; //de 2000 a 3000
//		try {
//			Thread.sleep(tempoParado);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	private void pessoaSaindo() {
//		posSaida++;
//		System.out.println("pessoa #" + id + " foi o " + posSaida + "o. a sair.");
//	}
}
