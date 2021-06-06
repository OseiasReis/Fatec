package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Formulario.Livro;

public class LivroDAO implements ILivroDAO{

	private static final String SQL_FIND_ALL = "select * from acervo";
	@Override
	public int save(Livro livro) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement patn = null;
		try {
			patn = conn.prepareStatement("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Livro livro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Long Cod_acervo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Livro> findAll() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement patn = null;
		List<Livro> livros = new ArrayList<Livro>();
		ResultSet rs = null;
		try {
			patn = conn.prepareStatement(SQL_FIND_ALL);
			rs = patn.executeQuery();
			while (rs.next()){
				Livro livro = new Livro();
				livro.setCod_acervo(rs.getString("Cod_Acervo"));
				livro.setEditora(rs.getString("Editora"));
				livro.setTitulo(rs.getString("Titulo"));
				livro.setIsbn(rs.getString("ISBN"));
				
				livros.add(livro);
			}
		} catch (SQLException e) {
			try {
				if (conn != null){
					conn.rollback();
				}
			} catch (SQLException ei){
				ei.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return livros;
	}

}
