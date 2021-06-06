import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class exercicio1 {
	public static void main(String[] args) {
		
		File f = new File ("C://temp//meunome.txt");
		
		FileWriter fw;
		try {
			fw = new FileWriter ( f );
			fw.write ("Oséias Reis");
			fw.close ();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
