package view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Operador;
import net.miginfocom.swing.MigLayout;
import persist.JDBCDAO;

@SuppressWarnings("serial")
public class Painel_BuscarOperadores extends JPanel {

	private DefaultTableModel modeloOperador;
	private JTable tblOperador;
	private JTextField txtBusca;
		
	private void filtrarOperador(String sql) {

		modeloOperador.setNumRows(0);
		ArrayList<Operador> lista_operador = new JDBCDAO<Operador, String>(Operador.class).readAll(sql);

		if (lista_operador != null) {
			for (Operador c : lista_operador) {
				modeloOperador.addRow(new Object[] { c.getRegistro(),c.getPrivilegio(), c.getNome(), c.getTelefone(), c.getCelular(), c.getCep(), c.getLocalizacao().getEndereco(), c.getNum(), c.getLocalizacao().getBairro(), c.getLocalizacao().getCidade()});
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_BuscarOperadores() {
		
		this.setLayout(new MigLayout("", 
			"[167.00][71.00][924.00]", 
			"[28.00][][20][23.00][][:322.00:344.00,grow]"));

		modeloOperador = new DefaultTableModel();		
		modeloOperador.addColumn("Registro");
		modeloOperador.addColumn("Privilégio");
		modeloOperador.addColumn("Nome");
		modeloOperador.addColumn("Telefone");
		modeloOperador.addColumn("Celular");
		modeloOperador.addColumn("Cep");
		modeloOperador.addColumn("Endereço");
		modeloOperador.addColumn("Nº");
		modeloOperador.addColumn("Bairro");
		modeloOperador.addColumn("Cidade");

		tblOperador = new JTable(modeloOperador);
		tblOperador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tblOperador.getColumnModel().getColumn(0).setPreferredWidth(86);
		tblOperador.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblOperador.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblOperador.getColumnModel().getColumn(3).setPreferredWidth(110);
		tblOperador.getColumnModel().getColumn(4).setPreferredWidth(115);
		tblOperador.getColumnModel().getColumn(5).setPreferredWidth(80);
		tblOperador.getColumnModel().getColumn(6).setPreferredWidth(180);
		tblOperador.getColumnModel().getColumn(7).setPreferredWidth(50);
		tblOperador.getColumnModel().getColumn(8).setPreferredWidth(130);
		tblOperador.getColumnModel().getColumn(9).setPreferredWidth(130);
		tblOperador.setRowHeight(25);

		JLabel lblPesquisarPor = new JLabel("Pesquisar por");
		this.add(lblPesquisarPor, "cell 0 1");

		JComboBox cbPesquisarPor = new JComboBox();
		
		cbPesquisarPor.addItem("-- selecione --");
		cbPesquisarPor.addItem("Registro");
		cbPesquisarPor.addItem("Nome");
		cbPesquisarPor.addItem("Privilégio");
		
		this.add(cbPesquisarPor, "cell 0 2,growx");

		txtBusca = new JTextField();
		this.add(txtBusca, "cell 0 3 2 1,grow");
		txtBusca.setColumns(10);
		txtBusca.setEditable(false);

		JScrollPane spCliente = new JScrollPane(tblOperador);
		this.add(spCliente, "cell 0 5 3 1,grow");
		spCliente.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spCliente.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		filtrarOperador("select * from operador");
		
		cbPesquisarPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtBusca.setEditable(true);
				String cb = cbPesquisarPor.getSelectedItem().toString();

				if (txtBusca.getText() == null) {
					filtrarOperador("select * from operador");
				}

				if (cb.equals("-- selecione --")) {
					txtBusca.setEditable(false);
					txtBusca.setText("");
				}

				if (cb == "Registro") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarOperador(
										"select * from operador where registro_operador like '" + txtBusca.getText() + "%'");
							}
						}
					});
				}

				if (cb == "Nome") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarOperador("select * from operador where nome like '" + txtBusca.getText() + "%'");
							}
						}
					});
				}
				if (cb == "Privilégio") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarOperador(
										"select * from operador where privilegio like '" + txtBusca.getText() + "%'");
							}
						}
					});
				}
			}
		});
	}
}