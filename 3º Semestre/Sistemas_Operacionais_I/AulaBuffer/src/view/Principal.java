package view;

import controller.Operacoes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operacoes op = new Operacoes();
		op.preencheString();
		op.preencheBuffer();
		String str = "Está chovendo lá fora de novo ah eu não quero ficar aqui e nem ficar pra p3";
		String[] vetString = str.split(" "); //Split= cada vez que ele detecta espa�o na frase do vetor, ele pula uma linha do array
		op.imprimeVetor(vetString);
	}

}
