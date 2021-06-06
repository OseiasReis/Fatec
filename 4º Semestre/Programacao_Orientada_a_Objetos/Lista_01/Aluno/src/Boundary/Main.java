package Boundary;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.Controller;
import Entity.Aluno;

public class Main implements ActionListener {
	JFrame janela;
	JPanel painel;
	JTextField txtRa, txtNome, txtIdade, txtNascimento;
	JLabel ra, nome, idade, nascimento;
	JButton btnAdicionar, btnRemover, btnAtualizar, btnPesquisar;
	private Controller control = new Controller();

	public Main() {
		janela = new JFrame("Registrar Alunos");
		painel = new JPanel();
		txtRa = new JTextField(05);
		txtNome = new JTextField(100);
		txtIdade = new JTextField(10);
		txtNascimento = new JTextField(10);

		ra = new JLabel("RA");
		nome = new JLabel("Nome");
		idade = new JLabel("Idade");
		nascimento = new JLabel("Nascimento");

		btnAdicionar = new JButton("Adicionar");
		btnRemover = new JButton("Remover");
		btnAtualizar = new JButton("Atualizar");
		btnPesquisar = new JButton("Pesquisar");

		GridLayout grid = new GridLayout(6, 2);
		painel.setLayout(grid);

		painel.add(ra);
		painel.add(txtRa);

		painel.add(nome);
		painel.add(txtNome);

		painel.add(idade);
		painel.add(txtIdade);

		painel.add(nascimento);
		painel.add(txtNascimento);

		painel.add(btnAdicionar);
		painel.add(btnRemover);
		painel.add(btnAtualizar);
		painel.add(btnPesquisar);
		btnAdicionar.addActionListener(this);
		btnRemover.addActionListener(this);
		btnAtualizar.addActionListener(this);
		btnPesquisar.addActionListener(this);

		janela.getContentPane().add(painel);
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
		Aluno aluno = new Aluno();
		if ("Adicionar".equals(cmd)) {
			aluno.setRa(txtRa.getText());
			aluno.setNome(txtNome.getText());
			aluno.setIdade(Integer.parseInt(txtIdade.getText()));
			try {
				Date d = sdf.parse(txtNascimento.getText());
				aluno.setNascimento(d);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			try {
				control.adicionar(aluno);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}

		if ("Remover".equals(cmd)) {
			aluno.setRa(txtRa.getText());
			try {
				control.remover(aluno);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}

		if ("Atualizar".equals(cmd)) {
			aluno.setRa(txtRa.getText());
			aluno.setNome(txtNome.getText());
			aluno.setIdade(Integer.parseInt(txtIdade.getText()));
			try {
				Date d = sdf.parse(txtNascimento.getText());
				aluno.setNascimento(d);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			try {
				control.atualizar(aluno);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}

		if ("Pesquisar".equals(cmd)) {
			Aluno a = new Aluno();
			try {
				control.pesquisar(txtRa.getText());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			if (a != null) {
				txtNome.setText(a.getNome());
				txtIdade.setText(String.valueOf(a.getIdade()));
			}
		}
	}
}

