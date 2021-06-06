package Exercicio31_45;

import java.util.Random;

public class Exe33_mod {
	public static void main(String args[]) {
		int n;
		Random gerador = new Random();
		n= gerador.nextInt(10)+1;
		System.out.println("Digite um numero: " + n);
		serie(n);
	}

	private static void serie(int n) {
		float res=0, s;
		for(s=1; s<=n; s++){
			res+= (1/s);
			System.out.println("1/" + s + "= " + res);
		}
	}
}
