package view;

import java.util.concurrent.Semaphore;

import controller.start;

public class main {
	public static void main (String args[]) {
		int permissao = 4;

		Semaphore semaforo = new Semaphore(permissao);

		for(int id=1; id<5; id++) {
			Thread tCav = new start(id, semaforo);
			tCav.start();

		}
	}

}
