package Exercício_Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClienteSocket1 {
	private int porta = 4000;
	private String servidorUrl = "localhost";

	public ClienteSocket1() {
		try {
			Socket srv = new Socket(servidorUrl, porta);
			InputStream in = srv.getInputStream();
			OutputStream out = srv.getOutputStream();

			InputStream kdbIn = System.in;
			InputStreamReader kdbInr = new InputStreamReader(kdbIn);
			BufferedReader kdbBr = new BufferedReader(kdbInr);

			boolean sair = false;
			while (!sair) {
				if (kdbBr.ready()) {
					String linhaKdb = kdbBr.readLine();
					out.write(linhaKdb.getBytes());
					out.write("\n\r".getBytes());
					out.flush();
				}
				if (in.available() > 0) {
					int i = in.read();
					System.out.println((char) i);
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServidorSocket();
	}
}
