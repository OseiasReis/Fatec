package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Metodos;

public class Tela extends JFrame
{
	public JLabel lblAbrir, lblDesc;
	public JTextField txtPesq;
	public JButton btnOk, btnCancel, btnProc;
	public ImageIcon icone;
	public JLabel lblInf;
	int i = 10;

	Metodos mt = new Metodos();

	public Tela(){
		super(".: Executar :.");

		lblAbrir = new JLabel("Abrir");
		lblDesc = new JLabel("Digite o caminho do executável ou clique em procurar");
		txtPesq = new JTextField();
		btnOk = new JButton("Ok");
		btnCancel = new JButton("Cancel");
		btnProc = new JButton("Procurar");
		lblInf = new JLabel(new ImageIcon("src/images/javaimg2.png"));

		Container tela = getContentPane();
		setSize(420, 215);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		icone = new ImageIcon("src/images/ti.png");
		setIconImage(icone.getImage());

		tela.add(lblAbrir);
		lblAbrir.setFont(new Font("Arial", 1, 14));
		lblAbrir.setBounds(15, 80, 60, 20);

		tela.add(lblDesc);
		lblDesc.setFont(new Font("Arial", 1, 12));
		lblDesc.setBounds(80, 30, 320, 20);

		tela.add(txtPesq);
		txtPesq.setFont(new Font("Arial", 1, 12));
		txtPesq.setBounds(70, 80, 320, 20);
		
		tela.add(btnOk);
		btnOk.setBounds(70, 125, 85, 20);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mt.Executar(txtPesq, Tela.this);
			}
		});
		tela.add(btnCancel);
		btnCancel.setBounds(188, 125, 85, 20);
		//btnParar.setEnabled(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mt.Cancelar(Tela.this);
			}
		});
		
		tela.add(btnProc);
		btnProc.setBounds(305, 125, 85, 20);
		//btnParar.setEnabled(false);
		btnProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mt.Procurar(txtPesq);
			}
		});
		
		tela.add(lblInf);
		lblInf.setBounds(10, 10, 50, 65);
		lblInf.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent a) {
				JOptionPane.showMessageDialog(null, "Oséias P. Reis © 2019", "Aviso", 1);
			}
			public void mouseEntered(MouseEvent arg0) {}

			public void mouseExited(MouseEvent arg0) {}

			public void mousePressed(MouseEvent arg0) {}

			public void mouseReleased(MouseEvent arg0) {}
		});
	}

	public static void main(String[] args) { 
		Tela t = new Tela(); 
	}
}