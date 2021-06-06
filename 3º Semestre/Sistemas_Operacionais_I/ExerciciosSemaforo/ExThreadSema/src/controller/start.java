package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class start extends Thread {
	
	private Semaphore semaforo;
	private int id;
	private static int posChegada;
	Random r = new Random();
	private int distFinal = 2000;
	private int distPerc = 0;
	private int tempo = 50;
	private int distocha = 500;
	private int dispedra = 1500;
	private static int pegouTocha=0;
	private static int pegouPedra=0;
	private static boolean tocha = false;
	private static boolean pedra = false;
	
	private int portaCerta = r.nextInt(4)+1;
	private static int porta;

	public start(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo; 

	}

	@Override
	public void run() {
		
		cavAndando();
		try {
			semaforo.acquire();
			porta += 1;
			abrirPorta(porta);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void cavAndando() {
		while (distPerc < distFinal) {
			int desloc = r.nextInt(3)+2;
			distPerc += desloc;
			pegouTocha();
			pegouPedra();
			System.out.println("Cavaleiro #" + id + " andou " + distPerc + "m. ");
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		posChegada++;
		System.out.println("CAVALEIRO #" + id + " FOI O " + posChegada + "º A CHEGAR.");
		
	}
	private void pegouTocha() {
		if(distPerc >= distocha) {
			if(pegouTocha == id) {	
				distPerc += 2;
			} else {
				if(tocha == false) {
					pegouTocha = id;
					System.out.println("CAVALEIRO #" + id + " PEGOU A TOCHA.");
					tocha = true;
				}
			}
		}
	}
	
	private void pegouPedra() {
		if(distPerc >= dispedra) {
			if(pegouPedra == id) {					
				distPerc += 2;
			} else {
				if(pedra == false) {
					pegouPedra = id;
					System.out.println("CAVALEIRO #" + id + " PEGOU A PEDRA.");
					pedra = true;
				}
			}
		}
	}

	private void abrirPorta(int porta) {
		System.out.println("CAVALEIRO " + id + " ABRIU A PORTA " + porta);
		if(porta == portaCerta) {
			System.out.println("CAVALEIRO " + id + " ABRIU A PORTA CERTA E VENCEU!!!!!!!!!!!!!!!");
		}else {
			System.out.println("CAVALEIRO " + id + " ABRIU A PORTA ERRADA E MORREU...");
		}
	}
}
