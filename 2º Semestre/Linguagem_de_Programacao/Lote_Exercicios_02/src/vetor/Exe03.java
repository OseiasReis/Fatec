package vetor;

import java.util.Random;

public class Exe03 {
	public static void main(String args[]) {
		int vt1[]= new int[3], vt2[]= new int[3], vt3[]= new int[6], i, j=0, n;
		Random gerador = new Random();
		
		for(i=0; i<=2; i++){
			System.out.print("Digite um numero VT1: ");
			n=gerador.nextInt(99)+1;
			vt1[i]=n;
			System.out.println(vt1[i]);
		}
		for(i=0; i<=2; i++){
			System.out.print("Digite um numero VT1: ");
			n=gerador.nextInt(99)+1;
			vt2[i]=n;
			System.out.println(vt2[i]);
		}
		for(i=0; i<=2; i++){
			vt3[i] = vt1[i];
		}
		for(i=3; i<=5; i++){
			vt3[i] = vt2[j];
			j++;
		}
		System.out.print("\nVT1: ");
		for(i=0; i<=2; i++){
			System.out.print(vt1[i]+ " | ");
		}
		System.out.print("\nVT2: ");
		for(i=0; i<=2; i++){
			System.out.print(vt2[i]+ " | ");
		}
		System.out.print("\nVT3: ");
		for(i=0; i<=5; i++){
			System.out.print(vt3[i]+ " | ");
		}
	}
}
