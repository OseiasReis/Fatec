package view.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controller.Masks;
import controller.MasksTextArea;
import model.Acervo;
import model.Exemplar;
import net.miginfocom.swing.MigLayout;
import persist.JDBCDAO;

@SuppressWarnings("serial")
public class Painel_AlterarExemplar extends JPanel {

	private JPanel panelButtons;

	private JLabel lblDetalhe_Fisico;
	private JLabel lblCodAcervo;
	private JLabel lblCodExemplar;
	private JLabel lblPrecoCompra;
	private JLabel lblDisponibilidade;

	private JTextField txtCodAcervo;
	private JTextField txtPrecoCompra;
	private JTextField txtCodExemplar;

	@SuppressWarnings("rawtypes")
	private JComboBox cbDisponibilidade;

	private JScrollPane spDetalheFisico;
	private JTextArea areaDetalheFisico;

	private JButton btnChecar;
	private JButton btnCancelar;
	private JButton btnAlterar;

	private static Boolean emprestado = null;
	private JLabel lblAtivo;
	private ButtonGroup buttonGroup;
	private JRadioButton rbSim;
	private JRadioButton rbNao;

	private boolean validarDados() {

		lblCodAcervo.setForeground(Color.BLACK);
		lblDisponibilidade.setForeground(Color.BLACK);

		boolean erro = false;

		if (new JDBCDAO<Acervo, String>(Acervo.class).read(txtCodAcervo.getText()) == null) {
			lblCodAcervo.setForeground(Color.RED);
			erro = true;
		}

		if (cbDisponibilidade.getSelectedItem().equals("-- selecione --")) {
			lblDisponibilidade.setForeground(Color.RED);
			erro = true;
		}

		return erro;
	}

	private void limparCampos() {

		areaDetalheFisico.setText("");
		cbDisponibilidade.setSelectedItem("-- selecione --");
		txtPrecoCompra.setText("");
		txtCodAcervo.setText("");
		txtCodExemplar.setText("");
	}

	private void desabilitarCampos(boolean opcao) {

		if (opcao == true) {

			areaDetalheFisico.setEnabled(false);
			cbDisponibilidade.setEnabled(false);
			txtPrecoCompra.setEnabled(false);
			txtCodAcervo.setEnabled(false);
			txtCodExemplar.setEnabled(true);
			btnAlterar.setVisible(false);
			rbNao.setEnabled(false);
			rbSim.setEnabled(false);
		} else {

			areaDetalheFisico.setEnabled(true);
			cbDisponibilidade.setEnabled(true);
			txtPrecoCompra.setEnabled(true);
			txtCodAcervo.setEnabled(true);
			txtCodExemplar.setEnabled(false);
			btnAlterar.setVisible(true);
			rbNao.setEnabled(true);
			rbSim.setEnabled(true);
		}
	}

	public void setTextField(Exemplar exemplar) {

		txtCodAcervo.setText(exemplar.getCod_acervo());
		txtPrecoCompra.setText(exemplar.getPreco_compra());
		areaDetalheFisico.setText(exemplar.getDetalhe());
		cbDisponibilidade.setSelectedItem(exemplar.getDisponibilidade());
		if (exemplar.getAtivo() == true) {
			rbSim.setSelected(true);
		} else {
			rbNao.setSelected(true);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_AlterarExemplar() {
		
		setSize(1360, 780);

		lblCodExemplar = new JLabel("Cod. Exemplar *");

		txtCodExemplar = new Masks(15);
		txtCodExemplar.setToolTipText("Campo de preenchimento obrigatório");
		txtCodExemplar.setColumns(10);

		btnChecar = new JButton("Checar");
		btnChecar.setMnemonic(KeyEvent.VK_C);

		lblCodAcervo = new JLabel("Cod. Acervo *");

		lblDetalhe_Fisico = new JLabel("Detalhe Físico");

		txtCodAcervo = new Masks(15);
		txtCodAcervo.setToolTipText("Campo de preenchimento obrigatório");
		txtCodAcervo.setColumns(10);

		spDetalheFisico = new JScrollPane();
		spDetalheFisico.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		areaDetalheFisico = new JTextArea();
		areaDetalheFisico.setToolTipText("Tamanho máximo: 500 caracteres");
		areaDetalheFisico.setLineWrap(true);
		areaDetalheFisico.setWrapStyleWord(true);
		areaDetalheFisico.setDocument(new MasksTextArea(500));
		spDetalheFisico.setViewportView(areaDetalheFisico);

		lblDisponibilidade = new JLabel("Disponibilidade *");

		cbDisponibilidade = new JComboBox();
		cbDisponibilidade.setToolTipText("Selecione uma opção");

		cbDisponibilidade.addItem("-- selecione --");
		cbDisponibilidade.addItem("Empréstimo");
		cbDisponibilidade.addItem("Consulta");

		lblPrecoCompra = new JLabel("Preço Compra (R$)");

		panelButtons = new JPanel();
		panelButtons.setLayout(new MigLayout("", "[120]", "[35][35]"));
		
		btnAlterar = new JButton("Alterar");
		panelButtons.add(btnAlterar, "cell 0 0,grow");
		btnAlterar.setMnemonic(KeyEvent.VK_A);
				
		btnAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (validarDados() == false) {

					Exemplar exemplar = new Exemplar();
					exemplar.setCodigo_Exemplar(txtCodExemplar.getText());
					exemplar.setCod_acervo(txtCodAcervo.getText());
					exemplar.setDetalhe(areaDetalheFisico.getText());
					exemplar.setDisponibilidade(cbDisponibilidade.getSelectedItem().toString());
					exemplar.setPreco_compra(txtPrecoCompra.getText());
					exemplar.setEmprestado(emprestado);
					if (rbSim.isSelected()) {
						exemplar.setAtivo(true);
					} else {
						exemplar.setAtivo(false);
					}
					new JDBCDAO<Exemplar, String>(Exemplar.class).update(exemplar, txtCodExemplar.getText());
					JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
					limparCampos();
					desabilitarCampos(true);
				} else {
					JOptionPane.showMessageDialog(null, "Há campos inválidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		btnCancelar = new JButton("Cancelar");
		panelButtons.add(btnCancelar, "cell 0 1,grow");
		btnCancelar.setMnemonic(KeyEvent.VK_N);

		txtPrecoCompra = new Masks(7);
		txtPrecoCompra.setColumns(10);
		
		lblAtivo = new JLabel("Situação");		
		rbSim = new JRadioButton("Ativado");
		rbNao = new JRadioButton("Desativado");

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rbNao);
		buttonGroup.add(rbSim);
		
		JLabel lblAsterisco = new JLabel("Os campos com asterisco (*) são de preenchimento obrigatório.");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAsterisco, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodExemplar)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtCodExemplar, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnChecar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPrecoCompra, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAtivo)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rbSim)
									.addGap(18)
									.addComponent(rbNao)))
							.addGap(684)
							.addComponent(panelButtons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCodAcervo, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDisponibilidade)
								.addComponent(cbDisponibilidade, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecoCompra)
								.addComponent(lblCodAcervo))
							.addGap(176)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDetalhe_Fisico)
								.addComponent(spDetalheFisico, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
							.addGap(238))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblAsterisco)
					.addGap(30)
					.addComponent(lblCodExemplar)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCodExemplar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChecar))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodAcervo)
						.addComponent(lblDetalhe_Fisico))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtCodAcervo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblDisponibilidade)
							.addGap(7)
							.addComponent(cbDisponibilidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblPrecoCompra)
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtPrecoCompra, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(lblAtivo)
									.addGap(2)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(rbSim)
										.addComponent(rbNao)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(panelButtons, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))
						.addComponent(spDetalheFisico, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);

		desabilitarCampos(true);

		btnChecar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Exemplar exemplar = new JDBCDAO<Exemplar, String>(Exemplar.class).read(txtCodExemplar.getText());
				if (exemplar != null) {
					setTextField(exemplar);
					desabilitarCampos(false);
					emprestado = exemplar.getEmprestado();
				} else {
					JOptionPane.showMessageDialog(null, "Exemplar não encontrado", "Aviso", JOptionPane.WARNING_MESSAGE);
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

	}
}
