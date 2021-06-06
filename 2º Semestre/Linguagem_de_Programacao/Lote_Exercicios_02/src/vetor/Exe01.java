package vetor;

import java.util.Random;

public class Exe01 {
	public static void main(String args[]) {
	int n[]= new int[50], i, j, m=0, impar=0;
	double media=0.0;
	Random gerador = new Random();
	
	for(i=0; i<=49; i++){
		j=gerador.nextInt(50);
		n[i]=j;
		System.out.println("Digite um numero: "+ j);
			if(j>=10 && j<=20){
				media += n[i];
				m++;
			}
			if(n[i] % 2 == 1){
				impar+= n[i];
			}
		}
		media= media/m;
		System.out.println("Média: "+ media);
		System.out.println("Soma do ímpares: "+ impar);
	}
}
