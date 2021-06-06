package BDLojaVirtual;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOProduto implements IDAOProduto {

	private Connection c;

	public DAOProduto() throws ClassNotFoundException, SQLException {
		IGenericDAO gDao = new GenericDAO();
		c = gDao.getConnection();
	}

	@Override
	public void inserir(Produto prod) throws SQLException {
		Produto prod1 = new Produto();
		String sql = "INSERT INTO produto (prodNome, prodDescricao, prodCategoria, prodPreco, prodValidade, prodFabricacao, prodPeso) VALUES (?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, prod1.getNome());
		ps.setString(2, prod1.getDescricao());
		ps.setString(3, prod1.getCategoria());
		ps.setDouble(4, prod1.getPreco());
		ps.setDate(5, (Date) prod1.getValidade());
		ps.setDate(6, (Date) prod1.getDataFabricacao());
		ps.setFloat(7, prod1.getPeso());
		ps.execute();
		ps.close();
	}

	@Override
	public Produto pesquisar(int pesq) throws SQLException {

		Produto proD1 = new Produto();
		String sql = "SELECT prodId, prodNome, prodDescricao, prodCategoria, prodPreco, prodValidade, prodFabricacao, prodPeso FROM produto WHERE prodId = ?;";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pesq);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			proD1.setId(rs.getInt("prodId"));
			proD1.setNome(rs.getString("prodNome"));
			proD1.setDescricao(rs.getString("prodDescricao"));
			proD1.setCategoria(rs.getString("prodCategoria"));
			proD1.setPreco(rs.getDouble("prodPreco"));
			proD1.setValidade(rs.getDate("prodValidade"));
			proD1.setDataFabricacao(rs.getDate("prodFabricacao"));
			proD1.setPeso(rs.getFloat("prodPeso"));
		}
		rs.close();
		ps.close();
		return proD1;
	}
}
