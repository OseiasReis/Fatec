package view.panels.configuracao;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Masks;
import model.Biblioteca;
import net.miginfocom.swing.MigLayout;
import persist.SerDAO;
import java.awt.Font;

@SuppressWarnings("serial")
public class Painel_Biblioteca extends JPanel {
	private JLabel lblEndereco;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblNome;
	private JLabel lblTelefone;

	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;

	private JButton btnAplicar;
	private JLabel lblAsterisco;

	private boolean validarCampos() {

		Component[] comp = this.getComponents();
		for (Component c : comp) {
			if (c.getClass().getSimpleName().contains("JLabel")) {
				((JLabel) c).setForeground(Color.BLACK);
			}
		}

		boolean erro = false;
		if (txtNome.getText().equals("")) {
			lblNome.setForeground(Color.RED);
			erro = true;
		}
		if (txtEndereco.getText().equals("")) {
			lblEndereco.setForeground(Color.RED);
			erro = true;
		}
		if (txtBairro.getText().equals("")) {
			lblBairro.setForeground(Color.RED);
			erro = true;
		}
		if (txtCidade.getText().equals("")) {
			lblCidade.setForeground(Color.RED);
			erro = true;
		}
		if (txtEstado.getText().equals("")) {
			lblEstado.setForeground(Color.RED);
			erro = true;
		}
		if (txtNumero.getText().equals("")) {
			lblNumero.setForeground(Color.RED);
			erro = true;
		}

		return erro;
	}

	public Painel_Biblioteca(JLabel bibliotecaApresenta) {

		setSize(800, 600);
		
		setLayout(new MigLayout("", "[15][][143.00][][68.00][15]", "[5][37.00][][25][][25][][25][][25][][25][grow][33.00][]"));
		
		lblAsterisco = new JLabel("Os campos com asterisco (*) são de preenchimento obrigatório.");
		lblAsterisco.setFont(new Font("Dialog", Font.BOLD, 10));
		add(lblAsterisco, "cell 1 1 4 1,aligny top");

		lblNome = new JLabel("Nome *");
		this.add(lblNome, "cell 1 2");

		txtNome = new JTextField();
		txtNome.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtNome, "cell 1 3 4 1,grow");
		txtNome.setColumns(10);

		lblTelefone = new JLabel("Telefone");
		this.add(lblTelefone, "cell 1 4");

		try {
			txtTelefone = new Masks("(##) ####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		this.add(txtTelefone, "cell 1 5,grow");
		txtTelefone.setColumns(10);

		lblEndereco = new JLabel("Endereco *");
		this.add(lblEndereco, "cell 1 6");

		lblNumero = new JLabel("Numero *");
		this.add(lblNumero, "cell 4 6");

		txtEndereco = new JTextField();
		txtEndereco.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtEndereco, "cell 1 7 2 1,grow");
		txtEndereco.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtNumero, "cell 4 7,grow");
		txtNumero.setColumns(10);

		lblBairro = new JLabel("Bairro *");
		this.add(lblBairro, "cell 1 8");

		txtBairro = new JTextField();
		txtBairro.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtBairro, "cell 1 9 2 1,grow");
		txtBairro.setColumns(10);

		lblCidade = new JLabel("Cidade *");
		this.add(lblCidade, "cell 1 10");

		lblEstado = new JLabel("Estado *");
		this.add(lblEstado, "cell 4 10");

		txtCidade = new JTextField();
		txtCidade.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtCidade, "cell 1 11 2 1,grow");
		txtCidade.setColumns(10);

		txtEstado = new JTextField();
		txtEstado.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtEstado, "cell 4 11,grow");
		txtEstado.setColumns(10);

		Biblioteca biblioteca = new SerDAO<Biblioteca, String>(Biblioteca.class).read(null);
		txtNome.setText(biblioteca.getNome());
		txtEndereco.setText(biblioteca.getEndereco());
		txtNumero.setText(biblioteca.getNumero());
		txtBairro.setText(biblioteca.getBairro());
		txtCidade.setText(biblioteca.getCidade());
		txtEstado.setText(biblioteca.getEstado());
		txtTelefone.setText(biblioteca.getTelefone());

		btnAplicar = new JButton("Aplicar");
		this.add(btnAplicar, "cell 3 13 2 1,grow");

		btnAplicar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (validarCampos() == false) {
					Biblioteca biblio = new Biblioteca(txtNome.getText(), txtEndereco.getText(), txtNumero.getText(),
							txtBairro.getText(), txtCidade.getText(), txtEstado.getText());
					biblio.setTelefone(txtTelefone.getText());
					new SerDAO<Biblioteca, String>(Biblioteca.class).create(biblio);
					bibliotecaApresenta.setText(
							"<html><b>" + txtNome.getText().toUpperCase() + "</b> <br/> Fone: " + txtTelefone.getText()
									+ "<br/>" + txtEndereco.getText() + ", " + txtNumero.getText() + " - "
									+ txtBairro.getText() + " - " + txtCidade.getText() + " - " + txtEstado.getText());
					
					JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "Há campos inválidos", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

}
