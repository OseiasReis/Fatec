package Estouro_memoria;

public class Stack {
	public static void main(String args[]) {
		int i=1000;
		stackover(i);
	}

	private static void stackover(int i) {
		i+=i; 
		stackover(i);
	}
}
