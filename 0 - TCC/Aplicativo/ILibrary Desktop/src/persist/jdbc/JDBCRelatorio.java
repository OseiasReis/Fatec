package persist.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import persist.ConnectionFactory;

public class JDBCRelatorio {

	private Connection conn;

	{
		conn = ConnectionFactory.getConnection();
	}

	public int count(String sql) {

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public ResultSet read(String sql) {

		String query = sql;

		try {
			Statement st;
			ResultSet rs;

			st = conn.createStatement();
			rs = st.executeQuery(query);

			if (rs.next()) {
				return rs;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("nulo");
		return null;
	}

	public ArrayList<Date> readAll(String sql) {

		ArrayList<Date> lista_Data = new ArrayList<Date>();
		PreparedStatement ps;
		ResultSet rsData;
		try {
			ps = conn.prepareStatement(sql);
			rsData = ps.executeQuery();

			if (rsData.next()) {
				lista_Data.add(rsData.getDate(1));

				while (rsData.next()) {
					lista_Data.add(rsData.getDate(1));
				}
			}

			if (!lista_Data.isEmpty()) {

				return (ArrayList<Date>) lista_Data;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
