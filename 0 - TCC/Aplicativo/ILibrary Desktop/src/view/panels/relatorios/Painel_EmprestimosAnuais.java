package view.panels.relatorios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.Grafico;
import net.miginfocom.swing.MigLayout;
import persist.jdbc.JDBCRelatorio;

@SuppressWarnings("serial")
public class Painel_EmprestimosAnuais extends JPanel {

	private DefaultTableModel modeloCliente;
	
	private JButton btnExibirGrafico;
	private JLabel lblTabelaAnual;
	private JScrollPane spEmprestimoAnual;
	private JTable tblEmprestimoAnual;
	private JLabel lblIntervaloAnual;
	private JLabel lblAte;
	private JButton btnFiltrar;
	private JSpinner spinnerMin;
	private JSpinner spinnerMax;
	private JButton btnTodos;
	
	private SpinnerModel modelMin;
	private SpinnerModel modelMax;
	
	public static int ano_menor = 0;
	private int ano_maior = 0;
	private JLabel lblApresentaTotal;
	private JLabel lblTotalEmprestimos;
	
	public void carregarTabela() {
		
		ResultSet rsEmp = null;
		
		try {
			rsEmp = new JDBCRelatorio().read("select MIN(data_retirada) from emprestimo");
			if (rsEmp.getDate(1) != null) {
				int teste = Integer.parseInt(rsEmp.getDate(1).toString().substring(0, 4));
				ano_menor = teste;	
			}
			
			rsEmp = new JDBCRelatorio().read("select MAX(data_retirada) from emprestimo");
			if (rsEmp.getDate(1) != null) {
				int teste = Integer.parseInt(rsEmp.getDate(1).toString().substring(0, 4));
				ano_maior = teste;
			}
		} catch (SQLException e) {
			
		}
		
		Object[] valores = new Object[14];
		int total = 0;
		if (ano_menor != 0) {
			for (int i=ano_menor; i<=ano_maior; i++) {
				int total_anual = 0;
				int cont;
				valores[0] = i;
				for (int t=1; t<=12; t++) {	
					cont = 0;
					cont = new JDBCRelatorio().count("SELECT count(data_retirada) FROM emprestimo WHERE month(data_retirada) = '" + t + "' AND year(data_retirada) = '" + i +"'");
					valores[t] = cont;
					total_anual += cont;			
				}
				valores[13] = total_anual;
				total += total_anual;
				modeloCliente.addRow(valores);		
			}
		}
		lblApresentaTotal.setText(String.valueOf(total));
	}

	public Painel_EmprestimosAnuais() {

		this.setLayout(new MigLayout("", 
			"[50][80.00][][80][76.00][76][357.00][41.00][80.00][122.00][]", 
			"[28.00][][25][15][][][25][][][128.00][:59.00:108.00]"));

		modeloCliente = new DefaultTableModel();
		modeloCliente.addColumn("ANO");
		modeloCliente.addColumn("Jan");
		modeloCliente.addColumn("Fev");
		modeloCliente.addColumn("Mar");
		modeloCliente.addColumn("Abr");
		modeloCliente.addColumn("Mai");
		modeloCliente.addColumn("Jun");
		modeloCliente.addColumn("Jul");
		modeloCliente.addColumn("Ago");
		modeloCliente.addColumn("Set");
		modeloCliente.addColumn("Out");
		modeloCliente.addColumn("Nov");
		modeloCliente.addColumn("Dez");
		modeloCliente.addColumn("Total");
		
		tblEmprestimoAnual = new JTable(modeloCliente);
		tblEmprestimoAnual.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		tblEmprestimoAnual.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		tblEmprestimoAnual.getColumnModel().getColumn(0).setPreferredWidth(68);
		tblEmprestimoAnual.getColumnModel().getColumn(12).setCellRenderer(centralizado);
		tblEmprestimoAnual.getColumnModel().getColumn(12).setPreferredWidth(100);
		tblEmprestimoAnual.getColumnModel().getColumn(13).setCellRenderer(centralizado);
		tblEmprestimoAnual.getColumnModel().setColumnSelectionAllowed(false);
		
		tblEmprestimoAnual.setEditingRow(555);
		
		for (int i=1; i<13; i++) {
			tblEmprestimoAnual.getColumnModel().getColumn(i).setPreferredWidth(47);
			tblEmprestimoAnual.getColumnModel().getColumn(i).setCellRenderer(centralizado);
		}
		          
		lblIntervaloAnual = new JLabel("Indique o intervalo anual");
		this.add(lblIntervaloAnual, "cell 1 1 3 1");

		lblAte = new JLabel("Até");
		this.add(lblAte, "cell 2 2,alignx trailing");

		btnFiltrar = new JButton("Filtrar");
		this.add(btnFiltrar, "cell 4 2,grow");

		btnTodos = new JButton("Todos");
		this.add(btnTodos, "cell 5 2,grow");

		btnExibirGrafico = new JButton("Exibir Gráfico");
		btnExibirGrafico.setHorizontalAlignment(SwingConstants.LEFT);
		this.add(btnExibirGrafico, "cell 6 2,alignx right");

		lblTabelaAnual = new JLabel("Tabela Anual de Empréstimos");
		lblTabelaAnual.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblTabelaAnual, "cell 1 4 6 1,growx");

		spEmprestimoAnual = new JScrollPane();
		spEmprestimoAnual.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(spEmprestimoAnual, "cell 1 5 6 6,grow");
		
		spEmprestimoAnual.setViewportView(tblEmprestimoAnual);
		
		lblTotalEmprestimos = new JLabel("Total de Empréstimos:");
		this.add(lblTotalEmprestimos, "cell 8 5");
		
		lblApresentaTotal = new JLabel("");
		lblApresentaTotal.setFont(new Font("Dialog", Font.BOLD, 14));
		this.add(lblApresentaTotal, "cell 9 5");
		
		carregarTabela();
		spinnerMin = new JSpinner();
		this.add(spinnerMin, "cell 1 2,grow");
		
		spinnerMax = new JSpinner();
		this.add(spinnerMax, "cell 3 2,grow");
		
		modelMin = new SpinnerNumberModel(ano_menor, ano_menor, ano_maior, 1);
		modelMax = new SpinnerNumberModel(ano_maior, ano_menor, ano_maior, 1);
		
		spinnerMin.setModel(modelMin);
		spinnerMax.setModel(modelMax);
		
		if (ano_menor == 0) {
			spinnerMax.setEnabled(false);
			spinnerMin.setEnabled(false);
		}
										
		btnExibirGrafico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (ano_menor != 0) {
					int viewRow = tblEmprestimoAnual.getSelectedRow();
					
					double[] valores = new double[12];
					
					try {
						for (int i=1; i<=12; i++) {
							try {
								valores[i-1] = Double.parseDouble(tblEmprestimoAnual.getValueAt(viewRow, i).toString());
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}
										
						new Grafico(valores, tblEmprestimoAnual.getValueAt(viewRow, 0).toString());
					} catch (ArrayIndexOutOfBoundsException e1) {
						JOptionPane.showMessageDialog(null, "Selecione uma linha da tablela", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		btnFiltrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (ano_menor != 0) {
					modeloCliente.setNumRows(0);
					Object[] valores = new Object[14];
					for (int i=Integer.parseInt(spinnerMin.getValue().toString()); i<=Integer.parseInt(spinnerMax.getValue().toString()); i++) {
						int total_anual = 0;
						int cont;
						valores[0] = i;
						for (int t=1; t<=12; t++) {	
							cont = 0;
							cont = new JDBCRelatorio().count("SELECT count(data_retirada) FROM devolucao WHERE month(data_retirada) = '" + t + "' AND year(data_retirada) = '" + i +"'");
							cont += new JDBCRelatorio().count("SELECT count(data_retirada) FROM emprestimo WHERE month(data_retirada) = '" + t + "' AND year(data_retirada) = '" + i +"'");
							valores[t] = cont;
							total_anual += cont;			
						}
						valores[13] = total_anual;
						modeloCliente.addRow(valores);		
					}	
				} 				
			}
		});
		
		btnTodos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				modeloCliente.setNumRows(0);
				carregarTabela();
				
				if (ano_menor != 0) {
					modelMin = new SpinnerNumberModel(ano_menor, ano_menor, ano_maior, 1);
					modelMax = new SpinnerNumberModel(ano_maior, ano_menor, ano_maior, 1);
					spinnerMin.setModel(modelMin);
					spinnerMax.setModel(modelMax);
					spinnerMax.setEnabled(true);
					spinnerMin.setEnabled(true);
				}
				
			}
		});

	}
}