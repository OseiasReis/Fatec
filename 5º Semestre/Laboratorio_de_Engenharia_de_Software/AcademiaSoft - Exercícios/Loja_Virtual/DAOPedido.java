package BDLojaVirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOPedido implements IDAOPedido{

private Connection c;
	
	public DAOPedido () throws ClassNotFoundException, SQLException{
		IGenericDAO gDao = new GenericDAO();
		c = gDao.getConnection();
	}
	
	@Override
	public void inserir(Pedido ped) throws SQLException {
		Pedido ped1 = new Pedido();
		String sql = "INSERT INTO pedido (pedContato) VALUES (?);";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setObject(1, ped1.getContato());
		ps.execute();
		ps.close();
		
	}

	@Override
	public Pedido pesquisar(int pesq) throws SQLException {
		
		Pedido peD1 = new Pedido();
		String sql = "SELECT pedId, pedContato FROM pedido WHERE pedId = ?;";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pesq);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			peD1.setId(rs.getInt("pedId"));
			peD1.setContato((Contato) rs.getObject("pedContato"));
		}
		rs.close();
		ps.close();
		return peD1;
	}

}
