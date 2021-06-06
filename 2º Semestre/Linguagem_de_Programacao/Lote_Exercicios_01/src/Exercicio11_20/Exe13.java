package Exercicio11_20;

import java.util.Random;

public class Exe13 {
	public static void main(String args[]) {
		float ali, alid=50, l;
		int dias=0;
		Random gerador = new Random();
		l= gerador.nextInt(1000)+1;
		ali = l;
		System.out.println("Alimentos em quilos: " + ali);
		if(ali>=alid) {
			while(alid<=ali){
				ali = ali - 50;
				dias++;
			}
			System.out.println("Durara " + dias + " dias");
		}else
			System.out.println("Durara " + dias + " dias");
	}
}
