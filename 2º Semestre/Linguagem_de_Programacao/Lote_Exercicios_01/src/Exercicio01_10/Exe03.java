package Exercicio01_10;

import java.util.Random;

public class Exe03 {
	public static void main(String args[]) {
		float bas, alt, area, l;
		Random gerador = new Random();
		l= gerador.nextInt(11)+1;
		bas = l;
		System.out.println("Base: " + bas);
		l= gerador.nextInt(10)+1;
		alt = l;
		System.out.println("Altura: " + alt);
		area = (bas * alt)/2;
		System.out.println("Area: " + area);
	}
}
