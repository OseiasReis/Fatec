package Exercicio31_45;

import java.util.Random;

public class Exe44_mod {
	public static void main(String args[]) {
		int base, exp;
		Random gerador = new Random();
		base= gerador.nextInt(10)+1;
		System.out.println("Base: "+base);
		exp= gerador.nextInt(10)+1;
		System.out.println("Expoente: "+exp);
		potencia(base, exp);
	}

	private static void potencia(int base, int exp) {
		int i=0, res=1;
		while(i<exp){
			res=res*base;
			i++;
		}
		System.out.println(res+ " é a potência");
	}
}
