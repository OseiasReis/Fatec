package BDLojaVirtual;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOContato implements IDAOContato {

private Connection c;
	
	public DAOContato () throws ClassNotFoundException, SQLException{
		IGenericDAO gDao = new GenericDAO();
		c = gDao.getConnection();
	}
	
	@Override
	public void inserir(Contato cont) throws SQLException {
		Contato cont1 = new Contato();
		String sql = "INSERT INTO contato (contNome, contUsuario, contSenha, contNascimento) VALUES (?, ?, ?, ?);";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, cont1.getNome());
		ps.setString(2, cont1.getUsuario());
		ps.setString(3, cont1.getSenha());
		ps.setDate(4, (Date) cont1.getNascimento());
		ps.execute();
		ps.close();
	}

	@Override
	public Contato pesquisar(int pesq) throws SQLException {
		
		Contato conT1 = new Contato();
		String sql = "SELECT contId, contNome, contUsuario, contSenha, contNascimento FROM contato WHERE contId = ?;";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pesq);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			conT1.setId(rs.getInt("contId"));
			conT1.setNome(rs.getString("contNome"));
			conT1.setUsuario(rs.getString("contUsuario"));
			conT1.setSenha(rs.getString("contSenha"));
			conT1.setNascimento(rs.getDate("contNascimento"));
		}
		rs.close();
		ps.close();
		return conT1;
	}

}
