package persist;

import java.util.ArrayList;

public interface IGenericDAO<E, PK> {

	void create(E newInstance);

	E read(PK pk);

	void update(E transferObject, PK pk);

	void delete(PK pk);

	ArrayList<E> readAll(String sql);

}
