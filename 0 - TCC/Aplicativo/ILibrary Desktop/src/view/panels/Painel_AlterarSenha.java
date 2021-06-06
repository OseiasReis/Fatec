package view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import model.Operador;
import net.miginfocom.swing.MigLayout;
import persist.JDBCDAO;

@SuppressWarnings("serial")
public class Painel_AlterarSenha extends JPanel {

	private JPanel panelButtons;
	private JLabel lblSenhaAtual;
	private JLabel lblNovaSenha;
	private JLabel lblConfirmarSenha;
	private JLabel lblimage;

	private JPasswordField pwSenhaAtual;
	private JPasswordField pwNovaSenha;
	private JPasswordField pwConfirmarSenha;

	private JButton btnLimpar;
	private JButton btnAlterar;

	private Operador operador;

	@SuppressWarnings("deprecation")
	private boolean validar() {

		boolean erro = false;

		if (!operador.getSenha().equals(pwSenhaAtual.getText())) {
			System.out.println(operador.getSenha());
			JOptionPane.showMessageDialog(null, "Senha atual incorreta!", "Aviso", JOptionPane.WARNING_MESSAGE);
			erro = true;
		} else if (!pwNovaSenha.getText().equals(pwConfirmarSenha.getText())) {
			JOptionPane.showMessageDialog(null, "Senhas não conferem!", "Aviso", JOptionPane.WARNING_MESSAGE);
			erro = true;
		}

		return erro;
	}

	public Painel_AlterarSenha(Operador operador) {

		this.operador = operador;

		this.setLayout(
				new MigLayout("", "[150.00][230.00][127.00][371.00]", "[89.00][][25][15][][25][15][][25][35.00][]"));

		lblSenhaAtual = new JLabel("Senha Atual");
		this.add(lblSenhaAtual, "cell 1 1");

		pwSenhaAtual = new JPasswordField();
		this.add(pwSenhaAtual, "cell 1 2,grow");

		lblimage = new JLabel(new ImageIcon("images/key.png"));
		lblimage.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblimage, "cell 3 2 1 9,grow");

		lblNovaSenha = new JLabel("Nova Senha");
		this.add(lblNovaSenha, "cell 1 4");

		pwNovaSenha = new JPasswordField();
		this.add(pwNovaSenha, "cell 1 5,grow");

		lblConfirmarSenha = new JLabel("Confirmar Senha");
		this.add(lblConfirmarSenha, "cell 1 7");

		pwConfirmarSenha = new JPasswordField();
		this.add(pwConfirmarSenha, "cell 1 8,grow");

		panelButtons = new JPanel();
		this.add(panelButtons, "cell 1 10,grow");
		panelButtons.setLayout(new MigLayout("", "[grow][120]", "[35][35]"));

		btnAlterar = new JButton("Alterar");
		panelButtons.add(btnAlterar, "cell 1 0,grow");
		btnAlterar.setMnemonic(KeyEvent.VK_A);

		btnLimpar = new JButton("Limpar");
		panelButtons.add(btnLimpar, "cell 1 1,grow");
		btnLimpar.setMnemonic(KeyEvent.VK_L);

		btnAlterar.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				if (validar() == false) {
					int opcao;

					opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar a senha?",
							"Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (opcao == 0) {
						operador.setSenha(pwNovaSenha.getText());
						new JDBCDAO<Operador, String>(Operador.class).update(operador, operador.getRegistro());
						pwSenhaAtual.setText("");
						pwNovaSenha.setText("");
						pwConfirmarSenha.setText("");
					}

				}

			}
		});

		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				pwSenhaAtual.setText("");
				pwNovaSenha.setText("");
				pwConfirmarSenha.setText("");
			}
		});
	}
}
