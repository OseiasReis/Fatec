package persist.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Data;
import model.Emprestimo;
import persist.ConnectionFactory;
import persist.IGenericDAO;

public class JDBCEmprestimo<E, PK> implements IGenericDAO<E, PK> {

	private Connection conn;

	{
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public void create(E newInstance) {

		String query = "insert into emprestimo (registro_cliente, cod_exemplar, registro_operador,  "
				+ "data_retirada, hora_retirada, data_devolucao, devolvido)" + " values (?, ?, ?, ?, ?, ?, false)";

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement(query);
			Emprestimo c = (Emprestimo) newInstance;
			ps.setString(1, c.getRegistro_cliente());
			ps.setString(2, c.getCod_exemplar());
			ps.setString(3, c.getRegistro_operador());
			ps.setString(4, Data.convertSql(c.getData_retirada()));
			ps.setString(5, c.getHora_retirada());
			ps.setString(6, Data.convertSql(c.getData_devolucao()));

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(PK pk) {

		String query = "select * from emprestimo where cod_emprestimo='" + pk + "'";

		Statement st;
		ResultSet rsEmprestimo;

		try {
			st = conn.createStatement();
			rsEmprestimo = st.executeQuery(query);
			
			if (rsEmprestimo.next()) {
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setCod_emprestimo(rsEmprestimo.getString("cod_emprestimo"));
				emprestimo.setRegistro_cliente(rsEmprestimo.getString("registro_cliente"));
				emprestimo.setCod_exemplar(rsEmprestimo.getString("cod_exemplar"));
				emprestimo.setRegistro_operador(rsEmprestimo.getString("registro_operador"));
				emprestimo.setData_retirada(Data.convertString(rsEmprestimo.getString("data_retirada")));
				emprestimo.setHora_retirada(rsEmprestimo.getString("hora_retirada"));
				emprestimo.setData_devolucao(Data.convertString(rsEmprestimo.getString("data_devolucao")));
				emprestimo.setDevolvido(rsEmprestimo.getBoolean("devolvido"));
				return (E) emprestimo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public E read(PK pk, PK pk2) {
		String query = "select * from emprestimo where registro_cliente='" + pk + "' and cod_exemplar='" + pk2 + "'";

		Statement st;
		ResultSet rsEmprestimo;

		try {
			st = conn.createStatement();
			rsEmprestimo = st.executeQuery(query);
			
			if (rsEmprestimo.next()) {
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setCod_emprestimo(rsEmprestimo.getString("cod_emprestimo"));
				emprestimo.setRegistro_cliente(rsEmprestimo.getString("registro_cliente"));
				emprestimo.setCod_exemplar(rsEmprestimo.getString("cod_exemplar"));
				emprestimo.setRegistro_operador(rsEmprestimo.getString("registro_operador"));
				emprestimo.setData_retirada(Data.convertString(rsEmprestimo.getString("data_retirada")));
				emprestimo.setHora_retirada(rsEmprestimo.getString("hora_retirada"));
				emprestimo.setData_devolucao(Data.convertString(rsEmprestimo.getString("data_devolucao")));
				emprestimo.setDevolvido(rsEmprestimo.getBoolean("devolvido"));
				return (E) emprestimo;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public void update(E transferObject, PK pk) {

		String query = "update emprestimo set devolvido=? where cod_emprestimo='" + pk + "'";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			Emprestimo e = (Emprestimo) transferObject;
			ps.setBoolean(1, e.getDevolvido());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(PK pk) {

		String query = "delete from emprestimo where cod_emprestimo='" + pk + "'";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<E> readAll(String sql) {
		ArrayList<Emprestimo> lista = new ArrayList<Emprestimo>();

		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			Emprestimo emprestimo;
			while (rs.next()) {
				emprestimo = new Emprestimo();
				emprestimo.setCod_emprestimo(rs.getString("cod_emprestimo"));
				emprestimo.setRegistro_cliente(rs.getString("registro_cliente"));
				emprestimo.setCod_exemplar(rs.getString("cod_exemplar"));
				emprestimo.setRegistro_operador(rs.getString("registro_operador"));
				emprestimo.setData_retirada(Data.convertString(rs.getString("data_retirada")));
				emprestimo.setHora_retirada(rs.getString("hora_retirada"));
				emprestimo.setData_devolucao(Data.convertString(rs.getString("data_devolucao")));
				emprestimo.setDevolvido(rs.getBoolean("devolvido"));

				lista.add(emprestimo);
			}

			ps.close();
			rs.close();

			return (ArrayList<E>) lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
