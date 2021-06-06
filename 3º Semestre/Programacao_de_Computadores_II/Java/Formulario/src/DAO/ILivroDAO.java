package DAO;

import java.util.List;

import Formulario.Livro;

public interface ILivroDAO {
	int save(Livro livro);
	
	int update(Livro livro);
	
	int remove(Long Cod_acervo);
	
	List<Livro> findAll();
}
