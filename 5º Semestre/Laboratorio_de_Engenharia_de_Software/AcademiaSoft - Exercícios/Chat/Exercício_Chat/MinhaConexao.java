package Exerc�cio_Chat;

public class MinhaConexao extends Thread {
	public void run() {
		new ClienteSocket1();
		new ClienteSocket2();
	}
}
