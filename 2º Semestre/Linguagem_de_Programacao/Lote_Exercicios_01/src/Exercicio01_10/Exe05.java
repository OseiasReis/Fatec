package Exercicio01_10;

import java.util.Random;

public class Exe05 {
	public static void main(String args[]) {
		float a, b, c, delta, x1, x2, l;
		Random gerador = new Random();
		l= gerador.nextInt(11)+1;
		a = l;
		System.out.println("A: " + a);
		l= gerador.nextInt(11)+1;
		b = l;
		System.out.println("B: " + b);
		l= gerador.nextInt(11)+1;
		c = l;
		System.out.println("C: " + c);
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
