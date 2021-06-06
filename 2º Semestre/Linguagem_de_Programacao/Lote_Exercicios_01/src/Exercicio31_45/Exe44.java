package Exercicio31_45;

import java.util.Random;

public class Exe44 {
	public static void main(String args[]) {
		int base, exp, i=0, res=1;
		Random gerador = new Random();
		base= gerador.nextInt(10)+1;
		System.out.println("Base: "+base);
		exp= gerador.nextInt(10)+1;
		System.out.println("Expoente: "+exp);
		while(i<exp){
			res=res*base;
			i++;
		}
		System.out.println(res+ " é a potência");
	}
}
