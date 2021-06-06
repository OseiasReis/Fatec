package Exercício_Chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
	public ServidorSocket() {
		try {
			System.out.println("Servidor Socket inciado");
			ServerSocket srv = new ServerSocket(4000);
			System.out.println("Porta 4000 reservada");
			System.out.println("Aguardando conexão do cliente");
			Socket cliente = srv.accept();
			
			OutputStream out = cliente.getOutputStream();
			out.write("Bem vindo ao servidor\n\r".getBytes());
			out.flush();
			
			InputStream in = cliente.getInputStream();
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			String linha = "";
			
			InputStreamReader kdbInr = new InputStreamReader(System.in);
			BufferedReader kdbBr = new BufferedReader(kdbInr);
			
			while(!"sair".equalsIgnoreCase(linha)) {
				if(kdbBr.ready()) {
					String linhaTeclado = kdbBr.readLine();
					out.write(linhaTeclado.getBytes());
					out.write("\n\r".getBytes());
					out.flush();
				}
			}
			srv.close();
			cliente.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		MinhaConexao t1 = new MinhaConexao();
		t1.start();
	}
}
