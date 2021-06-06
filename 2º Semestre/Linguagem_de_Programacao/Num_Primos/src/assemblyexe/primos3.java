package assemblyexe;

public class primos3 {
	public static void main(String args[]){
		int m, n, j, primo, c1=0, i=2;
		System.out.println("Digite o primeiro numero");
		n=1;
		System.out.println("Digite o segundo numero");
		m=50;
		if(n>=m){
			System.out.println("O primeiro numero deve ser maior que o segundo");
		}else {
			j=n;
			while(j<m) {
				primo=1;
				i=2;
				while(i<=j) {
					if(j % i == 0) {
						primo++;
					}
					i++;
				}
				if(primo == 2){
					c1++;
				}
				j++;
			}	
			System.out.println("Existem "+ c1 +" números primos entre eles");
		}
	}
}
