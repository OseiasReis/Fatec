package produtos;

import javax.swing.JFrame;
import javax.swing.JTextField;

import metodos.Alteracao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reestoque extends JFrame{
	
	private JLabel lblTitulo, lblCod, lblQtdeAdd,lblQtdeAdd_2;
	private JLabel lblDiv, lblNProd, lblQtdeProd,lblNProd_2,lblQtdeProd_2,lblQtdeProdAdd, lblTotal, lblTotalQtde;
	private JTextField txtCod, txtQtdeAdd;
	private JButton btnCheck, btnAdicionar, btnApagar;
	private JRadioButton[] operacao = new JRadioButton[2];
	private ButtonGroup btnGrupo1 = new ButtonGroup();
	private JLabel lblLogo;
		
	ImageIcon icone = new ImageIcon("Imagens/estoque.png");
	
	File arquivo1, adicional;
	FileReader reader;
	BufferedReader buffer;
	
	String codigo, qtdeAt, nomeProd = "N/A", reserva;
	int valQtde = 0;
	int qtdeDig;
	boolean validacao = false, isSoma = true;
	
	public Reestoque(){
		super("-> REESTOQUE DE PRODUTOS");
		
		lblTitulo = new JLabel("REESTOCAR PRODUTOS"); lblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
		lblCod = new JLabel("Código do produto: ");
		lblQtdeAdd = new JLabel("Quantidade a ser ");
		lblQtdeAdd_2 = new JLabel("modificada do estoque: ");
		lblDiv = new JLabel();	lblDiv.setOpaque(true);	lblDiv.setBackground(Color.GRAY);
		lblNProd = new JLabel("Nome do Produto: " );
		lblNProd_2 = new JLabel(nomeProd);
		lblQtdeProd = new JLabel("Quantidade em estoque: ");
		lblQtdeProd_2 = new JLabel("" + valQtde);
		lblQtdeProdAdd = new JLabel("(0)");	lblQtdeProdAdd.setOpaque(true);	lblQtdeProdAdd.setForeground(Color.gray);
		lblTotal = new JLabel("TOTAL: ");	
		lblTotalQtde = new JLabel();
		
		txtCod = new JTextField();
		txtQtdeAdd = new JTextField();
		
		operacao[0] = new JRadioButton("+");	operacao[0].setForeground(Color.green);
		operacao[1] = new JRadioButton("-");	operacao[1].setForeground(Color.red);
		btnGrupo1.add(operacao[0]);
		btnGrupo1.add(operacao[1]);
		
		btnCheck = new JButton("Ir!");	btnCheck.setMnemonic(KeyEvent.VK_I);
		btnAdicionar = new JButton("Alterar");	btnAdicionar.setMnemonic(KeyEvent.VK_A);
		btnApagar = new JButton("Limpar");			btnApagar.setMnemonic(KeyEvent.VK_L);
		
		lblLogo = new JLabel();				lblLogo.setIcon(new javax.swing.ImageIcon("Imagens/reestoque.png")); 
		
		Container paine = getContentPane();
		paine.setLayout(null);
		
		setIconImage(icone.getImage());
		
		paine.add(lblLogo);
		lblLogo.setBounds(400, -20, 210, 140);
		
		paine.add(lblTitulo);
		lblTitulo.setBounds(20, 10, 400, 50);
		lblTitulo.setFont(new Font("Colonna MT", Font.BOLD, 32));
		Color azul = new Color(1, 190, 254);
		lblTitulo.setForeground(azul);
		
		paine.add(lblDiv);
		lblDiv.setBounds(260, 70, 2, 190);
		paine.add(lblNProd);
		lblNProd.setBounds(280, 90, 300, 20);
		paine.add(lblNProd_2);
		lblNProd_2.setBounds(280, 110, 300, 20);
		paine.add(lblQtdeProd);
		lblQtdeProd.setBounds(280, 150, 300, 20);
		paine.add(lblQtdeProd_2);
		lblQtdeProd_2.setBounds(280, 170, 100, 20);
		paine.add(lblQtdeProdAdd);
		lblQtdeProdAdd.setBounds(380, 170, 100, 20);
		paine.add(lblTotal);
		lblTotal.setBounds(280, 210, 70, 20);
		paine.add(lblTotalQtde);
		lblTotalQtde.setBounds(340, 210, 140, 20);
		
		paine.add(lblCod);
		lblCod.setBounds(20, 80, 200, 20);
		paine.add(txtCod);
		txtCod.setBounds(20, 100, 150, 20);
				
		paine.add(lblQtdeAdd);
		lblQtdeAdd.setBounds(20, 145, 150, 20);
		paine.add(lblQtdeAdd_2);
		lblQtdeAdd_2.setBounds(20, 160, 200, 20);
		paine.add(txtQtdeAdd);
		txtQtdeAdd.setEditable(false);
		txtQtdeAdd.setBounds(20, 180, 100, 20);
		paine.add(operacao[0]);
		operacao[0].setBounds(140, 180, 40, 20);
		operacao[0].setSelected(true);
		paine.add(operacao[1]);
		operacao[1].setBounds(200, 180, 50, 20);
		
		paine.add(btnCheck);
		btnCheck.setBounds(180, 100, 50, 20);
		btnCheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				codigo = txtCod.getText();
				arquivo1 = new File("Produtos/" + codigo + ".txt");
				
				if(arquivo1.exists()){
					try {
						reader = new FileReader(arquivo1);
						buffer = new BufferedReader(reader);
						
						nomeProd = buffer.readLine();
						qtdeAt = buffer.readLine();
						qtdeAt = buffer.readLine();
						
						valQtde = Integer.parseInt(qtdeAt);
						
						buffer.close();
						reader.close();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					lblNProd_2.setText(nomeProd);
					lblQtdeProd_2.setText("" + valQtde);
					
					lblTotalQtde.setText(""+valQtde);
					
					txtQtdeAdd.setEditable(true);
					txtCod.setEditable(false);
					validacao = true;
				}else{
					JOptionPane.showMessageDialog(null, "Produto inexistente!","Erro",JOptionPane.ERROR_MESSAGE);
					txtCod.setText("");
				}
				
			}
		});
		
		paine.add(btnAdicionar);
		btnAdicionar.setBounds(20, 230, 100, 30);
		btnAdicionar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(validacao == false){
					JOptionPane.showMessageDialog(null,"Digite e valide o código do produto!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
				}else{
					if(txtQtdeAdd.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Digite um numero válido para reestoque!", "Erro", JOptionPane.ERROR_MESSAGE);
					}else{
						if(operacao[0].isSelected()){
							isSoma = true;
						}else{
							isSoma = false;
						}
						qtdeDig = Integer.parseInt(txtQtdeAdd.getText());
						if(isSoma == false &&  qtdeDig > valQtde){
							JOptionPane.showMessageDialog(null, "Impossível retirar uma quantidade superior ao que se encontra no estoque!");
							txtQtdeAdd.setText("");
						}else{
							lblQtdeProd_2.setText("" + lblTotalQtde.getText());
							Alteracao objAlt = new Alteracao();
							objAlt.adicionarProduto(codigo, qtdeDig, isSoma);
							if(operacao[0].isSelected()){
								lblQtdeProdAdd.setText("(" + operacao[0].getText() + qtdeDig + ")");
								lblQtdeProdAdd.setForeground(Color.green);
								lblTotalQtde.setText("" + (qtdeDig + valQtde));
							}else{
								lblQtdeProdAdd.setText("(" + operacao[1].getText() + qtdeDig + ")");
								lblQtdeProdAdd.setForeground(Color.red);
								lblTotalQtde.setText("" + (valQtde - qtdeDig));
							}							
							JOptionPane.showMessageDialog(null, "Reestocado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
							txtQtdeAdd.setText("");
							try {
								reader = new FileReader(arquivo1);
								buffer = new BufferedReader(reader);
								
								nomeProd = buffer.readLine();
								qtdeAt = buffer.readLine();
								qtdeAt = buffer.readLine();
								
								valQtde = Integer.parseInt(qtdeAt);
								
								buffer.close();
								reader.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							
						}
					}
				}
			}
		});
		
		paine.add(btnApagar);
		btnApagar.setBounds(140, 230, 100, 30);
		btnApagar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtCod.setText("");
				if(!txtCod.isEditable())
					txtCod.setEditable(true);
				txtQtdeAdd.setText("");
				if(txtQtdeAdd.isEditable())
					txtQtdeAdd.setEditable(false);
				valQtde = 0;
				nomeProd = "N/A";
				lblNProd_2.setText(nomeProd);
				lblQtdeProd_2.setText("" + valQtde);
				validacao = false;
				lblQtdeProdAdd.setText("(0)");	lblQtdeProdAdd.setForeground(Color.gray);
				lblTotalQtde.setText("");
			}
		});
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
		setResizable(false);
	}
}
