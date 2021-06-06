package Exercicio01_10;

import java.util.Random;

public class Exe06 {
	public static void main(String args[]) {
		int x, y, z, l;
		Random gerador = new Random();
		l= gerador.nextInt(11)+1;
		x = l;
		System.out.println("X: " + x);
		l= gerador.nextInt(11)+1;
		y = l;
		System.out.println("Y: " + y);
		z = x;
		x = y;
		y = z;
		System.out.println("Resultado X:" + x + " Y:" + y);
	}
}
