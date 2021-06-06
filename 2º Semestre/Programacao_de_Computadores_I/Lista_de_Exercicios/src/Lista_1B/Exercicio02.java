package Lista_1B;

public class Exercicio02 {
	public static void main(String args[]){
		
		int volume;
		float alt = 10, raio = 12f;
		double pi = 3.1415;
		
		volume = (int) (pi * Math.pow(raio, 2)*alt);
		
		System.out.println("Volume da lata de óleo: " + volume);
		
	}
}
