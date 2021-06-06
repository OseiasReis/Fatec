package ADM;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Func_Edit extends JFrame{
	
	private JLabel lblTitulo = new JLabel("Editar Funcionarios");
	private JLabel lblEmail = new JLabel("Email do Usuario:");
	private JLabel lblEmailC = new JLabel("Digite o Email Novamente:");
	private JLabel lblCpf = new JLabel("CPF:");
	private JLabel lblNome = new JLabel("Nome:");
	private JLabel lblEndereco = new JLabel("Endereço:");
	private JLabel lblBairro = new JLabel("Bairro:");
	private JLabel lblCep = new JLabel("Cep:");
	private JLabel lblCidade = new JLabel("Cidade:");
	private JLabel lblTelefoneR = new JLabel("Telefones:");
	private JLabel lblResidencia = new JLabel("R.");
	private JLabel lblTelefoneC = new JLabel("C.");
	private JLabel lblSexo = new JLabel("Sexo:");
	
	private JTextField txtEmail = new JTextField();
	private JTextField txtEmailC = new JTextField();
	private JTextField txtCpf;
	private JTextField txtNome = new JTextField();
	private JTextField txtEndereco = new JTextField();
	private JTextField txtBairro = new JTextField();
	private JTextField txtCep;
	private JTextField txtCidade = new JTextField();
	private JTextField txtTelefoneR;
	private JTextField txtTelefoneC;
	private JTextField txtReserva = new JTextField();
	private JTextField txtReserva1 = new JTextField();
	
	private JRadioButton[] rbSexo = new JRadioButton[2];
	private ButtonGroup group = new ButtonGroup();
	
	private JButton btnConcluir = new JButton("Concluir");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnValidar = new JButton("Validar");
	
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
	
	File arquivo = new File("Funcionarios/");
	
	ImageIcon icone = new ImageIcon("Imagens/anonimo.png");
	
	int validar;
	String email, emailn, senha, espaco, cpf, nome, endereco, bairro, cep, cidade, telefoner, telefonec, sexo;
	FileReader reader;
	BufferedReader buffer;
	FileWriter write;
	
	public Func_Edit(){
		super(".::ADM - Editar::.");
		
		btnConcluir.setEnabled(false);
		lblTitulo.setFont(new Font("Colonna MT", Font.BOLD, 32));
		Color azul = new Color(1, 190, 254);
		lblTitulo.setForeground(azul);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmailC.setFont(new Font("Arial", Font.BOLD, 14));
		lblCpf.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblBairro.setFont(new Font("Arial", Font.BOLD, 14));
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));
		lblCidade.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefoneR.setFont(new Font("Arial", Font.BOLD, 14));
		lblResidencia.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefoneC.setFont(new Font("Arial", Font.BOLD, 14));
		lblSexo.setFont(new Font("Arial", Font.BOLD, 14));
		btnValidar.setFont(new Font("Arial", Font.BOLD, 14));
		btnConcluir.setFont(new Font("Arial", Font.BOLD, 14));
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 14));
		
		rbSexo[0] = new JRadioButton("Masculino");
		rbSexo[1] = new JRadioButton("Feminino");
		group.add(rbSexo[0]);
		group.add(rbSexo[1]);
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
	
		setIconImage(icone.getImage());
		
		paine.add(lblTitulo);
		lblTitulo.setBounds(20, 20, 300, 30);
		
		paine.add(lblEmail);
		lblEmail.setBounds(20, 60, 150, 20);
		paine.add(txtEmail);
		txtEmail.setBounds(20, 80, 300, 20);
		
		paine.add(lblEmailC);
		lblEmailC.setBounds(20, 110, 250, 20);
		paine.add(txtEmailC);
		txtEmailC.setBounds(20, 130, 300, 20);
		
		txtNome.setEditable(false);
		txtEndereco.setEditable(false);
		txtBairro.setEditable(false);
		txtCidade.setEditable(false);
		rbSexo[0].setEnabled(false);
		rbSexo[1].setEnabled(false);
		
		paine.add(btnValidar);
		btnValidar.setBounds(100, 160, 110, 20); 
		btnValidar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				File arquivo = new File("Funcionarios/");
				
				String email = txtEmail.getText();
				String emailc = txtEmailC.getText();
				
				if(email.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
				}else{
					if(!email.equals(emailc)){
						JOptionPane.showMessageDialog(null, "Ambas os e-mails não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
					}else{
						File arquivoN = new File("Funcionarios/" + email + ".txt");
						if(email.equals(emailc) && arquivoN.exists()){
							btnValidar.setEnabled(false);
							JOptionPane.showMessageDialog(null, "Validado com sucesso!");
						
							arquivo = new File("Funcionarios/" + arquivo + ".txt");
					
							txtEmail.disable();
							txtEmailC.disable();
							txtCpf.setEditable(true);
							txtNome.setEditable(true);
							txtEndereco.setEditable(true);
							txtBairro.setEditable(true);
							txtCep.setEditable(true);
							txtCidade.setEditable(true);
							txtTelefoneR.setEditable(true);
							txtTelefoneC.setEditable(true);
							rbSexo[0].setEnabled(true);
							rbSexo[1].setEnabled(true);
							btnExcluir.setEnabled(true);
							btnConcluir.setEnabled(true);
				
							email = txtEmail.getText();
							arquivo = new File("Funcionarios/" + email + ".txt");
				
							try {
								reader = new FileReader(arquivo);
								buffer = new BufferedReader(reader);
					
								emailn = buffer.readLine();
								senha = buffer.readLine();
								espaco =buffer.readLine();
								cpf = buffer.readLine();
								nome = buffer.readLine();
								endereco = buffer.readLine();
								bairro = buffer.readLine();
								cep = buffer.readLine();
								cidade = buffer.readLine();
								telefoner = buffer.readLine();
								telefonec = buffer.readLine();
								sexo = buffer.readLine();
						
								buffer.close();
						
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							txtReserva.setText(emailn); 
							txtReserva1.setText(senha);
							txtCpf.setText(cpf);
							txtNome.setText(nome);
							txtEndereco.setText(endereco);
							txtBairro.setText(bairro);
							txtCep.setText(cep);
							txtCidade.setText(cidade);
							txtTelefoneR.setText(telefoner);
							txtTelefoneC.setText(telefonec);
						}else{
							JOptionPane.showMessageDialog(null, "Email Invalido", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		
		try{
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		paine.add(lblCpf);
		lblCpf.setBounds(20, 190, 80, 20);
		paine.add(txtCpf);
		txtCpf.setBounds(20, 210, 300, 20);
		txtCpf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
			// código do evento:
			String caracteres="0987654321";
			       if(!caracteres.contains(ev.getKeyChar()+"")){
			              ev.consume();
			       }
			}
		});
		
		paine.add(lblNome);
		lblNome.setBounds(20, 250, 80, 20);
		paine.add(txtNome);
		txtNome.setBounds(20, 270, 300, 20);
		
		paine.add(lblEndereco);
		lblEndereco.setBounds(20, 310, 200, 20);
		paine.add(txtEndereco);
		txtEndereco.setBounds(20, 330, 300, 20);
		
		paine.add(lblBairro);
		lblBairro.setBounds(20, 370, 80, 20);
		paine.add(txtBairro);
		txtBairro.setBounds(20, 390, 300, 20);
		
		try{
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		}catch(Exception e){
			e.printStackTrace();
		}
		txtCidade.setEditable(false);
		paine.add(lblCep);
		lblCep.setBounds(20, 430, 80, 20);
		paine.add(txtCep);
		txtCep.setBounds(20, 450, 300, 20);
		
		
		paine.add(lblCidade);
		lblCidade.setBounds(20, 490, 80, 20);
		paine.add(txtCidade);
		txtCidade.setBounds(20, 510, 300, 20);
		
		try{
			txtTelefoneR = new JFormattedTextField(new MaskFormatter("(##) ## ####-####"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		paine.add(lblTelefoneR);
		lblTelefoneR.setBounds(20, 550, 80, 20);
		
		paine.add(lblResidencia);
		lblResidencia.setBounds(20, 570, 80, 20);
		
		paine.add(txtTelefoneR);
		txtTelefoneR.setBounds(40, 570, 110, 20);
		txtTelefoneR.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
			// código do evento:
			String caracteres="0987654321";
			       if(!caracteres.contains(ev.getKeyChar()+"")){
			              ev.consume();
			       }
			}
		});
		
		try{
			txtTelefoneC = new JFormattedTextField(new MaskFormatter("(##) ## #####-####"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		paine.add(lblTelefoneC);
		lblTelefoneC.setBounds(160, 570, 80, 20);
		paine.add(txtTelefoneC);
		txtTelefoneC.setBounds(180, 570, 115, 20);
		txtTelefoneC.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev) {
			// código do evento:
			String caracteres="0987654321";
			       if(!caracteres.contains(ev.getKeyChar()+"")){
			              ev.consume();
			       }
			}
		});
		
		paine.add(lblSexo);
		lblSexo.setBounds(20, 600, 80, 20);
		paine.add(rbSexo[0]);
		rbSexo[0].setBounds(20, 620, 100, 20);
		paine.add(rbSexo[1]);
		rbSexo[1].setBounds(120, 620, 100, 20);
		
		paine.add(btnConcluir);
		btnConcluir.setBounds(40, 650, 120, 40); 
		btnConcluir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
				File arquivo = new File("Funcionarios/" + emailn + ".txt");

					String emailn = txtReserva.getText();
					String senha = txtReserva1.getText();
					String cpf = txtCpf.getText();
				    String nome = txtNome.getText();
					String endereco = txtEndereco.getText();
					String bairro = txtBairro.getText();
					String cep = txtCep.getText();
					String cidade = txtCidade.getText();
					String telefoner = txtTelefoneR.getText();
					String telefonec = txtTelefoneC.getText();
					String sexo;
					if(rbSexo[0].isSelected())
						sexo = "Masculino";
					else{ 
						if(rbSexo[1].isSelected())
							sexo = "Feminino";
						else
							sexo = "Indefinido";
					}
					
					arquivo.delete();
					
					File arquivoN = new File("Funcionarios/" + emailn + ".txt");
					
					try( FileWriter fw = new FileWriter(arquivoN, true) ){
						fw.write(emailn);
					    fw.write("\r\n");
					    fw.write(senha);
					    fw.write("\r\n\r\n");
					    fw.write(cpf);
					    fw.write("\r\n");
					    fw.write(nome);
					    fw.write("\r\n");
					    fw.write(endereco);
					    fw.write("\r\n");
					    fw.write(bairro);
					    fw.write("\r\n");
					    fw.write(cep);
					    fw.write("\r\n");
					    fw.write(cidade);
					    fw.write("\r\n");
					    fw.write(telefoner);
					    fw.write("\r\n");
					    fw.write(telefonec);
					    fw.write("\r\n");
					    fw.write(sexo);
					    fw.flush();
					    fw.close();
					    
					    JOptionPane.showMessageDialog(null, "Concluido, os dados foram alterados!");
					    
					}catch(IOException ex){
					  ex.printStackTrace();
					}
					dispose();
			}
		});
		
		btnExcluir.setEnabled(false);
		paine.add(btnExcluir);
		btnExcluir.setBounds(180, 650, 120, 40); 
		btnExcluir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int Excluir;
				arquivo = new File("Funcionarios/" + emailn + ".txt");
				
				Excluir = JOptionPane.showConfirmDialog(null, "Você deseja realmente excluir o funcionario?","Confirmação",JOptionPane.YES_NO_OPTION);
				
				if(Excluir == 0){
					
					arquivo.delete();
					btnExcluir.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Funcionario excluido!");
					dispose();
				}
			}
		});
		
		setLocation(1015, 0); 
	
		this.setSize(350, 725);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
