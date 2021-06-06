package Exercicio11_20;

import java.util.Random;

public class Exe18 {
	public static void main(String args[]) {
		int n1, n2, dif;
		Random gerador = new Random();
		n1 = gerador.nextInt(100)+1;
		System.out.println("Numero 1: " + n1);
		n2 = gerador.nextInt(100)+1;
		System.out.println("Numero 2: " + n2);
		if(n1 > n2){
			dif = n1 - n2;
			System.out.println("Diferença: " + dif);
		}else {
			dif = n2 - n1;
			System.out.println("Diferença: " + dif);
		}
	}
}
