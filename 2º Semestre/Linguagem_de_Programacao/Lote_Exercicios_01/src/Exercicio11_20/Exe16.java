package Exercicio11_20;

import java.util.Random;

public class Exe16 {
	public static void main(String args[]) {
		float vh, pd, salb, sall;
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
		salb= ht*vh;
		sall= salb-((salb*pd)/100);
		nd= nd*100;
		sall= sall + nd;
		System.out.println("Salario a receber: R$" + sall);
	}
}
