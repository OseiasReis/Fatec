package persist;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import model.BancoDados;

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
			objinput = new ObjectInputStream(new FileInputStream("system/systembd.ser"));
			BancoDados bd = (BancoDados) objinput.readObject();
			objinput.close();

			usuario = bd.getUsuario();
			senha = bd.getSenha();
			serverName = bd.getServerName();
			bancoDados = bd.getBancoDados();

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
