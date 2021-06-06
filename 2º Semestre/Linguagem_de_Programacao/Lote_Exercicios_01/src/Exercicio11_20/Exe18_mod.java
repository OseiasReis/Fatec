package Exercicio11_20;

import java.util.Random;

public class Exe18_mod {
	public static void main(String args[]) {
		int n1, n2;
		Random gerador = new Random();
		n1 = gerador.nextInt(100)+1;
		System.out.println("Numero 1: " + n1);
		n2 = gerador.nextInt(100)+1;
		System.out.println("Numero 2: " + n2);
		diferenca(n1, n2);
	}

	private static void diferenca(int n1, int n2) {
		int dif;
		if(n1 > n2){
			dif = n1 - n2;
			System.out.println("Diferença: " + dif);
		}else {
			dif = n2 - n1;
			System.out.println("Diferença: " + dif);
		}
	}
}
