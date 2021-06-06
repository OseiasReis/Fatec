package view;

import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Interface_Sobre extends JFrame {

	private JLabel lblLogo;
	private JLabel lblDescricao;
	private ImageIcon icone;
	
	public Interface_Sobre() {
		super("..::   I.Library - Sobre   ::..");
		
		icone = new ImageIcon("images/logotitulo.png");
		setIconImage(icone.getImage());
		
		lblLogo = new JLabel(new ImageIcon("images/image_media.png"));
		
		setSize(435, 450);
		Container pane = getContentPane();
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		pane.add(lblLogo);
		lblLogo.setBounds(38, 50, 355, 116);
		
		lblDescricao = new JLabel("<html> <p align='center'>Sistema para gerenciamento de bibliotecas.<br/><br/><br/>Desenvolvido por:<br/>Lucas Bezerra<br/>Lucas Henrique<br/>Oseias Reis<br/>Rodrigo Santos<br/>Wellington Cruz Tavares </p></html>");
		lblDescricao.setBounds(50, 180, 320, 164);
		getContentPane().add(lblDescricao);
	}
}
