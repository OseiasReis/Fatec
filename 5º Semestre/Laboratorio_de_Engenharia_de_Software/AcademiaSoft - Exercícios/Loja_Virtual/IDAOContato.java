package BDLojaVirtual;

import java.sql.SQLException;

public interface IDAOContato {
	public void inserir(Contato cont) throws SQLException;
	public Contato pesquisar (int pesq) throws SQLException;
}
