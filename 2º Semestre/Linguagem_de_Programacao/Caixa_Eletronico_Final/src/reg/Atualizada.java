package reg;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;

public class Atualizada extends JPanel{
	//processar e gerar Contas Atualizadas, assim como suas consultas
	
	private DefaultTableModel modeloConta;
	
	private String[] colunas = {"Cod. Conta", "Nome", "Saldo", "Limite"};
	private String[][] linhas;
	
	private JTable tblConta;
	
	private JScrollPane scrollPane;
	
	private JLabel lblTitulo;
	
	public Atualizada() {
		
		this.setLayout(null);
		this.setSize(678, 654);
		this.setVisible(true);
		
		File inf = new File("Pessoa");
		File[] arquivos =  inf.listFiles();
		arquivos = inf.listFiles();
		int l = 0;
		for(File nome : arquivos){
			l++; //contador de linhas
		}
		linhas = new String[l][4];
		
		try {
			alterarTabela();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lblTitulo = new JLabel("Contas Atualizadas"); lblTitulo.setFont(new Font("Script MT Bold", Font.BOLD, 60));
		
		modeloConta = new DefaultTableModel();
		tblConta = new JTable(linhas, colunas);
		tblConta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblConta.getColumnModel().getColumn(0).setPreferredWidth(90);
		tblConta.getColumnModel().getColumn(1).setPreferredWidth(140);
		//tblConta.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblConta.getColumnModel().getColumn(2).setPreferredWidth(95);
		tblConta.getColumnModel().getColumn(3).setPreferredWidth(95);
		//tblConta.getColumnModel().getColumn(5).setPreferredWidth(58);
		tblConta.setRowHeight(25);
		tblConta.setEnabled(false);
		tblConta.setAutoCreateRowSorter(true);
		
		scrollPane = new JScrollPane(tblConta);
		scrollPane.setBounds(57, 188, 438, 277);
		add(scrollPane);
		
		add(lblTitulo);
		lblTitulo.setBounds(36, 26, 529, 50);
		
	}
		public void alterarTabela() throws IOException{
			File inf = new File("Pessoa");
			File[] arquivos =  inf.listFiles();
			BufferedReader buffer;
			arquivos = inf.listFiles();
			
			int i = 0;
			for(File nome : arquivos){
				buffer = new BufferedReader(new FileReader(nome));
				linhas[i][0] = buffer.readLine();
				linhas[i][1] = buffer.readLine();
				linhas[i][2] = buffer.readLine();
				linhas[i][2] = buffer.readLine();
				linhas[i][2] = buffer.readLine();
				linhas[i][2] = buffer.readLine();
				linhas[i][3] = buffer.readLine();
				i++;
				buffer.close();
			}
			
			tblConta = new JTable(/*modeloConta*/);
		}
	
}
