package Exercicio21_30;

import java.util.Random;

public class Exe23_mod {
	public static void main(String args[]) {
		int n1, n2;
		Random gerador = new Random();
		n1= gerador.nextInt(3)+1;
		System.out.println("Numero 1: "+ n1);
		n2= gerador.nextInt(5)+1;
		System.out.println("Numero 2: "+ n2);
		cresc(n1, n2);
	}
	
	private static void cresc(int n1, int n2) {
		int n3, n4;
		Random gerador = new Random();
		if(n1 <= n2){
			n3= gerador.nextInt(9)+1;
			System.out.println("Numero 3: " + n3);
			if(n3 >= n1 && n3 >= n2){
				n4= gerador.nextInt(10)+1;
				System.out.println("Numero 4: " + n4);
				if(n4 == n1 || n4 == n2 || n4 == n3) {
					System.out.println("Digite outro numero");
				}else {
					if(n4 < n1) {
						System.out.println("Ordem crescente:\n" + n4 + "\n" + n1 + "\n" + n2 + "\n" + n3);
					}else {
						if(n4>n1 && n4<n2) {
							System.out.println("Ordem crescente:\n" + n1 + "\n" + n4 + "\n" + n2 + "\n" + n3);
						}else {
							if(n4>n2 && n4<n3) {
								System.out.println("Ordem crescente:\n" + n1 + "\n" + n2 + "\n" + n4 + "\n" + n3);
							}else {
								System.out.println("Ordem crescente:\n" + n1 + "\n" + n2 + "\n" + n3 + "\n" + n4);
							}
						}
					}
				}
			}else
				System.out.println("Digite numeros em ordem crescente");
		}else
			System.out.println("Digite numeros em ordem crescente");
	}
}
