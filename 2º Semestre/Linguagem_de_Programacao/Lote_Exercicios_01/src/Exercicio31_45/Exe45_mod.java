package Exercicio31_45;

public class Exe45_mod {
	public static void main(String args[]) {
		int x1=1;
		double res=1, x2=0;
		serie(x1, x2, res);
	}

	private static void serie(int x1, double x2, double res) {
		System.out.println(x1 + "     = 1");
		while(x1<15){
			x1++;
		 	x2=x1*x1;
		 	if(x1 % 2 == 0){
		 		res-= (x1/x2);
		 		System.out.println(x1+ "/"+ x2+ " = " + res);
		 	}else {
		 		res+= (x1/x2);
		 		System.out.println(x1+ "/"+ x2+ " = " + res);
		 	}
		}
	}
}
