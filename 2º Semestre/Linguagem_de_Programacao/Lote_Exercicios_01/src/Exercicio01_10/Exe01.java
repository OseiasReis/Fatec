package Exercicio01_10;

import java.util.Random;

public class Exe01 {
	public static void main(String args[]) {
		float lad, area, l;
		Random gerador = new Random();
		l= gerador.nextInt(10)+1;
		lad = l;
		System.out.println("Lado: " + lad);
		area = lad * lad;
		System.out.println("Area: " + area);
	}
}
