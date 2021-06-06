package control;

import java.util.Random;

public class Sapos extends Thread{
	private boolean sp1=false, sp2=false, sp3=false, sp4=false, sp5=false;
	private int dsp1=0, dsp2=0, dsp3=0, dsp4=0, dsp5=0;
	private int tMax=10, dMax=75, tamanho;
	private int col=0;
	Random r = new Random();

	public Sapos() {
	}

	public void run() {
		do{
			if(sp1==false) {
				primeira();
			}
			if(sp2==false) {
				segunda();
			}
			if(sp3==false) {
				terceira();
			}
			if(sp4==false) {
				quarta();
			}
			if(sp5==false) {
				quinta();
			}
		}while(sp1==false || sp2==false || sp3==false || sp4==false || sp5==false);
	}

	private void primeira() {
		if(dsp1<dMax) {
			tamanho = r.nextInt(tMax)+1;
			dsp1 += tamanho;
			System.out.println("Sapo 1");
			System.out.println("Tamanho do Salto: " + tamanho);
			System.out.println("Distancia percorrida: " + dsp1);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			sp1=true;
			System.out.println("------------------Sapo 1 chegou------------------");
			col++;
			System.out.println("------------------Colocação: " + col + "------------------");
		}
		System.out.println();
	}

	private void segunda() {
		if(dsp2<dMax) {
			tamanho = r.nextInt(tMax)+1;
			dsp2 += tamanho;
			System.out.println("Sapo 2");
			System.out.println("Tamanho do Salto: " + tamanho);
			System.out.println("Distancia percorrida: " + dsp2);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			sp2=true;
			System.out.println("------------------Sapo 2 chegou------------------");
			col++;
			System.out.println("------------------Colocação: " + col + "------------------");
		}
		System.out.println();
	}

	private void terceira() {
		if(dsp3<dMax) {
			tamanho = r.nextInt(tMax)+1;
			dsp3 += tamanho;
			System.out.println("Sapo 3");
			System.out.println("Tamanho do Salto: " + tamanho);
			System.out.println("Distancia percorrida: " + dsp3);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			sp3=true;
			System.out.println("------------------Sapo 3 chegou------------------");
			col++;
			System.out.println("------------------Colocação: " + col + "------------------");
		}
		System.out.println();
	}

	private void quarta() {
		if(dsp4<dMax) {
			tamanho = r.nextInt(tMax)+1;
			dsp4 += tamanho;
			System.out.println("Sapo 4");
			System.out.println("Tamanho do Salto: " + tamanho);
			System.out.println("Distancia percorrida: " + dsp4);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			sp4=true;
			System.out.println("------------------Sapo 4 chegou------------------");
			col++;
			System.out.println("------------------Colocação: " + col + "------------------");
		}
		System.out.println();
	}

	private void quinta() {
		if(dsp5<dMax) {
			tamanho = r.nextInt(tMax)+1;
			dsp5 += tamanho;
			System.out.println("Sapo 5");
			System.out.println("Tamanho do Salto: " + tamanho);
			System.out.println("Distancia percorrida: " + dsp5);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			sp5=true;
			System.out.println("------------------Sapo 5 chegou------------------");
			col++;
			System.out.println("------------------Colocação: " + col + "------------------");
		}
		System.out.println();
	}
}
