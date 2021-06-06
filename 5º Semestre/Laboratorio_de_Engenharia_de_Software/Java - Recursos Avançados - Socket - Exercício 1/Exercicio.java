import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Exercicio {

	public static void main(String[] args) {
		String msg1 = "[ATTACK DISABLED]";
		String msg2 = "[UNLOCK SYSTEM]";
		for (int i = 1; i <= 254; i++) {
			try {
				Socket con = new Socket("172.16.168." + i, 1110);
				OutputStream out = con.getOutputStream();
				OutputStreamWriter ouw = new OutputStreamWriter( out );
				ouw.write(msg1);
				ouw.flush();
				ouw.write(msg2);
				ouw.close();
				out.close();
				con.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}