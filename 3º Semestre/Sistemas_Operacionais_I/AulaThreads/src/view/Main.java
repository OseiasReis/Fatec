package view;

import java.util.Random;

import controller.ThreadOp;

public class Main {
	public static void main(String args[]) {
		int a;
		
		for(int op = 0; op < 10; op++) { 
			Random r = new Random();
			a = r.nextInt(20);
			Thread tCalc = new ThreadOp (a);
			tCalc.start();
		}
	}
}
