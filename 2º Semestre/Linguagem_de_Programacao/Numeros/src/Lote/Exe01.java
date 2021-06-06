package Lote;

public class Exe01 {
	public static void main (String args[]) {
		int n, res=0, cont=1;
		n=13;
		System.out.println("Digite um numero: " + n);
		if(n>10 && n<15){
			while(cont <= n) {
				if(cont % 2 == 0){
					res+=cont*2;
					cont++;
					//System.out.println(res);
				}else {
					res+=cont*3;
					cont++;
					//System.out.println(res);
				}
			}
			System.out.println("Soma dos resultados: " + res);
		}else {
			System.out.println("Digite um numero >10 e <15");
		}
	}
}
