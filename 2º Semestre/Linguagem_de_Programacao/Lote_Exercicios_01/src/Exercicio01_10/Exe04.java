package Exercicio01_10;

import java.util.Random;

public class Exe04 {
	public static void main(String args[]) {
		float cels, fahr, l;
		Random gerador = new Random();
		l= gerador.nextInt(40)+1;
		cels = l;
		System.out.println("Temperatura em Cº: " + cels + "º");
		fahr = (9*cels + 160)/5;
		System.out.println("Temperatura em Fº: " + fahr + "º");
	}
}
