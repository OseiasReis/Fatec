package vetor;

import java.util.Random;

public class Exe02 {
	public static void main(String args[]) {
		int n[]= new int[100], i, j, m=0, ma=0, me=9999;
		double media=0.0;
		Random gerador = new Random();
		
		for(i=0; i<=99; i++){
			j=gerador.nextInt(99)+1;
			n[i]=j;
			System.out.println("Digite um numero: "+ j);
			media += n[i];
			m++;
			if(n[i] > ma){
				ma=n[i];
			}
			if(n[i] < me){
				me=n[i];
			}
		}
		media= media/m;
		System.out.println("Maior: "+ ma);
		System.out.println("Menor: "+ me);
		System.out.println("Média: "+ media);
		
	}
}
