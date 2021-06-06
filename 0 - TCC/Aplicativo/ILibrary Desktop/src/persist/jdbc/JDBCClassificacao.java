package persist.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Classificacao;
import persist.ConnectionFactory;
import persist.IGenericDAO;

public class JDBCClassificacao<E, PK> implements IGenericDAO<E, PK> {

	private Connection conn;

	{
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public void create(E newInstance) {

		String query = "insert into classificacao (cod_classificacao, assunto) values (?, ?)";

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement(query);
			Classificacao c = (Classificacao) newInstance;
			ps.setString(1, c.getCod_classificacao());
			ps.setString(2, c.getAssunto());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(PK pk) {

		String query = "select * from classificacao where cod_classificacao='" + pk + "'";

		Statement st;
		ResultSet rsClassificacao;

		try {
			st = conn.createStatement();
			rsClassificacao = st.executeQuery(query);

			if (rsClassificacao.next()) {
				Classificacao classificacao = new Classificacao();
				classificacao.setCod_classificacao(rsClassificacao.getString("cod_classificacao"));
				classificacao.setAssunto(rsClassificacao.getString("assunto"));
				return (E) classificacao;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void update(E transferObject, PK pk) {

		String query = "update classificacao set cod_classificacao=?, assunto=? where cod_classificacao='" + pk + "'";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);

			Classificacao c = (Classificacao) transferObject;
			ps.setString(1, c.getCod_classificacao());
			ps.setString(2, c.getAssunto());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(PK pk) {

		String query = "delete from classificacao where cod_classificacao='" + pk + "'";

		Statement st;
		try {
			st = conn.createStatement();
			st.executeQuery(query);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<E> readAll(String sql) {
		ArrayList<Classificacao> lista_classificacao = new ArrayList<Classificacao>();
		PreparedStatement ps;
		ResultSet rsClassificacao;
		try {
			ps = conn.prepareStatement(sql);
			rsClassificacao = ps.executeQuery();

			while (rsClassificacao.next()) {
				Classificacao classificacao = new Classificacao();
				classificacao.setCod_classificacao(rsClassificacao.getString("cod_classificacao"));
				classificacao.setAssunto(rsClassificacao.getString("assunto"));
				lista_classificacao.add(classificacao);
			}

			if (!lista_classificacao.isEmpty()) {
				return (ArrayList<E>) lista_classificacao;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
