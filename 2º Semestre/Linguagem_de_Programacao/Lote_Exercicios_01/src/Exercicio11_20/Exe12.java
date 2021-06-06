package Exercicio11_20;

import java.util.Random;

public class Exe12 {
	public static void main(String args[]) {
		int an, at, si, ad, l;
		Random gerador = new Random();
		l= gerador.nextInt(1999)+1;
		an = l;
		System.out.println("Ano de nascimento: " + an);
		l= gerador.nextInt(2100)+1;
		at = l;
		System.out.println("Ano atual: " + at);
		si= at-an;
		System.out.println("Sua idade: " + si);
		ad= si + 17;
		System.out.println("Sua idade daqui 17 anos: " + ad);
	}
}
