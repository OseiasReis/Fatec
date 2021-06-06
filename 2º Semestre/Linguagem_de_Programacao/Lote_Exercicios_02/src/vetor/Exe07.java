package vetor;

import java.util.Random;

public class Exe07 {
	public static void main(String args[]) {
		double n[]= new double[20], aux, nin, nfim;
		int i, j, in, me, fim, num;
		boolean enc=false;
		Random gerador = new Random();

		for(i=0; i<=19; i++){
			System.out.print("Num "+ i+ ": ");
			j=gerador.nextInt(11);
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
			System.out.print(n[i]+" - ");
		}
		
		j=gerador.nextInt(11);
		num=j;
		System.out.println("\nNumero a ser encontrado: "+j);
		
		nin=n[0];
		in=0;
		nfim=n[19];
		fim=19;
		me=(in+fim)/2;
		System.out.println("\nInicio: "+ in+ " --- Valor: "+ nin+ "\nMeio:   "+ me+" --- Valor: "+ n[me]+"\nFim:    "+ fim+ " --- Valor: "+ nfim+ "\nEncontrado: " + enc+ "\n\n");
		
		while(enc==false){
			if(n[me]==num){
				enc=true;
				System.out.println("Numero encontrado: "+ num+ "\nEncontrado: " + enc+ "\n");
			}else{
				if(num>n[me]){
					in=me+1;
					nin=n[me+1];
					me=(in+fim)/2;
					System.out.println("Inicio: "+ in+ " --- Valor: "+ nin+ "\nMeio:   "+ me+" --- Valor: "+ n[me]+"\nFim:    "+ fim+ " --- Valor: "+ nfim+ "\nEncontrado: " + enc+ "\n\n");
				}else{
					fim=me-1;
					nfim=n[me-1];
					me=(in+fim)/2;
					System.out.println("Inicio: "+ in+ " --- Valor: "+ nin+ "\nMeio:   "+ me+" --- Valor: "+ n[me]+"\nFim:    "+ fim+ " --- Valor: "+ nfim+ "\nEncontrado: " + enc+ "\n\n");
				}
			}
		}
	}
}
