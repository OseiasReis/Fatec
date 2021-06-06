package Exercicio11_20;

import java.util.Random;

public class Exe15 {
	public static void main(String args[]) {
		float c1, c2;
		double h;
		Random gerador = new Random();
		c1 = gerador.nextInt(15)+1;
		System.out.println("Cateto 1: " + c1);
		c2 = gerador.nextInt(15)+1;
		System.out.println("Cateto 2: " + c2);
		h= (c1*c1) + (c2*c2);
		h= Math.sqrt(h);
		System.out.println("Hipotenusa: " + h);
	}
}
