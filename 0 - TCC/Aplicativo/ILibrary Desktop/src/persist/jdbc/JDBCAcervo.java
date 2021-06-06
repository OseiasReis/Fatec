package persist.jdbc;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Acervo;
import model.Classificacao;
import persist.ConnectionFactory;
import persist.IGenericDAO;
import persist.JDBCDAO;

public class JDBCAcervo<E, PK> implements IGenericDAO<E, PK>{

	private Connection conn;
	
	{
		conn = ConnectionFactory.getConnection();
	}
	
	private Acervo createAcervo(ResultSet rsAcervo) throws SQLException {
		
		Classificacao classificacao = new JDBCDAO<Classificacao, String>(Classificacao.class).read(rsAcervo.getString("cod_classificacao"));

		Acervo acervo = new Acervo();
		acervo.setCodigo_acervo(rsAcervo.getString("cod_acervo"));
		acervo.setAno(rsAcervo.getString("ano_publicacao"));
		acervo.setAutor(rsAcervo.getString("nome_autor"));	           
		acervo.setDimensoes(rsAcervo.getString("dimensoes"));
		acervo.setEdicao(rsAcervo.getString("edicao"));
		acervo.setEditora(rsAcervo.getString("editora"));	  
		acervo.setIsbn(rsAcervo.getString("isbn"));
		acervo.setLocal(rsAcervo.getString("local_publicacao"));
		acervo.setMaterial(rsAcervo.getString("tipo_material"));
		acervo.setPaginas(rsAcervo.getString("num_paginas"));
		acervo.setResumo(rsAcervo.getString("resumo"));
		acervo.setSubtitulo(rsAcervo.getString("subtitulo"));
		acervo.setTitulo(rsAcervo.getString("titulo"));
		acervo.setVolume(rsAcervo.getString("volume"));
		acervo.setCod_classificacao(rsAcervo.getString("cod_classificacao"));
		acervo.setClassificacao(classificacao);
		acervo.setIdioma(rsAcervo.getString("idioma"));
		
		if (rsAcervo.getBlob("imagem") != null) {
			acervo.setImagem(rsAcervo.getBlob("imagem").getBinaryStream());
		} else {
			acervo.setImagem(null);
		}

		return acervo;
	}
	
	@Override
	public void create(E newInstance) {
		
		String query = "insert into acervo (cod_acervo, cod_classificacao, tipo_material, titulo, subtitulo, edicao, volume, editora, nome_autor, num_paginas, ano_publicacao, local_publicacao, resumo, isbn, dimensoes, imagem, idioma) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			
			Acervo b = (Acervo) newInstance;
			ps.setString(1, b.getCodigo_acervo());
			ps.setString(2, b.getCod_classificacao());
			ps.setString(3, b.getMaterial());
			ps.setString(4, b.getTitulo());
			ps.setString(5, b.getSubtitulo());
			ps.setString(6, b.getEdicao());
			ps.setString(7, b.getVolume());
			ps.setString(8, b.getEditora());
			ps.setString(9, b.getAutor());
			ps.setString(10, b.getPaginas());
			ps.setString(11, b.getAno());
			ps.setString(12, b.getLocal());
			ps.setString(13, b.getResumo());
			ps.setString(14, b.getIsbn());
			ps.setString(15, b.getDimensoes());
			if (b.getImagem() != null) {
				ps.setBinaryStream(16, b.getImagem());
			} else {
				ps.setBlob(16, (Blob) null);
			}
			ps.setString(17, b.getIdioma());
			
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Acervo inserido com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(PK pk) {
		
		String query = "select * from acervo where cod_acervo='" + pk + "'";
		
		Statement st;
		ResultSet rsAcervo;
		 
			try {
				st = conn.createStatement();
				rsAcervo = st.executeQuery(query);

				if (rsAcervo.next()) {

			        return (E) createAcervo(rsAcervo);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return null;
           
	}

	@Override
	public void update(E transferObject, PK pk) {
		
		String query = "update acervo set cod_acervo=?, cod_classificacao=?, tipo_material=?, titulo=?, subtitulo=?, edicao=?, volume=?, editora=?, nome_autor=?, num_paginas=?, ano_publicacao=?, local_publicacao=?, resumo=?, isbn=?, dimensoes=?, imagem=?, idioma=? where cod_acervo='" + pk + "'";
        
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			
			Acervo b = (Acervo) transferObject;
			ps.setString(1, b.getCodigo_acervo());
			ps.setString(2, b.getCod_classificacao());
			ps.setString(3, b.getMaterial());
			ps.setString(4, b.getTitulo());
			ps.setString(5, b.getSubtitulo());
			ps.setString(6, b.getEdicao());
			ps.setString(7, b.getVolume());
			ps.setString(8, b.getEditora());
			ps.setString(9, b.getAutor());
			ps.setString(10, b.getPaginas());
			ps.setString(11, b.getAno());
			ps.setString(12, b.getLocal());
			ps.setString(13, b.getResumo());
			ps.setString(14, b.getIsbn());
			ps.setString(15, b.getDimensoes());
			if (b.getImagem() != null) {
				ps.setBinaryStream(16, b.getImagem());
			} else {
				ps.setBlob(16, (Blob) null);
			}
			ps.setString(17, b.getIdioma());

			ps.executeUpdate();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void delete(PK pk) {
		
		String query = "delete from acervo where cod_acervo='" + pk + "'";
		
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(query);
			st.close();
			JOptionPane.showMessageDialog(null, "Acervo removido com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<E> readAll(String sql) {
		ArrayList<Acervo> lista_acervo = new ArrayList<Acervo>();
		PreparedStatement ps;
		ResultSet rsAcervo;
		try {
			ps = conn.prepareStatement(sql);
			rsAcervo = ps.executeQuery();
			
			if (rsAcervo.next()) {
				lista_acervo.add(createAcervo(rsAcervo));
				
				while(rsAcervo.next()) {
					lista_acervo.add(createAcervo(rsAcervo));
				}
			}
			
			if(!lista_acervo.isEmpty()) {
				return (ArrayList<E>) lista_acervo;
			}
												
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
