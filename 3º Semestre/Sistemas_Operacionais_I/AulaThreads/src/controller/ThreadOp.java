package controller;

public class ThreadOp extends Thread {
	private int a;
	
	public ThreadOp(int a) { 
		this.a = a;
	}
	
	public void run() {
		calc();
	}

	private void calc() {
		int res = 0;
		if(a % 2 == 0) {
			res = (int) Math.pow(a, 2);
		}else {
			res = (int) Math.sqrt(a);
		}
		System.out.println(a + " = " + res );
	}
}
