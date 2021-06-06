package Lote;

public class Exe02 {
	public static void main(String args[]) {
		int n1, n, x=1, r=0;
		n1 = 13;
		System.out.println("Digite um numero: " + n1);
		if(n1>12 && n1<16) {
			if(n1==0){
				n1=1;
			}
			while(r<n1){
				n=x+r;
				x=r-1;
				r=n;
				x++;
				System.out.println(r);
			}
		}else
			System.out.println("Digite outros numeros");
	}
}
