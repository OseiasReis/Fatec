import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercicio {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		boolean checkSourceFile = false;
		
		while(!checkSourceFile){
			System.out.println("Digite o caminho do arquivo de origem: ");
			String source = sc.next();
			File sourceFile = new File (source);
			if(sourceFile.exists() && !sourceFile.isDirectory()) { 
				System.out.println("Arquivo de origem localizado");
				FileReader fr;
				try {
					fr = new FileReader( sourceFile );
					BufferedReader bfr = new BufferedReader( fr );
					String texto = "";
					while ( bfr.ready() ) {
						texto += bfr.readLine() + System.getProperty("line.separator");
					}
					
					bfr.close();
					fr.close();
					Reader(Desafio(texto));
				} catch (IOException e) {
					e.printStackTrace();
				}
				checkSourceFile = true;
			} else {
			    System.out.println("Arquivo de origem não encontrado");
			}
		}
		
		
	}
	
	public static boolean Reader(String infoSourceFile){
		
		System.out.println("Digite o caminho do arquivo de destino: ");
		String destination = sc.next();
		
		File f = new File(destination);
		FileWriter fw;
		BufferedWriter bfw;
		try {
			fw = new FileWriter( f );
			bfw = new BufferedWriter( fw );
			bfw.append(infoSourceFile);
			bfw.close();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return true;
	}

	public static String Desafio(String infoSourceFile){
	
		infoSourceFile = infoSourceFile.replaceAll("O","0");
		infoSourceFile = infoSourceFile.replaceAll("o","0");
		infoSourceFile = infoSourceFile.replaceAll("I","1");
		infoSourceFile = infoSourceFile.replaceAll("i","1");
		infoSourceFile = infoSourceFile.replaceAll("Z","2");
		infoSourceFile = infoSourceFile.replaceAll("z","2");
		infoSourceFile = infoSourceFile.replaceAll("E","3");
		infoSourceFile = infoSourceFile.replaceAll("e","3");
		infoSourceFile = infoSourceFile.replaceAll("A","4");
		infoSourceFile = infoSourceFile.replaceAll("a","4");
		infoSourceFile = infoSourceFile.replaceAll("S","5");
		infoSourceFile = infoSourceFile.replaceAll("s","5");
		infoSourceFile = infoSourceFile.replaceAll("G","6");
		infoSourceFile = infoSourceFile.replaceAll("g","6");
		infoSourceFile = infoSourceFile.replaceAll("T","7");
		infoSourceFile = infoSourceFile.replaceAll("t","7");
		infoSourceFile = infoSourceFile.replaceAll("B","8");
		infoSourceFile = infoSourceFile.replaceAll("b","8");
		
		return infoSourceFile;
	}
}
