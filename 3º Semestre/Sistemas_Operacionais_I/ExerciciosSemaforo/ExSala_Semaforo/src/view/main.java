package view;

import java.util.concurrent.Semaphore;

import controller.corredores;

public class main {
	public static void main (String args[]) {
	int permissao = 1;
	
	Semaphore semaforo = new Semaphore(permissao);
	
	for(int id=1; id<21; id++) {
		Thread tCav = new corredores(id, semaforo);
		tCav.start();
		
	}
}

}
