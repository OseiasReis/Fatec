package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Entity.Aluno;

public class Controller {


	public void adicionar(Aluno a) throws ClassNotFoundException {
		try {
			Connection con = ConnectionFactory.getConnection();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String sql = "INSERT INTO alunos " + " (ra, nome, idade, nascimento) " + " VALUES ( " + "'" + a.getRa()
					+ "', " + "'" + a.getNome() + "', " + "" + a.getIdade() + ", " + "" + sdf.format(a.getNascimento()) + ")";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Aluno> pesquisar(String a) throws ClassNotFoundException {
		List<Aluno> alunos = new ArrayList<>();
		try {
			Connection con = ConnectionFactory.getConnection();
			String query = "select * from alunos where ra " + " LIKE " + a + ";";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				Aluno al = new Aluno();
				al.setRa(rs.getString("ra"));
				al.setNome(rs.getString("nome"));
				al.setIdade(rs.getInt("idade"));
				al.setNascimento(rs.getDate("nascimento"));
				alunos.add(al);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}

	public Aluno remover(Aluno a) throws ClassNotFoundException {
		try {
			Connection con = ConnectionFactory.getConnection();
			System.out.println("Conectado");
			String sql = "delete from alunos where ra = " + a.getRa() + ";";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void atualizar(Aluno a) throws ClassNotFoundException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Connection con = ConnectionFactory.getConnection();
			System.out.println("Conectado");
			String sql = "update alunos set nome = '" + a.getNome()
			+ "' where ra =  '" + a.getRa() + "';";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate(sql);
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}