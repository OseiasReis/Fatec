package persistencia;

import java.io.Serializable;

public interface IGenericDAO <T, PK extends Serializable>{
	void create(T newInstance) throws Exception;
	T read(PK pk) throws Exception;
	void updat(T transferObject) throws Exception;
	void delete(T persistent) throws Exception;
}
