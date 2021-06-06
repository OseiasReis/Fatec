package AcademiaSoft;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Input_Output2 {
	public static void main(String[] args) throws IOException {
		File f = new File("C:/Windows/setuplog.txt");
		FileReader fr = new FileReader(f);
		int numero = 0;
		while ((numero = fr.read()) != -1) {
			char letra = (char) numero;
			System.out.println(letra);
		}
		fr.close();
	}
}
