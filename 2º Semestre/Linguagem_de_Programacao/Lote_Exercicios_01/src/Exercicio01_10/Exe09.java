package Exercicio01_10;

import java.util.Random;

public class Exe09 {
	public static void main(String args[]) {
		int n1, n2, soma, l;
		Random gerador = new Random();
		l= gerador.nextInt(11)+1;
		n1 = l;
		System.out.println("Numero 1: " + n1);
		l= gerador.nextInt(11)+1;
		n2 = l;
		System.out.println("Numero 2: " + n2);
		n1= n1 * n1;
		n2= n2 * n2;
		soma = n1 + n2;
		System.out.println("Quadrados: N1:" + n1 + " N2:" + n2);
		System.out.println("Soma dos quadrados: " + soma);
	}
}
