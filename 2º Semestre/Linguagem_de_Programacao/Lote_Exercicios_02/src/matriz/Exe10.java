package matriz;

public class Exe10 {
	public static void main(String args[]) {
		int p[][]=new int[8][8], i, j;
		double res=1.0, soma=0.0;
		
		for(i=0; i<=7; i++) {
			for(j=0; j<=7; j++) {
				p[i][j]=(int) res;
				soma+=res;
				res=res*2;
				System.out.print(p[i][j]+ " | ");
			}
			System.out.println();
		}
		System.out.println("Soma dos valores: "+ soma);
	}
}
