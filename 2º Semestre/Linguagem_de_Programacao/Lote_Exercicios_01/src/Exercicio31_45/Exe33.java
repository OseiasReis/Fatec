package Exercicio31_45;

import java.util.Random;

public class Exe33 {
	public static void main(String args[]) {
		float res=0, s;
		int n;
		Random gerador = new Random();
		n= gerador.nextInt(10)+1;
		System.out.println("Digite um numero: " + n);
		for(s=1; s<=n; s++){
			res+= (1/s);
			System.out.println("1/" + s + "= " + res);
		}
	}
}
