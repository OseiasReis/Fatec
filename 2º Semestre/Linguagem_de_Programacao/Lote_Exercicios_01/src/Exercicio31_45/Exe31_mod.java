package Exercicio31_45;

public class Exe31_mod {
	public static void main(String args[]) {
		quadrado();
	}

	private static void quadrado() {
		int n, res;
		for(n=10; n<=150; n++) {
			res=n*n;
			System.out.println(n + "= " + res);
		}
	}
}
