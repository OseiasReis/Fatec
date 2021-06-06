package Exercicio31_45;

import java.util.Random;

public class Exe40 {
	public static void main(String args[]) {
		int n1, n2, i;
		Random gerador = new Random();
		n1= gerador.nextInt(100)+1;
		System.out.println("Numero 1: " + n1);
		n2= gerador.nextInt(100)+1;
		System.out.println("Numero 2: " + n2);
		if (n1 > n2){
			if(n2<=2){
				System.out.println("2\n3\n5\n7");
			}else{
				if(n2==3){
					System.out.println("3\n5\n7");
				}else{
					if(n2>3 && n2<=5){
						System.out.println("5\n7");
					}else{
						if(n2>5 && n2<=7){
							System.out.println("7");
						}
					}
				}
			}
			for(i=n2; i<=n1; i++){
				if(i % 2 == 0){
				}else{
					if(i % 3 == 0){
					}else{
						if(i % 5 == 0){
						}else{
							if(i % 7 == 0){
							}else{
								if(i == 1){
								}else{
									System.out.println(i);
								}
							}
						}
					}
				}
				
			}
		}else{
			if(n1<=2){
				System.out.println("2\n3\n5\n7");
			}else{
				if(n1==3){
					System.out.println("3\n5\n7");
				}else{
					if(n1>3 && n1<=5){
						System.out.println("5\n7");
					}else{
						if(n1>5 && n1<=7);{
							System.out.println("7");
						}
					}
				}
			}
			for(i=n1; i<=n2; i++){
				if(i % 2 == 0){
				}else{
					if(i % 3 == 0){
					}else{
						if(i % 5 == 0){
						}else{
							if(i % 7 == 0){
							}else{
								if(i == 1){
								}else{
									System.out.println(i);
								}
							}
						}
					}
				}
			}
		}
	}
}
