package persistir;

import java.io.Serializable;

public interface IGenericDAO <T, PK extends Serializable>{
	void create(T newInstance) throws Exception;
}
