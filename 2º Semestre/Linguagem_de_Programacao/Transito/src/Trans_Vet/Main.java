package Trans_Vet;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {
	public static void main (String args[]) throws IOException{
		Transito[] transito = new Transito[20];
		Metodos m = new Metodos();
		int opc=0;
		int opc2=0;
		int tipo;
		while(opc!=9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("MENU\n1 - Cadastrar Acidente\n2 - Mostrar Estatisticas\n9 - Fim"));
		switch(opc){
			case 1: transito = m.FCadastraAcidente(transito);
			break;
			case 2: opc2 = Integer.parseInt(JOptionPane.showInputDialog("-------------ESTATÍSTICAS--------------\n\n1 - Tipo de Veículo \n2 - Quantidade de Acidentes \n3 - Todas as Cidades  \n4 - > < Média de Acidentes \n9 - Finaliza\n\n"));
				switch(opc2){
					case 1: tipo=Integer.parseInt(JOptionPane.showInputDialog("TIPO DE VEICULO\n0 - Veiculo Passeio\n1 - Transporte Coletivo\n2 - Transporte Publico\n3 - Moto\n9 - Fim"));
							if(tipo==0 || tipo==1 || tipo==2 || tipo==3) {
								transito = m.FTipo(transito, tipo);
							}
					break;
					case 2: m.FQtdaci(transito);
					break;
					case 3: m.PconsultaAcidentes(transito);
					break;
					case 4: m.PMMM(transito);
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
