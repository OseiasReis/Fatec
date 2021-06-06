package Table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Formulario.Livro;

public class LivroTableModel extends AbstractTableModel{

	private static final int COL_COD_A = 0;
	private static final int COL_EDITORA = 1;
	private static final int COL_TITULO = 2;
	private static final int COL_ISBN = 3;
	
	private List<Livro> valores;
	
	public LivroTableModel(List<Livro> valores){
		this.valores = valores;
	}
	
	@Override
	public int getColumnCount() {
		return valores.size();
	}

	@Override
	public int getRowCount() {
		return 4;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Livro livro = valores.get(rowIndex);
		if(columnIndex == COL_COD_A){
			return livro.getCod_acervo();
		} else if (columnIndex == COL_EDITORA){
			return livro.getEditora();
		} else if (columnIndex == COL_TITULO){
			return livro.getTitulo();
		} else if (columnIndex == COL_ISBN){
			return livro.getIsbn();
		}
		return null;
	}
	
	public String getColumnName(int column){
		String coluna = "";
		switch (column) {
			case COL_COD_A:
				coluna = "Cod_Acervo";
				break;
			case COL_EDITORA:
				coluna = "Editora";
				break;
			case COL_TITULO:
				coluna = "Titulo";
				break;
			case COL_ISBN:
				coluna = "ISBN";
				break;
			default:
				throw new IllegalArgumentException("Coluna invalida");
		}
		
		return coluna;
	}
	
	public Class<?> getColumnClass(int columnIndex){
		if (columnIndex == COL_COD_A){
			return String.class;
		} else if (columnIndex == COL_EDITORA){
			return String.class;
		} else if (columnIndex == COL_TITULO){
			return String.class;
		} else if (columnIndex == COL_ISBN){
			return String.class;
		}
		return null;
	}
	
	public Livro get(int row){
		return valores.get(row);
	}
	
}
