package Control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Entidade.Curso;

public class Controller implements TableModel {
	private List<Curso> curso = new ArrayList<>();
	private CursoDAO cursoDao;

	public Controller() {
		try {
			cursoDao = new CursoDAO();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void adicionar(Curso a) throws SQLException {
		cursoDao.add(a);
	}

	public Curso pesquisarPorNome(String nome) throws SQLException {
		curso = cursoDao.pesqNome(nome);
		return null;
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
	}

	@Override
	public Class<?> getColumnClass(int col) {
		switch (col) {
		case 0:
			return long.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return boolean.class;
		case 4:
			return Date.class;
		case 5:
			return Date.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID";
		case 1:
			return "Nome";
		case 2:
			return "Descricao";
		case 3:
			return "Ativo";
		case 4:
			return "Hr Inicio";
		case 5:
			return "Hr Fim";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return curso.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Curso a = curso.get(row);
		switch (col) {
		case 0:
			return a.getId();
		case 1:
			return a.getNome();
		case 2:
			return a.getDescricao();
		case 3:
			return a.isAtivo();
		case 4:
			return a.getHoraInicio();
		case 5:
			return a.getHoraTermino();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
}
