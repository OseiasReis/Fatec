package Exercicio1;

public class Apresentacao {
	 public static void main(String args[]) {
		 Valores vl = new Valores(7, 11);
		 Soma sm = new Soma(22, 8, 5);
		 Subtracao sb = new Subtracao(5, 8, 7);
		 Divisao dv = new Divisao(10, 9, 4);
		 Multiplicacao mt = new Multiplicacao(3, 2, 3);
		 Calculadora[] calc = new Calculadora[4];
		 calc[0] = vl;
		 calc[1] = sm;
		 calc[2] = dv;
		 calc[3] = mt;
		 
		 for(int i = 0; i < calc.length; i++)
		     System.out.println(calc[i].getNome() + ": "
		         + calc[i].toString() + " = "
		         + calc[i].result());
		}
	}