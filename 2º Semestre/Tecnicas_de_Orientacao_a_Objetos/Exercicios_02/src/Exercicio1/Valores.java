package Exercicio1;

public class Valores extends Calculadora{
	protected int x, y;
	public Valores(){
		x = 0;
		y = 0;
	}
	public Valores(int n1, int n2){
		x = n1;
		y = n2;
	}
	public int getX() {
		return x;
	}
	public int getY(){
		return y;
	}
	public String getNome() {
		return "Valores";
	}
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	
}
