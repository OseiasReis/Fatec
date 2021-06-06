package Boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import Control.Controller;
import Entidade.Animal;

public class Main implements ActionListener {
	private JFrame janela;

	private JTextField txtNome = new JTextField(30);
	private JTextField txtId = new JTextField(10);
	private JTextField txtNascimento = new JTextField(10);
	private JTextField txtPeso = new JTextField(30);

	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private Controller control = new Controller();

	private JTable table = new JTable(control);

	public Main () {
		janela = new JFrame("Registro de Alunos");
		JPanel panCampos = new JPanel(new GridLayout(5, 2));
		JPanel panPrincipal = new JPanel(new BorderLayout());
		JScrollPane panTable = new JScrollPane();

		panCampos.add(new JLabel("Id:"));
		panCampos.add(txtId);
		panCampos.add(new JLabel("Nome do Animal:"));
		panCampos.add(txtNome);
		panCampos.add(new JLabel("Data de Nascimento:"));
		panCampos.add(txtNascimento);
		panCampos.add(new JLabel("Peso:"));
		panCampos.add(txtPeso);

		panCampos.add(btnAdicionar);
		btnAdicionar.addActionListener(this);
		panCampos.add(btnPesquisar);
		btnPesquisar.addActionListener(this);

		panTable.getViewport().add(table);
		panPrincipal.add(panCampos, BorderLayout.NORTH);
		panPrincipal.add(panTable, BorderLayout.CENTER);
		janela.setContentPane(panPrincipal);

		janela.setSize(600, 300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Main();
	}
	public void actionPerformed(java.awt.event.ActionEvent e) {
		String cmd = e.getActionCommand();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if ("Adicionar".equals(cmd)) {
			Animal a = new Animal();
			a.setId(Integer.parseInt(txtId.getText()));
			a.setNome(txtNome.getText());
			try {
				Date d = sdf.parse(txtNascimento.getText());
				a.setNascimento(d);
			} catch (ParseException | java.text.ParseException e1) {
				e1.printStackTrace();
			}
			a.setPeso(Float.parseFloat(txtPeso.getText()));
			try {
				control.adicionar(a);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			table.invalidate();
			table.revalidate();
			table.repaint();
		} else {
			Animal a = new Animal ();
			try {
				a = control.pesquisarPorNome(txtNome.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (a != null) {
				txtId.setText(String.valueOf(a.getId()));
				txtNome.setText(a.getNome());
				txtPeso.setText(String.valueOf(a.getPeso()));
			}
			table.invalidate();
			table.revalidate();
			table.repaint();
		}
	}
}

