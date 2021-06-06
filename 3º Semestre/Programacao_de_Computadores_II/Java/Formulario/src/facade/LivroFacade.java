package facade;

import java.util.List;

import DAO.ILivroDAO;
import DAO.LivroDAO;
import Formulario.Livro;

public class LivroFacade {
	
	private ILivroDAO dao;

	public LivroFacade() {
		this.dao = new LivroDAO();
	}
	
	public int save(Livro livro) {
		return dao.save(livro);
	}
	
	public List<Livro> findAll(){
		return dao.findAll();
	}
}
