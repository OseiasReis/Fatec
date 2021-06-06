package edu.lojavirtual.managedbeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import edu.lojavirtual.dao.ProdutoDAO;
import edu.lojavirtual.dao.ProdutoDAOImpl;
import edu.lojavirtual.entidades.Produto;

@ManagedBean
@SessionScoped
public class ProdutoMB implements Serializable {

	private static final long serialVersionUID = -3304202810037758438L;
	
	private Produto prodAtual;
	private ProdutoDAO prodDAO;
	private List<Produto> produtos;
	
	public ProdutoMB() { 
		prodAtual = new Produto();
		setProdutos(new ArrayList<Produto>());
		prodDAO = new ProdutoDAOImpl();
		
	}
	
	public void testaValidade(FacesContext ctx, UIComponent ui, Object o) { 
		Date data = (Date) o;
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		
		if (cal.get(Calendar.YEAR) != 2014) { 
			FacesMessage msg = new FacesMessage("A validade deve ser no ano de 2014", 
												"Validade com o ano incorreto");
			throw new ValidatorException( msg );
		}
	}
	
	public String inserir() { 
		try {
			prodDAO.inserir( prodAtual );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String carregar(Produto p) { 
		prodAtual = p;
		return "";		
	}
	
	public String atualizar() {
		try {
			prodDAO.atualizar( prodAtual.getId(), prodAtual );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String remover(Produto p) { 
		try {
			prodDAO.remover( p.getId() );
			pesquisar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "";
	}
	
	public String pesquisar() { 
		try {
			produtos = prodDAO.pesquisar( prodAtual.getNome() );
//			if (produtos.size() > 0) { 
//				prodAtual = produtos.get(0);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String pesquisarTodos() { 
		try {
			produtos = prodDAO.pesquisar( "" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public Produto getProdAtual() {
		return prodAtual;
	}

	public void setProdAtual(Produto prodAtual) {
		this.prodAtual = prodAtual;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
