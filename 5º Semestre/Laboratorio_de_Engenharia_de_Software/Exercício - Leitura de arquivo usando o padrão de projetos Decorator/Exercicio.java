import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercicio {
	
	public static void main(String[] args) {
		
		FileInputStream f;
		InputStreamReader fr = null;
		BufferedReader bfr = null;
		
		try {
			
			f = new FileInputStream("C:\\WINDOWS\\WindowsUpdate.log");
			fr = new InputStreamReader ( f );
			bfr = new BufferedReader ( fr );
			while ( bfr.ready() ) {
				System.out.println(bfr.readLine());
			}
			bfr.close();
			fr.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
}
