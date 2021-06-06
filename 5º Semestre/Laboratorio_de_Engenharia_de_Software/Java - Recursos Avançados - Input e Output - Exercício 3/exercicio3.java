import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class exercicio3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File f = new File ("C://temp//teste.txt");
		FileWriter fw;
		try {
			fw = new FileWriter ( f );
			while (true) {
		        System.out.print("Digite um nome:");
		        String nome = sc.nextLine();
		        if(nome.equals("sair")){
		            break;
		        }
		        fw.write (nome);
		        fw.write (System.getProperty("line.separator"));
		        fw.flush ();
		    }
		    sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
}
