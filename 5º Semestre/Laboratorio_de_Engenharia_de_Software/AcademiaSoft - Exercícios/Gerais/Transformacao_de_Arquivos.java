package AcademiaSoft;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Transformacao_de_Arquivos {
	private static FileReader ff;

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\João Victor\\Documents\\a.txt");
		FileReader fr = new FileReader(f);
		System.out.println("\n ---------------------- Notas ----------------------");
		int numero = 0;
		while ((numero = fr.read()) != -1) {
			char letra = (char) numero;
			System.out.print(letra);
		}
		
		File fd = new File("C:\\Users\\João Victor\\Documents\\b.txt");
		FileWriter fw = new FileWriter(fd);
		ff = new FileReader(f);
		System.out.println("\n ---------------------- Notas atualizadas ----------------------");
		
		String texto;
		int converte = 0, opc = 0;
		while ((numero = ff.read()) != -1) {
			char letra = (char) numero;
			texto = String.valueOf(letra);
			
			try {
				converte = Integer.parseInt(texto);
			}catch (NumberFormatException e) {
			}
			
			if (opc == 2) {
				texto = String.valueOf(converte + 1);
				opc = 0;
			}
			
			if (texto.equals(";") || opc == 1) {
				opc++;
			}
			
			System.out.print(texto);
			fw.write(letra);
		}
		fr.close();
		fw.close();
	}
}
