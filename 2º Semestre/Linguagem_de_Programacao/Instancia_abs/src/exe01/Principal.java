package exe01;

import javax.swing.JOptionPane;

public class Principal {
	 public static void main ( String[] args )	
	 {	
	  Nota[] nota = new Nota[3];	
	  int i,ptos;	
	    for (i = 0 ; i < 3 ; i++)	
	    nota[i] = new Nota();
		
	  for (i = 0 ; i < 3 ; i++)
	   {	
		   nota[i].nome = JOptionPane.showInputDialog("Nome do aluno:");	
		   nota[i].nt1 = Integer.parseInt(JOptionPane.showInputDialog("Nota 1:"));	
		   nota[i].nt2 = Integer.parseInt(JOptionPane.showInputDialog("Nota 2:"));	
		   nota[i].nt3 = Integer.parseInt(JOptionPane.showInputDialog("Nota 3:"));	
	   }	
	  	
	  for (i = 0 ; i < 3; i++) {	
		  System.out.print(nota[i].nome + " = Nota1: " + nota[i].nt1 + " ---- Nota2: " + nota[i].nt2 + " ---- Nota3: " + nota[i].nt3);	
		  double media;
		  String st;
		  media= (nota[i].nt1 + nota[i].nt2 + nota[i].nt3)/3;
		  if(media >= 6){
			  st = "Aprovado";
		  }else{
			  st = "Reprovado";
		  }
		  System.out.println(" ---- Media:" + media + " ---- Situação: " + st + "\n");	
	  }
	  
	  System.exit(0);	
	 } // fim do método	
} // fim da classe

