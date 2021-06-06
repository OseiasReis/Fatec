package aula;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CadastroUsuario extends JFrame{
	
	private JLabel lblNome = new JLabel("Nome:");
	private JLabel lblEndereco = new JLabel("Endereço:");
	private JLabel lblBairro = new JLabel("Bairro:");
	private JLabel lblCep = new JLabel("Cep:");
	private JLabel lblCidade = new JLabel("Cidade:");
	private JLabel lblEstado = new JLabel("Estado:");
	private JLabel lblSexo = new JLabel("Sexo:");
	private JLabel lblProfissao = new JLabel("Profissão:");
	
	private JTextField txtNome = new JTextField();
	private JTextField txtEndereco = new JTextField();
	private JTextField txtBairro = new JTextField();
	private JTextField txtCep;
	private JTextField txtCidade = new JTextField();
	private JComboBox cboEstado = new JComboBox();
	
	private JRadioButton[] rbSexo = new JRadioButton[2];
	private ButtonGroup group = new ButtonGroup();
	
	private JCheckBox ckAdministracao = new JCheckBox("Administração");
	private JCheckBox ckContabilidade = new JCheckBox("Contabilidade");
	
	public CadastroUsuario(){
		super(".::Cadastro de Usuários::.");
		
		rbSexo[0] = new JRadioButton("Masculino");
		rbSexo[1] = new JRadioButton("Feminino");
		
		group.add(rbSexo[0]);
		group.add(rbSexo[1]);
		
		Container pane = this.getContentPane();
		
		pane.setLayout(new GridLayout(18,1));
		
		pane.add(lblNome);
		pane.add(txtNome);
		
		pane.add(lblEndereco);
		pane.add(txtEndereco);
		
		pane.add(lblBairro);
		pane.add(txtBairro);
		
		try{
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###")); 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pane.add(lblCep);
		pane.add(txtCep);
		
		pane.add(lblCidade);
		pane.add(txtCidade);
		
		cboEstado.addItem("SP");
		cboEstado.addItem("RJ");
		
		pane.add(lblEstado);
		pane.add(cboEstado);
		
		pane.add(lblSexo);
		pane.add(rbSexo[0]);
		pane.add(rbSexo[1]);
		
		pane.add(lblProfissao);
		pane.add(ckAdministracao);
		pane.add(ckContabilidade);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400, 400);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CadastroUsuario cad = new CadastroUsuario();
	}
}
