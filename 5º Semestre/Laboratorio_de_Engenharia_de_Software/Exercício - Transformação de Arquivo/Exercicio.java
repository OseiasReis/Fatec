import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercicio {
	
	static FileWriter fw;
	static BufferedWriter bfw;

	public static void main(String[] args) {
		
		File f = new File("c:\\temp\\a.csv");
		FileReader fr;
		BufferedReader bfr;
		
		File nf = new File("c:\\temp\\b.csv");
		FileWriter fw = null;
		BufferedWriter bfw = null;
		
		try {
			fr = new FileReader( f );
			bfr = new BufferedReader( fr );
			
			try {
				
				fw = new FileWriter( nf );
				bfw = new BufferedWriter( fw );
				
				while ( bfr.ready() ) {
					String[] line = bfr.readLine().split(";");
					double nota = Double.parseDouble(line[1].replace(',','.')) + 1;
					
					if (nota > 10) {
						nota = 10;
					}
					System.out.println(nota);
					bfw.append(line[0] + ";" + nota + System.getProperty("line.separator"));
				}
				bfw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
}
