package edu.lojavirtual.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.lojavirtual.entidades.Produto;

public class ProdutoDAOImplementation implements ProdutoDAO {
	private static EntityManagerFactory emf;
	
	public ProdutoDAOImplementation() {
		if ( emf == null ){ 
			emf = Persistence.createEntityManagerFactory("LOJAVIRTUAL");
		}
	}

	@Override
	public void inserir(Produto p) throws SQLException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public void remover(long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		Produto p = em.getReference(Produto.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public void atualizar(long id, Produto p) throws SQLException {
		EntityManager em = emf.createEntityManager();
		Produto prodAntigo = em.getReference(Produto.class, id);
		em.getTransaction().begin();
		prodAntigo.setNome( p.getNome() );
		prodAntigo.setDescricao( p.getDescricao() );
		prodAntigo.setValidade( p.getValidade() );
		em.getTransaction().commit();
		em.close();			
	}

	@Override
	public List<Produto> pesquisarPorNome(String nome) throws SQLException {
		List<Produto> produtos = null;
		EntityManager em = emf.createEntityManager();
		TypedQuery<Produto> qry = em.createNamedQuery(
				"select prod from Produto prod where prod.nome like :nome", 
				Produto.class);
		qry.setParameter("nome", nome);
		produtos = qry.getResultList();
		return produtos;
	}

	@Override
	public List<Produto> pesquisarTodos() throws SQLException {
		List<Produto> produtos = null;
		EntityManager em = emf.createEntityManager();
		TypedQuery<Produto> qry = em.createNamedQuery(
				"select prod from Produto prod", 
				Produto.class);
		produtos = qry.getResultList();
		return produtos;
	}

}
