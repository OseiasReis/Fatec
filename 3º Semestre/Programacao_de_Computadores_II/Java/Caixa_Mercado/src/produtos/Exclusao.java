package produtos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class Exclusao extends JFrame {
	
	private JLabel lblTitulo, lblCod, lblLogo, lblLogo2;
	private JTextField txtCod = new JTextField();
	private JButton btnExcluir;
	
	File arquivo;
	String nomeProd;
	int confirm;
	
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	
	public Exclusao(){
		super(".:Exclusão:.");
		
		lblTitulo = new JLabel("Excluir Produtos");		lblTitulo.setFont(new Font("Arial",Font.BOLD,20));
		
		lblCod = new JLabel("Digite o código do produto: ");
		
		btnExcluir = new JButton("Excluir");		btnExcluir.setBackground(Color.BLACK); 	btnExcluir.setForeground(Color.WHITE);
		
		lblLogo = new JLabel();
		lblLogo2 = new JLabel();
		
		lblLogo.setIcon(new ImageIcon("Imagens/lixeira.png"));
		
		Color azulc = new Color(174, 235, 255);
		
		Container paine = getContentPane();
		paine.setLayout(null);	paine.setBackground(azulc);
		
		paine.add(lblLogo);
		lblLogo.setBounds(225, 0, 50, 50);
		
		paine.add(lblLogo2);
		lblLogo2.setBounds(225, 0, 50, 50);
		
		paine.add(lblTitulo);
		lblTitulo.setBounds(50, 0, 200, 40);
		
		paine.add(lblCod);
		lblCod.setBounds(10, 50, 200, 20);
		
		paine.add(txtCod);
		txtCod.setBounds(210, 50, 70, 20);
		
		paine.add(btnExcluir);
		btnExcluir.setBounds(100, 90, 80, 40);
		btnExcluir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				arquivo = new File("Produtos/" + txtCod.getText() + ".txt");
				if(!arquivo.exists()){
					JOptionPane.showMessageDialog(null, "Produto não encontrado!","Erro",JOptionPane.ERROR_MESSAGE);
				}else{		
					try {
						BufferedReader buffw = new BufferedReader(new FileReader(arquivo));
						nomeProd = buffw.readLine();
						buffw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}					
					int Apagar = JOptionPane.showConfirmDialog(null, "Você deseja realmente remover " + nomeProd + " permanentemente do estoque?","Confirmação",JOptionPane.YES_NO_OPTION);
					if(Apagar == 0){
						arquivo.delete();
						JOptionPane.showMessageDialog(null,"Produto " + nomeProd + " retirado do estoque!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
						txtCod.setText("");
						lblLogo.setVisible(false);
						lblLogo2.setIcon(new ImageIcon("Imagens/lixeira-cheia.png"));
					}					
				}
			}
		});
		
		
		setResizable(false);
		setSize(300, 170);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocation((tela.width-this.getSize().width)-10,   
                (0));  
	}
}
