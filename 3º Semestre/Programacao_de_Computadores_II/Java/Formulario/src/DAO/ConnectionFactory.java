package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	static Connection conn;
	
	
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String stringConnection = "jdbc:mysql://localhost:3306/ilibrarybd";
			ConnectionFactory.conn = DriverManager.getConnection(stringConnection, "root", "");
			return ConnectionFactory.conn;
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		return null;
	}

}
