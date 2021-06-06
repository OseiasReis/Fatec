package Exercicio31_45;

public class Exe41 {
	public static void main(String args[]) {
		int d1=1, d2, r=0;
		
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
