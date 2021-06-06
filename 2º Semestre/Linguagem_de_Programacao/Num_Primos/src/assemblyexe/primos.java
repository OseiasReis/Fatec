package assemblyexe;

public class primos {
	public static void main(String args[]){
		int m, n, n2, c1=0, c2=0, i=2, i2, j, max=7;
		System.out.println("Digite o primeiro numero");
		m=30;
		System.out.println("Digite o segundo numero");
		n=10;
		n2=n;
		if(m<n){
			System.out.println("O primeiro numero deve ser maior que o segundo");
		}else {
			while(n<m) {
				c1=0;
				while(i<=n) {
					if(n % i == 0) {
						c1++;
						System.out.println("i: "+i);
					}
					i++;
				}
				if(c1 == 2){
					c2++;
					System.out.println("primo: "+i);
					
				}
				n++;
			}	
			System.out.println("Existem "+ c2 +" números primos entre eles");
		}
	}
}
