import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercicio {
	
	static Scanner sc = new Scanner(System.in);
	static FileWriter fw;
	static BufferedWriter bfw;

	public static void main(String[] args) {
		
		File f = new File("c:\\temp\\texto.txt");
		
		while (true) {
	        System.out.print("Digite um nome:");
	        String nome = sc.nextLine();
	        if(nome.equals("sair")){
	        	break;
	        }
	        try {
				fw = new FileWriter( f );
				bfw = new BufferedWriter( fw );
				bfw.append(Desafio(nome) + System.getProperty("line.separator"));
				bfw.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    }
		
		try {
			bfw.close();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		
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
