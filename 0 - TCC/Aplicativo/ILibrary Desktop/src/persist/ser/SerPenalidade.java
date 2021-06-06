package persist.ser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Penalidade;
import persist.IGenericDAO;

public class SerPenalidade<E, PK> implements IGenericDAO<E, PK> {

	@Override
	public void create(E newInstance) {

		Penalidade penalidade = (Penalidade) newInstance;
		FileOutputStream file;
		ObjectOutputStream oos;
		File arquivo = new File("system/systempen.ser");
		try {
			file = new FileOutputStream(arquivo);
			oos = new ObjectOutputStream(file);
			oos.writeObject(penalidade);
			oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(PK pk) {

		ObjectInputStream objinput;

		try {
			objinput = new ObjectInputStream(new FileInputStream("system/systempen.ser"));
			Penalidade penalidade = (Penalidade) objinput.readObject();
			objinput.close();

			return (E) penalidade;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void delete(PK pk) {
	}

	@Override
	public ArrayList<E> readAll(String sql) {
		return null;
	}

	@Override
	public void update(E transferObject, PK pk) {
	}
}
