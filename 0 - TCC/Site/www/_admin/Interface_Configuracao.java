package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import view.panels.configuracao.Painel_BancoDados;
import view.panels.configuracao.Painel_Biblioteca;
import view.panels.configuracao.Painel_RegrasNegocio;

@SuppressWarnings("serial")
public class Interface_Configuracao extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private ImageIcon icone;

	public Interface_Configuracao(JLabel biblioteca) {

		icone = new ImageIcon("images/logotitulo.png");
		setIconImage(icone.getImage());

		setTitle("..::   I.Library - Configurações   ::..");
		setSize(435, 486);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[321.00,grow]"));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 0 0,grow");

		tabbedPane.addTab("Regras de Negócio", null, new Painel_RegrasNegocio(), null);
		tabbedPane.addTab("Biblioteca", null, new Painel_Biblioteca(biblioteca), null);
		tabbedPane.addTab("Banco de Dados", null, new Painel_BancoDados(), null);
	}
}
