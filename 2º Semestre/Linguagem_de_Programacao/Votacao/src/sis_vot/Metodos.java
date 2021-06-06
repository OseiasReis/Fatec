package sis_vot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Metodos {
	boolean term=false;
	int votos[] =  new int[301];;
	int classfi[] = new int[100];
	int qtd[] = new int[11];
	int qtdca[] = new int[300];
	int back;
	public Vota[ ] FCadastraVotacao (Vota[ ] vota) throws IOException {	
	     int i;	
	     Random r = new Random();
	     for (i = 0 ; i < 100 ; i++){
	    	 vota[i] = new Vota();
	     }
	     for (i = 0 ; i < 100 ; i++)  {	
	    	   vota[i].numSecao = r.nextInt(11);		
	           vota[i].numCandidato = r.nextInt(301);
	           } 
	      	   System.out.println("CADASTRO FEITO COM SUCESSO");
	      	   return vota;
		}
	 
	public void FClassificacao( Vota[ ] vota ) throws IOException	 {	
		  int i, aux, j=0, cl=0;
		  File arquivo = new File("ArquivoVoto.txt");
		  if (arquivo.exists()) {
			  String fileName = "ArquivoVoto.txt";
			  BufferedReader ler = new BufferedReader(new FileReader( fileName ));	
			  
			  for (i = 0 ; i < 200 ; i++)   {	
				  if(i % 2 == 0) {
					  //pega só as seções
					  vota[cl].classficacao = Integer.parseInt(ler.readLine());
					  cl++;
				  }else {
					  //votos por candidato
					  votos[j] =  Integer.parseInt(ler.readLine());
					  j++;
				  }
			  }	
			  ler.close();
			  i=0;
			  j=0;
			  
			  for(i=0; i<100; i++) {
				  for(j=0; j<99; j++) {
					  if (vota[i].classficacao < vota[j+1].classficacao) {
						  //coloca em ordem crescente
						  aux = vota[i].classficacao;
						  vota[i].classficacao = vota[j+1].classficacao;
						  vota[j+1].classficacao = aux;
					  }
					  if(i==0) { 
						  //o primeiro sempre fica, caso maior, então fazer isso para trocar
						  aux = vota[i].classficacao;
						  vota[i].classficacao = vota[j+1].classficacao;
						  vota[j+1].classficacao = aux;
					  }
				  }
			  }
			  /*for(i=0; i<100; i++) {
				  System.out.print(vota[i].classficacao + " - ");
			  }*/
			  
			  System.out.println("DADOS CLASSIFICADOS");
			  
			  for(i=0; i<100; i++) {
				  classfi[i]= vota[i].classficacao;
			  }
			  term=true; //terminou
			  
		  }else {
			  System.out.println("ARQUIVO NÃO GERADO");
		  }
	}
	
	public void qtdes() throws IOException {	
	     int i, j=0, q=0;
	     if(term==true) {
		     for (i = 0 ; i < 99 ; i++){
		    	 if(classfi[i] == classfi[i+1]) {
		    		 //qtd[j]= qtd[j] + 1;
		    		 q++;
		    	 }else {
		    		 q+=1; //caso diferente, ele não conta, então acrescentar mais 1;
		    		 qtd[j]= q;
		    		 j++;
		    		 q=0; //zerar
		    	 }
		    	 //se igual a 10
		    	 if(j==10) {
		    		 q+=1;
		    		 qtd[j]= q;
		    	 }
		     }
		     for (i = 0 ; i < 11 ; i++){
		    	 System.out.println("Quantidade seção " + i + ": " + qtd[i]);
		     }
	     }else {
	    	 System.out.println("CLASSIFIQUE PRIMEIRO");
	     }
	}
	
	public void mm() throws IOException {	
	     int i, maior=0, menor=100, sa=0, so=0;
	     if(term==true) {
		     for (i = 0 ; i < 11 ; i++){
		    	 if(qtd[i] > maior) {
		    		 maior = qtd[i];
		    		 sa=i;
		    	 }
		    	 if(qtd[i] < menor) {
		    		 menor = qtd[i];
		    		 so=i;
		    	 }
		     }
		     System.out.println("Maior seção " + sa + ": " + maior);
		     System.out.println("Menor seção " + so + ": " + menor);
	     }else {
	    	 System.out.println("CLASSIFIQUE PRIMEIRO");
	     }
	}
	
	public void qtdcan() throws IOException {	
		int i;
		int aux[] = new int[300];
		
		
		System.out.println("Votos por candidatos:");
		for (i = 0 ; i < 300 ; i++){
			back = votos[i];
			aux[back]++;
			qtdca[back] = back; //passar os numeros dos candidatos
		}
		for (i = 0 ; i < 300 ; i++){
			votos[i] = aux[i];
		}
		votos[0] = 0; //erro
		for (i = 0 ; i <= 300 ; i++){	
			System.out.println("Candidato " + i + ": " + votos[i]);
		}
	}
	
	public void qtdvot() throws IOException {	
		int i, j=0, aux=0, aux2=0;
		
		for(i=0; i<300; i++) {
			  for(j=0; j<299; j++) {
				  if (votos[i] > votos[j+1]) {
					  //coloca em ordem crescente os votos
					  aux = votos[i];
					  votos[i] = votos[j+1];
					  votos[j+1] = aux;
					 //coloca em ordem crescente os candidatos
					  aux2 = qtdca[i];
					  qtdca[i] = qtdca[j+1];
					  qtdca[j+1] = aux2;
				  }
			  }
		  }
		System.out.println("\n\nOs 10  mais votados:");
		for (i = 1 ; i <= 10 ; i++){	
			System.out.println(i + "º candidato: " + qtdca[i] + " ----- Votos: " + votos[i]);
		}
	}
	
	
	 public Vota[ ] FGravaVotacao (Vota[ ] vota) throws IOException {	
	     int i;	
	     String fileName = "ArquivoVoto.txt";	
	     BufferedWriter writer = new BufferedWriter(new FileWriter( fileName ));	
	     
	     for (i = 0 ; i < 100 ; i++)  {	
	           writer.write(Integer.toString(vota[i].numSecao));
	           writer.newLine();
	           writer.write(Integer.toString(vota[i].numCandidato)); 
	           writer.newLine(); 
	           } 
	      	   System.out.println("ARQUIVO GERADO");	
	      	   writer.close();
	      	   return vota;
		}
}
