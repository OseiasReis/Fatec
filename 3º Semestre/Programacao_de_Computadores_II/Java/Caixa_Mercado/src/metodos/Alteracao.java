package metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Alteracao {
	
	public BufferedWriter writer;
	public BufferedReader reader;
	public File arquivo;
	public File novoArquivo;
	public String linha = "a";
	
	public void adicionarProduto(String codigo, int quantAdd, boolean soma){
		arquivo = new File("Produtos/" + codigo + ".txt");
		novoArquivo = new File("Produtos/" + codigo + "-tmp.txt");
		
		try {
			writer = new BufferedWriter(new FileWriter(novoArquivo));
			reader = new BufferedReader(new FileReader(arquivo));
			
			
			int count = 0, resultado = 0, quantidade;
			String mensagem;
			
			while(count < 6){
				linha = reader.readLine();
				count++;
				if(count == 3){
					quantidade = Integer.parseInt(linha);
					if(soma == true){
						resultado = quantidade + quantAdd;
					}else{
						resultado = quantidade - quantAdd;
					}
					mensagem = "" + resultado;
					writer.write(mensagem);
					writer.write("\r\n");
						
				}
				else{
					writer.write(linha);
					writer.write("\r\n");
				}
			}
			arquivo.delete();
			novoArquivo.renameTo(arquivo);
			writer.close();
			reader.close();
		} catch (IOException e) {
			
		}		
	}	
	
	public void informarProduto(int codigo) throws IOException{
		arquivo = new File("Produtos/" + codigo + ".txt");
		reader = new BufferedReader(new FileReader(arquivo));
		while((linha = reader.readLine()) != null){
			
		}
			
	}

}

