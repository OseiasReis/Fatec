package reg_cliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Mov_Cliente extends JPanel{
	
	private DefaultTableModel modeloConta;
	//- Gravar também o cadastro de movimento com 10 registros com código conta,valor do movimento, tipo de movimento e statusM;
	private String[] colunas = {"Cod. Conta", "Tipo Mov.", "Valor Mov.", "Status Mov."};
	private String[][] linhas;
	
	private JTable tblContaM;
	
	private JScrollPane scrollPane;
	
	private JLabel lblTitulo, lblCodigo;
	
	private JTextField txtCodigo;
	
	private JButton btnVerificar;
	
	public Mov_Cliente() {
		
		this.setLayout(null);
		this.setSize(678, 654);
		this.setVisible(true);
		
		linhas = new String[10][4];
		
		lblTitulo = new JLabel("Movimento"); 	 	  lblTitulo.setFont(new Font("Script MT Bold", Font.BOLD, 60));
		lblCodigo = new JLabel("Cod. Conta");         lblCodigo.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		txtCodigo = new JTextField("");
		
		btnVerificar = new JButton("Verificar");
		
		modeloConta = new DefaultTableModel();
		tblContaM = new JTable(linhas, colunas);
		tblContaM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblContaM.getColumnModel().getColumn(0).setPreferredWidth(90);
		tblContaM.getColumnModel().getColumn(1).setPreferredWidth(150);
		tblContaM.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblContaM.getColumnModel().getColumn(3).setPreferredWidth(95);
		tblContaM.setRowHeight(25);
		tblContaM.setEnabled(false);
		//tblContaM.setAutoCreateRowSorter(true);
		
		scrollPane = new JScrollPane(tblContaM);
		scrollPane.setBounds(57, 188, 438, 277);
		add(scrollPane);
		
		add(lblTitulo);
		lblTitulo.setBounds(123, 31, 315, 50);
		
		add(lblCodigo);
		lblCodigo.setBounds(215, 107, 113, 20);
		
		add(txtCodigo);
		txtCodigo.setBounds(221, 138, 78, 20);
		
		add(btnVerificar);
		btnVerificar.setBounds(307, 137, 86, 23);
		btnVerificar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String codigo = txtCodigo.getText();
				File arquivo = new File("Movimento/" + codigo + ".txt");
					if(arquivo.exists()){
						try {
							alterarTabela(codigo);
							repaint();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}else{					
						JOptionPane.showMessageDialog(null, "Código inexistente ou sem movimentação!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
		});
		
	}
		public void alterarTabela(String codigo) throws IOException{
			File inf = new File("Movimento/" + codigo + ".txt");
			BufferedReader buffer;
			FileReader reader;
			reader = new FileReader(inf);
			buffer = new BufferedReader(reader);
			int i = 0;
			int j = 0;
			String linha = "1";
			while(i<=9){
				j=0;
				linhas[i][j] = ""; j++;
				linhas[i][j] = ""; j++;
				linhas[i][j] = ""; j++;
				linhas[i][j] = ""; //limpar linhas da tebala
				i++;
			};
			i = 0;
			j = 0;
			while((linha = buffer.readLine()) != null){
				j=0;
				linhas[i][j] = buffer.readLine(); j++;
				linhas[i][j] = buffer.readLine(); j++;
				linhas[i][j] = buffer.readLine(); j++;
				linhas[i][j] = buffer.readLine();
				i++;
			};
			buffer.close();
			reader.close();
			
			//tblContaM = new JTable();
		}
}
