package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Validacao {
	public boolean verificarRegistro(String login, String senha) throws IOException
	{
		//Throws = tratamento de excessão. Usado para substituir catch. Necessita do mesmo ao trabalhar com a classe BufferedReader;
		boolean existencia = false;
		String senhaCadastrada = "";
		File arquivo = new File("Pessoa/" + login + ".txt");
		if(!arquivo.exists()){
			existencia = false;
		}else{
			try {
				FileReader reader = new FileReader(arquivo);
				BufferedReader buffer = new BufferedReader(reader);  
				
				senhaCadastrada = buffer.readLine();  
				senhaCadastrada = buffer.readLine();  

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			if(senhaCadastrada.equals(senha))
			{
				existencia = true;
			}
		}
		
		return existencia;
	}
}
