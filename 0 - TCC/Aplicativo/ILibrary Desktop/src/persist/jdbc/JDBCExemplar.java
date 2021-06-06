package persist.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Exemplar;
import persist.ConnectionFactory;
import persist.IGenericDAO;

public class JDBCExemplar<E, PK> implements IGenericDAO<E, PK> {

	private Connection conn;

	{
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public void create(E newInstance) {

		String query = "insert into exemplar (cod_acervo, detalhe_fisico, preco_compra, disponibilidade, emprestado, ativo) values (?, ?, ?, ?, ?, true)";

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement(query);
			Exemplar e = (Exemplar) newInstance;
			ps.setString(1, e.getCod_acervo());
			ps.setString(2, e.getDetalhe());
			ps.setString(3, e.getPreco_compra());
			ps.setString(4, e.getDisponibilidade());
			ps.setBoolean(5, false);

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(PK pk) {

		String query = "select * from exemplar where cod_exemplar='" + pk + "'";

		Statement st;
		ResultSet rsExemplar;

		try {
			st = conn.createStatement();
			rsExemplar = st.executeQuery(query);

			if (rsExemplar.next()) {
				Exemplar exemplar = new Exemplar();
				exemplar.setCodigo_Exemplar(rsExemplar.getString("cod_exemplar"));
				exemplar.setCod_acervo(rsExemplar.getString("cod_acervo"));
				exemplar.setDetalhe(rsExemplar.getString("detalhe_fisico"));
				exemplar.setPreco_compra(rsExemplar.getString("preco_compra"));
				exemplar.setDisponibilidade(rsExemplar.getString("disponibilidade"));
				exemplar.setEmprestado(rsExemplar.getBoolean("emprestado"));
				exemplar.setAtivo(rsExemplar.getBoolean("ativo"));

				return (E) exemplar;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void update(E transferObject, PK pk) {

		String query = "update exemplar set cod_acervo=?, detalhe_fisico=?, preco_compra=?, disponibilidade=?, emprestado=?, ativo=? where cod_exemplar='"
				+ pk + "'";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);

			Exemplar e = (Exemplar) transferObject;
			ps.setString(1, e.getCod_acervo());
			ps.setString(2, e.getDetalhe());
			ps.setString(3, e.getPreco_compra());
			ps.setString(4, e.getDisponibilidade());
			ps.setBoolean(5, e.getEmprestado());
			ps.setBoolean(6, e.getAtivo());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(PK pk) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<E> readAll(String sql) {

		ArrayList<Exemplar> lista = new ArrayList<Exemplar>();
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				Exemplar exemplar = new Exemplar();
				exemplar.setCodigo_Exemplar(rs.getString("cod_exemplar"));
				exemplar.setCod_acervo(rs.getString("cod_acervo"));
				exemplar.setPreco_compra(rs.getString("preco_compra"));
				exemplar.setDetalhe(rs.getString("detalhe_fisico"));
				exemplar.setDisponibilidade(rs.getString("disponibilidade"));
				exemplar.setEmprestado(rs.getBoolean("emprestado"));
				exemplar.setAtivo(rs.getBoolean("ativo"));
				lista.add(exemplar);

				while (rs.next()) {
					exemplar = new Exemplar();
					exemplar.setCodigo_Exemplar(rs.getString("cod_exemplar"));
					exemplar.setCod_acervo(rs.getString("cod_acervo"));
					exemplar.setPreco_compra(rs.getString("preco_compra"));
					exemplar.setDetalhe(rs.getString("detalhe_fisico"));
					exemplar.setDisponibilidade(rs.getString("disponibilidade"));
					exemplar.setEmprestado(rs.getBoolean("emprestado"));
					exemplar.setAtivo(rs.getBoolean("ativo"));
					lista.add(exemplar);
				}
			}

			if (!lista.isEmpty()) {
				return (ArrayList<E>) lista;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
