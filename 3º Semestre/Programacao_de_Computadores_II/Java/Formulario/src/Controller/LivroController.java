package Controller;

import java.util.List;

import Formulario.Livro;
import facade.LivroFacade;

public class LivroController {
	
	private LivroFacade facade;
	
	public LivroController(){
		this.facade = new LivroFacade();
	}
	
	public List<Livro> findLivros(){
		return facade.findAll();
	}
}
