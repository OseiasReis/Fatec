package exe01;

import java.io.IOException;

import javax.swing.JOptionPane;

import AlunoReg.Metodos;

public class Main {
	public static void main (String args[]) throws IOException {
	    Nota[ ] nota = new Nota[3];	
	     Metodos m = new Metodos(); 
	      int opc=0      ;
	      while (opc!=9){
	    	  	opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Gravar Nota \n 2 - Ler Nota \n 9 - Finaliza"));
	      switch (opc)     {
	            case 1: nota = m.GravaAluno(nota);
	                         break;
	            case 2: m.LerAluno (nota);
	                         break;
	            case 9: JOptionPane.showMessageDialog(null,"FINALIZADO ");
	                         break;
	            default: JOptionPane.showMessageDialog(null,"OP��O INV�LIDA");
	         }   
	      }  
	      
	}
}
