package Exercicio01_10;

import java.util.Random;

public class Exe02 {
	public static void main(String args[]) {
		float sal, salr, l;
		Random gerador = new Random();
		l= gerador.nextInt(10000);
		sal = l;
		System.out.println("Salario: " + sal);
		salr = (float) ((sal * 0.15) + sal);
		System.out.println("Salario com reajuste: " + salr);
	}
}
