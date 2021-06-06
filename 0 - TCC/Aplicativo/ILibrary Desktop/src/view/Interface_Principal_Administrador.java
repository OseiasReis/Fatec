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
import view.panels.Painel_AlterarAcervo;
import view.panels.Painel_AlterarCliente;
import view.panels.Painel_AlterarExemplar;
import view.panels.Painel_AlterarOperador;
import view.panels.Painel_AlterarSenha;
import view.panels.Painel_Apresentacao;
import view.panels.Painel_BuscarAcervo;
import view.panels.Painel_BuscarCliente;
import view.panels.Painel_BuscarOperadores;
import view.panels.Painel_Devolucao;
import view.panels.Painel_Emprestimo;
import view.panels.Painel_NovoAcervo;
import view.panels.Painel_NovoCliente;
import view.panels.Painel_NovoExemplar;
import view.panels.Painel_NovoOperador;
import view.panels.relatorios.Painel_EmprestimosAnuais;
import view.panels.relatorios.Painel_RelatorioDevolucoes;
import view.panels.relatorios.Painel_RelatorioEmprestimos;

@SuppressWarnings("serial")
public class Interface_Principal_Administrador extends JFrame {

	private JPanel contentPane;
	private JLabel lblBiblioteca;
	private JLabel lbLogo;
	private JLabel lbRotulo;
	private JLabel lblBemVindo;
	private JLabel lblLogout;
	
	private JScrollPane scrollPane;
	private ImageIcon icone;

	private JMenuBar menuBar;

	private JMenu mnCatalogar;
	private JMenu mnCliente;
	private JMenu mnCirculacao;
	private JMenu mnSistema;
	private JMenu mnInformacoes;

	private JMenuItem mniNovoAcervo;
	private JMenuItem mntmNovoExemplar;
	private JMenuItem mniAlterarAcervo;
	private JMenuItem mniAlterarExemplar;
	private JMenuItem mniBuscarAcervo;
	private JMenuItem mniNovoCliente;
	private JMenuItem mniAlterarCliente;
	private JMenuItem mniBuscaCliente;
	private JMenuItem mniEmprestimo;
	private JMenuItem mniDevolucao;
	private JMenuItem mniEmprestimoAnual;
	private JMenuItem mniNovoOperador;
	private JMenuItem mniAlterarOperador;
	private JMenuItem mniBuscarOperadores;
	private JMenuItem mniConfiguracoes;
	private JMenuItem mniAlterarSenha;
	private JMenuItem mniSobre;
	private JMenuItem mniRelatorioEmprestimos;
	private JMenuItem mniRelatorioDevolucoes;
	private JMenuItem mniRemoverMulta;

	public Interface_Principal_Administrador(Operador operador) {

		super("..::   I.Library - Administrador   ::..");

		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		icone = new ImageIcon("images/logotitulo.png");
		setIconImage(icone.getImage());

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnCatalogar = new JMenu("Catalogar");
		menuBar.add(mnCatalogar);

		mniNovoAcervo = new JMenuItem("Novo Acervo");
		mnCatalogar.add(mniNovoAcervo);

		mntmNovoExemplar = new JMenuItem("Novo Exemplar");
		mnCatalogar.add(mntmNovoExemplar);

		mniAlterarAcervo = new JMenuItem("Alterar Acervo");
		mnCatalogar.add(mniAlterarAcervo);

		mniAlterarExemplar = new JMenuItem("Alterar Exemplar");
		mnCatalogar.add(mniAlterarExemplar);

		mniBuscarAcervo = new JMenuItem("Buscar Acervo");
		mnCatalogar.add(mniBuscarAcervo);

		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		mniNovoCliente = new JMenuItem("Novo Cliente");
		mnCliente.add(mniNovoCliente);

		mniAlterarCliente = new JMenuItem("Alterar Cliente");
		mnCliente.add(mniAlterarCliente);

		mniBuscaCliente = new JMenuItem("Buscar Cliente");
		mnCliente.add(mniBuscaCliente);
		
		mniRemoverMulta = new JMenuItem("Remover Multa Pendente");
		mnCliente.add(mniRemoverMulta);

		mnCirculacao = new JMenu("Circulação");
		menuBar.add(mnCirculacao);

		mniEmprestimo = new JMenuItem("Empréstimo");
		mnCirculacao.add(mniEmprestimo);

		mniDevolucao = new JMenuItem("Devolução");
		mnCirculacao.add(mniDevolucao);

		mnInformacoes = new JMenu("Informações");
		mnInformacoes.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnInformacoes);

		mniEmprestimoAnual = new JMenuItem("Empréstimo Anual");
		mnInformacoes.add(mniEmprestimoAnual);
		
		mniRelatorioEmprestimos = new JMenuItem("Empréstimos");
		mnInformacoes.add(mniRelatorioEmprestimos);
		
		mniRelatorioDevolucoes = new JMenuItem("Devoluções");
		mnInformacoes.add(mniRelatorioDevolucoes);

		mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);

		mniNovoOperador = new JMenuItem("Novo Operador");
		mnSistema.add(mniNovoOperador);

		mniAlterarOperador = new JMenuItem("Alterar Operador");
		mnSistema.add(mniAlterarOperador);

		mniBuscarOperadores = new JMenuItem("Buscar Operadores");
		mnSistema.add(mniBuscarOperadores);

		mniConfiguracoes = new JMenuItem("Configurações");
		mnSistema.add(mniConfiguracoes);

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

		mniNovoAcervo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Novo Acervo   ::..");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("NOVO ACERVO");
				scrollPane.setViewportView(new Painel_NovoAcervo());
				scrollPane.repaint();

			}
		});

		mntmNovoExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Novo Exemplar   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("NOVO EXEMPLAR");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_NovoExemplar());
				scrollPane.repaint();

			}
		});

		mniNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Novo Cliente   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("NOVO CLIENTE");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_NovoCliente());
				scrollPane.repaint();

			}
		});

		mniBuscaCliente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Buscar Clientes   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("BUSCAR CLIENTES");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_BuscarCliente());
				scrollPane.repaint();

			}
		});

		lbLogo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				setTitle("..::   I.Library - Administrador   ::..");
				lbLogo.setIcon(null);
				lbRotulo.setText(null);
				scrollPane.setViewportView(new Painel_Apresentacao());
				scrollPane.repaint();

			}
		});

		mniAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Alterar Cliente   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("ALTERAR CLIENTE");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_AlterarCliente());
				scrollPane.repaint();

			}
		});

		mniBuscarAcervo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Buscar Acervo   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("BUSCAR ACERVO");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_BuscarAcervo());
				scrollPane.repaint();

			}
		});

		mniNovoOperador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Novo Operador   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("NOVO OPERADOR");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_NovoOperador());
				scrollPane.repaint();

			}
		});

		mniConfiguracoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Interface_Configuracao(lblBiblioteca);
			}
		});

		mniAlterarOperador.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Alterar Operador   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("ALTERAR OPERADOR");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_AlterarOperador(operador));
				scrollPane.repaint();

			}
		});

		mniBuscarOperadores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Buscar Operadores   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("BUSCAR OPERADORES");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_BuscarOperadores());
				scrollPane.repaint();

			}
		});

		mniAlterarAcervo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Alterar Acervo   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("ALTERAR ACERVO");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_AlterarAcervo());
				scrollPane.repaint();

			}
		});

		mniAlterarExemplar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Alterar Exemplar   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("ALTERAR EXEMPLAR");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_AlterarExemplar());
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

		mniEmprestimoAnual.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Empréstimos Anuais   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("EMPRÉSTIMOS ANUAIS");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_EmprestimosAnuais());
				scrollPane.repaint();

				if (Painel_EmprestimosAnuais.ano_menor == 0) {
					JOptionPane.showMessageDialog(null, "Não há dados a serem apresentados!", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		mniAlterarSenha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setTitle("..::   I.Library - Administrador - Alterar Senha   ::..");
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
				setTitle("..::   I.Library - Administrador - Realizar Devolução   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("REALIZAR DEVOLUÇÕES");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_Devolucao(operador));
				scrollPane.repaint();
			}
		});
		
		mniRelatorioEmprestimos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setTitle("..::   I.Library - Administrador - Informações sobre Empréstimos   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("EMPRÉSTIMOS");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_RelatorioEmprestimos());
				scrollPane.repaint();
			}
		});
		
		mniRelatorioDevolucoes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setTitle("..::   I.Library - Administrador - Informações sobre Devoluções   ::..");
				lbLogo.setIcon(new ImageIcon("images/logo2.png"));
				lbRotulo.setText("DEVOLUÇÕES");
				contentPane.add(lbRotulo, "cell 1 2 4 1,growx,aligny bottom");
				scrollPane.setViewportView(new Painel_RelatorioDevolucoes());
				scrollPane.repaint();
			}
		});
		
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
	}
}
