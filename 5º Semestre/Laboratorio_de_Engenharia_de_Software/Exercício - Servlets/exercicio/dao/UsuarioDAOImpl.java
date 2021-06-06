package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/jogos";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "";
	private Connection con;

	public UsuarioDAOImpl() throws GenericDAOException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException | ClassNotFoundException e) {
			throw new GenericDAOException( e );
		}
	}
	
	@Override
	public String login(String user, String pass) throws GenericDAOException {
		String sql = "SELECT * FROM usuarios WHERE usuario = ?";
		String msg = "Usuário incorreto";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) { 
				
				if (pass.equals(rs.getString("password"))) {
					msg = "Logado com sucesso";
				} else {
					msg = "Senha incorreta";
				}
				
				
			}
		} catch (SQLException e) {
			msg = null;
			throw new GenericDAOException( e );
		}
		return msg;
	}

}
