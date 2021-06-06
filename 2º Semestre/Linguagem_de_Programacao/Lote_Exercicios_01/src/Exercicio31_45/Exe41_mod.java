package Exercicio31_45;

public class Exe41_mod {
	public static void main(String args[]) {
		int d1=1, d2=1, r=0;
		dado(d1, d2, r);
		
	}

	private static void dado(int d1, int d2, int r) {
		while(d1<=6){
			d2=1;
			while(d2<=6){
				if((d1+d2)==7){
					r++;
					System.out.println(r+"= "+d1+"-"+d2);
				}
				d2++;
			}
			d1++;
		}
	}
}
