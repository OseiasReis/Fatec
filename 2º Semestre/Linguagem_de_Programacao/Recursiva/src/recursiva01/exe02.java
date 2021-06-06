package recursiva01;

public class exe02 {
	public static void main(String srgs[]){
		int soma=0;
		recursiva(soma);
		System.out.println("O resultado é " + recursiva(soma));
	}

	private static int recursiva(int soma) {
		int x;
		if(soma==100){
			return soma;
		}else{
			x=soma+recursiva(soma+1);
			//System.out.println(soma);
			return x;
		}
	}
}
