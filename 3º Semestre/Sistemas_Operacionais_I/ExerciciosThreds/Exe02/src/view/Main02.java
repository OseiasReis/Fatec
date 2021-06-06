package view;

import java.util.Random;

import control.MatSoma;

public class Main02 {
	public static void main(String args[]) {
		int matriz[][] = new int [3][5];
		
		Random r = new Random();
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 4; j++) {
				matriz[i][j] = r.nextInt(10);
			}
		}
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 4; j++) {
				System.out.print("|");
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		Thread tMS = new MatSoma (matriz);
		tMS.start();
	}
}
