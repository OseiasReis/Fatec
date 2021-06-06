package persist.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Localizacao;
import model.Operador;
import persist.ConnectionFactory;
import persist.IGenericDAO;
import persist.JDBCDAO;

public class JDBCOperador<E, PK> implements IGenericDAO<E, PK> {

	private Connection conn;

	{
		conn = ConnectionFactory.getConnection();
	}

	private Operador createOperador(ResultSet rsOperador) throws SQLException {

		Localizacao local = new JDBCDAO<Localizacao, String>(Localizacao.class).read(rsOperador.getString("cep"));

		Operador operador = new Operador();
		operador.setRegistro(rsOperador.getString("registro_operador"));
		operador.setPrivilegio(rsOperador.getString("privilegio"));
		operador.setSenha(rsOperador.getString("senha"));
		operador.setNome(rsOperador.getString("nome"));
		operador.setCep(rsOperador.getString("cep"));
		operador.setNum(rsOperador.getString("numero"));
		operador.setTelefone(rsOperador.getString("telefone"));
		operador.setCelular(rsOperador.getString("celular"));
		operador.setAtivo(rsOperador.getBoolean("ativo"));
		operador.setLocalizacao(local);

		return operador;
	}

	@Override
	public void create(E newInstance) {

		String query = "insert into operador (registro_operador, privilegio, nome, cep, numero, telefone, celular, senha, ativo) values (?, ?, ?, ?, ?, ?, ?, ?, true)";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			Operador o = (Operador) newInstance;
			ps.setString(1, o.getRegistro());
			ps.setString(2, o.getPrivilegio());
			ps.setString(3, o.getNome());
			ps.setString(4, o.getCep());
			ps.setString(5, o.getNum());
			ps.setString(6, o.getTelefone());
			ps.setString(7, o.getCelular());
			ps.setString(8, o.getSenha());

			ps.executeUpdate();
			ps.close();

			JOptionPane.showMessageDialog(null, "Operador inserido com sucesso!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(PK pk) {

		String query = "select * from operador where registro_operador='" + pk + "'";

		try {
			Statement st = conn.createStatement();
			ResultSet rsOperador = st.executeQuery(query);

			if (rsOperador.next()) {

				Operador operador = createOperador(rsOperador);
				return (E) operador;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void update(E transferObject, PK pk) {

		String query = "update operador set registro_operador=?, privilegio=?, nome=?, cep=?, numero=?, telefone=?, celular=?, senha=?, ativo=? where registro_operador='"
				+ pk + "'";

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement(query);
			Operador o = (Operador) transferObject;
			ps.setString(1, o.getRegistro());
			ps.setString(2, o.getPrivilegio());
			ps.setString(3, o.getNome());
			ps.setString(4, o.getCep());
			ps.setString(5, o.getNum());
			ps.setString(6, o.getTelefone());
			ps.setString(7, o.getCelular());
			ps.setString(8, o.getSenha());
			ps.setBoolean(9, o.getAtivo());

			ps.executeUpdate();
			ps.close();

			JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
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
		ArrayList<Operador> lista_operador = new ArrayList<Operador>();
		PreparedStatement ps;
		ResultSet rsOperador;
		try {
			ps = conn.prepareStatement(sql);
			rsOperador = ps.executeQuery();

			if (rsOperador.next()) {
				lista_operador.add(createOperador(rsOperador));

				while (rsOperador.next()) {
					lista_operador.add(createOperador(rsOperador));
				}
			}

			if (!lista_operador.isEmpty()) {
				return (ArrayList<E>) lista_operador;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
