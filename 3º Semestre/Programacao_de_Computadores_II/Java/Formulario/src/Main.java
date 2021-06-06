import DAO.ConnectionFactory;
import form.Livroform;

public class Main {
	public static void main (String[] args){
		ConnectionFactory.getConnection();
		new Livroform();
	}
}
