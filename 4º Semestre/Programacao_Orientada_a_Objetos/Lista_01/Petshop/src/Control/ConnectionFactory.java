package Control;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection conn;

	static {

	}

	public static Connection getConnection() {

		if (ConnectionFactory.conn != null) {
			return ConnectionFactory.conn;
		} else {
			return createConnection();
		}

	}

	private static Connection createConnection() {

		String usuario, senha, serverName, bancoDados;
		ObjectInputStream objinput;

		try {
			usuario = "root";
			senha = "";
			serverName = "localhost";
			bancoDados = "Animal";

			Class.forName("com.mysql.jdbc.Driver");
			String stringConnection = "jdbc:mysql://" + serverName + "/" + bancoDados;
			ConnectionFactory.conn = DriverManager.getConnection(stringConnection, usuario, senha);
			return ConnectionFactory.conn;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
