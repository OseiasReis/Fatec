package edu.lojavirtual.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.lojavirtual.entidades.Produto;

public class ProdutoDAOImpl implements ProdutoDAO {

	@Override
	public void inserir(Produto p) throws SQLException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.persist( p );
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(long id) throws SQLException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Produto p = em.getReference(Produto.class, id);
		if (p != null) { 
			em.getTransaction().begin();
			em.remove( p );
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public void atualizar(long id, Produto p) throws SQLException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Produto prodAntigo = em.getReference(Produto.class, id);
		if (prodAntigo != null) { 
			em.getTransaction().begin();
			prodAntigo.setNome( p.getNome() );
			prodAntigo.setDescricao( p.getDescricao() );
			prodAntigo.setValidade( p.getValidade() );
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public List<Produto> pesquisar(String nome) throws SQLException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Produto> qry = 
				em.createQuery("select p from Produto p where p.nome like :n", Produto.class);
		qry.setParameter("n", "%" + nome + "%");
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.addAll( qry.getResultList() ); 
		em.close();
		return produtos;
	}
}
