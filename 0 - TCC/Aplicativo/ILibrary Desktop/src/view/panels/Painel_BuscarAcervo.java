package view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import model.Acervo;
import model.Exemplar;
import net.miginfocom.swing.MigLayout;
import persist.JDBCDAO;
import view.Interface_InfoAcervo;

@SuppressWarnings("serial")
public class Painel_BuscarAcervo extends JPanel {

	
	private JLabel lblExemplares;
	private JLabel lblPesquisarPor;
	private JTextField txtBusca;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private DefaultTableModel modeloAcervo;
	private DefaultTableModel modeloExemplar;
	private JTable tblAcervo;
	private JTable tblExemplar;
	private JScrollPane spAcervo;
	private JScrollPane spExemplares;
	private JButton btnMaisInformacoes;
	private String cod_acervo;

	private void filtrarAcervo(String sql) {

		modeloAcervo.setNumRows(0);
		ArrayList<Acervo> lista_acervo = new JDBCDAO<Acervo, String>(Acervo.class).readAll(sql);

		if (lista_acervo != null) {
			for (Acervo a : lista_acervo) {
				modeloAcervo.addRow(new Object[] { a.getCodigo_acervo(), a.getMaterial(), a.getTitulo(),
					a.getSubtitulo(), a.getClassificacao().getAssunto(), a.getAutor(), a.getEditora() });
			}
		}
	}

	private void apresentarExemplares(String sql) {

		modeloExemplar.setNumRows(0);
		ArrayList<Exemplar> lista_exemplares = new JDBCDAO<Exemplar, String>(Exemplar.class).readAll(sql);
		if (lista_exemplares != null) {
			for (Exemplar e : lista_exemplares) {
				modeloExemplar
						.addRow(new Object[] { e.getCodigo_Exemplar(), e.getDisponibilidade(), e.getPreco_compra() });
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_BuscarAcervo() {
		
		this.setLayout(new MigLayout("", 
			"[167.00][71.00][412.00][104.00][20][350.00]", 
			"[28.00][][20][23.00][][:201.00:238.00][::123.00]"));

		modeloAcervo = new DefaultTableModel();
		modeloAcervo.addColumn("Cod. Acervo");
		modeloAcervo.addColumn("Material");
		modeloAcervo.addColumn("Titulo");
		modeloAcervo.addColumn("Subtitulo");
		modeloAcervo.addColumn("Assunto");
		modeloAcervo.addColumn("Nome Autor");
		modeloAcervo.addColumn("Editora");

		modeloExemplar = new DefaultTableModel();
		modeloExemplar.addColumn("Cod. Exemplar");
		modeloExemplar.addColumn("Disponibilidade");
		modeloExemplar.addColumn("Preço Compra");

		tblAcervo = new JTable(modeloAcervo);
		tblAcervo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tblAcervo.getColumnModel().getColumn(0).setPreferredWidth(120);
		tblAcervo.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblAcervo.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblAcervo.getColumnModel().getColumn(3).setPreferredWidth(150);
		tblAcervo.getColumnModel().getColumn(4).setPreferredWidth(150);
		tblAcervo.getColumnModel().getColumn(5).setPreferredWidth(150);
		tblAcervo.getColumnModel().getColumn(6).setPreferredWidth(120);
		tblAcervo.setRowHeight(25);

		tblExemplar = new JTable(modeloExemplar);
		tblExemplar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tblExemplar.getColumnModel().getColumn(0).setPreferredWidth(112);
		tblExemplar.getColumnModel().getColumn(1).setPreferredWidth(110);
		tblExemplar.getColumnModel().getColumn(2).setPreferredWidth(110);
		tblExemplar.setRowHeight(20);

		lblPesquisarPor = new JLabel("Pesquisar por");
		this.add(lblPesquisarPor, "cell 0 1");

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "-- selecione --", "Cod. Acervo", "Titulo", "Subtitulo", "Autor", "Editora", "Tipo Material", "Assunto" }));
		this.add(comboBox, "cell 0 2,growx");

		txtBusca = new JTextField();

		this.add(txtBusca, "cell 0 3 2 1,grow");
		txtBusca.setColumns(10);
		txtBusca.setEditable(false);

		btnMaisInformacoes = new JButton("<html><p align='center'>Mais<br/>Informações</p></html>");

		this.add(btnMaisInformacoes, "cell 3 3 1 2,grow");

		lblExemplares = new JLabel("Exemplares");
		lblExemplares.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblExemplares, "cell 5 4,grow");

		spAcervo = new JScrollPane(tblAcervo);
		this.add(spAcervo, "cell 0 5 4 2,grow");
		spAcervo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spAcervo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		
		spExemplares = new JScrollPane(tblExemplar);
		this.add(spExemplares, "cell 5 5,alignx leading,growy");
		spExemplares.setViewportView(tblExemplar);
		spExemplares.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spExemplares.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		filtrarAcervo("select * from acervo");
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtBusca.setEditable(true);
				String cb = comboBox.getSelectedItem().toString();

				if (txtBusca.getText() == null) {
					filtrarAcervo("select * from acervo");
				}

				if (cb.equals("-- selecione --")) {
					txtBusca.setEditable(false);
					txtBusca.setText("");
				}

				if (cb == "Cod. Acervo") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarAcervo(
										"select * from acervo where cod_acervo like '" + txtBusca.getText() + "%'");
							}
						}
					});
				}

				if (cb == "Titulo") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarAcervo("select * from acervo where titulo like '%" + txtBusca.getText() + "%'");
							}
						}
					});
				}
				if (cb == "Subtitulo") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarAcervo(
										"select * from acervo where subtitulo like '%" + txtBusca.getText() + "%'");
							}
						}
					});
				}
				if (cb == "Autor") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarAcervo(
										"select * from acervo where nome_autor like '%" + txtBusca.getText() + "%'");
							}
						}
					});
				}
				if (cb == "Editora") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarAcervo("select * from acervo where editora like '" + txtBusca.getText() + "%'");
							}
						}
					});
				}
				if (cb == "Tipo Material") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarAcervo(
										"select * from acervo where Tipo_Material like '" + txtBusca.getText() + "%'");
							}
						}
					});
				}
				
				if (cb == "Assunto") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarAcervo(
										"select * from acervo INNER JOIN classificacao ON acervo.cod_classificacao=classificacao.cod_classificacao where classificacao.assunto like '%" + txtBusca.getText() + "%'");
							}
						}
					});
				}
			}
		});
		
		tblAcervo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int viewRow = tblAcervo.getSelectedRow();
				cod_acervo = tblAcervo.getValueAt(viewRow, 0).toString();
				apresentarExemplares("select * from exemplar where cod_acervo=" + cod_acervo);
			}
		});
		
		btnMaisInformacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cod_acervo != null) {
					new Interface_InfoAcervo(cod_acervo);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um acervo", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
	}
}