package Exercicio21_30;

import java.util.Random;

public class Exe24_mod {
	public static void main(String args[]) {
		int n1;
		Random gerador = new Random();
		n1= gerador.nextInt(10)+1;
		System.out.println("Numero 1: "+ n1);
		divisivel(n1); 
	}
	
	private static void divisivel(float n1)  {
		if(n1 % 2 == 0 && n1 % 3 == 0) {
			System.out.println(n1 + " é divisivel por 2 e 3");
		}else {
			if(n1 % 2 == 0) {
				System.out.println(n1 + " é divisivel por 2");
			}else {
				if(n1 % 3 == 0) {
					System.out.println(n1 + " é divisivel por 3");
				}else {
					System.out.println(n1 + " NÃO é divisivel por 2 ou 3");
				}
			}
		}
	}
}
