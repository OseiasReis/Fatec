package persist.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Data;
import model.Devolucao;
import persist.ConnectionFactory;
import persist.IGenericDAO;

public class JDBCDevolucao<E, PK> implements IGenericDAO<E, PK> {

	private Connection conn;

	{
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public void create(E newInstance) {

		String query = "insert into devolucao (cod_emprestimo, "
				+ "data_entrega, hora_entrega, termino_susp, registro_operador, preco_multa)"
				+ " values (?, ?, ?, ?, ?, ?)";

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement(query);
			Devolucao c = (Devolucao) newInstance;
			ps.setString(1, c.getCod_emprestimo());
			ps.setString(2, Data.convertSql(c.getData_entrega()));
			ps.setString(3, c.getHora_entrega());
			ps.setString(4, Data.convertSql(c.getTermino_suspensao()));
			ps.setString(5, c.getRegistro_operador());
			ps.setDouble(6, c.getPreco_multa());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(PK pk) {

		String query = "select * from devolucao where cod_emprestimo=" + pk;

		Statement st;
		ResultSet rsDevolucao;

		try {
			st = conn.createStatement();
			rsDevolucao = st.executeQuery(query);
			rsDevolucao.next();

			Devolucao devolucao = new Devolucao();
			devolucao.setCod_emprestimo(rsDevolucao.getString("cod_emprestimo"));
			devolucao.setData_entrega(Data.convertString(rsDevolucao.getString("data_entrega")));
			devolucao.setHora_entrega(rsDevolucao.getString("hora_entrega"));
			devolucao.setPreco_multa(rsDevolucao.getDouble("preco_multa"));
			devolucao.setTermino_suspensao(Data.convertString(rsDevolucao.getString("termino_susp")));
			devolucao.setRegistro_operador(rsDevolucao.getString("registro_operador"));
			devolucao.setPreco_multa(rsDevolucao.getDouble("preco_multa"));

			return (E) devolucao;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void update(E transferObject, PK pk) {

		String query = "update devolucao set cod_emprestimo=?, registro_cliente=?, codigo_exemplar=?, "
				+ "data_retirada=?, hora_retirada=?,  where Cod_Devolucao='" + pk + "'";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(PK pk) {

		String query = "delete from devolucao where cod_devolucao='" + pk + "'";

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
		ArrayList<Devolucao> lista = new ArrayList<Devolucao>();
		PreparedStatement ps;
		ResultSet rsDevolucao;
		try {
			ps = conn.prepareStatement(sql);
			rsDevolucao = ps.executeQuery();

			Devolucao devolucao;
			while (rsDevolucao.next()) {
				devolucao = new Devolucao();
				devolucao.setCod_emprestimo(rsDevolucao.getString("cod_emprestimo"));
				devolucao.setData_entrega(Data.convertString(rsDevolucao.getString("data_entrega")));
				devolucao.setHora_entrega(rsDevolucao.getString("hora_entrega"));
				devolucao.setTermino_suspensao(Data.convertString(rsDevolucao.getString("termino_susp")));
				devolucao.setRegistro_operador(rsDevolucao.getString("registro_operador"));
				devolucao.setPreco_multa(rsDevolucao.getDouble("preco_multa"));

				lista.add(devolucao);
			}

			ps.close();
			rsDevolucao.close();

			return (ArrayList<E>) lista;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
