package acesso;

import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import model.Biblioteca;
import model.Penalidade;
import persist.ConnectionFactory;
import persist.SerDAO;
import view.Interface_ConfiguracaoBancoDados;
import view.Login;

public class Programa  {
	
	public static void main(String[] args) {

		Penalidade penalidade = new SerDAO<Penalidade, String>(Penalidade.class).read(null);
		if (penalidade == null) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar as configurações de penalidade.\nForam aplicadas as configurações padrão do sistema!\n", "Erro", JOptionPane.ERROR_MESSAGE);
			penalidade = new Penalidade();
			penalidade.setDias_suspensao("0");
			penalidade.setEmprestar_multado(false);
			penalidade.setEmprestar_suspenso(true);
			penalidade.setMulta(false);
			penalidade.setSuspensao_automatica(false);
			penalidade.setSuspensao_manual(true);
			penalidade.setValor_multa(0.00);
			new SerDAO<Penalidade, String>(Penalidade.class).create(penalidade);
		}
		
		Biblioteca biblioteca = new SerDAO<Biblioteca, String>(Biblioteca.class).read(null);
		if (biblioteca == null) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar os dados da biblioteca.\nForam aplicadas as configurações padrão do sistema!\n", "Erro", JOptionPane.ERROR_MESSAGE);
			biblioteca = new Biblioteca("ILibrary", "Endereço", "Número", "Bairro", "Cidade", "SP");
			biblioteca.setTelefone("(00) 0000-0000");
			new SerDAO<Biblioteca, String>(Biblioteca.class).create(biblioteca);
		}
				
		if ((Connection) ConnectionFactory.getConnection() != null) {
			new Login();
		} else {
			new Interface_ConfiguracaoBancoDados();
		}
	}
}
