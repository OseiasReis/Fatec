package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class veiculos extends Thread {
	
	private Semaphore semaforo;
	private int id;
	Random r = new Random();

	public veiculos(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo; 

	}

	@Override
	public void run() {
		
		if(id % 2 == 0) {
			try {
				semaforo.acquire();
				veiAndando();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
		if(id % 2 == 1) {
			try {
				semaforo.acquire();
				veiAndando();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}

	private void veiAndando() {
		int tempo = r.nextInt(7000)+2000;	
		if(id%2==0){
			System.out.println("Carro #" + id + " procurando vaga");
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			carro();
		}
		if(id%2==1){
			System.out.println("Moto #" + id + " procurando vaga");
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			moto();
		}
	}
	private void carro() { 
		System.out.println("CARRO #" + id + " ESTACIONOU");
	}

	private void moto() { 
		System.out.println("MOTO #" + id + " ESTACIONOU");
	}
}
