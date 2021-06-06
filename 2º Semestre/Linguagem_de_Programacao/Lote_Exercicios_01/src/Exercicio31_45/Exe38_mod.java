package Exercicio31_45;

import java.util.Random;

public class Exe38_mod {
	public static void main(String args[]) {
		float ma=0, me=9999;
		ma_me(ma, me);
	}

	private static void ma_me(float ma, float me) {
		float n=0;
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
