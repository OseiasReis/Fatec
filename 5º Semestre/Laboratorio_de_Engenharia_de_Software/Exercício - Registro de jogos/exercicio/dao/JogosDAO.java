package dao;

import java.util.List;
import model.Jogos;

public interface JogosDAO {
	public void adicionar(Jogos jogos) throws GenericDAOException;
	public List<Jogos> presquisarPorNome(String jogos) throws GenericDAOException;
}
