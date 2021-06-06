package Cadastro;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Cadastro_Prod extends JFrame{

	private JLabel lblTitulo = new JLabel("Cadastro de Produto");
	private JLabel lblNome = new JLabel("Nome do Produto:");
	private JLabel lblPreco = new JLabel("Preço: (sem R$)");
	private JLabel lblQuantidade = new JLabel("Quantidade:");
	private JLabel lblCategoria = new JLabel("Categoria:");
	private JLabel lblEstado = new JLabel ("Estado do Produto:");
	
	private JTextField txtNome = new JTextField();
	private JTextField txtPreco = new JTextField();
	private JTextField txtQuantidade = new JTextField();
	private JComboBox  cboCategoria = new JComboBox();
	
	private JRadioButton[] rbEstado = new JRadioButton[2];
	private ButtonGroup group = new ButtonGroup();
	
	private JButton btnVoltar = new JButton ("Voltar");
	private JButton btnCadastrar = new JButton ("Cadastrar");
	private JButton btnApagar = new JButton ("Apagar");
	
	public Cadastro_Prod(){
		super (".:Cadastrar Produto:.");
		
		lblTitulo.setFont(new Font("ALGERIAN", Font.BOLD, 26));
		lblTitulo.setForeground(Color.red);
		lblNome.setFont(new Font("Arial", Font.BOLD, 16));
		lblPreco.setFont(new Font("Arial", Font.BOLD, 16));
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 16));
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 16));
		lblEstado.setFont(new Font("Arial", Font.BOLD, 16));
		
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnApagar.setFont(new Font("Arial", Font.BOLD, 14));
		
		rbEstado[0] = new JRadioButton("Novo");
		rbEstado[1] = new JRadioButton("Usado");
		
		group.add(rbEstado[0]);
		group.add(rbEstado[1]);
		
		Container pane = this.getContentPane();
		pane.setLayout(null);
		
		pane.add(lblTitulo);
		lblTitulo.setBounds(20, 20, 325, 20);
		
		pane.add(lblNome);
		lblNome.setBounds(20, 60, 150, 20);
		pane.add(txtNome);
		txtNome.setBounds(20, 80, 300, 20);
		
		pane.add(lblPreco);
		lblPreco.setBounds(20, 120, 150, 20);
		pane.add(txtPreco);
		txtPreco.setBounds(20, 140, 300, 20);
		
		pane.add(lblQuantidade);
		lblQuantidade.setBounds(20, 180, 100, 20);
		pane.add(txtQuantidade);
		txtQuantidade.setBounds(20, 200, 300, 20);
		
		pane.add(lblCategoria);
		lblCategoria.setBounds(20, 240, 80, 20);
		
		cboCategoria.addItem("Agronegócios");
		cboCategoria.addItem("Alimentos e Bebidas");
		cboCategoria.addItem("Automoção");
		cboCategoria.addItem("Bebês e Crianças");
		cboCategoria.addItem("Beleza e Estética");
		cboCategoria.addItem("Brindes");
		cboCategoria.addItem("Brinquedos e Games");
		cboCategoria.addItem("Cama Mesa e Banho");
		cboCategoria.addItem("Carros Motos e Autopeças");
		cboCategoria.addItem("Celulares e Telefones");
		cboCategoria.addItem("Componentes Eletrônicos");
		cboCategoria.addItem("Comunicação e Marketing");
		cboCategoria.addItem("Construção e Reforma");
		cboCategoria.addItem("Corretoras de Seguros");
		cboCategoria.addItem("Eletrodomésticos");
		cboCategoria.addItem("Eletrônicos TV Som e DVD");
		cboCategoria.addItem("Embalagens");
		cboCategoria.addItem("Escolas e Cursos");
		cboCategoria.addItem("Esporte e Lazer");
		cboCategoria.addItem("Ferramentas e Máquinas");
		cboCategoria.addItem("Foto Câmera e Filmadora");
		cboCategoria.addItem("Gráficas e Editoras");
		cboCategoria.addItem("Imóveis");
		cboCategoria.addItem("Indústria e Comércio");
		cboCategoria.addItem("Informática");
		cboCategoria.addItem("Internet e Sites");
		cboCategoria.addItem("Joias e Relógios");
		cboCategoria.addItem("Lojas e Variedades");
		cboCategoria.addItem("Materiais de Limpeza");
		cboCategoria.addItem("Moda e Acessórios");
		cboCategoria.addItem("Móveis e Decoração");
		cboCategoria.addItem("Papelarias e Livrarias");
		cboCategoria.addItem("Perfumes e Cosméticos");
		cboCategoria.addItem("Pet Shop");
		cboCategoria.addItem("Saúde e Odontologia");
		cboCategoria.addItem("Serviços Administrativos");
		cboCategoria.addItem("Serviços Diversos");
		cboCategoria.addItem("Transporte e Logística");
		cboCategoria.addItem("Turismo e Hotelaria");
		cboCategoria.addItem("Utensílios Domésticos");
		
		pane.add(cboCategoria);
		cboCategoria.setBounds(20, 260, 300, 20);
		
		pane.add(lblEstado);
		lblEstado.setBounds(20, 300, 150, 20);
		pane.add(rbEstado[0]);
		rbEstado[0].setBounds(20, 320, 80, 20);
		pane.add(rbEstado[1]);
		rbEstado[1].setBounds(120, 320, 80, 20);
		
		pane.add(btnCadastrar);
		btnCadastrar.setBounds(20, 360, 105, 20);
		
		pane.add(btnApagar);
		btnApagar.setBounds(132, 360, 90, 20);
		btnApagar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int Apagar;
			
			Apagar = JOptionPane.showConfirmDialog(null, "Você deseja realmente Apagar?");
			
			if(Apagar == 0){
				txtNome.setText("");
				txtPreco.setText("");
				txtQuantidade.setText("");
			}
		}
	});
		
		pane.add(btnVoltar);
		btnVoltar.setBounds(230, 360, 80, 20);
		btnVoltar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int Voltar;
				
				Voltar = JOptionPane.showConfirmDialog(null, "Você deseja realmente voltar?");
				
				if(Voltar == 0){
					System.exit(0);
				}
			}
		});
		
		this.setSize(350, 430);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main (String args[]){
		Cadastro_Prod cp = new Cadastro_Prod();
	}
}