package Exercicio11_20;

import java.util.Random;

public class Exe17_mod {
	public static void main(String args[]) {
		float tp, vm;
		Random gerador = new Random();
		tp = gerador.nextInt(12)+1;
		System.out.println("Tempo percorrido em horas: " + tp);
		vm = gerador.nextInt(150)+1;
		System.out.println("Velocidade media: " + vm);
		litros(tp, vm);
	}

	private static void litros(float tp, float vm) {
		float dis, lg;
		dis= tp*vm;
		lg= dis/12;
		System.out.println("Quantidade de litros gastos: " + lg + " litros");
	}
	
	
}
