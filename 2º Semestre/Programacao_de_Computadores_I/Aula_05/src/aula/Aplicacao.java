package aula;

public class Aplicacao {
	public static void main(String[] args){
		Carro objcarro = new Carro();
		
		//Atribuição de valores as variaveis existentes na classe Carro
		objcarro.modelo = "Celta";
		objcarro.marca = "Chevrolet";
		
		//Acessando os métodos disponiveis na classe Carro
		objcarro.ligar();
		objcarro.acelerar();
		objcarro.freiar();
		objcarro.desligar();
		
		System.out.println("O modelo do carro é: " + objcarro.modelo);
		System.out.println("A marca do carro é: " + objcarro.marca);
	}
}
