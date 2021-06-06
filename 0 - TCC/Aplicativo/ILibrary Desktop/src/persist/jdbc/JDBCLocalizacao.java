package persist.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Localizacao;
import persist.ConnectionFactory;
import persist.IGenericDAO;

public class JDBCLocalizacao<E, PK> implements IGenericDAO<E, PK> {

	private Connection conn;

	{
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public void create(E newInstance) {

		String query = "insert into localizacao (cep, endereco, bairro, cidade) values (?, ?, ?, ?)";

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement(query);
			Localizacao l = (Localizacao) newInstance;
			ps.setString(1, l.getCep());
			ps.setString(2, l.getEndereco());
			ps.setString(3, l.getBairro());
			ps.setString(4, l.getCidade());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(PK pk) {

		String query = "select * from localizacao where cep='" + pk + "'";

		Statement st;
		ResultSet rsLocalizacao;

		try {
			st = conn.createStatement();
			rsLocalizacao = st.executeQuery(query);

			if (rsLocalizacao.next()) {
				Localizacao localizacao = new Localizacao();
				localizacao.setCep(rsLocalizacao.getString("cep"));
				localizacao.setEndereco(rsLocalizacao.getString("endereco"));
				localizacao.setBairro(rsLocalizacao.getString("bairro"));
				localizacao.setCidade(rsLocalizacao.getString("cidade"));
				return (E) localizacao;
			}

			return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void update(E transferObject, PK pk) {

		String query = "update localizacao set cep=?, endereco=?, bairro=?, cidade=? where cep='" + pk + "'";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);

			Localizacao l = (Localizacao) transferObject;
			ps.setString(1, l.getCep());
			ps.setString(2, l.getEndereco());
			ps.setString(3, l.getBairro());
			ps.setString(4, l.getCidade());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(PK pk) {

		String query = "delete from localizacao where cep='" + pk + "'";

		Statement st;
		try {
			st = conn.createStatement();
			st.executeQuery(query);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<E> readAll(String sql) {
		return null;
	}
}
