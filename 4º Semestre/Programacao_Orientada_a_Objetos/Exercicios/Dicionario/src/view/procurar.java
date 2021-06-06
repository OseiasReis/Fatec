package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class procurar {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();

		if(l.isEmpty()) {
			preencher(l);
		}
		Collections.sort(l);

		String palavra = JOptionPane.showInputDialog("Palavra: ");

		for(int i=0; i<=l.size(); i++) {
			if(l.get(i).contains(palavra)) {
				System.out.println(l.get(i));
				i=l.size();
			}else if(i>=l.size()-1){
				String incluir = JOptionPane.showInputDialog("Informe a definição: ");
				l.add(palavra +" - "+incluir);
			}
		}
	}

	private static List preencher(List<String> l) {
		l.add("Admoesta – perdão, isenção, arrego, repreensão, reprimenda.");
		l.add("Alarido – confusão , algazarra , farra.");
		l.add("Alcunha – apelido.");
		l.add("Âmago – parte muito interior , cerne.");
		l.add("Ardiloso – manhoso , esperto.");
		l.add("Arroubo – entusiasmo , fervor , encanto.");
		l.add("Balbúrdia – baderna , bagunça , confusão.");
		l.add("Belicoso – que incita à guerra.");
		l.add("Besugo – pequeno peixe acantopterígio vulgar;");
		l.add("Curra – abuso sexual , esturo com a participação de várias pessoas.");
		l.add("Dilapidar – desperdiçar , estragar , destruir.");
		l.add("Dândi – que procura se vestir com elegância.");
		l.add("Engodar – mentir , enganar.");
		l.add("Fenecimento – fim , término.");
		l.add("Fugaz – passageiro , que passa rápido.");
		l.add("Fleumático – imperturbável.");
		l.add("Frugal – simples.");
		l.add("Homizio – refúgio, guarida, abrigo, esconderijo");
		l.add("Ígneo – próprio do fogo.");
		l.add("Ignóbil – sem caráter , vergonhoso.");
		l.add("ImplÍcito – escondido , não expresso , omisso.");
		l.add("Insolente – desaforado , desagradável.");
		l.add("Irrupção – entrada violenta , pancada forte.");
		l.add("Incólume – intacto.");
		l.add("Inócuo – inofensivo.");
		l.add("Jaez – tipo , categoria.");
		l.add("Janota – bem vestida.");
		l.add("Justapor – colocar perto.");
		l.add("Loquaz – falador.");
		l.add("Nódoa – sujeira , mancha. pode ser também a alcunha de uma pessoa de má fama.");
		l.add("Pachorrento – calmo , sereno , acomodado.");
		l.add("Pacóvio – imbecil , ignorante.");
		l.add("Parco – moderado , econômico , diminuto.");
		l.add("Pedante – nojento , exibido , audacioso.");
		l.add("Pederasta – gay.");
		l.add("Perdulário – que gasta mais.");
		l.add("Perene – que dura muito , imortal.");
		l.add("Permuta – troca , câmbio.");
		l.add("Pernóstico – pretensioso , esnobe.");
		l.add("Petiz – criança , adolescente.");
		l.add("Plissado – com rugas.");
		l.add("Perscrutar – vasculhar , procurar , revirar.");
		l.add("Pândego – feliz , alegre.");
		l.add("Pérfido – cruel , traidor , desgraçado.");
		l.add("Ruar – sair sem destino , andar à toa.");
		l.add("Recôndito – escondido, encoberto, secreto, oculto");
		l.add("Rubicundo – avermelhado.");
		l.add("Sumidade – personalidade importante , sábio.");
		l.add("Suscitar – fazer surgir , encorajar , provocar.");
		l.add("Tergiversar – desculpar-se.");
		l.add("Taciturno – calado.");
		l.add("Tênue – fraco , frágil.");

		return l;
	}


}
