package Exercicio21_30;

import java.util.Random;

public class Exe25_mod {
	public static void main(String args[]) {
		int hi=0, hf=0, hhi, hhf=0, mm=0, m1=0, m2=0;
		Random gerador = new Random();
		hhi= gerador.nextInt(24);
		System.out.println("Hora de inicio:\nHH:" + hhi);
		if(hhi<24) {
			mm= gerador.nextInt(60);
			System.out.println("MM:" + mm);
			if(mm<60) {
				m1= mm;
				hi= hhi*60;
				hi= hi+mm;
				hhf= gerador.nextInt(24);
				System.out.println("\nHora de termino:\nHH:" + hhf);
				if(hhf<24) {
					mm= gerador.nextInt(60);
					System.out.println("MM:" + mm);
					if(mm<60) {
						m2= mm;
						hf= hhf*60;
						hf= hf+mm;
					}else
						System.out.println("Tempo maximo � de 59m");
				}else
					System.out.println("Tempo maximo � de 24h");
			}else
				System.out.println("Tempo maximo � de 59m");
		}else
			System.out.println("Tempo maximo � de 24h");
		periodo(hi, hf, hhi, hhf, mm, m1, m2);
	}
	
	private static void periodo(int hi, int hf, int hhi, int hhf, int mm, int m1, int m2) {
		int h, m;
		if(hi<hf) {
			h=(hf-hi)/60;
			if(m1<m2) {
				m=m2-m1;
				System.out.println("Horas de jogo: " + h + ":" + m + "h");
			}else {
				m= (60-m1)+m2;
				if (m==60){
					m=0;
				}
				System.out.println("Horas de jogo: " + h + ":" + m + "h");
			}
		}else {
			if(hi>=hf) {
				if(hhi==hhf && m1==m2) {
					h=0;
				}else {
					if(hhi==hhf && m1>m2) {
						h= (24-(hi/60))+(hf/60)-1;
					}else {
						h= (24-(hi/60))+(hf/60);
					}
					if(m1<m2) {
						m=m2-m1;
						System.out.println("Horas de jogo: " + h + ":" + m + "h");
					}else {
						m= (60-m1)+m2;
						if (m==60){
							m=0;
						}
						System.out.println("Horas de jogo: " + h + ":" + m + "h");
					}
				}
			}
		}
	}
}
