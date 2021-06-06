package AcademiaSoft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leitura_Ordenacao_Escrita {
	public static void main(String[] args) throws IOException {
		File f = new File("C:/Windows/WindowsUpdate.log");
		FileReader fr = new FileReader(f);
		BufferedReader bfr = new BufferedReader(fr);
		List<String> update = new ArrayList<String>();
		
		String texto = "";
		while (bfr.ready()) {
			texto += bfr.readLine();
		}
		update.add(texto);
		System.out.println(texto + "\n");
		fr.close();

		File ff =  new File ("C:\\Users\\João Victor\\Documents\\Ordenado.txt");
		FileWriter fw = new FileWriter(ff);
		
		// Ordena de acordo com o dicionário
		Collections.sort(update, Collator.getInstance());
		System.out.println(update);	
		
		Collections.reverse(update);
		System.out.println(update);
		String teste = String.valueOf(update);
		fw.write(teste);
		fw.close();
	}
}
