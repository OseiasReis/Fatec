package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidade.Curso;

public class CursoDAO implements CursoIDAO{
	public CursoDAO () throws ClassNotFoundException, SQLException{
		
	}
	@Override
	public void add(Curso a) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO curso " + " (id, nome, descricao, ativo, horainicio, horatermino) " + " VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setLong(1, a.getId());
		stmt.setString(2, a.getNome());
		stmt.setString(3, a.getDescricao());
		stmt.setBoolean(4, a.isAtivo());
		long milisec = a.getHoraInicio().getTime();
		java.sql.Date sqlD = new java.sql.Date(milisec);
		stmt.setDate(5, sqlD);
		milisec = a.getHoraTermino().getTime();
		java.sql.Date sqlD1 = new java.sql.Date(milisec);
		stmt.setDate(6, sqlD1);
		stmt.executeUpdate();
	}

	@Override
	public List<Curso> pesqNome(String nome) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		List<Curso> animal = new ArrayList<>();
		String query = "SELECT * FROM curso WHERE nome like ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, "%" + nome + "%");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) { 
			Curso a = new Curso();
			a.setId( rs.getInt("id") );
			a.setNome( rs.getString("nome") );
			a.setDescricao(rs.getString("nascimento") );
			a.isAtivo( );
			a.setHoraInicio(rs.getTime("horainicio"));
			a.setHoraTermino(rs.getTime("horatermino"));
			animal.add(a);
}
		return null;
	}

}
