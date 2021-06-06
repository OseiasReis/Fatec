package edu.lojavirtual.managedbeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import edu.lojavirtual.dao.ProdutoDAO;
import edu.lojavirtual.dao.ProdutoDAOImplementation;
import edu.lojavirtual.entidades.Produto;

@ManagedBean(name="produtoMB")
public class ProdutoMB implements Serializable {
	
	private Produto produtoAtual;
	private ProdutoDAO prodDao;
	
	public ProdutoMB() { 
		setProdutoAtual(new Produto());
		this.produtoAtual.setValidade( new Date() );
		prodDao = new ProdutoDAOImplementation();
	}
	
	public String inserir() {
		try {
			prodDao.inserir( produtoAtual );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String remover() { 
		try {
			prodDao.remover( produtoAtual.getId() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String atualizar() { 
		try {
			prodDao.atualizar( produtoAtual.getId(), produtoAtual );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String pesquisar() { 
		try {
			List<Produto> produtos = prodDao.pesquisarPorNome( produtoAtual.getNome() );
			for (Produto p : produtos) { 
				System.out.println("Nome : " + p.getNome());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	

	public Produto getProdutoAtual() {
		return produtoAtual;
	}

	public void setProdutoAtual(Produto produtoAtual) {
		this.produtoAtual = produtoAtual;
	}

}
