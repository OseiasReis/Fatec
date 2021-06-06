package Exercicio31_45;

import java.util.Random;

public class Exe38 {
	public static void main(String args[]) {
		float n=0, ma=0, me=9999;
		int num=0;
		Random gerador = new Random();
		while(num<100) {
			num++;
			n=gerador.nextFloat()*gerador.nextInt(90);
			System.out.println("N"+ num + " = "+ n);
			if(n<0){
				System.out.println("Apenas valores positivos");
				n=n*-1;
				System.out.println("N" + num + " = " + n);
			}
			if(n>ma) {
				ma=n;
			}
			if(n<me) {
				me=n;
			}
		}
		System.out.println("Maior = " + ma);
		System.out.println("Menor = " + me);
	}
}
