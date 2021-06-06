package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jogos;

public class JogosDAOImpl implements JogosDAO {

	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/jogos";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "";
	private Connection con;

	public JogosDAOImpl() throws GenericDAOException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException | ClassNotFoundException e) {
			throw new GenericDAOException( e );
		}
	}

	@Override
	public void adicionar(Jogos jogos) throws GenericDAOException {
		String sql = "INSERT INTO jogos (id, nome, dif) VALUES (?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, 0);
			pstmt.setString(2, jogos.getNome());
			pstmt.setString(3, jogos.getDif());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
	}

	@Override
	public List<Jogos> presquisarPorNome(String jogo) throws GenericDAOException {
		List<Jogos> lista = new ArrayList<>();
		String sql = "SELECT * FROM jogos WHERE nome like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + jogo + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) { 
				Jogos jogos = new Jogos();
				jogos.setId(rs.getLong("id"));
				jogos.setNome(rs.getString("nome"));
				jogos.setDif(rs.getString("dif"));
				lista.add( jogos );
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return lista;
	}

}
