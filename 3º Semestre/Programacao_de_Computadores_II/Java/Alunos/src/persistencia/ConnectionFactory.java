package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	static Connection conn;
	static{
		
	}
	
	public static Connection getConnection(){
		if (null != ConnectionFactory.conn){
			return ConnectionFactory.conn;
		}else{
			return createConnection();
		}
	}
	
	private static Connection createConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String stringConnection="jdbc:mysql://localhost:3306/escola";
			return DriverManager.getConnection(stringConnection,"root","");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
