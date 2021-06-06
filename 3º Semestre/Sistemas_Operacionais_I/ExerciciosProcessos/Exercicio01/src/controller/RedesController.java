package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {
	public RedesController() {
		super();
	}
	
	public String ip() {
		String so = System.getProperty("os.name");
		try {
			Process pr = null;
			if(so.contains("W")) {
				pr = Runtime.getRuntime().exec("ipconfig");
			}else {
				//COMANDO LINUX 
				pr = Runtime.getRuntime().exec("ifconfig");
			}
			InputStream fluxo = pr.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				if(linha.contains("Adaptador")) {
					System.out.println(linha);
				}
				if(linha.contains("IPv4")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		return so;
	}
	
	public void ping() {
		String so = System.getProperty("os.name");
		int i=0;
		try {
			Process pr = null;
			if(so.contains("W")) {
				pr = Runtime.getRuntime().exec("ping -t1 www.google.com.br");
			}else {
				pr = Runtime.getRuntime().exec("ping www.google.com.br");
			}
			InputStream fluxo = pr.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				if(so.contains("W")) {
					if (linha.contains("TTL")) {
						String tempo = linha.substring(linha.indexOf("tempo=") + 6, linha.indexOf("TTL=") - 1);
						System.out.print(tempo + " - ");
					}
					linha = buffer.readLine();
					
				}else {
					if (linha.contains("TTL")) {
						String tempo = linha.substring(linha.indexOf("time=") + 6);
						System.out.print(tempo + " - ");
					}
					linha = buffer.readLine();
				}
				if(i>=10) {
					fluxo.close();
				}
				i++;
			}
			
		} catch (IOException e) {
			if(e.getMessage().contains("closed")) {
				//JOptionPane.showMessageDialog(null, "Ping finalizado", "Ping", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
}
