package Exercicio11_20;

import java.util.Random;

public class Exe20_mod {
	public static void main(String args[]) {
		float a, b, c;
		Random gerador = new Random();
		a = gerador.nextInt(11)+1;
		System.out.println("A: " + a);
		b = gerador.nextInt(11)+1;
		System.out.println("B: " + b);
		c = gerador.nextInt(11)+1;
		System.out.println("C: " + c);
		raiz(a, b, c);
	}
	
	private static void raiz(float a, float b, float c) {
		float delta, x1, x2;
		delta = (b*b)-4*a*c;
		if(delta > 0){
			x1 = (float) ((-b+(Math.sqrt(delta))) / (2*a));
			x2 = (float) ((-b-(Math.sqrt(delta))) / (2*a));
			
			System.out.println("Delta: " + delta);
			System.out.println("Raiz 1: " + x1 + "\nRaiz 2: " + x2);
		}else {
			if(delta == 0) {
				x1 = -b/2*a;
				System.out.println("Possui uma unica raiz: " + x1);
			}else
				System.out.println("Não possui raizes reais");
		}
	}
}