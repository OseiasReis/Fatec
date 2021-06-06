package view;

import java.util.concurrent.Semaphore;

import controller.veiculos;

public class main {
	public static void main (String args[]) {
	int permissao = 1;
	
	Semaphore semaforo = new Semaphore(permissao);
	
	for(int id=1; id<20; id++) {
		Thread tCav = new veiculos(id, semaforo);
		tCav.start();
		
	}
}

}
