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
import model.Cliente;
import net.miginfocom.swing.MigLayout;
import persist.JDBCDAO;

@SuppressWarnings("serial")
public class Painel_BuscarCliente extends JPanel {

	private JLabel lblPesquisarPor;
	private JTextField txtBusca;
	private DefaultTableModel modeloCliente;
	@SuppressWarnings("rawtypes")
	private JComboBox cbPesquisarPor;
	private JTable tblCliente;
	private JScrollPane spCliente;
	
	private void filtrarCliente(String sql) {

		modeloCliente.setNumRows(0);
		ArrayList<Cliente> lista_cliente = new JDBCDAO<Cliente, String>(Cliente.class).readAll(sql);

		if (lista_cliente != null) {
			for (Cliente c : lista_cliente) {
				modeloCliente.addRow(new Object[] { c.getRegistro(),c.getTipo(), c.getNome(), c.getSexo(), c.getData_nasc(), c.getCep(), c.getLocalizacao().getEndereco(), c.getNum_residencia(), c.getLocalizacao().getBairro(), c.getLocalizacao().getCidade(), c.getTelefone(), c.getCelular(), c.getEmail(), c.getResponsavel()});
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_BuscarCliente() {
		
		this.setLayout(new MigLayout("", 
			"[167.00][71.00][924.00]", 
			"[28.00][][20][23.00][][:322.00:344.00,grow]"));

		modeloCliente = new DefaultTableModel();		
		modeloCliente.addColumn("Reg. Cliente");
		modeloCliente.addColumn("Tipo");
		modeloCliente.addColumn("Nome");
		modeloCliente.addColumn("Sexo");
		modeloCliente.addColumn("Data Nasc.");
		modeloCliente.addColumn("Cep");
		modeloCliente.addColumn("Endereço");
		modeloCliente.addColumn("Nº");
		modeloCliente.addColumn("Bairro");
		modeloCliente.addColumn("Cidade");
		modeloCliente.addColumn("Telefone");
		modeloCliente.addColumn("Celular");
		modeloCliente.addColumn("Email");
		modeloCliente.addColumn("Responsável");

		tblCliente = new JTable(modeloCliente);
		tblCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tblCliente.getColumnModel().getColumn(0).setPreferredWidth(86);
		tblCliente.getColumnModel().getColumn(1).setPreferredWidth(80);
		tblCliente.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblCliente.getColumnModel().getColumn(3).setPreferredWidth(70);
		tblCliente.getColumnModel().getColumn(4).setPreferredWidth(80);
		tblCliente.getColumnModel().getColumn(5).setPreferredWidth(80);
		tblCliente.getColumnModel().getColumn(6).setPreferredWidth(180);
		tblCliente.getColumnModel().getColumn(7).setPreferredWidth(50);
		tblCliente.getColumnModel().getColumn(8).setPreferredWidth(100);
		tblCliente.getColumnModel().getColumn(9).setPreferredWidth(100);
		tblCliente.getColumnModel().getColumn(10).setPreferredWidth(110);
		tblCliente.getColumnModel().getColumn(11).setPreferredWidth(115);
		tblCliente.getColumnModel().getColumn(12).setPreferredWidth(170);
		tblCliente.getColumnModel().getColumn(13).setPreferredWidth(170);
		tblCliente.setRowHeight(25);
		
		lblPesquisarPor = new JLabel("Pesquisar por");
		this.add(lblPesquisarPor, "cell 0 1");

		cbPesquisarPor = new JComboBox();
		
		cbPesquisarPor.addItem("-- selecione --");
		cbPesquisarPor.addItem("Reg. Cliente");
		cbPesquisarPor.addItem("Nome");
		cbPesquisarPor.addItem("Sexo");
		cbPesquisarPor.addItem("Tipo");
		cbPesquisarPor.addItem("Cep");
		
		this.add(cbPesquisarPor, "cell 0 2,growx");

		txtBusca = new JTextField();
		this.add(txtBusca, "cell 0 3 2 1,grow");
		txtBusca.setColumns(10);
		txtBusca.setEditable(false);

		spCliente = new JScrollPane(tblCliente);
		this.add(spCliente, "cell 0 5 3 1,grow");
		spCliente.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spCliente.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		filtrarCliente("select * from cliente");   
		
		cbPesquisarPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtBusca.setEditable(true);
				String cb = cbPesquisarPor.getSelectedItem().toString();

				if (txtBusca.getText() == null) {
					filtrarCliente("select * from cliente");
				}

				if (cb.equals("-- selecione --")) {
					txtBusca.setEditable(false);
					txtBusca.setText("");
				}

				if (cb == "Reg. Cliente") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarCliente(
										"select * from cliente where registro_cliente like '" + txtBusca.getText() + "%'");
							}
						}
					});
				}

				if (cb == "Cep") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarCliente("select * from cliente where cep like '" + txtBusca.getText() + "%'");
							}
						}
					});
				}
				if (cb == "Tipo") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarCliente(
										"select * from cliente where tipo like '" + txtBusca.getText() + "%'");
							}
						}
					});
				}
				if (cb == "Nome") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarCliente(
										"select * from cliente where nome like '" + txtBusca.getText() + "%'");
							}
						}
					});
				}
				if (cb == "Sexo") {
					txtBusca.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (txtBusca.getText() != null) {
								filtrarCliente("select * from cliente where sexo like '" + txtBusca.getText() + "%'");
							}
						}
					});
				}
			}
		});
	}
}