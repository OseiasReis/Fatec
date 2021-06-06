package persist;

import java.io.Serializable;
import java.util.ArrayList;
import model.Biblioteca;
import model.Penalidade;
import persist.ser.SerBiblioteca;
import persist.ser.SerPenalidade;

public class SerDAO<E, PK extends Serializable> implements IGenericDAO<E, PK> {

	@SuppressWarnings("rawtypes")
	private Class classe;

	@SuppressWarnings("rawtypes")
	public SerDAO(Class classe) {
		this.classe = classe;
	}

	@Override
	public void create(E newInstance) {

		if (newInstance instanceof Penalidade) {
			(new SerPenalidade<Penalidade, String>()).create((Penalidade) newInstance);
		} else if (newInstance instanceof Biblioteca) {
			(new SerBiblioteca<Biblioteca, String>()).create((Biblioteca) newInstance);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(PK pk) {

		if (classe.getSimpleName().equals("Penalidade")) {
			return (E) ((new SerPenalidade<Penalidade, String>()).read((String) pk));
		}

		if (classe.getSimpleName().equals("Biblioteca")) {
			return (E) ((new SerBiblioteca<Biblioteca, String>()).read((String) pk));
		}

		return null;
	}

	@Override
	public void update(E transferObject, PK pk) {
	}

	@Override
	public void delete(PK pk) {
	}

	@Override
	public ArrayList<E> readAll(String sql) {
		return null;
	}
}