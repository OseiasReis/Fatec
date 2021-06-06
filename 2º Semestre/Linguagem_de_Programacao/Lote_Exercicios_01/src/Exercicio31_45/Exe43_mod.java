package Exercicio31_45;

public class Exe43_mod {
	public static void main(String args[]) {
		int a=0;
		double aa=1.10, am=1.50, ca=0.03, cm=0.02;
		ano(aa, am, ca, cm, a);
	}

	private static void ano(double aa, double am, double ca, double cm, int a) {
		while(aa<=am){
			aa=aa+ca;
			am=am+cm;
			a++;
		}
		System.out.println(a+ " anos");
	}
}
