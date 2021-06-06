package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidade.Animal;

public class AnimalDAO implements AnimalIDAO {
	public AnimalDAO() throws ClassNotFoundException, SQLException {

	}

	@Override
	public void add(Animal a) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO bichinhos " + " (id, nome, nascimento, peso) "
				+ " VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, a.getId());
		stmt.setString(2, a.getNome());
		long milisec = a.getNascimento().getTime();
		java.sql.Date sqlD = new java.sql.Date(milisec);
		stmt.setDate(3, sqlD);
		stmt.setFloat(4, a.getPeso());
		int i = stmt.executeUpdate();
	}

	@Override
	public List<Animal> pesqNome(String nome) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		List<Animal> animal = new ArrayList<>();
		String query = "SELECT * FROM bichinhos WHERE nome like ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, "%" + nome + "%");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) { 
			Animal a = new Animal();
			a.setId( rs.getInt("id") );
			a.setNome( rs.getString("nome") );
			a.setNascimento( rs.getDate("nascimento") );
			a.setPeso( rs.getFloat("peso") );
			animal.add(a);
		}
		return animal;
	}
}