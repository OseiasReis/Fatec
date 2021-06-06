import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class exercicio2 {
	public static void main(String[] args) {
		
		File f = new File ("C://Windows//setuplog.txt");
		
		FileReader fr;
		try {
			fr = new FileReader ( f );
			int i = 0;
			while ((i = fr.read()) != -1){
				System.out.print( (char)i );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
