package ADM;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;

import produtos.Listagem;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Funcionarios extends JFrame{
	protected String[] colunas = {"Email", "CPF", "Nome", "Estado", "Bairro", "Cep", "Cidade", "Telefone R", "Telefone C", "Sexo"};
	protected String[][] dados = new String[200][10];
	protected JTable jtTabela = new JTable(dados, colunas);
	JScrollPane jsBarra;
	
	private JButton btnAtualizar = new JButton("Atualizar");
	File diretorio = new File("Funcionarios");
	File[] arquivos =  diretorio.listFiles();
	BufferedReader buffer;
	
	int I;
	
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	int largura = (tela.width-this.getSize().width);
	int altura = (tela.height-this.getSize().height);
	
	public Funcionarios(){
		super(".:Funcionarios:.");
		
		btnAtualizar.setFont(new Font("Arial", Font.BOLD, 16));
		
			try {
				alterarTabela();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Container paine = getContentPane();
			paine.setLayout(null);
			
			jtTabela.setDragEnabled(false);
			jtTabela.setEnabled(false);
			jsBarra = new JScrollPane(jtTabela);
			paine.add(jsBarra);
			jsBarra.setBounds(20, 20, 950, 150);
			
			
			paine.add(btnAtualizar);
	        btnAtualizar.setBounds(400, 190, 150, 60);
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
	          
			this.setSize(1000, 300);
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
				dados[I][1] = buffer.readLine();
				dados[I][1] = buffer.readLine();
				dados[I][1] = buffer.readLine();
				dados[I][2] = buffer.readLine();
				dados[I][3] = buffer.readLine();
				dados[I][4] = buffer.readLine();
				dados[I][5] = buffer.readLine();
				dados[I][6] = buffer.readLine();
				dados[I][7] = buffer.readLine();
				dados[I][8] = buffer.readLine();
				dados[I][9] = buffer.readLine();
				I++;
				buffer.close();
			}
			jtTabela = new JTable(dados, colunas);
		}
	}



