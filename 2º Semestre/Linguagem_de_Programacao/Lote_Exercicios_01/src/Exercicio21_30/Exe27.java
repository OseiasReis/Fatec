package Exercicio21_30;

import java.util.Random;

public class Exe27 {
	public static void main(String args[]) {
		double nv, ec, td, vm;
		Random gerador = new Random();
		nv= gerador.nextInt(25)+1;
		System.out.println("Número de voltas: " + nv);
		ec= gerador.nextInt(25)+1;
		System.out.println("Extenção do circuito (em metros): " + ec);
		td= gerador.nextInt(500)+1;
		System.out.println("Tempo de duração (minutos): " + td);
		vm=((nv*ec)/td*60)*3.6;
		System.out.println("Velocidade média de " + vm + "km/h.");
	}
}
