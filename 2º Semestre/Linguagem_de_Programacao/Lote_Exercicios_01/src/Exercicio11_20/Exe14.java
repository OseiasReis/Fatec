package Exercicio11_20;

import java.util.Random;

public class Exe14 {
	public static void main(String args[]) {
		float a1, a2, a3;
		Random gerador = new Random();
		a1 = gerador.nextInt(90)+1;
		System.out.println("Angulo 1: " + a1);
		a2 = gerador.nextInt(90)+1;
		System.out.println("Angulo 2: " + a2);
		a3= a1 + a2;
		a3= 180 - a3;
		System.out.println("Angulo 3: " + a3);
	}
}
