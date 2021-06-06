package Exercicio31_45;

import java.util.Random;

public class Exe34_mod {
	public static void main(String args[]) {
		int n;
		Random gerador = new Random();
		n= gerador.nextInt(10)+1;
		System.out.println("Digite um numero: ");
		tabuada(n);
	}

	private static void tabuada(int n) {
		int t, res;
		for(t=1; t<=10; t++){
			res=t*n;
			System.out.println(n + "x" + t + "= " + res);
		}
	}
}
