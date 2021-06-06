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
import Entidade.Curso;
import javafx.event.ActionEvent;

public class Main implements ActionListener {
	private JFrame janela;

	private JTextField txtNome = new JTextField(30);
	private JTextField txtId = new JTextField(10);
	private JTextField txtDescricao = new JTextField(10);
	private JTextField txtAtivo = new JTextField(30);
	private JTextField txtHrInicio = new JTextField(30);
	private JTextField txtHrFim = new JTextField(30);

	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private Controller control = new Controller();

	private JTable table = new JTable(control);

	public Main() {
		janela = new JFrame("Registro de Alunos");
		JPanel panCampos = new JPanel(new GridLayout(7, 2));
		JPanel panPrincipal = new JPanel(new BorderLayout());
		JScrollPane panTable = new JScrollPane();

		panCampos.add(new JLabel("Id"));
		panCampos.add(txtId);
		panCampos.add(new JLabel("Nome"));
		panCampos.add(txtNome);
		panCampos.add(new JLabel("Descricao"));
		panCampos.add(txtDescricao);
		panCampos.add(new JLabel("Ativo "));
		panCampos.add(txtAtivo);
		panCampos.add(new JLabel("Hora Inicio"));
		panCampos.add(txtHrInicio);
		panCampos.add(new JLabel("Hora Termino"));
		panCampos.add(txtHrFim);

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

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		String cmd = e.getActionCommand();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if ("Adicionar".equals(cmd)) {
			Curso a = new Curso();
			a.setId(Integer.parseInt(txtId.getText()));
			a.setNome(txtNome.getText());
			a.setAtivo(Boolean.getBoolean(txtAtivo.getText()));
			try {
				Date d = sdf.parse(txtHrInicio.getText());
				a.setHoraInicio(d);
				Date d1 = sdf.parse(txtHrFim.getText());
				a.setHoraInicio(d1);
			} catch (ParseException | java.text.ParseException e1) {
				e1.printStackTrace();
			}
			a.setDescricao(txtDescricao.getText());
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
			Curso a = new Curso ();
			try {
				a = control.pesquisarPorNome(txtNome.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (a != null) {
				txtId.setText(String.valueOf(a.getId()));
				txtNome.setText(a.getNome());
			}
			table.invalidate();
			table.revalidate();
			table.repaint();
		}
	}
}
