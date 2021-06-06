package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	
	private Semaphore semaforo;
	private int id;
	private static int posChegada;
	private static int posSaida;

	public ThreadCarro(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {
		
		carroAndando();
		try {
			semaforo.acquire();
			carroParado();
			carroSaindo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void carroAndando() {// ações do carro até chegar no estacionamento
		int distFinal = (int) ((Math.random() * 1001) + 1000); // gerando valores de 1000 --> 2000 //1001 pois se for
																// somente 1000
		// vai ser gerado um valor de 999, nisso acrescentamos 1 + 1000 para gerar 2000
		// quando coloca (int) antes do math os valores gerados são os que estão antes
		// da vírgula, a direita
		int distPerc = 0;
		int desloc = (int) ((Math.random() * 41) + 60); // simulação de velocidade
		int tempo = 50;
		while (distPerc < distFinal) {
			distPerc += desloc;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Carro #" + id + " andou " + distPerc + "m. ");
		}
		posChegada++;
		System.out.println("Carro #" + id + " foi o " + posChegada + " a chegar.");
	}

	private void carroParado() {
		System.out.println("Carro #" + id + " estacionou.");
		int tempoParado = (int) ((Math.random()*2001)+1000); //de 2000 a 3000
		try {
			Thread.sleep(tempoParado);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void carroSaindo() {
		posSaida++;
		System.out.println("Carro #" + id + " foi o " + posSaida + "o. a sair.");
	}
}
