package funcao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Caixa extends JFrame{

	private JPanel jpTitulo = new JPanel();
	private JLabel lblDiv = new JLabel();
	private JLabel lblTitulo = new JLabel("CAIXA");	
	
	private JLabel lblCod = new JLabel ("Cod. Produto: ");
	private JTextField txtCod = new JTextField();
	private JLabel lblQtde = new JLabel("Qtde.: ");
	private JTextField txtQtde = new JTextField();
	private JButton btnValidar = new JButton("VALIDAR");
	private JButton btnFinalizar = new JButton("FINALIZAR");
	private JScrollPane jsArea;
	
	private JButton btnAdd;
	private JLabel lblPrecoTotal = new JLabel("Total: ");
	private JLabel lblTotal = new JLabel();
	
	private JTextArea txtArea = new JTextArea();
	
	protected String[] titulo = {"Cod.", "Nome", "Val. U", "Qtde.", "Val. Tot"};
	protected Object[][] dados = new Object[50][5];
	protected Object[] codigos = new Object[50];
	protected JTable jtTabela = new JTable(dados, titulo);
	protected JScrollPane jsTabela;
	
	double precoTotal;
	
	//Arquivos
	File produto, arquivo;
	String codigo, linha;
	BufferedReader buffR;
	BufferedWriter buffW;

	//Captura de data
	Date date = new Date();
	int horas, minutos, segundos;
	int dia, mes, ano;
	int count;
	
	int qtdeDig, indice = 0, qtdeEs, indiceTabela = 0, indiceCod = 0;
	String[] dados2 = new String[6];
	double precoTotal1, precoProd, precoTotProd;
	double[] precos = new double[50];
	DecimalFormat df = new DecimalFormat("0.##");
	String email;
	
	public Caixa(final String email){
		super(":. CAIXA .:");
		
		jpTitulo.setOpaque(true);	jpTitulo.setBackground(Color.lightGray);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 36));
		lblTitulo.setForeground(Color.BLACK);
		lblDiv.setOpaque(true);		lblDiv.setBackground(Color.gray);
		btnValidar.setBackground(Color.WHITE);	btnFinalizar.setBackground(Color.RED);
		jsArea = new JScrollPane(txtArea);
		txtArea.setLineWrap(true);	txtArea.setEditable(false);
		
		jtTabela.disable();
		jsTabela = new JScrollPane(jtTabela);
		
		btnAdd = new JButton("Adicionar");		
		
		//Habilitação
		txtQtde.setEditable(false);
		btnAdd.setEnabled(false);
		btnFinalizar.setEnabled(false);
		
		Container paine = getContentPane();
		paine.setLayout(null);
		
		txtArea.setBackground(paine.getBackground());
		
		paine.add(jpTitulo);
		jpTitulo.setBounds(20, 20, 450, 50);
		
		paine.add(jsTabela);
		jsTabela.setBounds(20, 80, 300, 180);
		paine.add(lblPrecoTotal);
		lblPrecoTotal.setBounds(20, 260, 60, 30);
		paine.add(lblTotal);
		lblTotal.setBounds(70, 260, 150, 30);
		
		jpTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
		jpTitulo.add(lblTitulo);
		
		paine.add(lblDiv);
		lblDiv.setBounds(490, 20, 2, 270);
		paine.add(jsArea);
		jsArea.setBounds(510, 20, 265, 270);
		
		paine.add(lblCod);
		lblCod.setBounds(340, 70, 120, 30);
		paine.add(txtCod);
		txtCod.setBounds(340, 100, 120, 25);
		
		paine.add(lblQtde);
		lblQtde.setBounds(340, 180, 50, 30);
		paine.add(txtQtde);
		txtQtde.setBounds(390, 180, 70, 25);
		
		btnValidar.setMnemonic(KeyEvent.VK_V);
		paine.add(btnValidar);
		btnValidar.setBounds(340, 130, 120, 30);
		btnAdd.setMnemonic(KeyEvent.VK_A);
		paine.add(btnAdd);
		btnAdd.setBounds(340, 220, 120, 30);
		paine.add(btnFinalizar);
		btnFinalizar.setBounds(340, 260, 120, 30);
		btnFinalizar.setMnemonic(KeyEvent.VK_F);
		
		//Ações dos botões
		btnValidar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(txtCod.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Digite o código do produto p/ validá-lo!","Mensagem",JOptionPane.PLAIN_MESSAGE);
				}else{
					codigo = txtCod.getText();
					produto = new File("Produtos/" + codigo + ".txt");
					if(!produto.exists()){
						JOptionPane.showMessageDialog(null, "Código de produto inexistente!", "Erro", JOptionPane.ERROR_MESSAGE);
					}else{
						txtCod.setEditable(false);
						txtQtde.setEditable(true);
						btnValidar.setEnabled(false);
						btnAdd.setEnabled(true);
						
						try {
							informarProduto(codigo);
							lblTotal.setText("" + precoTotal);
							paine.repaint();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(txtQtde.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "É necessario que informe a quantidade!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
				}else{
					qtdeDig = Integer.parseInt(txtQtde.getText());
					txtQtde.setText("");
					qtdeEs = Integer.parseInt(dados2[3]);
					if(qtdeDig > qtdeEs){
						JOptionPane.showMessageDialog(null, "Valor fornecido é superior a quantidade do produto no estoque!","Mensagem",JOptionPane.PLAIN_MESSAGE);
					}else{
						preencherTabela();
						lblTotal.setText("R$" + df.format(precoTotal));
						paine.repaint();
						if(!btnFinalizar.isEnabled())
							btnFinalizar.setEnabled(true);
						txtQtde.setText("");
						txtQtde.setEditable(false);
						btnValidar.setEnabled(true);
						btnAdd.setEnabled(false);
						txtCod.setText("");
						txtCod.setEditable(true);
						
					}
				}
			}
		});
		
		btnFinalizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gravarArquivo(email);
				JOptionPane.showMessageDialog(null, "Venda efetuada! Preço Final: " + lblTotal.getText(),"Sucesso",JOptionPane.PLAIN_MESSAGE);
				dispose();
			}
		});

				
		setSize(800, 340);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
	}
		
	public void informarProduto(String codigo) throws IOException{
		arquivo = new File("Produtos/" + codigo + ".txt");
		buffR = new BufferedReader(new FileReader(arquivo));
		
		dados2[0] = arquivo.getName().replace(".txt","");
		dados2[1] = buffR.readLine();		
		txtArea.setText("Nome: " + dados2[1]);
		
		dados2[2] = buffR.readLine();	linha = dados2[2];
		dados2[3] = buffR.readLine();
		dados2[4] = buffR.readLine();
		dados2[5] = buffR.readLine();
		dados2[5] = buffR.readLine();
		
		txtArea.setText("Nome: " + dados2[1]);
		txtArea.setText(txtArea.getText() + "\nPreço: R$" + linha);
		txtArea.setText(txtArea.getText() + "\nQuantidade: " + dados2[3]);
		txtArea.setText(txtArea.getText() + "\nCategoria: " + dados2[4]);
		txtArea.setText(txtArea.getText() + "\nDescrição: " + dados2[5]);
		
		codigos[indiceCod] = dados2[0];
		indiceCod++;
		
		
		buffR.close();
	}
	
	public void preencherTabela(){
		dados[indiceTabela][0] = dados2[0];
		dados[indiceTabela][1] = dados2[1];
		dados[indiceTabela][2] = dados2[2];
		precoProd = Double.parseDouble(dados2[2]);
		precoTotProd = qtdeDig * precoProd;
		dados[indiceTabela][3] = qtdeDig;
		dados[indiceTabela][4] = df.format(precoTotProd);
		precos[indiceTabela] = precoTotProd;
		precoTotal += precoTotProd;
		
		indiceTabela++;
		
		jtTabela = new JTable(dados,titulo);
	}
	
	public void gravarArquivo(String email) {
		horas = date.getHours();
		minutos = date.getMinutes();
		segundos = date.getSeconds();
		
		dia = date.getDate();
		mes = date.getMonth();
		ano = date.getYear();
		
		String data = dia + "/" + mes + "/" + ano;
		String horario = horas + ":" + minutos + ":" + segundos;
		String valTot = lblTotal.getText().replace("R$","").replace(",", ".");
		System.out.println(email + "\n" + data + "\n" + horario + "\n" + valTot);
		
		count = 0;
				
		do{
			arquivo = new File("Vendas/" + count + ".txt");
			count++;
		}while(arquivo.exists());
		
		try( FileWriter fw = new FileWriter(arquivo, true) ){
		
		fw.write("" + email);
		fw.write("\r\n");
		fw.write("" + data);
		fw.write("\r\n");
		fw.write("" + horario);
		fw.write("\r\n");
		fw.write("" + valTot);
		}catch(IOException ex){
			  ex.printStackTrace();
		}
		
	}

}


