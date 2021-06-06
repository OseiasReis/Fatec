package Exercicio01_10;

import java.util.Random;

public class Exe07 {
	public static void main(String args[]) {
		float comp, larg, alt, vol, l;
		Random gerador = new Random();
		l= gerador.nextInt(11)+1;
		comp = l;
		System.out.println("Comprimento: " + comp);
		l= gerador.nextInt(11)+1;
		larg = l;
		System.out.println("Largura: " + larg);
		l= gerador.nextInt(11)+1;
		alt = l;
		System.out.println("Altura: " + alt);
		vol= comp*larg*alt;
		System.out.println("Volume do Paralelepipedo: " + vol + " m3");
	}
}
