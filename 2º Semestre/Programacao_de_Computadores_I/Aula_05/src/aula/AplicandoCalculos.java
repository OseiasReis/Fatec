package aula;

public class AplicandoCalculos {
	public static void main(String[] args){
		Calculos calc = new Calculos();
		
		System.out.println("A resposta da soma é: " + calc.somar(10,  5));
		System.out.println("A resposta da subtração é: " + calc.subtrair(10,  2));
		System.out.println("A resposta da multiplicação é: " + calc.multiplicar(2,  2));
		System.out.println("A resposta da divisão é: " + calc.dividir(7,  2));
	}
}
