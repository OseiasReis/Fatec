package Exercicio31_45;

import java.util.Random;

public class Exe36 {
	public static void main(String args[]) {
		int s, n;
		double res=0, n1, f;
		Random gerador = new Random();
		n= gerador.nextInt(10)+1;
		System.out.println("Digite um numero: "+ n);
		f=1;
		s=1;
		System.out.println("1");
		for(n1=1; n1<=n; n1++) {
			f= f*(n1);
			res+= (1/f);
			System.out.println("1/" + s + "!= " + res);
			s++;
		}
	}
}
