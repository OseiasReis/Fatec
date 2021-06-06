package Exercicio1;

public class Soma extends Valores{
	protected int result;
	public Soma(){
		result = 0;
	}
	public Soma(int r, int n1, int n2){
		super (n1, n2);
		result = r;
	}
	public int result(int s1, int s2){
		return s1 + s2;
	}
	public String getNome() {
		return "Soma";
	}
	public String toString() {
		return "Soma: " + super.toString() + " = " + result;
	}
	
}
