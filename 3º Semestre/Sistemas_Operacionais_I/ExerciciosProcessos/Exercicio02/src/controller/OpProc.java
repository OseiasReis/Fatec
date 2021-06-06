package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class OpProc {
	public OpProc() {
		super();
	}
	
	public void chamaProcesso(String processo) {
		String so = System.getProperty("os.name");
		try {
			Runtime.getRuntime().exec(processo);
			
		} catch (IOException e) {
			if(e.getMessage().contains("740")) {
				StringBuffer buffer = new StringBuffer();
				if(so.contains("W")) {
					buffer.append("cmd /c ");
				}else {
					//COMANDO LINUX 
					buffer.append("sudo /c ");
				}
				
				buffer.append(processo);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void lerProcesso(String processo) {
		try {
			Process pr = Runtime.getRuntime().exec(processo);
			InputStream fluxo = pr.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void mataProcesso(String info, String so) {
		StringBuffer buffer = new StringBuffer();
		String cmdNome = "taskkill /im ";
		String cmdPid = "taskkill /pid ";
		if(so.contains("W")) {
			cmdNome = "taskkill /im ";
			cmdPid = "taskkill /pid ";
		}else {
			//COMANDO LINUX 
			cmdPid = "kill ";
		}
		int pid = 0;
		try {
			pid = Integer.parseInt(info);
			buffer.append(cmdPid);
			buffer.append(pid);
			
		}catch(NumberFormatException e){
			if(so.contains("W")) {
				buffer.append(cmdNome);
				buffer.append(info);
			}else {
				System.out.println("Linux aceita apenas PID");
			}
		} finally {
			chamaProcesso(buffer.toString());
		}
	}
}

