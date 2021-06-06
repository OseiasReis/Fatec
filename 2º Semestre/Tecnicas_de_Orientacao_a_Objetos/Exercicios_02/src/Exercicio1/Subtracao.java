package Exercicio1;

public class Subtracao extends Valores{
	protected int result;
	public Subtracao(){
		result = 0;
	}
	public Subtracao(int r, int n1, int n2){
		super (n1, n2);
		result = r;
	}
	public int result(int s1, int s2){
		return s1 - s2;
	}
	public String getNome() {
		return "Subtracao";
	}
	public String toString() {
		return "Subtracao: " + super.toString() + " = " + result;
	}
	
}
