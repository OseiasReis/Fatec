package assemblyexe;

public class primos2 {
	public static void main(String args[]){
		int m, n, j, primo, c1=0, i=2;
		System.out.println("Digite o primeiro numero");
		n=1;
		System.out.println("Digite o segundo numero");
		m=30;
		if(m<n){
			System.out.println("O primeiro numero deve ser maior que o segundo");
		}else {
			for(j=n; j<m; j++) {
				primo=1;
				for(i=2; i<=j; i++) {
					if(j % i == 0) {
						primo++;
					}
				}
				if(primo == 2){
					/*System.out.println(i=i-1);*/
					c1++;
				}
			}	
			System.out.println("Existem "+ c1 +" números primos entre eles");
		}
	}
}
