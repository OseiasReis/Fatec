package Exercicio4;

public class Result_POI {
	public static void main(String[] args){
		
		ParOuImpar poi = new ParOuImpar();
		if (poi.par() == 0){
			System.out.println("O numero digitado é Par");
		}else{
			System.out.println("O numero digitado é Impar");
		}
	}
}