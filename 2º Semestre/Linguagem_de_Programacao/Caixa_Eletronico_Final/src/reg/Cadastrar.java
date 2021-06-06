package reg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Canvas;

public class Cadastrar extends JPanel{
	
	private JLabel lblTitulo, lblSenha, lblSenhaN, lblNome, lblCodigo, lblale, lblTipo, lblSaldo, lblLim;
	
	private JTextField txtSenha, txtSenhaN, txtNome, txtCodigo, txtSaldo, txtLim;
	
	private JButton btnCadastrar, btnValidar, btnApagar;
	
	private JComboBox cboTipo;
	
	private boolean validacao;
	
	private Canvas canvas_1, canvas_2, canvas_3;
		
	public Cadastrar(){
		
		//Color azul = new Color(1, 190, 254);
		lblTitulo = new JLabel("Cadastrar");          lblTitulo.setFont(new Font("Script MT Bold", Font.BOLD, 70));  //lblTitulo.setForeground(azul);
		lblSenha = new JLabel("Senha:");              lblSenha.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblSenhaN = new JLabel("Confirme a Senha:");  lblSenhaN.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblNome = new JLabel("Nome:");                lblNome.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblCodigo = new JLabel("Gerar Codigo");       lblCodigo.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblSaldo = new JLabel("Saldo:");              lblSaldo.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblLim = new JLabel("Limite:");               lblLim.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		lblTipo = new JLabel("Tipo de conta:");       lblTipo.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		
		btnCadastrar = new JButton ("Cadastrar");    btnCadastrar.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnValidar = new JButton ("Validar");        btnValidar.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnApagar = new JButton ("Apagar");          btnApagar.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		
		lblale = new JLabel();                       lblale.setIcon(new ImageIcon("Imagens/aleatoria.png"));
	
		txtSaldo = new JTextField();
		txtLim = new JTextField();
		txtNome = new JTextField();
		txtCodigo = new JTextField();
		txtSenha = new JPasswordField();
		txtSenhaN = new JPasswordField();
		
		cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] { "-- selecione --", "Física", "Conjunta", "Jurídica", "Especial"}));
		
		//lblLogo.setIcon(new ImageIcon("Imagens/prancheta.png"));
		
		this.setLayout(null);
		this.setSize(600, 700);
		this.setVisible(true);
		
		this.add(lblTitulo);
		lblTitulo.setBounds(103, 33, 341, 51);
		
		lblCodigo.setBounds(108, 117, 125, 30);
		add(lblCodigo);
		
		add(txtCodigo);
		txtCodigo.setBounds(110, 148, 64, 20);
		txtCodigo.setEditable(false);
		
		this.add(lblNome);
		lblNome.setBounds(110, 180, 80, 20);
		this.add(txtNome);
		txtNome.setBounds(109, 205, 300, 20);
		txtNome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//txtNome.setText(txtNome.getText());
			}
		});
		
		this.add(lblSenha);
		lblSenha.setBounds(110, 240, 80, 20);
		this.add(txtSenha);
		txtSenha.setBounds(110, 265, 180, 20);
		
		this.add(lblSenhaN);
		lblSenhaN.setBounds(110, 300, 180, 22);
		this.add(txtSenhaN);
		txtSenhaN.setBounds(110, 325, 180, 20);
		
		this.add(lblSaldo);
		lblSaldo.setBounds(110, 365, 180, 22);
		this.add(txtSaldo);
		txtSaldo.setBounds(110, 390, 180, 20);
		
		this.add(lblLim);
		lblLim.setBounds(110, 421, 180, 22);
		this.add(txtLim);
		txtLim.setBounds(110, 444, 180, 20);
		
		add(lblTipo);
		lblTipo.setBounds(295, 123, 140, 18);
		
		add(cboTipo);
		cboTipo.setBounds(295, 148, 125, 20);
		cboTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cb = cboTipo.getSelectedItem().toString();
				if (cb.equals("-- selecione --")) {
					JOptionPane.showMessageDialog(null, "Erro! Escolha o tipo de conta", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		add(lblale);
		lblale.setBounds(186, 148, 34, 20);
		lblale.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent a) {
				Random r = new Random();
				int ra= r.nextInt(8999)+1000;
				txtCodigo.setText(String.valueOf(ra));
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent arg0) {
			}			
		});
		
		this.add(btnValidar);
		btnValidar.setBounds(44, 523, 144, 40);
		btnValidar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String codigo = txtCodigo.getText();
				String nome = txtNome.getText();
				String senha = txtSenha.getText();
				String senhaN = txtSenhaN.getText();
				String saldo = txtSaldo.getText();
				String lim = txtLim.getText();
				String cb = cboTipo.getSelectedItem().toString();
				if(senha.isEmpty() || senhaN.isEmpty() || nome.isEmpty() || codigo.isEmpty() || cb.equals("-- selecione --") || saldo.isEmpty() || lim.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
				}else{
					if(!senha.equals(senhaN)){
						JOptionPane.showMessageDialog(null, "Ambas as senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE); 
					}else{File arquivo = new File("Pessoa/" + codigo + ".txt");
							if(arquivo.exists()){
								JOptionPane.showMessageDialog(null, "O código já foi cadastradom, mudeo", "Erro", JOptionPane.ERROR_MESSAGE);
							}else{					
								txtNome.setEditable(false);
								txtSenha.setEditable(false);
								txtSenhaN.setEditable(false);
								btnValidar.setEnabled(false);
								cboTipo.setEnabled(false);
								txtSaldo.setEditable(false);
								txtLim.setEditable(false);
								JOptionPane.showMessageDialog(null, "Validado com sucesso!");
								validacao = true;
							}
						}
					}
			}
		});
		
		this.add(btnCadastrar);
		btnCadastrar.setBounds(217, 523, 146, 40);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			
				if(!validacao == true){
					JOptionPane.showMessageDialog(null, "Erro! Digite e valide todos os campos obrigatórios", "Erro", JOptionPane.ERROR_MESSAGE);
				}else{
					String codigo = txtCodigo.getText();
					String nome = txtNome.getText();
					String senha = txtSenha.getText();
					String senhaN = txtSenhaN.getText();
					String tipo = cboTipo.getSelectedItem().toString();
					String saldo = txtSaldo.getText();
					String limite = txtLim.getText();
									
					JOptionPane.showMessageDialog(null, "Obrigado " + txtNome.getText() + ", você foi cadastrado");
					
					File arquivo = new File("Pessoa/" + codigo + ".txt");
					
					try( FileWriter fw = new FileWriter(arquivo, false) ){
					    fw.write(codigo);
					    fw.write("\r\n");
					    fw.write(nome);
					    fw.write("\r\n");
					    fw.write(senha);
					    fw.write("\r\n");
					    fw.write(senhaN);
					    fw.write("\r\n");
					    fw.write(tipo);
					    fw.write("\r\n");
					    fw.write(saldo);
					    fw.write("\r\n");
					    fw.write(limite);
					    fw.flush();
					    fw.close();
					    
					}catch(IOException ex){
					  ex.printStackTrace();
					}
					//dispose();
				}	
			}
		});
		
		this.add(btnApagar);
		btnApagar.setBounds(392, 523, 130, 40);
		btnApagar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int Apagar;
				
				Apagar = JOptionPane.showConfirmDialog(null, "Você deseja realmente Apagar?","Confirmação",JOptionPane.YES_NO_OPTION);
				
				if(Apagar == 0){
					txtCodigo.setText("");
					txtNome.setText("");
					txtSenha.setText("");
					txtSenhaN.setText("");
					txtNome.setText("");
					txtSaldo.setText("");
					txtLim.setText("");
					txtNome.setEditable(true);
					txtSenha.setEditable(true);
					txtSenhaN.setEditable(true);
					txtSaldo.setEditable(true);
					txtLim.setEditable(true);
					btnValidar.setEnabled(true);
					cboTipo.setEnabled(true);
					validacao = false;
				}
			}
		});
		
		Canvas canvas = new Canvas();
		canvas = new Canvas();
		canvas.setBackground(Color.GRAY);
		canvas.setBounds(10, 10, 3, 612);
		add(canvas);
		canvas_1 = new Canvas();
		canvas_1.setBackground(Color.GRAY);
		canvas_1.setBounds(10, 619, 565, 3);
		add(canvas_1);
		canvas_2 = new Canvas();
		canvas_2.setBackground(Color.GRAY);
		canvas_2.setBounds(10, 10, 565, 3);
		add(canvas_2);
		canvas_3 = new Canvas();
		canvas_3.setBackground(Color.GRAY);
		canvas_3.setBounds(575, 10, 3, 612);
		add(canvas_3);
		
	}
}
