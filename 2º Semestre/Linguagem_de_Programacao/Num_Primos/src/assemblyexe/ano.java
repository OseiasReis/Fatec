package assemblyexe;

public class ano {
	public static void main(String args[]){
		int a1, a2, dif, bi=0, bin=0, bia=0, res;
		System.out.println("Digite o primeiro ano");
		a1=1999;
		System.out.println("Digite o segundo ano");
		a2=2018;
		
		if(a1-a2>=1000 || a2-a1>=1000){
			System.out.println("A diferença entre os anos não pode ser maior que 1000");
		}else {
			while(bi<a1){
				bin++;
				bi+=4;
			}
			bi=0;
			while(bi<a2){
				bia++;
				bi+=4;
			}
			if(a1>a2){
				bi= bin-bia;
				dif=a1-a2;
			}else {
				bi= bia-bin;
				dif=a2-a1;
			}
			res=dif-bi;
			System.out.println("Existem "+ res +" anos não bissextos entre os anos");
		}
	}
}
