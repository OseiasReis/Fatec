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
import model.Devolucao;
import model.Emprestimo;
import net.miginfocom.swing.MigLayout;
import persist.JDBCDAO;

@SuppressWarnings("serial")
public class Painel_RelatorioDevolucoes extends JPanel {
	
	private JLabel lblFiltrar;
	private JLabel lblTotalDeRegistros;
	private JLabel lblOrdenarPor;
	
	private JTextField txtFiltro;
	@SuppressWarnings("rawtypes")
	private JComboBox cbFiltrarPor;
	@SuppressWarnings("rawtypes")
	private JComboBox cbOrdenarPor;
	
	private DefaultTableModel modeloDevolucoes;
	private JTable tblDevolucoes;
	private JScrollPane scrollTabela;
	
	private String ordenarPor = "data_retirada";

	private void carregarTable(String sql) {
		modeloDevolucoes.setNumRows(0);
		
		ArrayList<Devolucao> list_devolucoes =  (ArrayList<Devolucao>) ((new JDBCDAO<Devolucao, String>(Devolucao.class)).readAll(sql));
		Emprestimo emprestimo;
		
		String  terminoSuspensao;
		String multa;
		if (list_devolucoes != null) {
			for (Devolucao e : list_devolucoes) {
				emprestimo = new JDBCDAO<Emprestimo, String>(Emprestimo.class).read(e.getCod_emprestimo());
				e.setEmprestimo(emprestimo);
				
				if (e.getTermino_suspensao().equals(e.getData_entrega())) {
					terminoSuspensao = "N/D";
				} else {
					terminoSuspensao = e.getTermino_suspensao();
				}
				
				if (e.getPreco_multa() != 0.0) {
					multa ="R$ " + String.format("%.2f", e.getPreco_multa());
				} else {
					multa = "N/D";
				}
				
				modeloDevolucoes.addRow(new Object[] {e.getCod_emprestimo(), 
					e.getEmprestimo().getRegistro_cliente(),
					e.getEmprestimo().getCod_exemplar(), 
					e.getEmprestimo().getRegistro_operador(), 
					e.getEmprestimo().getData_retirada(), 
					e.getEmprestimo().getHora_retirada(), 
					e.getEmprestimo().getData_devolucao(), 
					e.getRegistro_operador(),
					e.getData_entrega(), 
					e.getHora_entrega(), 
					terminoSuspensao, 
					multa});	
			}
		}
				
		tblDevolucoes.removeAll();
		tblDevolucoes.repaint();
		lblTotalDeRegistros.setText("Total de Registros: " + modeloDevolucoes.getRowCount());	
	}
	
	private void filtrar() {
		String sql;
		switch(cbFiltrarPor.getSelectedItem().toString()) {
		
		case "Registro Cliente":
			sql = "select * from devolucao INNER JOIN emprestimo ON devolucao.cod_emprestimo=emprestimo.cod_emprestimo where emprestimo.registro_cliente like '" + txtFiltro.getText() + "%' order by " + ordenarPor;
			carregarTable(sql);
			break;
						
		case "Cod. Exemplar":
			sql = "select * from devolucao INNER JOIN emprestimo ON devolucao.cod_emprestimo=emprestimo.cod_emprestimo where emprestimo.cod_exemplar like '" + txtFiltro.getText() + "%' order by " + ordenarPor;
			carregarTable(sql);
			break;
			
		case "Operador Empréstimo":
			sql = "select * from devolucao INNER JOIN emprestimo ON devolucao.cod_emprestimo=emprestimo.cod_emprestimo where emprestimo.registro_operador like '" + txtFiltro.getText() + "%' order by " + ordenarPor;
			carregarTable(sql);
			break;
			
		case "Operador Devolução":
			sql = "select * from devolucao INNER JOIN emprestimo ON devolucao.cod_emprestimo=emprestimo.cod_emprestimo where devolucao.registro_operador like '" + txtFiltro.getText() + "%' order by " + ordenarPor;
			carregarTable(sql);
			break;
		}
	}
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_RelatorioDevolucoes() {
		
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
		cbFiltrarPor.addItem("Operador Empréstimo");
		cbFiltrarPor.addItem("Operador Devolução");
		
		cbOrdenarPor = new JComboBox();
		this.add(cbOrdenarPor, "cell 4 2,grow");
		
		cbOrdenarPor.addItem("Registro Cliente");
		cbOrdenarPor.addItem("Cod. Exemplar");
		cbOrdenarPor.addItem("Operador Empréstimo");
		cbOrdenarPor.addItem("Operador Devolução");
		cbOrdenarPor.addItem("Data Retirada");
		cbOrdenarPor.addItem("Data Devolução");
		cbOrdenarPor.addItem("Data Entrega");
		cbOrdenarPor.addItem("Término Suspensão");

		modeloDevolucoes = new DefaultTableModel();
		modeloDevolucoes.addColumn("Cod. Empréstimo");
		modeloDevolucoes.addColumn("Registro Cliente");
		modeloDevolucoes.addColumn("Cod. Exemplar");
		modeloDevolucoes.addColumn("Operador Emp");
		modeloDevolucoes.addColumn("Data Retirada");
		modeloDevolucoes.addColumn("Hora Retirada");
		modeloDevolucoes.addColumn("Data Devoluçao");
		modeloDevolucoes.addColumn("Operador Dev");
		modeloDevolucoes.addColumn("Data Entrega");
		modeloDevolucoes.addColumn("Hora Entrega");
		modeloDevolucoes.addColumn("Término Suspensão");
		modeloDevolucoes.addColumn("Preço Multa");
				
		tblDevolucoes = new JTable(modeloDevolucoes);
		tblDevolucoes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tblDevolucoes.getColumnModel().getColumn(0).setPreferredWidth(120);
		tblDevolucoes.getColumnModel().getColumn(1).setPreferredWidth(120);
		tblDevolucoes.getColumnModel().getColumn(2).setPreferredWidth(120);
		tblDevolucoes.getColumnModel().getColumn(3).setPreferredWidth(125);
		tblDevolucoes.getColumnModel().getColumn(4).setPreferredWidth(130);
		tblDevolucoes.getColumnModel().getColumn(5).setPreferredWidth(130);
		tblDevolucoes.getColumnModel().getColumn(6).setPreferredWidth(130);
		tblDevolucoes.getColumnModel().getColumn(7).setPreferredWidth(130);
		tblDevolucoes.getColumnModel().getColumn(8).setPreferredWidth(130);
		tblDevolucoes.getColumnModel().getColumn(9).setPreferredWidth(130);
		tblDevolucoes.getColumnModel().getColumn(10).setPreferredWidth(130);
		tblDevolucoes.getColumnModel().getColumn(11).setPreferredWidth(130);
		
		txtFiltro = new JTextField();
		this.add(txtFiltro, "cell 1 3 2 1,grow");
		txtFiltro.setColumns(10);
		
		lblTotalDeRegistros = new JLabel("Total de Registros: 0");
		add(lblTotalDeRegistros, "cell 5 3,alignx right");
				
		scrollTabela = new JScrollPane();
		this.add(scrollTabela, "cell 1 5 5 1,grow");
		scrollTabela.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollTabela.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTabela.setViewportView(tblDevolucoes);
		
		carregarTable("select devolucao.* from devolucao INNER JOIN emprestimo ON devolucao.cod_emprestimo=emprestimo.cod_emprestimo order by emprestimo.data_retirada");
				
		cbOrdenarPor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch(cbOrdenarPor.getSelectedItem().toString()) {
					
				case "Registro Cliente":
					ordenarPor = "registro_cliente";
					break;
					
				case "Cod. Exemplar":
					ordenarPor = "cod_exemplar";
					break;
					
				case "Operador Empréstimo":
					ordenarPor = "emprestimo.registro_operador";
					break;
					
				case "Operador Devolução":
					ordenarPor = "devolucao.registro_operador";
					break;
					
				case "Data Retirada":
					ordenarPor = "data_retirada";
					break;
									
				case "Data Devolução":
					ordenarPor = "data_devolucao";
					break;
					
				case "Data Entrega":
					ordenarPor = "data_entrega";
					break;	
				
				case "Término Suspensão":
					ordenarPor = "termino_susp";
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
