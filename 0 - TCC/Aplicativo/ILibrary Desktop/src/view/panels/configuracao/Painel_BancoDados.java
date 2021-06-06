package view.panels.configuracao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import model.BancoDados;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class Painel_BancoDados extends JPanel {

	private JLabel lblNomeServidor;
	private JLabel lblBaseDeDados;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblatenoAntesDe;

	private JTextField txtBancoDados;
	private JTextField txtNomeServidor;
	private JTextField txtUsuario;
	private JPasswordField pwSenha;

	private JButton btnAplicar;

	public Painel_BancoDados() {
				
		setLayout(new MigLayout("", "[][:223.00:197.00][71.00][:94.00:87.00]",
				"[10][64.00][13.00][][25][][25][][25][][25][33]"));

		lblatenoAntesDe = new JLabel(
				"<html><p style=\"align=justify\"><span style=\"color: red\">Atenção!</span> <br />Alterar essas configurações de acesso ao banco de dados poderá causar problemas no funcionamento do sistema se a alteração for realizada incorretamente! Só altere essas configurações se souber exatamente o que está fazendo.<br/>Para maiores informações consulte o manual do sistema.</html>");
		this.add(lblatenoAntesDe, "cell 1 1 3 1,grow");

		lblNomeServidor = new JLabel("Nome Servidor");
		this.add(lblNomeServidor, "cell 1 3,grow");

		txtNomeServidor = new JTextField();
		this.add(txtNomeServidor, "cell 1 4,grow");
		txtNomeServidor.setColumns(10);

		lblBaseDeDados = new JLabel("Base de Dados");
		this.add(lblBaseDeDados, "cell 1 5");

		txtBancoDados = new JTextField();
		this.add(txtBancoDados, "cell 1 6,grow");
		txtBancoDados.setColumns(10);

		lblUsuario = new JLabel("Usuário");
		this.add(lblUsuario, "cell 1 7");

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		this.add(txtUsuario, "cell 1 8,grow");

		lblSenha = new JLabel("Senha");
		this.add(lblSenha, "cell 1 9");

		pwSenha = new JPasswordField();
		this.add(pwSenha, "cell 1 10,grow");

		btnAplicar = new JButton("Aplicar");
		this.add(btnAplicar, "cell 3 11,grow");

		ObjectInputStream objinput;
		try {
			objinput = new ObjectInputStream(new FileInputStream("system/systembd.ser"));
			BancoDados bd = (BancoDados) objinput.readObject();
			objinput.close();

			txtNomeServidor.setText(bd.getServerName());
			txtBancoDados.setText(bd.getBancoDados());
			txtUsuario.setText(bd.getUsuario());
			pwSenha.setText(bd.getSenha());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao receber acesso ao banco de dados!", "Aviso", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

		btnAplicar.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				Connection conn = null;
				try {
					String stringConnection = "jdbc:mysql://" + txtNomeServidor.getText() + "/"
							+ txtBancoDados.getText();
					conn = (Connection) DriverManager.getConnection(stringConnection, txtUsuario.getText(),
							pwSenha.getText());
				} catch (Exception e1) {
					conn = null;
				}

				if (conn != null) {
					int option = JOptionPane.showConfirmDialog(null,
							"Conexão checada com sucesso!"
							+ "\nPara aplicar as alterações o sistema precisa ser desligado."
							+ "\nDeseja aplicar estas configurações permanentemente?",
							"Teste Conexão", JOptionPane.YES_NO_OPTION, 3);

					if (option == 0) {
						BancoDados bd = new BancoDados(txtNomeServidor.getText(), txtBancoDados.getText(),
								txtUsuario.getText(), pwSenha.getText());
						FileOutputStream file;
						ObjectOutputStream oos;
						File arquivo = new File("system/systembd.ser");
						try {
							file = new FileOutputStream(arquivo);
							oos = new ObjectOutputStream(file);
							oos.writeObject(bd);
							oos.close();
							JOptionPane.showMessageDialog(null, "Configurações aplicadas!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "Erro fatal no sistema! Configurações não aplicadas", "Erro", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Conexão checada com sucesso!\nErro ao estabelecer uma conexão.", "Teste Conexão", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
