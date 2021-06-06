package form;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controller.LivroController;
import Formulario.Livro;
import Table.LivroTableModel;

public class Livroform extends JFrame{
	private JLabel lbleditora, lbltitulo, lblisbn;
	private JTextField txtEditora, txtTitulo, txtisbn;
	private JPanel panelADD, panelTable, panelButtons;
	private JTable table;
	private JScrollPane scrollPane;
	
	private List<Livro> livroList;
	private String CodLivro;
	
	public Livroform() throws HeadlessException{
		super("Cadastro de livros");
		
		setContentPane(new JPanel());
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelADD = new JPanel(new GridLayout());
		panelADD.setBorder(BorderFactory.createTitledBorder("Adicionar livros"));
		panelADD.setBounds(5, 0, 480, 100);
		
		panelTable = new JPanel(new GridLayout());
		panelTable.setBorder(BorderFactory.createTitledBorder("Lista de livros"));
		panelTable.setBounds(5, 150, 480, 240);
		
		table = new JTable();
		
		scrollPane = new JScrollPane(table);
		
		panelTable.add(scrollPane);
		
		refreshTable();
		
		add(panelADD);
		add(panelTable);
		setMinimumSize(new Dimension(500, 420));
		setVisible(true);
		
		
	}
	
	private void refreshTable(){
		livroList = new LivroController().findLivros();
		if (livroList != null){
			table.setModel(new LivroTableModel(livroList));
		}
	}
}
