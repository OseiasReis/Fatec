package Exercicio11_20;

import java.util.Random;

public class Exe16_mod {
	public static void main(String args[]) {
		float vh, pd;
		int ht, nd;
		Random gerador = new Random();
		ht = gerador.nextInt(300)+1;
		System.out.println("Horas trabalhadas: " + ht);
		vh = gerador.nextInt(15)+1;
		System.out.println("Valor por hora: " + vh);
		pd = gerador.nextInt(30)+1;
		System.out.println("Percentual de descontos: " + pd);
		nd = gerador.nextInt(10)+1;
		System.out.println("Numero de descendentes: " + nd);
		calc(ht, vh, pd, nd);
	}
	
	public static void calc(int ht, float vh, float pd, int nd){
		float salb, sall;
		salb= ht*vh;
		sall= salb-((salb*pd)/100);
		nd= nd*100;
		sall= sall + nd;
		System.out.println("Salario a receber: R$" + sall);
	}
}
