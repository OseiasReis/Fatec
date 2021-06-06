package Exercicio01_10;

import java.util.Random;

public class Exe08 {
	public static void main(String args[]) {
		float pou, l;
		double am=1.3, valor;
		Random gerador = new Random();
		l= gerador.nextInt(1000)+1;
		pou = l;
		System.out.println("Deposito em poupanca: " + pou);
		valor= (pou*am/100) + pou;
		System.out.println("Valor apos 1 mes: " + valor);
	}
}
