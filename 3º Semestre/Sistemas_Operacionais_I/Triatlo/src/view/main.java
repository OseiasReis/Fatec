package view;

import java.util.concurrent.Semaphore;

import control.corrida;

public class main {
	public static void main (String args[]) {
		int permissao = 1;
		
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int id=1; id<25; id++) {
			Thread tCav = new corrida(id, semaforo);
			tCav.start();
			
		}
	}
}
