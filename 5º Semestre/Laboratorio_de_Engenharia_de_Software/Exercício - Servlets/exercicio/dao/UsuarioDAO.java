package dao;

public interface UsuarioDAO {
	public String login(String user, String pass) throws GenericDAOException;
}
