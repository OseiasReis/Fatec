package AcademiaSoft;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Input_Output1 {
	public static void main(String[] args) throws IOException {
		File f = new File ("C:/nome.txt");
		FileWriter fw = new FileWriter(f);
		fw.write("João Victor");
		fw.flush();
		fw.close();
	}
}
