package BDLojaVirtual;

import java.sql.SQLException;

public interface IDAOProduto {
	public void inserir(Produto prod) throws SQLException;
	public Produto pesquisar (int pesq) throws SQLException;
}
