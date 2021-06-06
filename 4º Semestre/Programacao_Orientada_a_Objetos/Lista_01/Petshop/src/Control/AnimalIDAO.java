package Control;

import java.sql.SQLException;
import java.util.List;

import Entidade.Animal;

public interface AnimalIDAO {
	public void add (Animal a) throws SQLException;
	List<Animal> pesqNome (String nome) throws SQLException;
}
