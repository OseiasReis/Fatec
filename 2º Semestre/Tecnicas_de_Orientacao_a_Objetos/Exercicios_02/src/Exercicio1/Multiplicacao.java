package Exercicio1;

public class Multiplicacao extends Valores{
	protected int result;
	public Multiplicacao(){
		result = 0;
	}
	public Multiplicacao(int r, int n1, int n2){
		super (n1, n2);
		result = r;
	}
	public int result(int s1, int s2){
		return s1 * s2;
	}
	public String getNome() {
		return "Multiplicacao";
	}
	public String toString() {
		return "Multiplicacao: " + super.toString() + " = " + result;
	}
	
}