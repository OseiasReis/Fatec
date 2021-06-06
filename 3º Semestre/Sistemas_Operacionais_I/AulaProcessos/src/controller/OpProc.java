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
	
	public String so() {
		String so = System.getProperty("os.name");
		//String so = System.getProperty("os.version");
		return so;
	}
	
	public void chamaProcesso(String processo) {
		try {
			Runtime.getRuntime().exec(processo); //executa determidado processo; Exemplo: Notepad;
			//retorna um valor do tipo process (guarda o input)
		} catch (IOException e) {
			//e.printStackTrace();
			//JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			if(e.getMessage().contains("740")) { //contains: se achar 740 no getMessage, entra no if
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c "); //vai perdir permiss�o, ent�o colocar caminho para rodar no cmd
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
			InputStream fluxo = pr.getInputStream();//pega os processos, tendo o getErrorStream() onde pega os errors
			InputStreamReader leitor = new InputStreamReader(fluxo); //leitor receba os bits convertido em String
			BufferedReader buffer = new BufferedReader(leitor); //enquando rodar o input, preenche o buffer
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void mataProcesso(String info) {
		StringBuffer buffer = new StringBuffer();
		String cmdNome = "taskkill /im ";
		String cmdPid = "taskkill /pid ";
		int pid = 0;
		try {
			pid = Integer.parseInt(info);
			buffer.append(cmdPid);
			buffer.append(pid);
			
		}catch(NumberFormatException e){
			buffer.append(cmdNome);
			buffer.append(info);
		} finally { //independente de rodar no try ou catch, vai pro finally
			chamaProcesso(buffer.toString());
		}
	}
}
