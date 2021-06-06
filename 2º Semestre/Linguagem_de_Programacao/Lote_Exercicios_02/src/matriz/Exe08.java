package matriz;

import java.util.Random;

public class Exe08 {
	public static void main(String args[]) {
		int p[][]=new int[4][3], i, j, n, s=1, pr=1, v=0;
		Random gerador = new Random();
		
		System.out.println("DIGITE AS VENDAS");
		for(i=0; i<=3; i++) {
			System.out.println("\nSemana "+ s);
			pr=1;
			for(j=0; j<=2; j++) {
				System.out.print("Produto "+ pr +": ");
				n=gerador.nextInt(11);
				p[i][j]=n;
				System.out.println(n);
				pr++;
			}
			s++;
		}
		
		pr=1;
		System.out.println("\n\nA quantidade de cada produto vendido no mês:");
		for(j=0; j<=2; j++){
			for(i=0; i<=3; i++){
				v+=p[i][j];
			}
			System.out.println("Produto "+ pr+ ": "+ v);
			pr++;
			v=0;
		}

		s=1;
		System.out.println("\nA quantidade de produtos vendidos por semana:");
		for(i=0; i<=3; i++){
			for(j=0; j<=2; j++){
				v+=p[i][j];
			}
			System.out.println("Semana "+ s+ ": "+ v);
			s++;
			v=0;
		}
		
		System.out.println("\nO total de produtos vendidos no mês:");
		for(i=0; i<=3; i++){
			for(j=0; j<=2; j++){
				v+=p[i][j];
			}
		} 
		System.out.println("Mês: "+ v);
	}
}
