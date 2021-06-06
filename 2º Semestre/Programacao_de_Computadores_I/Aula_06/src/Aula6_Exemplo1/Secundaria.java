package Aula6_Exemplo1;

public class Secundaria {
	public String frase = "Isso é uma frase";
	protected int x = 100;
	private char y = 'a';
	
	public static void main(String[] args){
	
		Principal pa = new Principal();
		pa.nome = "Aeeeeeeeeee";
		
		System.out.println(pa.nome);
		pa.n10(15);
	}
}