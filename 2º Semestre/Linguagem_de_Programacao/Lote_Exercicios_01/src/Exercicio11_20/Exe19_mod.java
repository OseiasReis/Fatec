package Exercicio11_20;

import java.util.Random;

public class Exe19_mod {
	public static void main(String args[]) {
		double n1, n2;
		Random gerador = new Random();
		n1 = gerador.nextDouble()*40;
		System.out.println("Numero 1: " + n1);
		n2 = gerador.nextDouble()*40;
		System.out.println("Numero 2: " + n2);
		maior(n1, n2);
	}

	private static void maior(double n1, double n2) {
		if(n1 > n2){
			System.out.println("Maior: " + n1);
		}else {
			System.out.println("Maior: " + n2);
		}
	}
	
}
