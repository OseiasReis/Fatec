package view.panels.relatorios;

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
import model.Emprestimo;
import net.miginfocom.swing.MigLayout;
import persist.JDBCDAO;

@SuppressWarnings("serial")
public class Painel_RelatorioEmprestimos extends JPanel {
	
	private DefaultTableModel modeloEmp;
	
	private JLabel lblFiltrar;
	private JLabel lblTotalDeRegistros;
	private JLabel lblOrdenarPor;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cbFiltrarPor;
	@SuppressWarnings("rawtypes")
	private JComboBox cbOrdenarPor;
	private JTextField txtFiltro;
	
	private JTable tblEmprestimo;	
	private JScrollPane scrollTabela;
	
	private String ordenarPor = "data_retirada";
	
	private void carregarTable(String sql) {
		modeloEmp.setNumRows(0);
		
		ArrayList<Emprestimo> list_emprestimos =  (ArrayList<Emprestimo>) ((new JDBCDAO<Emprestimo, String>(Emprestimo.class)).readAll(sql));
				
		if (list_emprestimos != null) {
			for (Emprestimo e : list_emprestimos) {
				modeloEmp.addRow(new Object[] {e.getCod_emprestimo(), e.getRegistro_cliente(), e.getCod_exemplar(), e.getRegistro_operador(), e.getData_retirada(), e.getHora_retirada(), e.getData_devolucao()});
			}
		}
		
		tblEmprestimo.removeAll();
		tblEmprestimo.repaint();
		lblTotalDeRegistros.setText("Total de Registros: " + modeloEmp.getRowCount());
			
	}
	
	private void filtrar() {
		
		String sql;
		switch(cbFiltrarPor.getSelectedItem().toString()) {
		
		case "Registro Cliente":
			sql="select * from emprestimo where registro_cliente like '" + txtFiltro.getText() + "%' and devolvido=false order by " + ordenarPor;
			carregarTable(sql);
			break;
			
		case "Cod. Exemplar":
			sql="select * from emprestimo where cod_exemplar like '" + txtFiltro.getText() + "%' and devolvido=false order by " + ordenarPor;
			carregarTable(sql);
			break;
			
		case "Registro Operador":
			sql="select * from emprestimo where registro_operador like '" + txtFiltro.getText() + "%' and devolvido=false order by " + ordenarPor;
			carregarTable(sql);
			break;
		}
	}
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_RelatorioEmprestimos() {
		
		setSize(1200, 600);
		
		this.setLayout(new MigLayout("", 
				"[45.00][194.00][57.00][59.00][194][545.00]", 
				"[45][][25.00][25][7][319.00]"));
		
		lblFiltrar = new JLabel("Filtrar por:");
		this.add(lblFiltrar, "cell 1 1,aligny center");
		
		lblOrdenarPor = new JLabel("Ordenar por:");
		add(lblOrdenarPor, "cell 4 1");
		
		cbFiltrarPor = new JComboBox();
		this.add(cbFiltrarPor, "cell 1 2,grow");
		cbFiltrarPor.addItem("Registro Cliente");
		cbFiltrarPor.addItem("Cod. Exemplar");
		cbFiltrarPor.addItem("Registro Operador");
		
		cbOrdenarPor = new JComboBox();
		this.add(cbOrdenarPor, "cell 4 2,grow");
		cbOrdenarPor.addItem("Registro Cliente");
		cbOrdenarPor.addItem("Cod. Exemplar");
		cbOrdenarPor.addItem("Registro Operador");
		cbOrdenarPor.addItem("Data Retirada");
		cbOrdenarPor.addItem("Data Devolução");
		
		modeloEmp = new DefaultTableModel();
		modeloEmp.addColumn("Cod. Empréstimo");
		modeloEmp.addColumn("Registro Cliente");
		modeloEmp.addColumn("Cod. Exemplar");
		modeloEmp.addColumn("Registro Operador");
		modeloEmp.addColumn("Data Retirada");
		modeloEmp.addColumn("Hora Retirada");
		modeloEmp.addColumn("Data Devoluçao");
				
		tblEmprestimo = new JTable(modeloEmp);
		tblEmprestimo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tblEmprestimo.getColumnModel().getColumn(0).setPreferredWidth(135);
		tblEmprestimo.getColumnModel().getColumn(1).setPreferredWidth(160);
		tblEmprestimo.getColumnModel().getColumn(2).setPreferredWidth(120);
		tblEmprestimo.getColumnModel().getColumn(3).setPreferredWidth(160);
		tblEmprestimo.getColumnModel().getColumn(4).setPreferredWidth(160);
		tblEmprestimo.getColumnModel().getColumn(5).setPreferredWidth(160);
		tblEmprestimo.getColumnModel().getColumn(6).setPreferredWidth(160);
		
		txtFiltro = new JTextField();
		this.add(txtFiltro, "cell 1 3 2 1,grow");
		txtFiltro.setColumns(10);
		
		lblTotalDeRegistros = new JLabel("Total de Registros: 0");
		add(lblTotalDeRegistros, "cell 5 3,alignx right");
				
		scrollTabela = new JScrollPane();
		this.add(scrollTabela, "cell 1 5 5 1,grow");
		scrollTabela.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollTabela.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTabela.setViewportView(tblEmprestimo);
		
		carregarTable("select * from emprestimo where devolvido=false order by data_retirada");
		
		cbOrdenarPor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch(cbOrdenarPor.getSelectedItem().toString()) {
				case "Data Retirada":
					ordenarPor = "data_retirada";
					break;
					
				case "Registro Cliente":
					ordenarPor = "registro_cliente";
					break;
					
				case "Cod. Exemplar":
					ordenarPor = "cod_exemplar";
					break;
					
				case "Registro Operador":
					ordenarPor = "registro_operador";
					break;
										
				case "Data Devolução":
					ordenarPor = "data_devolucao";
					break;
				}
				filtrar();
			}
		});
		
		txtFiltro.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				filtrar();
			}
		});
	}
}
