package Exercicio1;

public class Exercicio1 {
	public static void main( String[] args){
		String str = "Curso de Java";
		System.out.println( str.substring(0, 13) + " - Exemplo String" );
		System.out.println( "Tamanho da String: " + str.length() );
		String xyz = "Aqui Esta Um";
		System.out.println( xyz.substring(0, 12) + " Exemplo String - " + str.substring(0, 13));
	}
}
