package Exercicio21_30;

import java.util.Random;

public class Exe28 {
	public static void main(String args[]) {
		double pa, mm, np;
		Random gerador = new Random();
		pa= gerador.nextInt(50)+1;
		System.out.println("Preço atual: " + pa);
		mm=8;
		System.out.println("Média mensal: " + mm);
		if(mm < 500){
			if(pa<30){
				np = (pa*10/100) + pa;
				System.out.println("Novo preço: " + np);
			}
			else
				System.out.println("Novo preço: " + pa);
		}
		else
		if(mm >= 500 && mm < 1000){
			if(pa >= 30 & pa < 80){
				np = (pa*15/100) + pa;
				System.out.println("Novo preço: " + np);
			}
			else
				System.out.println("Novo preço: " + pa);
		}
		else
		if(mm >= 1000){
			if(pa >= 80){
				np = ((pa*-5)/100) + pa;
				System.out.println("Novo preço: " + np);
			}
			else
				System.out.println("Novo preço: " + pa);
		}
		else
			System.out.println("Novo preço: " + pa);
	}
}
