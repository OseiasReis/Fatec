package exe01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Metodos {
	public Nota[ ] GravaAluno (Nota[ ] nota) throws IOException {	
	     int i;	
	     String fileName = "ArquivoNota.txt";	
	     BufferedWriter writer = new BufferedWriter(new FileWriter( fileName ));	
	     for (i = 0 ; i < 3 ; i++){
	          nota[i] = new Nota();
	     }
	     for (i = 0 ; i < 3 ; i++)  {	
	    	   nota[i].nome = JOptionPane.showInputDialog("Nome do aluno:");	
	           writer.write( nota[i].nome );  	
	           writer.newLine();	
	           nota[i].nt1 = Integer.parseInt(JOptionPane.showInputDialog("Nota do aluno:"));	
	           writer.write(Integer.toString(nota[i].nt1));  	
	           writer.newLine();	
	           nota[i].nt2 = Integer.parseInt(JOptionPane.showInputDialog("Pontos Graduação do aluno:"));	
	           writer.write(Integer.toString(nota[i].nt2));   	
	          writer.newLine();  } 
	      System.out.println("GRAVAÇÃO FEITA COM SUCESSO ");	
	    writer.close();
	  return nota;
	}
	
	 public void LerAluno ( Nota[ ] nota ) throws IOException	 {	
		   int i;	
		  String fileName = "ArquivoAluno.txt";	
		  BufferedReader ler = new BufferedReader(new FileReader( fileName ));	
		  for (i = 0 ; i < 3 ; i++)	
			  nota[i] = new Nota();
		  for (i = 0 ; i < 3 ; i++)   {	
			  nota[i].nome = ler.readLine();  	
			  nota[i].nt1 = ler.readLine();	
			  nota[i].nt2 = Integer.parseInt(ler.readLine());	
		   }	
		  	
		  for (i = 0 ; i < 3; i++) {	
		   System.out.println(nota[i].pnome + " " + nota[i].unome + " pontos: " + nota[i].pontos);	
		  }
		  ler.close();	
		  }
}
