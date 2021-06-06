package Exercicio1;

public class Divisao extends Valores{
	protected int result;
	public Divisao(){
		result = 0;
	}
	public Divisao(int r, int n1, int n2){
		super (n1, n2);
		result = r;
	}
	public int result(int s1, int s2){
		return s1 / s2;
	}
	public String getNome() {
		return "Divisao";
	}
	public String toString() {
		return "Divisao: " + super.toString() + " = " + result;
	}
	
}