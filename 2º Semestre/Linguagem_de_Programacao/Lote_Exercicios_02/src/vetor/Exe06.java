package vetor;

import java.util.Random;

public class Exe06 {
	public static void main(String args[]) {
		double n[]= new double[20], aux;
		int i, j;
		Random gerador = new Random();

		for(i=0; i<=19; i++){
			System.out.print("Num "+ i+ ": ");
			j=gerador.nextInt(99);
			n[i]=j;
			System.out.println(n[i]);
		}
		for(i=0; i<=18; i++){
			j=i+1;
			if(n[i]>n[j]){
				aux=n[i];
				n[i]=n[j];
				n[j]=aux;
				i=-1;
			}
		}
		for(i=0; i<=19; i++){
			System.out.println(n[i]);
		}
	}
}
