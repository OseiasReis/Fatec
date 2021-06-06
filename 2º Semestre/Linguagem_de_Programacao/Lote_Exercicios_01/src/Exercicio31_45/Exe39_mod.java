package Exercicio31_45;

public class Exe39_mod {
	public static void main(String args[]) {
		double q=1;
		int c=1;
		tabuleiro(c, q);
	}

	private static void tabuleiro(int c, double q) {
		for(c=1; c<=64; c++) {
			System.out.println(c+ " = "+ q);
			q= q*2;
		}
	}
}
