package Exercicio21_30;

import java.util.Random;

public class Exe29 {
	public static void main(String args[]) {
		int ti;
		double vi, vc;
		Random gerador = new Random();
		ti= gerador.nextInt(2)+1;
		System.out.println("Tipo de investimento \n(1 = poupança e 2 = renda fixa): " + ti);
		if(ti==1 || ti==2){
			vi= gerador.nextInt(5000);
			System.out.println("Valor do investimento: " + vi);
			if(ti==1){
				vc= (vi*3/100) + vi;
				System.out.println("Valor corrigido em 30 dias: " + vc);
			}else {
				if(ti==2){
					vc= (vi*5/100) + vi;
					System.out.println("Valor corrigido em 30 dias: " + vc);
				}
				else
					System.out.println("Tipo não identificado");
			}
		}
	}
}
