package Exercicio31_45;

import java.util.Random;

public class Exe37 {
	public static void main(String args[]) {
		int n1, n, x, r=0;
		Random gerador = new Random();
		n1= gerador.nextInt(100)+1;
		System.out.println("Digite um numero: "+ n1);
		if(n1==0){
			n1=1;
		}
		System.out.println("0");
		for(x=1; r<n1; x++) {
			n=x+r;
			x=r-1;
			r=n;
			System.out.println(r);
		}
	}
}
