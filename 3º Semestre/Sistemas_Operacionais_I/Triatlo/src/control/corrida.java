package control;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class corrida extends Thread {
	
	private Semaphore semaforo;
	private int id;
	Random r = new Random();
	private int distFinalCor = 3000;
	private int distFinalCic = 5000;
	private int distPerc = 0;
	private static int v[];
	v[] = new int v{0};

	public corrida(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo; 
	}

	@Override
	public void run() {
		CorridaAtl();
		try {
			semaforo.acquire();
			TiroAtl();
			try {
				semaforo.acquire();
				CiclismoAtl();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 	
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}		
	}

	private void CorridaAtl() {
		while (distPerc < distFinalCor) {
			int desloc = r.nextInt(10)+20;
			int tempo = r.nextInt(3000)+1000;
			distPerc += desloc;
			
			System.out.println("Corredor #" + id + " andou " + distPerc + "m. ");
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void TiroAtl() { 
		try {
			System.out.println("CORREDOR #" + id + " DEU UM TIRO.");
			Thread.sleep(r.nextInt(2000)+1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 	
	}

	private void CiclismoAtl()  {
		while (distPerc < distFinalCic) {
			int desloc = r.nextInt(10)+30;
			int tempo = r.nextInt(3000)+1000;
			distPerc += desloc;
			
			System.out.println("Corredor #" + id + " andou " + distPerc + "m. ");
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
