package vetor;

import java.util.Random;

public class Exe04 {
	public static void main(String args[]) {
		int i, j, m=0, qam=0;
		double media=0.0, n[]= new double[30];
		Random gerador = new Random();
		
		for(i=0; i<=29; i++){
			j=gerador.nextInt(11);
			n[i]=j;
			System.out.println("Nota: "+ n[i]);
			media += n[i];
			m++;
			if(i==29){
				media= media/m;;
				for(i=0; i<=29; i++) {
					if(n[i] > media) {
						qam++;
					}
				}
			}
		}
		System.out.println("M�dia do grupo: "+ media);
		System.out.println("Quantidade acima da m�dia: "+ qam);
		System.out.println("Posi��o dos valores abaixo da m�dia: ");
		for(i=0; i<=29; i++) {
			if(n[i]<media) {
				System.out.print(i + " - "); 
			}
		}
	}
}
