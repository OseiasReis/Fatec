package BDLojaVirtual;

import java.sql.SQLException;

public interface IDAOPedido {
	public void inserir(Pedido ped) throws SQLException;
	public Pedido pesquisar (int pesq) throws SQLException;
}
