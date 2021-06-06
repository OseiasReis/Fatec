package Exercicio21_30;

import java.util.Random;

public class Exe27_mod {
	public static void main(String args[]) {
		double nv, ec, td;
		Random gerador = new Random();
		nv= gerador.nextInt(25)+1;
		System.out.println("N�mero de voltas: " + nv);
		ec= gerador.nextInt(25)+1;
		System.out.println("Exten��o do circuito (em metros): " + ec);
		td= gerador.nextInt(500)+1;
		System.out.println("Tempo de dura��o (minutos): " + td);
		velmed(nv, ec, td);
	}
	
	private static void velmed(double nv, double ec, double td) {
		double vm;
		vm=((nv*ec)/td*60)*3.6;
		System.out.println("Velocidade m�dia de " + vm + "km/h.");
	}
}
