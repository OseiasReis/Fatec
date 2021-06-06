package Exercicio21_30;

import java.util.Random;

public class Exe26 {
	public static void main(String args[]) {
		int n1, n2, m;
		Random gerador = new Random();
		n1= gerador.nextInt(10);
		System.out.println("Digite um numero: " + n1);
		n2= gerador.nextInt(10);
		System.out.println("Digite um numero: " + n2);
		if(n1>n2){
			m=n2*n2;
			if(n1==m){
				System.out.println(n1 + " é multiplo de " + n2);
			}
			else
				System.out.println(n1 + " não é multiplo de " + n2);
		}else{
			m=n1*n1;
			if(n2==m){
				System.out.println(n2 + " é multiplo de " + n1);
			}else
				System.out.println(n2 + " não é multiplo de " + n1);
		}
	}
}
