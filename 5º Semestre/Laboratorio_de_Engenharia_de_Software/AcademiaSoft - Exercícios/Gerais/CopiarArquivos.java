package AcademiaSoft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopiarArquivos {
	private static Scanner scan;
	private static FileReader ff;

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
		scan = new Scanner(System.in);
		System.out.println("Informe o Arquivo de origem (Coloque a extensão, por favor): ");
		String origem = scan.nextLine();

		File f = new File("C:\\Users\\João Victor\\Documents\\" + origem);
		FileReader fr = new FileReader(f);
		BufferedReader bfr = new BufferedReader(fr);

		System.out.println("Informe o Arquivo de Destino");
		String destino = scan.nextLine();

		File fd = new File("C:\\Users\\João Victor\\Documents\\" + destino);
		FileWriter fw = new FileWriter(fd);

		String texto = "";
		System.out.println("------------------- Arquivo Origem -------------------");
		while (bfr.ready()) {
			texto += bfr.readLine();
		}
		System.out.println(texto + "\n");
		
		ff = new FileReader(f);
		
		int numero = 0;
		String teste;
		System.out.println("------------------- Arquivo Destino -------------------");
		while ((numero = ff.read()) != -1) {
			char letra = (char) (numero);
			for (int i = 0; i < 10; i++) {
				teste = Character.toString(letra);
				if (teste.equals(array[i])) {
					teste = String.valueOf(i);
					letra = teste.charAt(0);
				}
			}
			fw.write(letra);
			fw.flush();
			System.out.print(letra);
		}

		fw.flush();
		bfr.close();
		fw.close();
		fr.close();

	}
}
