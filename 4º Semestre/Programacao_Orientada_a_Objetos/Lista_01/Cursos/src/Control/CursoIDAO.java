package Control;

import java.sql.SQLException;
import java.util.List;

import Entidade.Curso;

public interface CursoIDAO {
	void add (Curso a) throws SQLException;
	List<Curso> pesqNome (String nome) throws SQLException;
}
