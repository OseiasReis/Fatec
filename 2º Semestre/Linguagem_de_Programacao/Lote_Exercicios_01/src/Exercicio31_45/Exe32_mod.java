package Exercicio31_45;

import java.util.Random;

public class Exe32_mod {
	public static void main(String args[]) {
		int n;
		Random gerador = new Random();
		n= gerador.nextInt(10)+1;
		System.out.println("Digite um número inteiro");
		fatorial(n);
	}

	private static void fatorial(int n) {
		int n1, f;
		f=n;
		if(n==0 || n==1) {
			System.out.println(n + "! = 1");
		}else {
			for(n1=n; n1>=2; n1--) {
				f=f*(n1-1);
			}
			System.out.println(n + "! = " + f + "\n");
		}
	}
}
