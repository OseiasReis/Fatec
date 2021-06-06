package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.mysql.jdbc.Connection;
import model.BancoDados;
import persist.ConnectionFactory;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.Font;

@SuppressWarnings("serial")
public class Interface_ConfiguracaoBancoDados extends JFrame {

	private JTextField txtUsuario;
	private JTextField txtServidor;
	private JTextField txtBaseDados;

	private JLabel lblAviso;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblServidor;
	private JLabel lblBaseDados;
	private JLabel lblAcessoAoBanco;

	private JPasswordField pwSenha;
	private JButton btnConectar;
	private ImageIcon icone;

	public Interface_ConfiguracaoBancoDados() {

		super(".:: ILibrary - Configuração - Banco de Dados ::.");
		setSize(437, 460);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		Container tela = getContentPane();

		icone = new ImageIcon("images/logotitulo.png");
		setIconImage(icone.getImage());

		lblAviso = new JLabel(
				"<html><p align='justify'>Não foi possível realizar a conexão com o banco de dados.<br/><br/>Certifique-se que o banco de dados Mysql esteja devidamente instalado e que a base de dados ilibrary esteja criada.<br/><br/>Preencha os campos abaixo para realizar a conexão:</p></html>");
		tela.add(lblAviso);
		lblAviso.setBounds(24, 60, 383, 130);

		lblUsuario = new JLabel("Usuário");
		tela.add(lblUsuario);
		lblUsuario.setBounds(24, 284, 70, 15);

		txtUsuario = new JTextField();
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(25, 303, 173, 27);

		lblSenha = new JLabel("Senha");
		tela.add(lblSenha);
		lblSenha.setBounds(235, 284, 70, 15);

		pwSenha = new JPasswordField();
		tela.add(pwSenha);
		pwSenha.setColumns(10);
		pwSenha.setBounds(235, 303, 173, 27);

		btnConectar = new JButton("Conectar");
		tela.add(btnConectar);
		btnConectar.setBounds(290, 366, 117, 39);
		btnConectar.setMnemonic(KeyEvent.VK_C);
		getRootPane().setDefaultButton(btnConectar);

		txtServidor = new JTextField();
		tela.add(txtServidor);
		txtServidor.setColumns(10);
		txtServidor.setBounds(25, 236, 173, 27);

		lblServidor = new JLabel("Servidor");
		tela.add(lblServidor);
		lblServidor.setBounds(24, 217, 70, 15);

		lblBaseDados = new JLabel("Base Dados");
		tela.add(lblBaseDados);
		lblBaseDados.setBounds(235, 217, 104, 15);

		txtBaseDados = new JTextField();
		tela.add(txtBaseDados);
		txtBaseDados.setColumns(10);
		txtBaseDados.setBounds(235, 236, 173, 27);

		lblAcessoAoBanco = new JLabel("ACESSO AO BANCO DE DADOS");
		tela.add(lblAcessoAoBanco);
		lblAcessoAoBanco.setFont(new Font("Arial", Font.BOLD, 16));
		lblAcessoAoBanco.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcessoAoBanco.setBounds(24, 12, 383, 36);

		btnConectar.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				BancoDados bd = new BancoDados(txtServidor.getText(), txtBaseDados.getText(), txtUsuario.getText(),
						pwSenha.getText());
				FileOutputStream file;
				ObjectOutputStream oos;
				File arquivo = new File("system/systembd.ser");
				try {
					file = new FileOutputStream(arquivo);
					oos = new ObjectOutputStream(file);
					oos.writeObject(bd);
					oos.close();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Erro fatal no sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				Connection conn = (Connection) ConnectionFactory.getConnection();

				if (conn != null) {
					JOptionPane.showMessageDialog(null, "Conexão com o banco de dados estabelecida", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
					new Login();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não estabelecida", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
