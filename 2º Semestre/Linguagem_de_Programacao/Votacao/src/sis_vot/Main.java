package sis_vot;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {
	public static void main (String args[]) throws IOException{
	    Vota[] vota = new Vota[100];
	    Metodos m = new Metodos();
	    int opc=0;
	    int opc2=0;
	    while(opc!=9){
	    	opc = Integer.parseInt(JOptionPane.showInputDialog("-------------VOTAÇÃO--------------\n\n1 - Carregar Seção/Eleitor \n2 - Classificar por Seção \n3 - Gravar Registros \n4 - Mostrar Indicadores \n9 - Finaliza\n\n"));
	    switch(opc){
	        case 1: vota = m.FCadastraVotacao(vota);
	        break;
	        case 2: m.FClassificacao (vota);
	        break;
	        case 3: m.FGravaVotacao (vota);
            break;
	        case 4: opc2 = Integer.parseInt(JOptionPane.showInputDialog("-------------INDICADORES--------------\n\n1 - Qtd Eleitores (Seção) \n2 - Seção > ou < Eleitores \n3 - Qtd de Sotos (Candidato) \n4 - Primeiros Colocados \n9 - Finaliza\n\n"));
		        //segundo switch
	            switch (opc2){
			          case 1: m.qtdes();
			          break;
			          case 2: m.mm();
			          break;
			          case 3: m.qtdcan();
		              break;
			          case 4: m.qtdvot();
		              break;
			          case 9: JOptionPane.showMessageDialog(null,"FINALIZADO ");
			          break;
			          default: JOptionPane.showMessageDialog(null,"OPÇÃO INVALIDA");
			     }
	         break;
	         case 9: JOptionPane.showMessageDialog(null,"FINALIZADO ");
	         break;
	         default: JOptionPane.showMessageDialog(null,"OPÇÃO INVALIDA");
	      }
	    }
	}
}
