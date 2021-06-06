package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import controller.Masks;
import controller.MasksTextArea;
import model.Acervo;
import model.Exemplar;
import net.miginfocom.swing.MigLayout;
import persist.IGenericDAO;
import persist.JDBCDAO;
import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class Painel_NovoExemplar extends JPanel {

	private JPanel panelButtons;
	
	private JLabel lblApresentaCodAcervo;
	private JLabel lblQuantidade;
	private JLabel lblDetalhe_Fisico;
	private JLabel lblCodAcervo;
	private JLabel lblExemplaresCad;
	private JLabel lblCodigoAcervo;
	private JLabel lblPrecoCompra;
	private JLabel lblDisponibilidade;
	
	private JTextField txtCodBib;
	private JTextField txtPrecoCompra;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cbDisponibilidade;
	
	private JTable tblExemplares;
	private DefaultTableModel modelo;
	
	private JButton btnChecar;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JButton btnExibirTodos;

	private JScrollPane scrollExemplares;
	private JScrollPane scrollDetalheFisico;
	
	private JTextArea areaDetalheFisico;
	private JSpinner spQuantidade;
	
	
	private void carregarTable(String sql) {
			
		modelo.setNumRows(0);
		
		ArrayList<Exemplar> list_exemplares =  new JDBCDAO<Exemplar, String>(Exemplar.class).readAll(sql);		
		
		if (list_exemplares != null) {
			for (Exemplar ex : list_exemplares) {
				modelo.addRow(new Object[] {ex.getCodigo_Exemplar(), ex.getDisponibilidade(), ex.getPreco_compra()});
			}
		}
	}
	
	private boolean validarDados() {
		
		lblCodigoAcervo.setForeground(Color.BLACK);
		lblDisponibilidade.setForeground(Color.BLACK);
		lblQuantidade.setForeground(Color.BLACK);
		
		boolean erro = false;
		
		if (lblApresentaCodAcervo.getText().equals("")) {
			lblCodigoAcervo.setForeground(Color.RED);
			erro = true;
		}
				
		if (cbDisponibilidade.getSelectedItem().toString().equals("-- selecione --")) {
			lblDisponibilidade.setForeground(Color.RED);
			erro = true;
		}
				
		return erro;
		
	}
	
	private void limparCampos() {
		spQuantidade.setValue(1);
		areaDetalheFisico.setText("");
		cbDisponibilidade.setSelectedItem("-- selecione --");
		txtPrecoCompra.setText("");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_NovoExemplar() {
		
		this.setSize(1370, 760);

		lblCodAcervo = new JLabel("Cod. Acervo *");
		
		txtCodBib = new Masks(15);
		txtCodBib.setToolTipText("Campo de preenchimento obrigatório");
		txtCodBib.setColumns(10);

		btnChecar = new JButton("Checar");
		btnChecar.setMnemonic(KeyEvent.VK_C);

		lblExemplaresCad = new JLabel("Exemplares Cadastrados");
		
		lblCodigoAcervo = new JLabel("Cod. Acervo");
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod. Exemplar");
		modelo.addColumn("Disponibilidade");
		modelo.addColumn("Preço Compra");
		
		tblExemplares = new JTable(modelo);
		tblExemplares.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblExemplares.setEnabled(false);
		
		tblExemplares.getColumnModel().getColumn(0).setPreferredWidth(150);
		tblExemplares.getColumnModel().getColumn(1).setPreferredWidth(113);
		tblExemplares.getColumnModel().getColumn(2).setPreferredWidth(112);
		tblExemplares.setRowHeight(20);
		
		lblDetalhe_Fisico = new JLabel("Detalhe Físico");
		
		scrollExemplares = new JScrollPane(tblExemplares);
		scrollExemplares.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollExemplares.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		scrollExemplares.setViewportView(tblExemplares);
		
		lblApresentaCodAcervo = new JLabel();
		lblApresentaCodAcervo.setFont(new Font("Dialog", Font.BOLD, 14));
		
		scrollDetalheFisico = new JScrollPane();
		
		scrollDetalheFisico.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaDetalheFisico = new JTextArea();
		areaDetalheFisico.setToolTipText("Tamanho máximo: 500 caracteres");
		areaDetalheFisico.setDocument(new MasksTextArea(500));
		scrollDetalheFisico.setViewportView(areaDetalheFisico);
		areaDetalheFisico.setLineWrap(true);
		areaDetalheFisico.setWrapStyleWord(true);
		
		lblDisponibilidade = new JLabel("Disponibilidade *");
		
		cbDisponibilidade = new JComboBox();
		cbDisponibilidade.setToolTipText("Selecione uma opção");
		
		cbDisponibilidade.addItem("-- selecione --");
		cbDisponibilidade.addItem("Empréstimo");
		cbDisponibilidade.addItem("Consulta");
		
		lblPrecoCompra = new JLabel("Preço Compra (R$)");
		
		panelButtons = new JPanel();
		panelButtons.setLayout(new MigLayout("", "[grow][120]", "[grow][35][35]"));
		
		btnSalvar = new JButton("Salvar");
		panelButtons.add(btnSalvar, "cell 1 1,grow");
		btnSalvar.setMnemonic(KeyEvent.VK_S);
		
		btnLimpar = new JButton("Limpar");
		panelButtons.add(btnLimpar, "cell 1 2,grow");
		btnLimpar.setMnemonic(KeyEvent.VK_L);
		
		txtPrecoCompra = new Masks(7);
		txtPrecoCompra.setColumns(10);
		
		lblQuantidade = new JLabel("Quantidade *");
		
		btnExibirTodos = new JButton("Exibir Todos");
		btnExibirTodos.setMnemonic(KeyEvent.VK_E);
		
		spQuantidade = new JSpinner();
		spQuantidade.setFont(new Font("Arial", Font.BOLD, 13));
		spQuantidade.setModel(new SpinnerNumberModel(1, 1, null, 1));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodAcervo)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtCodBib, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnChecar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollExemplares, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(274)
											.addComponent(btnExibirTodos)))
									.addGap(122)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblApresentaCodAcervo)
										.addComponent(lblDisponibilidade)
										.addComponent(cbDisponibilidade, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrecoCompra)
										.addComponent(txtPrecoCompra, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblQuantidade)
										.addComponent(spQuantidade, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblExemplaresCad, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
									.addGap(279)
									.addComponent(lblCodigoAcervo)))
							.addGap(108)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
								.addComponent(lblDetalhe_Fisico)
								.addComponent(scrollDetalheFisico, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))))
					.addGap(104))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(lblCodAcervo)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCodBib, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChecar))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExemplaresCad)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCodigoAcervo)
							.addComponent(lblDetalhe_Fisico)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollExemplares, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnExibirTodos))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblApresentaCodAcervo)
							.addGap(39)
							.addComponent(lblDisponibilidade)
							.addGap(7)
							.addComponent(cbDisponibilidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblPrecoCompra)
							.addGap(6)
							.addComponent(txtPrecoCompra, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblQuantidade)
							.addGap(6)
							.addComponent(spQuantidade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollDetalheFisico, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelButtons, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))))
		);
		setLayout(groupLayout);
		
		
		btnChecar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(new JDBCDAO<Acervo, String>(Acervo.class).read(txtCodBib.getText()) != null) {
					lblApresentaCodAcervo.setText(txtCodBib.getText());
					carregarTable("select * from exemplar where cod_acervo='" + txtCodBib.getText() + "' order by cod_exemplar");
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum acervo encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}	
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Exemplar exemplar = new Exemplar();
				exemplar.setCod_acervo(lblApresentaCodAcervo.getText());
				exemplar.setDetalhe(areaDetalheFisico.getText());
				exemplar.setDisponibilidade(cbDisponibilidade.getSelectedItem().toString());
				exemplar.setPreco_compra(txtPrecoCompra.getText());
				
				if (validarDados() == false) {
					IGenericDAO<Exemplar, String> exemplarDao = new JDBCDAO<Exemplar, String>(Exemplar.class);
					for (int i=1; i<=Integer.parseInt(spQuantidade.getValue().toString()); i++) {
						exemplarDao.create(exemplar);
					}
					carregarTable("select * from exemplar where cod_acervo='" + lblApresentaCodAcervo.getText() + "' order by cod_exemplar");
					JOptionPane.showMessageDialog(null, "Exemplares inseridos com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					limparCampos();
				} else {
					JOptionPane.showMessageDialog(null, "Há campos invalidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
								
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				limparCampos();
				
			}
		});
		
		btnExibirTodos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				carregarTable("select * from exemplar order by cod_exemplar");
				
			}
		});
		
	}
}
