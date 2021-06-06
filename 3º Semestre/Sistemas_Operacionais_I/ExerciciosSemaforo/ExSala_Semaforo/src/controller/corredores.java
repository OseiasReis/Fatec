package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class corredores extends Thread {
	
	private Semaphore semaforo;
	private int id;
	Random r = new Random();
	private int distFinal = 15;
	private int distPerc = 0;

	public corredores(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo; 

	}

	@Override
	public void run() {
		cavAndando();
		if(id % 3 == 0) {
			try {
				semaforo.acquire();
				pegouP();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
		if(id % 3 == 1) {
			try {
				semaforo.acquire();
				pegouM();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
		if(id % 3 == 2) {
			try {
				semaforo.acquire();
				pegouG();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			
		}
		
	}

	private void cavAndando() {
		while (distPerc < distFinal) {
			int desloc = r.nextInt(3)+2;
			int tempo = r.nextInt(5000)+2000;
//			int desloc = 5;
			distPerc += desloc;
			
			System.out.println("Corredor #" + id + " andou " + distPerc + "m. ");
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void pegouP() { 
		System.out.println("CORREDOR #" + id + " PEGOU A PEDRA P.");
		try {
			Thread.sleep(r.nextInt(4000)+1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("CORREDOR #" + id + " JOGOU A PEDRA P. ------------");
		}	
	}

	private void pegouM()  {
		System.out.println("CORREDOR #" + id + " PEGOU A PEDRA M.");
		try {
			Thread.sleep(r.nextInt(7000)+3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("CORREDOR #" + id + " JOGOU A PEDRA M. ------------");
		}
	}

	private void pegouG() {
		System.out.println("CORREDOR #" + id + " PEGOU A PEDRA G.");
		try {
			Thread.sleep(r.nextInt(8000)+4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("CORREDOR #" + id + " JOGOU A PEDRA G. ------------");
		}
		
	}
}
