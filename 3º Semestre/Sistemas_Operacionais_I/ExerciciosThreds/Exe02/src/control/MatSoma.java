package control;

public class MatSoma extends Thread{
	private int i, res=0;
	private int matriz[][] = new int [3][5];

	public MatSoma(int matriz[][]) {
		this.matriz = matriz;
	}

	public void run() {
		primeira();
		segunda();
		terceira();
	}

	private void primeira() {
		for(i=0; i<=4; i++) {
			res += matriz[0][i];
		}
		System.out.println("Soma da linha 1: " + res);
		res=0;
	}

	private void segunda() {
		for(i=0; i<=4; i++) {
			res += matriz[1][i];
		}
		System.out.println("Soma da linha 2: " + res);
		res=0;
	}

	private void terceira() {
		for(i=0; i<=4; i++) {
			res += matriz[2][i];
		}
		System.out.println("Soma da linha 3: " + res);
		res=0;
	}
}
