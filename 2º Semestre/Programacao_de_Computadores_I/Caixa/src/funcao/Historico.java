package funcao;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import ADM.Funcionarios;

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

public class Historico extends JFrame{
	protected String[] colunas = {"CPF", "Email", "Nome", "V.Total", "Data", "Horario"};
	protected String[][] dados = new String[200][6];
	protected JTable jtTabela = new JTable(dados, colunas);
	JScrollPane jsBarra;
	
	private JButton btnAtualizar = new JButton("Atualizar");
	
	File funcionario;
	File arquivos = new File("Vendas");
	File[] vendas = arquivos.listFiles();
	BufferedReader buffVenda, buffFuncionario;
	
	int I = 0;
	
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	int largura = (tela.width-this.getSize().width);
	int altura = (tela.height-this.getSize().height);
	
	String codigo, email, nome, vtotal, data, horario, cpf;
	
	public Historico(){
		super(".:Historico:.");
		
		btnAtualizar.setFont(new Font("Arial", Font.BOLD, 16));
		
			try {
				alterarTabela();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Container paine = getContentPane();
			paine.setLayout(null);
			
			paine.add(btnAtualizar);
	        btnAtualizar.setBounds(300, 190, 150, 60);
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
	        
			jtTabela.setDragEnabled(false);
			jtTabela.setEnabled(false);
			jsBarra = new JScrollPane(jtTabela);
			paine.add(jsBarra);
			jsBarra.setBounds(20, 20, 750, 150);
			
			this.setSize(800, 300);
			this.setVisible(true);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setResizable(false);
		}
		
		public void alterarTabela() throws IOException{
			I = 0;
			System.out.println(vendas[0]);
			for(File venda : vendas){
				buffVenda = new BufferedReader(new FileReader(venda));
				codigo = venda.getName().replace(".txt", "");
				email = buffVenda.readLine();
				funcionario = new File("Funcionarios/" + email + ".txt");
				buffFuncionario = new BufferedReader(new FileReader(funcionario));
				
				cpf = buffFuncionario.readLine();
				cpf = buffFuncionario.readLine();
				cpf = buffFuncionario.readLine();
				cpf = buffFuncionario.readLine();
				
				nome = buffFuncionario.readLine();
				data = buffVenda.readLine();
				horario = buffVenda.readLine();
				vtotal = buffVenda.readLine();
				
				buffFuncionario.close();
				buffVenda.close();
				
				//Ordem: {"CPF", "Email", "Nome", "V.Total", "Data", "Horario"}
				dados[I][0] = cpf;
				dados[I][1] = email;
				dados[I][2] = nome;
				dados[I][3] = vtotal;
				dados[I][4] = data;
				dados[I][5] = horario;
				I++;
			}
			
			
			jtTabela = new JTable(dados, colunas);
		}
	}

