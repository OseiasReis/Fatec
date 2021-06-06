package View;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import Model.Produto;
import javafx.event.ActionEvent;

public class Main implements ActionListener {
	
	private JTextField txtId = new JTextField(30);
	private JTextField txtPreco = new JTextField(30);
	private JTextField txtPeso = new JTextField(30);
	private JTextField txtNome = new JTextField(30);
	private JTextField txtTipo = new JTextField(30);
	private JTextField txtValidade = new JTextField(30);
	
	private JButton btnPesquisar;
	private JButton btnAdicionar;

	private List<Produto> lista = new ArrayList<>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Main() {
		JFrame janela = new JFrame("Loja Virtual");
		JPanel painel = new JPanel(new GridLayout(7, 2, 3, 10));

		btnAdicionar = new JButton("Adicionar");
		btnPesquisar = new JButton("Pesquisar");

		painel.add(new JLabel(" ID"));
		painel.add(txtId);
		painel.add(new JLabel("Preço "));
		painel.add(txtPreco);
		painel.add(new JLabel("Peso"));
		painel.add(txtPeso);
		painel.add(new JLabel("Nome "));
		painel.add(txtNome);
		painel.add(new JLabel("Tipo"));
		painel.add(txtTipo);
		painel.add(new JLabel("Validade"));
		painel.add(txtValidade);

		painel.add(btnAdicionar);
		painel.add(btnPesquisar);

		btnAdicionar.addActionListener(this);
		btnPesquisar.addActionListener(this);

		janela.setContentPane(painel);
		janela.setSize(600, 300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ProdutoToForm(new Produto());
	}


	public static void main(String[] args) {
		new Main();
	}
	
	private void ProdutoToForm(Produto f) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		txtId.setText(String.valueOf(f.getId()));
		txtPreco.setText(String.valueOf(f.getPreco()));
		txtPeso.setText(String.valueOf(f.getPeso()));
		txtNome.setText(f.getNome());
		String date = sdf.format(f.getValidade());
		txtValidade.setText(date);
		txtTipo.setText(f.getTipo());
	}

	private Produto formToProduto() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Produto func = new Produto();
		func.setId(Long.parseLong(txtId.getText()));
		func.setPreco(Float.parseFloat(txtPreco.getText()));
		func.setTipo(txtTipo.getText());
		func.setPeso(Float.parseFloat(txtPeso.getText()));
		func.setNome(txtNome.getText());
		try {
			Date d = sdf.parse(txtValidade.getText());
			func.setValidade(d);
		} catch (ParseException | java.text.ParseException e1) {
			e1.printStackTrace();
		}
		return func;
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Adicionar".equals(cmd)) {
			Produto func = formToProduto();
			lista.add(func);
			func = new Produto();
			ProdutoToForm(func);

			System.out.printf("Lista tem %d elementos\n", lista.size());
		} else if ("Pesquisar".equals(cmd)) {
			for (Produto f : lista) {
				if (f.getNome().contains(txtId.getText())) {
					ProdutoToForm(f);
				}
			}
		}
	}

	
}

