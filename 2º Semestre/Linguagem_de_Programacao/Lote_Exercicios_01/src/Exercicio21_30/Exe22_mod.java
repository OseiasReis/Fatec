package Exercicio21_30;

import java.util.Random;

public class Exe22_mod {
	public static void main(String args[]) {
		float n1, n2;
		Random gerador = new Random();
		n1= gerador.nextInt(10)+1;
		System.out.println("Nota 1: "+ n1);
		n2= gerador.nextInt(10)+1;;
		System.out.println("Nota 2: "+ n2);
		ordem(n1, n2);
	}
	
	private static void ordem(float n1, float n2) {
		if(n1 > n2){
			System.out.println("Ordem crescente:\n" + n2 + "\n" + n1);
		}else {
			if(n2 > n1){
				System.out.println("Ordem crescente:\n" + n1 + "\n" + n2);
			}else{
				System.out.println("Digite numeros diferentes");
			}
		}
	}
}
