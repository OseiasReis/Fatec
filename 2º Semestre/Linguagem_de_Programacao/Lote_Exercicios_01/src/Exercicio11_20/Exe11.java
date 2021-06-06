package Exercicio11_20;

import java.util.Random;

public class Exe11 {
	public static void main(String args[]) {
		float raio, l;
		double pi=3.14, area;
		Random gerador = new Random();
		l= gerador.nextInt(11)+1;
		raio = l;
		System.out.println("Raio da circunferencia: " + raio);
		area= 2*pi*raio;
		System.out.println("A area da circunferencia eh: " + area);
	}
}
