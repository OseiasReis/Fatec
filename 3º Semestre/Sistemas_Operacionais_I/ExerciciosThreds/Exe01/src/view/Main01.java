package view;

import control.Imprimir;

public class Main01 {
	public static void main(String args[]) {
		Thread tImpri = new Imprimir ();
		tImpri.start();
	}
}
