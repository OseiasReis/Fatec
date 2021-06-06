package Cadastro;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class Menu extends JFrame{
	
	private JMenuItem miAbrir = new JMenuItem("Abrir");
	private JMenuItem miNovo = new JMenuItem("Novo");
	private JMenuItem miSalvar = new JMenuItem("Salvar");
	private JMenuItem miFechar = new JMenuItem("Sair");
	
	private JMenu mArquivo = new JMenu("Arquivo");
	private JMenu mEditar = new JMenu("Ajuda");
	private JMenuBar menuBar = new JMenuBar();
	
	public Menu(){
		super(".:Menus:.");
		
		mArquivo.add(miAbrir);
		mArquivo.add(miNovo);
		
		mArquivo.add(miSalvar);
		mArquivo.addSeparator();
		mArquivo.add(miFechar);
		miFechar.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				int sair;
				
				sair = JOptionPane.showConfirmDialog(null, "Você deseja realmente sair?","Confirmação",JOptionPane.YES_NO_OPTION);
				
				if (sair == 0){
					System.exit(0);
				}
			}
		});
		
		menuBar.add(mArquivo);
		menuBar.add(mEditar);
		
		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(310, 200);
		this.setVisible(true);
	}
	public static void main(String args[]){
		Menu me = new Menu();
	}
}
