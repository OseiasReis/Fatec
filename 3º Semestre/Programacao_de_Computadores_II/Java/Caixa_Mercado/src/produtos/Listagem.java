package produtos;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Listagem extends JFrame{
	protected String[] colunas = {"Código", "Nome", "Preço(R$)", "Quantidade", "Categoria", "Descrição"};
	protected String[][] dados = new String[200][6];
	protected JTable jtTabela = new JTable(dados, colunas);
	protected JButton btnAtualizar = new JButton("ATUALIZAR");	
	JScrollPane jsBarra;
	
	File diretorio = new File("Produtos");
	File[] arquivos =  diretorio.listFiles();
	BufferedReader buffer;
	
	int I;
	
	public Listagem() {		
		super("Lista de Produtos");
		try {
			alterarTabela();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnAtualizar.setMnemonic(KeyEvent.VK_A);
		
		Container paine = getContentPane();
		paine.setLayout(null);
		
		jtTabela.setDragEnabled(false);
		jtTabela.setEnabled(false);
		jsBarra = new JScrollPane(jtTabela);
		paine.add(jsBarra);
		jsBarra.setBounds(20, 20, 750, 150);
		paine.add(btnAtualizar);
		btnAtualizar.setBounds(300, 180, 160, 70);
		btnAtualizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					alterarTabela();
					paine.repaint();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.setSize(800, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
	}
	
	public void alterarTabela() throws IOException{
		arquivos = diretorio.listFiles();
		I = 0;
		for(File nome : arquivos){
			buffer = new BufferedReader(new FileReader(nome));
			dados[I][0] = nome.getName().replace(".txt", "");
			dados[I][1] = buffer.readLine();
			dados[I][2] = buffer.readLine();
			dados[I][3] = buffer.readLine();
			dados[I][4] = buffer.readLine();
			dados[I][5] = buffer.readLine();
			dados[I][5] = buffer.readLine();
			I++;
			buffer.close();
		}
		
		jtTabela = new JTable(dados, colunas);
	}
	
}
