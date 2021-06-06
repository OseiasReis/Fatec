package Exercicio31_45;

import java.util.Random;

public class Exe35 {
	public static void main(String args[]) {
		int n1, n2, i, res=0, soma=0;
		Random gerador = new Random();
		n1= gerador.nextInt(10)+1;
		System.out.println("Numero 1: "+ n1);
		n2= gerador.nextInt(10)+1;
		System.out.println("Numero 1: "+ n2);
		if(n1>n2) {
			System.out.println("Maior: " + n1);
			System.out.println("Menor: " + n2);
			for(i=n2; i<=n1; i++) {
				if(i%2==1) {
					res=i;
					soma+=res;
				}
			}
			System.out.println("Somatória dos números ímpares entre esses valores: " + soma);
		}else {
			System.out.println("Maior: " + n2);
			System.out.println("Menor: " + n1);
			for(i=n1; i<=n2; i++) {
				if(i%2==1) {
					res=i;
					soma+=res;
				}
			}
			System.out.println("Somatória dos números ímpares entre esses valores: " + soma);
		}
	}
}
