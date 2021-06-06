package reg;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.TextField;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JRadioButton;

public class Movimentacao extends JPanel{
	private JLabel lblTipo, lblCodigo, lblValorM, lblStatusM, lblTitulo, lblSenha;
	
	private TextField txtCodigo, txtValorM;

	private JPasswordField txtSenha;
	
	private JButton btnEnviar, btnApagar;
	
	private JRadioButton[] statusM;
	
	private JComboBox cboTipo;
	
	private ButtonGroup group;
	
	private Canvas canvas_1, canvas_2, canvas_3;
	
	private int valorl;
	
	public Movimentacao() {
		
		this.setLayout(null);
		this.setSize(600, 650);
		this.setVisible(true);
		
		//Color azul = new Color(1, 190, 254);
		lblTipo = new JLabel("Tipo de Movimento");    lblTipo.setFont(new Font("Script MT Bold", Font.BOLD, 20));     
		lblCodigo = new JLabel("Cod. Conta");         lblCodigo.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblValorM = new JLabel("Valor de Movimento:");lblValorM.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblStatusM = new JLabel("Status:");           lblStatusM.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblSenha = new JLabel("Senha");               lblSenha.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblTitulo = new JLabel("Movimento");          lblTitulo.setFont(new Font("Script MT Bold", Font.BOLD, 60));
		
		btnEnviar = new JButton("Efetuar");           btnEnviar.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnApagar = new JButton ("Apagar");           btnApagar.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		
		txtCodigo = new TextField("");
		txtValorM = new TextField("");
		txtSenha = new JPasswordField();
		
		statusM = new JRadioButton[2];
		statusM[0] = new JRadioButton ("1");
		statusM[1] = new JRadioButton ("2");
		
		group = new ButtonGroup();
		group.add(statusM[0]);
		group.add(statusM[1]);
		
		cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] { "-- selecione --", "Crédito", "Débito"}));
		
		add(cboTipo);
		cboTipo.setBounds(180, 230, 105, 22);
		cboTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cb = cboTipo.getSelectedItem().toString();
				if (cb.equals("-- selecione --")) {
					JOptionPane.showMessageDialog(null, "Erro! Escolha o tipo de conta", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		add(lblTipo);
		lblTipo.setBounds(180, 205, 180, 22);
		
		add(lblSenha);
		lblSenha.setBounds(180, 275, 105, 22);
		
		add(txtSenha);
		txtSenha.setBounds(180, 300, 125, 22);
		
		lblCodigo.setBounds(180, 135, 180, 22);
		add(lblCodigo);
		
		txtCodigo.setBounds(180, 160, 105, 20);
		add(txtCodigo);
		
		lblValorM.setBounds(180, 345, 195, 22);
		add(lblValorM);
		
		txtValorM.setBounds(180, 370, 125, 22);
		add(txtValorM);
		
		lblStatusM.setBounds(180, 415, 69, 22);
		add(lblStatusM);
		
		statusM[0].setBounds(252, 415, 33, 22);
		add(statusM[0]);
		
		statusM[1].setBounds(287, 415, 33, 22);
		add(statusM[1]);
		
		lblTitulo.setBounds(132, 26, 328, 72);
		add(lblTitulo);
		
		this.add(btnApagar);
		btnApagar.setBounds(294, 485, 130, 40);
		btnApagar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int apagar;
				
				apagar = JOptionPane.showConfirmDialog(null, "Você deseja realmente Apagar?","Confirmação",JOptionPane.YES_NO_OPTION);
				
				if(apagar == 0){
					txtCodigo.setText("");
					txtValorM.setText("");
					txtSenha.setText("");
				}
			}
		});
		
		add(btnEnviar);
		btnEnviar.setBounds(140, 485, 125, 40);
		btnEnviar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String codigoM = txtCodigo.getText();
				String tm = cboTipo.getSelectedItem().toString();
				String valorM = txtValorM.getText();
				String senha = txtSenha.getText();
				String status;
				if(statusM[0].isSelected())
					status = "1";
				else{ 
					if(statusM[1].isSelected())
						status = "2";
					else
						status = "null";
				}
				if(codigoM.isEmpty() || tm.equals("-- selecione --") || valorM.isEmpty() || senha.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
				}else{
					if(status == "null"){
						JOptionPane.showMessageDialog(null, "Status inválido!", "Erro", JOptionPane.ERROR_MESSAGE); 
					}else{File arquivo = new File("Pessoa/" + codigoM + ".txt");
							if(arquivo.exists()){
								BufferedReader buffer;
								String senhap = "";
								String saldop = "";
								String valorlim = "";
								try {
									buffer = new BufferedReader(new FileReader(arquivo));
									senhap = buffer.readLine();
									senhap = buffer.readLine();
									senhap = buffer.readLine();
									saldop = buffer.readLine();
									saldop = buffer.readLine();
									saldop = buffer.readLine();
									valorlim = buffer.readLine();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								if(senha.equals(senhap)){
									int saldo = Integer.valueOf(saldop);
									int valormo = Integer.valueOf(valorM);
									int valorli = Integer.valueOf(valorlim);
									
									if(tm.equals("Débito")){
										if(status == "1") {
											if(valormo < saldo) {
												valormo = saldo - valormo;
												gravar();
												try {
													attSaldoP(valormo);
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												JOptionPane.showMessageDialog(null, "Movimentado com sucesso!");
											}else {
												JOptionPane.showMessageDialog(null, "Valor de movimento maior que o valor limite!", "Erro", JOptionPane.ERROR_MESSAGE);
											}
										}else {
											// status = 2
											if(valormo > saldo) {
												String cb = cboTipo.getSelectedItem().toString();
												if (cb == "Física") {
													valorl = 0;
												}
												if (cb == "Conjunta") {
													valorl = valorli;
												}
												if (cb == "Jurídica") {
													valorl = valorli + ((saldo*50)/100);
												}
												if (cb == "Especial") {
													valorl = valorli + saldo;
												}
												if(valormo < valorl) {
													valormo = saldo - valormo;
													gravar();
													try {
														attSaldoP(valormo);
													} catch (IOException e1) {
														e1.printStackTrace();
													}
													JOptionPane.showMessageDialog(null, "Movimentado com sucesso!");
												}else {
													JOptionPane.showMessageDialog(null, "Valor de movimento maior que o valor limite!", "Erro", JOptionPane.ERROR_MESSAGE);
												}
											}else {
												valormo = saldo - valormo;
												gravar();
											    try {
													attSaldoP(valormo);
												} catch (IOException e1) {
													e1.printStackTrace();
												}
											    JOptionPane.showMessageDialog(null, "Movimentado com sucesso!");
											}
										}
									}else{
										if (tm.equals("Crédito")){
											valormo = saldo + valormo;
											gravar();
										    try {
												attSaldoP(valormo);
											} catch (IOException e1) {
												e1.printStackTrace();
											}
										    JOptionPane.showMessageDialog(null, "Movimentado com sucesso!");
										}
									}
									
								}else{
									JOptionPane.showMessageDialog(null, "Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
								}
							}else{					
								JOptionPane.showMessageDialog(null, "Código incorreto!", "Erro", JOptionPane.ERROR_MESSAGE);
								//JOptionPane.showMessageDialog(null, "Validado com sucesso!");
						}
					}
				}
			}
		});
		
		Canvas canvas = new Canvas();
		canvas = new Canvas();
		canvas.setBackground(Color.GRAY);
		canvas.setBounds(66, 10, 3, 612);
		add(canvas);
		canvas_1 = new Canvas();
		canvas_1.setBackground(Color.GRAY);
		canvas_1.setBounds(66, 619, 435, 3);
		add(canvas_1);
		canvas_2 = new Canvas();
		canvas_2.setBackground(Color.GRAY);
		canvas_2.setBounds(66, 10, 435, 3);
		add(canvas_2);
		canvas_3 = new Canvas();
		canvas_3.setBackground(Color.GRAY);
		canvas_3.setBounds(498, 10, 3, 612);
		add(canvas_3);
	}
	
	public void gravar() {
			String codigoM = txtCodigo.getText();
			String tm = cboTipo.getSelectedItem().toString();
			String valorM = txtValorM.getText();
			String status;
			if(statusM[0].isSelected())
				status = "1";
			else{ 
				if(statusM[1].isSelected())
					status = "2";
				else
					status = "null";
			}
			
			File arquivo = new File("Movimento/" + codigoM + ".txt");
			int pular = 0;
			if(arquivo.exists()){
				pular = 1;
			}
			try( FileWriter fw = new FileWriter(arquivo, true) ){
				if(pular == 1){
					fw.write("\r\n");
				}
				fw.write("\r\n");
			    fw.write(codigoM);
			    fw.write("\r\n");
			    fw.write(tm);
			    fw.write("\r\n");
			    fw.write(valorM);
			    fw.write("\r\n");
			    fw.write(status);
			    fw.flush();
			    fw.close();
			    
			}catch(IOException ex){
			  ex.printStackTrace();
			}
	}
	
	public void attSaldoP(int valormo) throws IOException {
		String codigoM = txtCodigo.getText();
		String s1="", s2="", s3="", s4="", s5="", s6="", s7="";
		String valorm = String.valueOf(valormo);
		BufferedReader buffer;
		
		File arquivo = new File("Pessoa/" + codigoM + ".txt");
		
		
		try { buffer = new BufferedReader(new FileReader(arquivo));
			//salvar tudo do txt
			s1 = buffer.readLine();
			s2 = buffer.readLine();
			s3 = buffer.readLine();
			s4 = buffer.readLine();
			s5 = buffer.readLine();
			s6 = buffer.readLine();
			s7 = buffer.readLine();
			buffer.close();
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
		
		try( BufferedWriter writer = new BufferedWriter(new FileWriter( arquivo ))){
			//escrever dnv, só que editado
			writer.write(s1);
		    writer.write("\r\n");
		    writer.write(s2);
		    writer.write("\r\n");
		    writer.write(s3);
		    writer.write("\r\n");
		    writer.write(s4);
		    writer.write("\r\n");
		    writer.write(s5);
		    writer.write("\r\n");
		    writer.write(valorm);
		    writer.write("\r\n");
		    writer.write(s7);
		    writer.flush();
		    writer.close();
		}catch(FileNotFoundException ex){
		  ex.printStackTrace();
		}
	}
}
