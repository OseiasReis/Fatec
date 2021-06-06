package Control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Entidade.Animal;

public class Controller implements TableModel {
	private List<Animal> animal = new ArrayList<>();
	private AnimalDAO animalDao;

	public Controller() {
		try {
			animalDao = new AnimalDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adicionar(Animal a) throws SQLException {
		animalDao.add(a);
	}

	public Animal pesquisarPorNome(String nome) throws SQLException {
		animal = animalDao.pesqNome(nome);
		return null;
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
	}

	@Override
	public Class<?> getColumnClass(int col) {
		switch (col) {
		case 0:
			return int.class;
		case 1:
			return String.class;
		case 4:
			return Date.class;
		case 2:
			return Float.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID";
		case 1:
			return "Nome";
		case 2:
			return "Nascimento";
		case 3:
			return "Peso";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return animal.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Animal a = animal.get(row);
		switch (col) {
		case 0: return a.getId();
		case 1: return a.getNome();
		case 2: return a.getNascimento();
		case 3: return a.getPeso();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
	}
}

