package control;

import java.util.Random;

public class Imprimir extends Thread{
	private int a;

	public Imprimir() {
	}

	public void run() {
		Random r = new Random();
		primeira(a = r.nextInt(20));
		segunda(a = r.nextInt(20));
		terceira(a = r.nextInt(20));
		quarta(a = r.nextInt(20));
		quinta(a = r.nextInt(20));
	}

	private void primeira(int a) {
		System.out.println(a);
	}

	private void segunda(int a) {
		System.out.println(a);
	}

	private void terceira(int a) {
		System.out.println(a);
	}

	private void quarta(int a) {
		System.out.println(a);
	}

	private void quinta(int a) {
		System.out.println(a);
	}
}
