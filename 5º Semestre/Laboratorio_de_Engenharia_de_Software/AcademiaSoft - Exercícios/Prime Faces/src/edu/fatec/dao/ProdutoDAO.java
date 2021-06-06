package edu.lojavirtual.dao;

import java.sql.SQLException;
import java.util.List;

import edu.lojavirtual.entidades.Produto;

public interface ProdutoDAO {
	
	public void inserir(Produto p) throws SQLException;
	public void remover(long id) throws SQLException;
	public void atualizar(long id, Produto p) throws SQLException;
	public List<Produto> pesquisar(String nome) throws SQLException;

}
