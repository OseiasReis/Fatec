package Trans_Vet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Metodos {
    String reg[]={"Leste", "Oeste", "Sul", "Norte", "Centro"};
	String cit[]= {"São Paulo", "Guarulhos", "Campinas", "Osasco", "São B. do Campo", "Santo André", "Sorocaba"};
    //int reg2[]={1, 2, 3, 4, 5};
    String tvd[]={"Veiculo Passeio","Transporte Coletivo", "Transporte Publico", "Moto"};
    String nomes[]= new String[20];
    int qtd=0;
    Random r = new Random();
    
	public Transito[ ] FCadastraAcidente (Transito[ ] transito) throws IOException {	
		 int i;
		 String fileName = "ArquivoTransito.txt";	
	     BufferedWriter w = new BufferedWriter(new FileWriter( fileName ));	
	     
	     for (i=0 ; i<19 ; i++){
	    	 transito[i] = new Transito();
	     }
	     for (i=0 ; i<19 ; i++){	
	    	   transito[i].CodCidade = r.nextInt(5)+1;		
	    	   transito[i].NomeCidade = cit[(r.nextInt(7))];
	    	   transito[i].QTDAcidentes = r.nextInt(5)+1;
	    	   transito[i].TipoVeiculo = r.nextInt(4);
	     }
	     
	     for (i=0 ; i<19 ; i++){
	           w.write(Integer.toString(transito[i].CodCidade));
	           w.newLine();
	           w.write(transito[i].NomeCidade);
	           w.newLine(); 
	           w.write(Integer.toString(transito[i].QTDAcidentes));
	           w.newLine(); 
	           w.write(Integer.toString(transito[i].TipoVeiculo));
	           w.newLine();
	     } 
	     w.close();
	      	   
	     System.out.println("CADASTRO FEITO COM SUCESSO");
	     return transito;
	}
	 
	 public Transito[ ] FTipo (Transito[ ] transito, int tipo) throws IOException {	
	     int i, j=0, resp=0, aux;
	     String aux2;
		  File arquivo = new File("ArquivoTransito.txt");
		  if (arquivo.exists()) {
			  String fileName = "ArquivoTransito.txt";
			  BufferedReader ler = new BufferedReader(new FileReader( fileName ));	
			  
			  for (i = 0 ; i < 19 ; i++)   {
				  aux=Integer.parseInt(ler.readLine());
				  aux2=ler.readLine();
				  aux=Integer.parseInt(ler.readLine());
				  if(tipo==Integer.parseInt(ler.readLine())) {
					  resp++;
				  }
			  }	
			  ler.close();
		  }
		  j=tipo;
		  System.out.println("Acidente com " + tvd[j] + ": "+ resp);
	     return transito;
	}
	 
	 public Transito[] FQtdaci (Transito[ ] transito) throws IOException {	
	    int i, j=0, resp=0, aux;
	    String aux2;
	    File arquivo = new File("ArquivoTransito.txt");
		  if (arquivo.exists()) {
			  String fileName = "ArquivoTransito.txt";
			  BufferedReader ler = new BufferedReader(new FileReader( fileName ));	
			  
			  for (i = 0 ; i < 19 ; i++)   {
				  aux=Integer.parseInt(ler.readLine());
				  aux2=ler.readLine();
				  qtd+=Integer.parseInt(ler.readLine());
				  aux=Integer.parseInt(ler.readLine());
			  }	
			  ler.close();
		  }
		System.out.println("Quantidade total de acidentes: " + qtd);
		return transito;
	}
	
	 public Transito[] PconsultaAcidentes (Transito[ ] transito) throws IOException {	
		 int i, j=0, a, c, d;
		    String b;
		    File arquivo = new File("ArquivoTransito.txt");
			  if (arquivo.exists()) {
				  String fileName = "ArquivoTransito.txt";
				  BufferedReader ler = new BufferedReader(new FileReader( fileName ));	
				  
				  for (i = 0 ; i < 19 ; i++)   {
					  a=Integer.parseInt(ler.readLine());
					  System.out.println("Codigo da cidade: " + reg[a-1]);
					  b=ler.readLine();
					  System.out.println("Nome da cidade: " + b);
					  c=Integer.parseInt(ler.readLine());
					  System.out.println("Quantidade de acidentes: " + c);
					  d=Integer.parseInt(ler.readLine());
					  System.out.println("Tipo de veiculo: " + tvd[d]);
					  System.out.println("");
				  }	
				  ler.close();
			  }
			return transito;
		}
	 
	 public Transito[] PMMM (Transito[ ] transito) throws IOException {	
		 int i, maior=0, menor=100, sa=0, so=0, media=0, cont=0;
		 int j=0, a, c=0, d;
		 File arquivo = new File("ArquivoTransito.txt");
		 String fileName = "ArquivoTransito.txt";
		 BufferedReader ler = new BufferedReader(new FileReader( fileName ));	
			  if (arquivo.exists()) {
				  for (i = 0 ; i < 19 ; i++)   {
					  a=Integer.parseInt(ler.readLine());
					  nomes[i]=ler.readLine();
					  c=Integer.parseInt(ler.readLine());
					  if(c > maior) {
				    		 maior = c;
				    		 sa=i;
				      }
				      if(c < menor) {
				    		 menor = c;
				    		 so=i;
				      }
				      media+=c; //media
					  cont++; //contador
					  d=Integer.parseInt(ler.readLine());
				  }	
				  ler.close();
			  }
			  
			  media= media/cont;

			  System.out.print("Cidades com qtd de acidentes acima da média: " + media);
			  BufferedReader ler2 = new BufferedReader(new FileReader( fileName ));
				  for (i = 0 ; i < 19 ; i++)   {
					  ler2.readLine();
					  ler2.readLine();
					  c=Integer.parseInt(ler2.readLine());
					  //if(nomes[i].equals(Integer.toString(media))) {
					  if(c <= media) { //se menor que a meddia, a cidade recebe 0
						  nomes[i]="0";
					  }
					  ler2.readLine();
				  }	
				  ler2.close();
				  
				  for (i = 0 ; i < 19 ; i++)   {
					  for (j = i+1 ; j < 19 ; j++)   {
						  if (nomes[i].equals(nomes[j])) { //se igual os nomes, excluir colocando 0
							  nomes[j]="0";
						  }
					  }
				  }
				  for (i = 0 ; i < 19 ; i++)   {
					  if (nomes[i] != "0") { //apresentar todos que não tem 0
						  System.out.print("\n" + nomes[i]);
					  }
				  }
				  
		     System.out.println("\nMaior número de acidentes: " + maior);
		     System.out.println("Menor número de acidentes: " + menor);
			
		     return transito;
		}
}
