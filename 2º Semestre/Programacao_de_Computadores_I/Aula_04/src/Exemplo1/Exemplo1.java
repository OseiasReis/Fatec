package Exemplo1;

public class Exemplo1 {
	public static void main( String[] args){
		float media = 7.3f;
		
		//Aprovado > 7
		//Recuperação - 5 até 6.9
		//Reprovado < 5
		
		if( media > 7){
			System.out.println("Aprovado");
		}else if(media >=5){
			System.out.println("Recuperação");
		}else{
			System.out.println("Reprovado");
		}
	}
}