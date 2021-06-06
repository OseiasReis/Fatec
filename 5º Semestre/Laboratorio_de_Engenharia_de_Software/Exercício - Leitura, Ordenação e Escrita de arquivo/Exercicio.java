import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercicio {
	
	public static void main(String[] args) {
		
		FileInputStream f;
		InputStreamReader fr = null;
		BufferedReader bfr = null;
		
		File nf = new File("c:\\temp\\Ordenado.txt");
		FileWriter fw = null;
		BufferedWriter bfw = null;
		
		String texto = "";
		try {
			
			f = new FileInputStream("C:\\WINDOWS\\WindowsUpdate.log");
			fr = new InputStreamReader ( f );
			bfr = new BufferedReader ( fr );
			while ( bfr.ready() ) {
				texto = bfr.readLine() + System.getProperty("line.separator") + texto;
			}
			
			fw = new FileWriter( nf );
			bfw = new BufferedWriter( fw );
			
			bfw.append(texto);
			bfw.close();
			fw.close();
			
			System.out.println(texto);
			
			bfr.close();
			fr.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
}
