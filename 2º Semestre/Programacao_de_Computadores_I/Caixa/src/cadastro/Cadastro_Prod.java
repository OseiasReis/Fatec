package cadastro;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.MaskFormatter;

public class Cadastro_Prod extends JFrame{

	/*static{
		JOptionPane.showMessageDialog(null, "Seja Bem vindo!", "Boas VIndas", JOptionPane.PLAIN_MESSAGE);
	}*/
	
	private JLabel lblTitulo = new JLabel("Cadastro de Produto");
	private JLabel lblCodigo = new JLabel("Código:");
	private JLabel lblNome = new JLabel("*Nome:");
	private JLabel lblPreco = new JLabel("*Preço: (R$)");
	private JLabel lblQuantidade = new JLabel("*Quantidade:");
	private JLabel lblCategoria = new JLabel("Categoria:");
	private JLabel lblEstado = new JLabel("Estado:");
	private JLabel lblDescricao = new JLabel("Descrição:");
	private JLabel lblVirgula = new JLabel(",");
	
	private JLabel lblSit = new JLabel("Validar");
	
	private JTextField txtCodigo = new JTextField();
	private JTextField txtNome = new JTextField();
	private JTextField txtPreco = new JTextField();
	private JTextField txtCentavo;
	private JTextField txtQuantidade = new JTextField();
	private JComboBox  cboCategoria = new JComboBox();
	private JComboBox  cboCategoria2 = new JComboBox();
	private JTextArea txtDescricao = new JTextArea(1,1);
	
	private JButton btnValidar = new JButton ("Validar/Gerar");
	private JButton btnCadastrar = new JButton ("Cadastrar");
	private JButton btnApagar = new JButton ("Apagar");
	
   private JScrollPane scroll = new JScrollPane(txtDescricao, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	int validar;
	
	public Cadastro_Prod(){
		super (".:Cadastrar Produto:.");
		
		lblTitulo.setFont(new Font("Colonna MT", Font.BOLD, 30));
		Color azul = new Color(1, 190, 254);
		lblTitulo.setForeground(azul);
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 16));
		lblNome.setFont(new Font("Arial", Font.BOLD, 16));
		lblPreco.setFont(new Font("Arial", Font.BOLD, 16));
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 16));
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 16));
		lblEstado.setFont(new Font("Arial", Font.BOLD, 16));
		lblDescricao.setFont(new Font("Arial", Font.BOLD, 16));
		lblVirgula.setFont(new Font("Arial", Font.BOLD, 16));
		
		btnValidar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnApagar.setFont(new Font("Arial", Font.BOLD, 14));
		
		Container pane = this.getContentPane();
		pane.setLayout(null);

		pane.add(lblTitulo);
		lblTitulo.setBounds(20, 20, 325, 20);
		
		pane.add(lblCodigo);
		lblCodigo.setBounds(20, 60, 100, 20);
		
		txtCodigo.setToolTipText("Deixe o campo em branco para gerar o código automaticamente!");
		pane.add(txtCodigo);
		txtCodigo.setBounds(20, 80, 100, 20);
		txtCodigo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
			// código do evento:
			String caracteres="0987654321";
			       if(!caracteres.contains(ev.getKeyChar()+"")){
			              ev.consume();
			       }
			}
		});
		
		pane.add(btnValidar);
		btnValidar.setBounds(130, 80, 150, 20);
		btnValidar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				File arquivo;
				if(txtCodigo.getText().equals(""))
				{
					boolean laco = false;
					validar = (int) (1 + Math.random() * 1000);
					do{
						arquivo = new File("Produtos/" + validar + ".txt");
						if(arquivo.exists()){
							validar = (int) (1 + Math.random() * 1000);
							laco = true;
						}
					}while(laco == true);
					txtCodigo.setText("" + validar);
					txtCodigo.disable();
					btnValidar.setEnabled(false);
				}else{
					validar = Integer.parseInt(txtCodigo.getText());
					arquivo = new File("Produtos/" + validar + ".txt");
					if(arquivo.exists())
						JOptionPane.showMessageDialog(null,"Já existe um produto com o mesmo código!","Erro",JOptionPane.ERROR_MESSAGE);
					else
					{
						txtCodigo.setText("" + validar);
						txtCodigo.disable();
						btnValidar.setEnabled(false);
						JOptionPane.showMessageDialog(null,"Validado com sucesso","Mensagem",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		pane.add(lblNome);
		lblNome.setBounds(20, 120, 100, 20);
		pane.add(txtNome);
		txtNome.setBounds(20, 140, 300, 20);
		
		pane.add(lblPreco);
		lblPreco.setBounds(20, 180, 150, 20);
		pane.add(txtPreco);
		txtPreco.setBounds(20, 200, 100, 20);
		txtPreco.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
			// código do evento:
			String caracteres="0987654321";
			       if(!caracteres.contains(ev.getKeyChar()+"")){
			              ev.consume();
			       }
			}
		});
		
		pane.add(lblVirgula);
		lblVirgula.setBounds(125, 200, 150, 20);
		
		try{
			txtCentavo = new JFormattedTextField(new MaskFormatter("##"));
			txtCentavo.setText("00");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pane.add(txtCentavo);
		txtCentavo.setBounds(135, 200, 40, 20);
		txtCentavo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
			// código do evento:
			String caracteres="0987654321";
			       if(!caracteres.contains(ev.getKeyChar()+"")){
			              ev.consume();
			       }
			}
		});
		
		pane.add(lblQuantidade);
		lblQuantidade.setBounds(20, 300, 150, 20);
		pane.add(txtQuantidade);
		txtQuantidade.setBounds(20, 320, 150, 20);
		txtQuantidade.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
			// código do evento:
			String caracteres="0987654321";
			       if(!caracteres.contains(ev.getKeyChar()+"")){
			              ev.consume();
			       }
			}
		});
		
		pane.add(lblCategoria);
		lblCategoria.setBounds(20, 240, 200, 20);
		
		cboCategoria.addItem("Bebidas"); cboCategoria.addItem("Bolos"); cboCategoria.addItem("Café da Manhã");
		cboCategoria.addItem("Carnes"); cboCategoria.addItem("Ceia"); cboCategoria.addItem("Doces e Sobremesas");
		cboCategoria.addItem("Grãos/Cereais"); cboCategoria.addItem("Lanches"); cboCategoria.addItem("Light");
		cboCategoria.addItem("Massas"); cboCategoria.addItem("Molhos"); cboCategoria.addItem("Peixes");
		cboCategoria.addItem("Sopas");
		
		pane.add(cboCategoria);
		cboCategoria.setBounds(20, 260, 120, 20);
		
		cboCategoria2.addItem("-Nenhum-"); cboCategoria2.addItem("Bebidas"); cboCategoria2.addItem("Bolos"); 
		cboCategoria2.addItem("Café da Manhã");	cboCategoria2.addItem("Carnes"); cboCategoria2.addItem("Ceia"); 
		cboCategoria2.addItem("Doces e Sobremesas"); cboCategoria2.addItem("Grãos/Cereais"); cboCategoria2.addItem("Lanches"); 
		cboCategoria2.addItem("Light"); cboCategoria2.addItem("Massas"); cboCategoria2.addItem("Molhos"); 
		cboCategoria2.addItem("Peixes");cboCategoria2.addItem("Sopas");
		
		pane.add(cboCategoria2);
		cboCategoria2.setBounds(180, 260, 150, 20);
		
		pane.add(lblDescricao);
		lblDescricao.setBounds(20, 360, 290, 20);
		pane.add(scroll);
		scroll.setBounds(20, 380, 250 ,60);
		txtDescricao.setLineWrap(true);

		
		pane.add(btnCadastrar);
		btnCadastrar.setBounds(40, 450, 120, 40);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (txtCodigo.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo Código deve ser preenchido e validado"); 
				}else{
				
				if (txtNome.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo Nome deve ser preenchido"); 
				}else{
				
				if (txtPreco.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo Preço deve ser preenchido"); 
				}else {
				
				if (txtQuantidade.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo Quantidade deve ser preenchido"); 
				}else{
										
					String codigo = txtCodigo.getText();
					String nome = txtNome.getText();
					String preco = txtPreco.getText();
					String centavo = txtCentavo.getText();
					String quantidade = txtQuantidade.getText();
					String descricao = txtDescricao.getText();
					String categoria = (String) cboCategoria.getSelectedItem();
					String categoria2 = (String) cboCategoria2.getSelectedItem();
					
					File arquivo = new File("Produtos/" + codigo + ".txt");
					try( FileWriter fw = new FileWriter(arquivo, true) ){
					    fw.write(nome);
					    fw.write("\r\n");
					    fw.write(preco + "." + centavo);
					    fw.write("\r\n");
					    fw.write(quantidade);
					    fw.write("\r\n");
					    fw.write(categoria);
					    fw.write("\r\n");
					    fw.write(categoria2);
					    fw.write("\r\n");
					    fw.write(descricao);
					    fw.write("\r\n");
					    fw.flush();
					}catch(IOException ex){
					  ex.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Obrigado, o produto " + txtNome.getText() + ", foi cadastrado!\nCódigo: " + txtCodigo.getText());
					dispose();
							}
						}
					}
				}
			}
		});
		
		pane.add(btnApagar);
		btnApagar.setBounds(182, 450, 90, 40);
		btnApagar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int Apagar;
			
			Apagar = JOptionPane.showConfirmDialog(null, "Você deseja realmente apagar?","Confirmar",JOptionPane.YES_NO_OPTION);
			
			if(Apagar == 0){
				txtCodigo.setText("");
				txtCodigo.enable();
				btnValidar.setEnabled(true);
				txtNome.setText("");
				txtPreco.setText("");
				txtQuantidade.setText("");
				txtDescricao.setText("");
				txtCentavo.setText("");
			}
		}
	});
		
		this.setSize(350, 550);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}