package Exercicio21_30;

import java.util.Random;

public class Exe21 {
	public static void main(String args[]) {
		float n1, n2, n3, n4, media;
		Random gerador = new Random();
		n1= gerador.nextInt(10)+1;
		System.out.println("Nota 1: "+ n1);
		n2= gerador.nextInt(10)+1;
		System.out.println("Nota 2: "+ n2);
		n3= gerador.nextInt(10)+1;
		System.out.println("Nota 3: "+ n3);
		n4= gerador.nextInt(10)+1;
		System.out.println("Nota 4: "+ n4);
		media=(n1+n2+n3+n4)/4;
		if(media >= 6.0){
			System.out.println("APROVADO media: " + media);
		}else {
			if(media >= 3.0 && media < 6.0){
				System.out.println("EXAME media: " + media);
			}else{
				System.out.println("RETIDO media: " + media);
			}
		}
	}
}
