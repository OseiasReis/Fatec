package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import model.Biblioteca;
import model.Operador;
import model.Penalidade;
import net.miginfocom.swing.MigLayout;
import persist.IGenericDAO;
import persist.SerDAO;
import view.panels.Painel_AlterarCliente;
import view.panels.Painel_AlterarSenha;
import view.panels.Painel_Apresentacao;
import view.panels.Painel_BuscarAcervo;
import view.panels.Painel_BuscarCliente;
import view.panels.Painel_Devolucao;
import view.panels.Painel_Emprestimo;
import view.panels.Painel_NovoCliente;

@SuppressWarnings("serial")
public class Interface_Principal_Atendente extends JFrame {

	private JLabel lblBiblioteca;
	private JPanel contentPane;
	private JLabel lbLogo;
	private JLabel lbRotulo;
	private JLabel lblBemVindo;
	private JLabel lblLogout;
	
	private JScrollPane scrollPane;
	private ImageIcon icone;
	
	private JMenuBar menuBar;
	private JMenu mnAcervo;
	private JMenu mnCliente;
	private JMenu mnCirculacao;
	private JMenu mnSistema;
	private JMenuItem mniBuscarAcervo;
	private JMenuItem mniNovoCliente;
	private JMenuItem mniAlterarRemoverCliente;
	private JMenuItem mniBuscaCliente;
	private JMenuItem mniEmprestimo;
	private JMenuItem mniDevolucao;
	private JMenuItem mniAlterarSenha;
	private JMenuItem mniSobre;
	private JMenuItem mniRemoverMulta;

	public Interface_Principal_Atendente(Operador operador) {

		super("..::   I.Library - Atendente   ::..");

		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);

		icone = new ImageIcon("images/logotitulo.png");
		setIconImage(icone.getImage());

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAcervo = new JMenu("Acervo");
		menuBar.add(mnAcervo);

		mniBuscarAcervo = new JMenuItem("Buscar Acervo");
		mnAcervo.add(mniBuscarAcervo);

		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		mniNovoCliente = new JMenuItem("Novo Cliente");
		mnCliente.add(mniNovoCliente);

		mniBuscaCliente = new JMenuItem("Buscar Cliente");
		mnCliente.add(mniBuscaCliente);

		mniAlterarRemoverCliente = new JMenuItem("Alterar Cliente");
		mnCliente.add(mniAlterarRemoverCliente);
		
		mniRemoverMulta = new JMenuItem("Remover Multa Pendente");
		mnCliente.add(mniRemoverMulta);
		
		mniRemoverMulta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IGenericDAO<Penalidade, String> serPenalidade = new SerDAO<Penalidade, String>(Penalidade.class);	
				Penalidade penalidade = serPenalidade.read(null);
				if (penalidade.getMulta() == false) {
					JOptionPane.showMessageDialog(null, "Sistema não foi configurado para\nAceitar multas!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					new RemoverMulta();
				}	
			}
		});

		mnCirculacao = new JMenu("Circulação");
		menuBar.add(mnCirculacao);

		mniEmprestimo = new JMenuItem("Empréstimo");
		mnCirculacao.add(mniEmprestimo);

		mniDevolucao = new JMenuItem("Devolução");
		mnCirculacao.add(mniDevolucao);

		mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);

		mniAlterarSenha = new JMenuItem("Alterar Senha");
		mnSistema.add(mniAlterarSenha);

		mniSobre = new JMenuItem("Sobre");
		mnSistema.add(mniSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lbRotulo = new JLabel("");
		lbRotulo.setFont(new Font("Arial", Font.BOLD, 19));
		lbRotulo.setHorizontalAlignment(SwingConstants.CENTER);

		contentPane.setLayout(new MigLayout("", "[70][383.00px,grow][255.00][83.00][70]",
				"[38.00,baseline][grow][22.00px][471.00px,grow]"));

		lbLogo = new JLabel();
		contentPane.add(lbLogo, "flowx,cell 1 0 1 2");

		lblBemVindo = new JLabel("Olá " + operador.getNome());
		lblBemVindo.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblBemVindo, "cell 2 0,growx");

		lblLogout = new JLabel("<html><u>LOGOUT</u></html>");
		lblLogout.setFont(new Font("Arial", Font.BOLD, 12));
		lblLogout.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblLogout, "cell 3 0,growx");

		Biblioteca biblioteca = new SerDAO<Biblioteca, String>(Biblioteca.class).read(null);
		lblBiblioteca = new JLabel("<html><b>" + biblioteca.getNome().toUpperCase() + "</b> <br/> Fone: "
				+ biblioteca.getTelefone() + "<br/>" + biblioteca.getEndereco() + ", " + biblioteca.getNumero() + " - "
				+ biblioteca.getBairro() + " - " + biblioteca.getCidade() + " - " + biblioteca.getEstado());
		lblBiblioteca.setVerticalAlignment(SwingConstants.TOP);
		lblBiblioteca.setFont(new Font("Dialog", Font.PLAIN, 9));
		contentPane.add(lblBiblioteca, "cell 2 1 2 1,grow");

		contentPane.add(lbRotulo, "cell 1 2 3 1,growx,aligny bottom");

		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		contentPane.add(scrollPane, "cell 1 3 3 1,grow");

		scrollPane.setViewportView(new Painel_Apresentacao());

		mniNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Atendente - Novo Cliente   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("NOVO CLIENTE");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_NovoCliente());
				scrollPane.repaint();

			}
		});

		lbLogo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				setTitle("..::   I.Library - Atendente   ::..");
				lbLogo.setIcon(null);
				lbRotulo.setText(null);
				scrollPane.setViewportView(new Painel_Apresentacao());
				scrollPane.repaint();

			}
		});

		mniAlterarRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Atendente - Alterar Cliente   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("ALTERAR CLIENTE");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_AlterarCliente());
				scrollPane.repaint();

			}
		});

		mniBuscarAcervo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Atendente - Buscar Acervo   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("BUSCAR ACERVO");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_BuscarAcervo());
				scrollPane.repaint();

			}
		});

		mniBuscaCliente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Atendente - Buscar Cliente   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("BUSCAR CLIENTE");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_BuscarCliente());
				scrollPane.repaint();

			}
		});

		mniEmprestimo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setTitle("..::   I.Library - Atendente - Realizar Empréstimo   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("REALIZAR EMPRÉSTIMOS");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_Emprestimo(operador));
				scrollPane.repaint();
			}
		});

		mniDevolucao.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setTitle("..::   I.Library - Atendente - Realizar Devolução   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("REALIZAR DEVOLUÇÕES");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_Devolucao(operador));
				scrollPane.repaint();
			}
		});

		lblLogout.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int option;

				option = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar logout do sistema?",
						"Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (option == 0) {
					new Login();
					dispose();
				}
			}
		});

		mniAlterarSenha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Atendente - Alterar Senha   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("ALTERAR SENHA");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_AlterarSenha(operador));
				scrollPane.repaint();

			}
		});

		mniSobre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Interface_Sobre();
			}
		});
	}
}
