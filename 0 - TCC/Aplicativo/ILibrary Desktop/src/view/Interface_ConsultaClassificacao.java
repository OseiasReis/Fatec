package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import model.Classificacao;
import persist.JDBCDAO;

@SuppressWarnings("serial")
public class Interface_ConsultaClassificacao extends JFrame {
	
	private JTable tblClassificacao;
	private DefaultTableModel modelClassificacao;
	private JLabel lblOrdenarPor;
	@SuppressWarnings("rawtypes")
	private JComboBox cbOrdenarPor;
	private JScrollPane scrollPaneClassificacao;
	private ImageIcon icone;
	private JLabel lblTitulo;
	
	private void uploadTable(String ordenar) {
		modelClassificacao.setNumRows(0);
		ArrayList<Classificacao> lista_classificacoes = new JDBCDAO<Classificacao, String>(Classificacao.class).readAll("select * from classificacao order by " + ordenar);
		if (lista_classificacoes != null) {
			for (Classificacao c : lista_classificacoes) {
				modelClassificacao.addRow(new Object[] { c.getCod_classificacao(), c.getAssunto() });
			}
		}
	}
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Interface_ConsultaClassificacao(JTextField codClassificacao, JTextField assunto) {
		
		super("..::     Consulta Classificação     ::..");
		setSize(541, 455);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		icone = new ImageIcon("images/logotitulo.png");
		setIconImage(icone.getImage());
		
		lblOrdenarPor = new JLabel("Ordenar Por:");
		lblOrdenarPor.setBounds(26, 78, 103, 15);
		getContentPane().add(lblOrdenarPor);
		
		cbOrdenarPor = new JComboBox();
		cbOrdenarPor.setBounds(26, 101, 149, 24);
		getContentPane().add(cbOrdenarPor);
		cbOrdenarPor.addItem("Assunto");
		cbOrdenarPor.addItem("Código");
		
		scrollPaneClassificacao = new JScrollPane();
		scrollPaneClassificacao.setBounds(26, 137, 486, 261);
		getContentPane().add(scrollPaneClassificacao);
		scrollPaneClassificacao.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneClassificacao.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		modelClassificacao = new DefaultTableModel();
		modelClassificacao.addColumn("Código");
		modelClassificacao.addColumn("Assunto");
				
		tblClassificacao = new JTable(modelClassificacao);
		scrollPaneClassificacao.setViewportView(tblClassificacao);
		tblClassificacao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblClassificacao.setRowHeight(20);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.setBounds(430, 101, 82, 25);
		getContentPane().add(btnAplicar);
		
		lblTitulo = new JLabel("CONSULTA CLASSIFICAÇÃO");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(26, 12, 486, 54);
		getContentPane().add(lblTitulo);
		
		tblClassificacao.getColumnModel().getColumn(0).setPreferredWidth(150);
		tblClassificacao.getColumnModel().getColumn(1).setPreferredWidth(318);
		
		uploadTable("assunto");
		
		cbOrdenarPor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbOrdenarPor.getSelectedItem().toString().equals("Código")) {
					uploadTable("cod_classificacao");
				} else if (cbOrdenarPor.getSelectedItem().toString().equals("Assunto")) {
					uploadTable("assunto");
				}
			}
		});
		
		btnAplicar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					codClassificacao.setText(modelClassificacao.getValueAt(tblClassificacao.getSelectedRow(), 0).toString());
					assunto.setText(modelClassificacao.getValueAt(tblClassificacao.getSelectedRow(), 1).toString());
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
