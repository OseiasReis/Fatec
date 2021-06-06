package InterfaceGrafica;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Sistema extends JFrame{
	private JLabel lblNome = new JLabel("Nome: ");
	private JLabel lblEndereco = new JLabel("Endereço: ");
	private JLabel lblBairro = new JLabel("Bairro: ");
	private JLabel lblCep = new JLabel("Cep: ");
	private JLabel lblCidade = new JLabel("Cidade: ");
	private JLabel lblEstado = new JLabel("Estado: ");
	
	private JTextField txtNome = new JTextField();
	private JTextField txtEndereco = new JTextField();
	private JTextField txtBairro = new JTextField();
	private JTextField txtCep = new JTextField();
	private JTextField txtCidade = new JTextField();
	private JComboBox  cboEstado = new JComboBox();
	
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnLocalizar = new JButton("Localizar");
	private JButton btnSair = new JButton("Sair");
	
	public Sistema(){
		super(".::Sistema::.");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(lblNome);
		lblNome.setBounds(20, 20, 80, 20);
		
		paine.add(txtNome);
		txtNome.setBounds(100, 20, 500, 20);
		
		paine.add(lblEndereco);
		lblEndereco.setBounds(20, 60, 80, 20);
		
		paine.add(txtEndereco);
		txtEndereco.setBounds(100, 60, 500, 20);
		
		paine.add(lblBairro);
		lblBairro.setBounds(20, 100, 80, 20);
		
		paine.add(txtBairro);
		txtBairro.setBounds(100, 100, 250, 20);
		
		paine.add(lblCep);
		lblCep.setBounds(20, 140, 80, 20);
		
		paine.add(txtCep);
		txtCep.setBounds(100, 140, 250, 20);
		
		paine.add(lblCidade);
		lblCidade.setBounds(20, 180, 80, 20);
		
		paine.add(txtCidade);
		txtCidade.setBounds(100, 180, 250, 20);
		
		paine.add(lblEstado);
		lblEstado.setBounds(20, 220, 80, 20);
		
		cboEstado.addItem("SP");
		cboEstado.addItem("RJ");
		cboEstado.addItem("MG");
				
		paine.add(cboEstado);
		cboEstado.setBounds(100, 220, 100, 20);
		
		paine.add(btnCadastrar);
		btnCadastrar.setBounds(20, 280, 120, 80);
		btnCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Nome: " + txtNome.getText() + "\nEndereço: " + txtEndereco.getText() + "\nBairro: " + txtBairro.getText() + "\nCep: " + txtCep.getText() + "\nEstado: " + cboEstado.getSelectedItem());
			}
		});
		
		paine.add(btnLocalizar);
		btnLocalizar.setBounds(160, 280, 120, 80);
		btnLocalizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Localizado"); 			
			}
		});
		
		paine.add(btnSair);
		btnSair.setBounds(300, 280, 120, 80);
		btnSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int Sair;
				
				Sair = JOptionPane.showConfirmDialog(null, "Você deseja realmente sair?");
				
				if(Sair == 0){
					System.exit(0);
				}
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(725, 400);
		this.setResizable(false);
		
	}
	
	
	public static void main(String args[]){
	Sistema sis = new Sistema();
	}
}
