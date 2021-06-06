package view.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Masks;
import model.Localizacao;
import model.Operador;
import net.miginfocom.swing.MigLayout;
import persist.IGenericDAO;
import persist.JDBCDAO;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class Painel_AlterarOperador extends JPanel {

	private JPanel panelButtons;

	private JLabel lblPrivilegio;
	private JLabel lblRegistro;
	private JLabel lblCep;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblEndereco;
	private JLabel lblNum;
	private JLabel lblCelular;
	private JLabel lblBairro;
	private JLabel lblCidade;

	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtNum;
	private JTextField txtCelular;
	private JTextField txtRegistro;

	private JButton btnAlterar;
	private JButton btnCancelar;

	@SuppressWarnings("rawtypes")
	private JComboBox cbPrivilegio;

	private JButton btnChecar;

	private String senha;
	private JLabel lblSituao;
	private ButtonGroup buttonGroup;
	private JRadioButton rbAtivo;
	private JRadioButton rbDesativo;
	private JLabel lblAsterisco;

	private void limparCampos() {

		Component[] comp = this.getComponents();
		for (Component c : comp) {
			if (c.getClass().getSimpleName().contains("JTextField") || c.getClass().getSimpleName().contains("Masks")) {
				((JTextField) c).setText("");
				txtCep.setText("");
				txtTelefone.setText("");
				txtCelular.setText("");
			}
		}

		cbPrivilegio.setSelectedItem("-- selecione --");

	}

	private boolean validarDados() {
		boolean erro = false;

		Component[] comp = this.getComponents();
		for (Component c : comp) {
			if (c.getClass().getSimpleName().contains("JLabel")) {
				((JLabel) c).setForeground(Color.BLACK);
			}
		}

		cbPrivilegio.setForeground(Color.BLACK);

		if (cbPrivilegio.getSelectedItem().equals("-- selecione --")) {
			lblPrivilegio.setForeground(Color.RED);
			erro = true;
		}

		if (txtCep.getText().equals("     -   ")) {
			lblCep.setForeground(Color.RED);
			erro = true;
		}

		if (txtNome.getText().equals("")) {
			lblNome.setForeground(Color.RED);
			erro = true;
		}

		return erro;
	}

	private void desabilitarCampos(boolean opcao) {

		Component[] comp = this.getComponents();
		if (opcao == true) {
			for (Component c : comp) {
				if (c.getClass().getSimpleName().contains("JTextField")
						|| c.getClass().getSimpleName().contains("Masks")) {
					c.setEnabled(false);
				}

				cbPrivilegio.setEnabled(false);
				btnAlterar.setVisible(false);
				txtRegistro.setEnabled(true);
				rbAtivo.setEnabled(false);
				rbDesativo.setEnabled(false);

			}
		} else {
			for (Component c : comp) {
				if (c.getClass().getSimpleName().contains("JTextField")
						|| c.getClass().getSimpleName().contains("Masks")) {
					c.setEnabled(true);
				}
				txtRegistro.setEnabled(false);
				cbPrivilegio.setEnabled(true);
				btnAlterar.setVisible(true);
				rbAtivo.setEnabled(true);
				rbDesativo.setEnabled(true);
			}
		}
	}

	public void PreencherCampos(Operador p) {

		txtCelular.setText(p.getCelular());
		txtNome.setText(p.getNome());
		txtNum.setText(p.getNum());
		txtTelefone.setText(p.getTelefone());
		txtBairro.setText(p.getLocalizacao().getBairro());
		txtCep.setText(p.getCep());
		txtCidade.setText(p.getLocalizacao().getCidade());
		txtEndereco.setText(p.getLocalizacao().getEndereco());
		cbPrivilegio.setSelectedItem(p.getPrivilegio());
		if (p.getAtivo() == true) {
			rbAtivo.setSelected(true);
		} else {
			rbDesativo.setSelected(true);
		}

		txtRegistro.setEnabled(false);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_AlterarOperador(Operador operador) {

		setSize(3600, 760);
		this.setLayout(new MigLayout("", "[50][87.00][50.00][35.00][34.00][36.00][:31.00:33.00][70.00][79.00][][46.00][70][136.00]", "[45][][25][15][][25][15][][25][15][][25][15][][25][15][][25]"));
		
		lblAsterisco = new JLabel("Os campos com asterisco (*) são de preenchimento obrigatório.");
		add(lblAsterisco, "cell 1 0 9 1,growx,aligny top");

		lblRegistro = new JLabel("Registro *");
		this.add(lblRegistro, "cell 1 1");

		txtRegistro = new Masks(20);
		txtRegistro.setToolTipText("Verifique se já não exista um operador com o mesmo registro cadastrado.\nCampo de preenchimento obrigatório.");
		txtRegistro.setColumns(10);
		this.add(txtRegistro, "cell 1 2 3 1,grow");

		btnChecar = new JButton("Checar");
		this.add(btnChecar, "cell 4 2 2 1,grow");
		btnChecar.setMnemonic(KeyEvent.VK_C);

		lblPrivilegio = new JLabel("Privilégio *");
		this.add(lblPrivilegio, "cell 1 4,grow");

		lblCidade = new JLabel("Cidade");
		this.add(lblCidade, "cell 8 4,grow");

		cbPrivilegio = new JComboBox();
		cbPrivilegio.setToolTipText("Selecione um privilégio");
		this.add(cbPrivilegio, "cell 1 5 2 1,grow");

		cbPrivilegio.addItem("-- selecione --");
		cbPrivilegio.addItem("Atendente");
		cbPrivilegio.addItem("Administrador");

		txtCidade = new Masks(40);
		this.add(txtCidade, "cell 8 5 3 1,grow");
		txtCidade.setColumns(10);

		lblNome = new JLabel("Nome *");
		this.add(lblNome, "cell 1 7,grow");

		lblTelefone = new JLabel("Telefone");
		this.add(lblTelefone, "cell 8 7,grow");

		txtNome = new Masks(50);
		txtNome.setToolTipText("Campo de preenchimento obrigatório");
		this.add(txtNome, "cell 1 8 4 1,grow");
		txtNome.setColumns(10);

		try {
			txtTelefone = new Masks("(##) ####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		this.add(txtTelefone, "cell 8 8 2 1,grow");
		txtTelefone.setColumns(10);

		lblCep = new JLabel("Cep *");
		this.add(lblCep, "cell 1 10,grow");

		lblCelular = new JLabel("Celular");
		this.add(lblCelular, "cell 8 10,grow");

		try {
			txtCep = new Masks("#####-###");
			txtCep.setToolTipText("Campo de preenchimento obrigatório");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtCep.setText("");
		this.add(txtCep, "cell 1 11,grow");
		txtCep.setColumns(10);

		try {
			txtCelular = new Masks("(##) #####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		this.add(txtCelular, "cell 8 11 2 1,grow");
		txtCelular.setColumns(10);

		panelButtons = new JPanel();
		this.add(panelButtons, "cell 12 12 1 6,grow");
		panelButtons.setLayout(new MigLayout("", "[120]", "[35][35][35]"));

		btnAlterar = new JButton("Alterar");
		panelButtons.add(btnAlterar, "cell 0 1,grow");
		btnAlterar.setMnemonic(KeyEvent.VK_A);

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validarDados() == false) {

					Operador operador = new Operador();
					operador.setRegistro(txtRegistro.getText());
					operador.setPrivilegio(cbPrivilegio.getSelectedItem().toString());
					operador.setSenha(senha);
					operador.setCelular(txtCelular.getText());
					operador.setCep(txtCep.getText());
					operador.setNome(txtNome.getText());
					operador.setNum(txtNum.getText());
					operador.setTelefone(txtTelefone.getText());
					if (rbAtivo.isSelected()) {
						operador.setAtivo(true);
					} else {
						operador.setAtivo(false);
					}

					System.out.println(operador.getAtivo());
					System.out.println(operador.getRegistro());
					Localizacao local = new Localizacao();
					local.setCep(txtCep.getText());
					local.setBairro(txtBairro.getText());
					local.setCidade(txtCidade.getText());
					local.setEndereco(txtEndereco.getText());

					IGenericDAO<Localizacao, String> jdbcLocal = new JDBCDAO<Localizacao, String>(Localizacao.class);
					if (jdbcLocal.read(txtCep.getText()) == null) {
						jdbcLocal.create(local);
					} else {
						jdbcLocal.update(local, txtCep.getText());
						limparCampos();
						desabilitarCampos(true);
					}

					JDBCDAO<Operador, String> jdbcOperador = new JDBCDAO<Operador, String>(Operador.class);
					jdbcOperador.update(operador, operador.getRegistro());
				}
			}
		});

		btnCancelar = new JButton("Cancelar");
		panelButtons.add(btnCancelar, "cell 0 2,grow");
		btnCancelar.setMnemonic(KeyEvent.VK_N);

		lblEndereco = new JLabel("Endereço");
		this.add(lblEndereco, "cell 1 13,grow");

		lblNum = new JLabel("Nº");
		this.add(lblNum, "cell 5 13");

		lblSituao = new JLabel("Situação");
		add(lblSituao, "cell 8 13");

		txtEndereco = new Masks(50);
		this.add(txtEndereco, "cell 1 14 4 1,grow");
		txtEndereco.setColumns(10);

		txtNum = new Masks(6);
		this.add(txtNum, "cell 5 14 2 1,grow");
		txtNum.setColumns(10);

		rbAtivo = new JRadioButton("Ativado");
		add(rbAtivo, "cell 8 14");

		rbDesativo = new JRadioButton("Desativado");
		add(rbDesativo, "cell 9 14");

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rbAtivo);
		buttonGroup.add(rbDesativo);

		lblBairro = new JLabel("Bairro");
		this.add(lblBairro, "cell 1 16,grow");

		txtBairro = new Masks(40);
		this.add(txtBairro, "cell 1 17 3 1,grow");
		txtBairro.setColumns(10);

		desabilitarCampos(true);

		btnChecar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Operador operador = new JDBCDAO<Operador, String>(Operador.class).read(txtRegistro.getText());

				if (operador != null) {
					PreencherCampos(operador);
					senha = operador.getSenha();
					desabilitarCampos(false);

				} else {
					JOptionPane.showMessageDialog(null, "Operador não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				limparCampos();
				desabilitarCampos(true);

			}
		});

		txtCep.addKeyListener(new KeyAdapter() {
			String cep = null;

			@Override
			public void keyTyped(KeyEvent evt) {

				String texto = txtCep.getText().replaceAll(" ", "").replaceAll("-", "") + evt.getKeyChar();

				if (texto.length() == 8) {
					cep = texto.substring(0, 5) + "-" + texto.substring(5);
				}

				txtEndereco.setText("");
				txtBairro.setText("");
				txtCidade.setText("");

				if ((cep != null) && (cep.length() == 9)) {
					try {

						IGenericDAO<Localizacao, String> jdbcLoc = new JDBCDAO<Localizacao, String>(Localizacao.class);
						Localizacao local = (Localizacao) jdbcLoc.read(cep);
						if (local != null) {
							txtEndereco.setText(local.getEndereco());
							txtBairro.setText(local.getBairro());
							txtCidade.setText(local.getCidade());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

}
