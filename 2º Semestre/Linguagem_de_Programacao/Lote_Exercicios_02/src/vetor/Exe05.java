package vetor;

import java.util.Random;

public class Exe05 {
	public static void main(String args[]) {
		int n[]= new int[20], i, j, soma=0;
		Random gerador = new Random();
		
		for(i=0; i<=19; i++){
			System.out.print("Num "+ i +": ");
			j=gerador.nextInt(50)+1;
			n[i]=j;
			System.out.println(n[i]);
		}
		for(i=0; i<=19; i++){
			soma = n[i] - n[19-i];
			System.out.println("Soma "+ i +": "+ soma);
		}
	}
}
