package AcademiaSoft;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decorator {
	private static BufferedReader br;

	public static void main(String[] args) throws IOException {
		FileInputStream f = new FileInputStream("C:\\WINDOWS\\WindowsUpdate.log");
		InputStreamReader isr = new InputStreamReader(f);
		br = new BufferedReader(isr);
		
		String texto = "";
		while(br.ready()) {
			texto += br.readLine();
		}
		System.out.println(texto);
	}
}
