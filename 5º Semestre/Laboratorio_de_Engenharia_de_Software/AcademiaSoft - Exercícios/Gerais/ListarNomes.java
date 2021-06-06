package AcademiaSoft;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ListarNomes {
	private static Scanner scan;

	public static void main(String[] args) throws IOException {
		String[] array = new String[10];
		array[0] = "O";
		array[1] = "I";
		array[2] = "Z";
		array[3] = "E";
		array[4] = "A";
		array[5] = "S";
		array[6] = "G";
		array[7] = "T";
		array[8] = "B";
		File f = new File("C:\\Users\\João Victor\\Documents\\exercicio.txt");
		FileReader fr = new FileReader(f);
		FileWriter fw = new FileWriter(f);
		scan = new Scanner(System.in);
		String palavra = "";

		while (palavra.equalsIgnoreCase("sair") == false) {
			fw.write(palavra);
			fw.flush();
			System.out.println("Digite uma palavra");
			palavra = scan.nextLine();
		}
		

		System.out.println("------- Arquivo -------");
		int numero = 0;
		String teste;
		while ((numero = fr.read()) != -1) {
			char letra = (char) (numero);
			for (int i = 0; i < 10; i++) {
				teste = Character.toString(letra);
				if (teste.equals(array[i])) {
					teste = String.valueOf(i);
					letra = teste.charAt(0);
				}
			}
			System.out.print(letra);
			fw.write(letra);
		}
		fw.close();
		fr.close();
	}
}

