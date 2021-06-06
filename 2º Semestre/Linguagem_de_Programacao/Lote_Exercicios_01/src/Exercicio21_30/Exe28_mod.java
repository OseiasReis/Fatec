package Exercicio21_30;

public class Exe28_mod {
	public static void main(String args[]) {
		double pa, mm;
		pa=5;
		System.out.println("Preço atual: " + pa);
		mm=450;
		System.out.println("Média mensal: " + mm);
		preco(pa, mm);
	}
	
	private static void preco(double pa, double mm) {
		double np;
		if(mm < 500){
			if(pa<30){
				np = (pa*10/100) + pa;
				System.out.println("Novo preço: " + np);
			}
			else
				System.out.println("Novo preço: " + pa);
		}
		else
		if(mm >= 500 && mm < 1000){
			if(pa >= 30 && pa < 80){
				np = (pa*15/100) + pa;
				System.out.println("Novo preço: " + np);
			}
			else
				System.out.println("Novo preço: " + pa);
		}
		else
		if(mm >= 1000){
			if(pa >= 80){
				np = ((pa*-5)/100) + pa;
				System.out.println("Novo preço: " + np);
			}
			else
				System.out.println("Novo preço: " + pa);
		}
		else
			System.out.println("Novo preço: " + pa);
	}
}
