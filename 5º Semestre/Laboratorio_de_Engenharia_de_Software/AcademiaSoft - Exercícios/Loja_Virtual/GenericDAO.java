package BDLojaVirtual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO implements IGenericDAO {
	private Connection c;

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mariadb://localhost:3306/lojavirtual?allowMultiQueries=true";
		String user = "root";
		String pass = "";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			c = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

}

