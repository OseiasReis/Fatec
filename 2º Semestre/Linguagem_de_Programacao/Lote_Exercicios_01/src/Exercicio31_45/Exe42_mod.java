package Exercicio31_45;

public class Exe42_mod {
	public static void main(String args[]) {
		int n=99, i=1;
		double res=0, s=1;
		serie(res, s, n, i);
	}

	private static void serie(double res, double s, int n, int i) {
		for(s=1; s<=n; s++){
			res+= (i/s);
			System.out.println(i+"/" + s + "= " + res);
			s++;
			i++;
		}
	}
}
