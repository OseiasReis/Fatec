package Aula02;

public class Aula02 {
 public static void main (String[] args){
	 String str = "Isto é uma String do Java";
	 String xyz = new String ("Isto é uma String do Java");
	 
	 if( str == xyz ) System.out.println("IGUAL");
	 else System.out.println("DIFERENTE");
	  //MANEIRA CORRETA DE SE COMPARAR O CONTEUDO DAS STRINGS
	 if( str.equals( xyz ) ) {
		 
	 }
	 System.out.println ("Tamanho da String: " + str.length() );
	 System.out.println ("SubString: " + str.substring(0, 10) );
	 System.out.println ("Caracter na posição 5: " + str.charAt (5) );
	 
	 String[] palavras = str.split(" ");
	 
	 int i = str.indexOf ("Uma");
	 
	 if ( str.startsWith("Olá") || str.endsWith("Mundo!")) {
		 
	 }
	
	 str = str.trim();
	 
	 str = str.replace('a','@');
	 
	 str = str.replaceAll("String","Cadeia de caracteres");
 }
}
