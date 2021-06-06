package matriz;

public class Exe09 {
	public static void main(String args[]) {
		int p[][]=new int[4][4], i, j, s=1, res, v=1;
		
		System.out.println("DIGITE AS VENDAS:");
		for(i=0; i<=3; i++) {
			for(j=0; j<=3; j++) {
				p[i][j]=v;
				if(i==j && i!=0) {
					res=s*4;
					s=res;
					p[i][j]=res;
					//estetica
					System.out.print(p[i][j]);
					if(p[i][j]<10) {
						System.out.print(" ");
					}
					System.out.print(" | ");
				}else {
					//estetica
					System.out.print(p[i][j]);
					if(p[i][j]<10) {
						System.out.print(" ");
					}
					System.out.print(" | ");
				}
				v++;
			}
			System.out.println();
		}
	}
}
