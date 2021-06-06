package view.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Masks;
import controller.MasksTextArea;
import model.Acervo;
import model.Classificacao;
import net.miginfocom.swing.MigLayout;
import persist.IGenericDAO;
import persist.JDBCDAO;
import view.Interface_ConsultaClassificacao;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class Painel_NovoAcervo extends JPanel {

	private JPanel panelButtons;
	
	private JTextField txtDimencoes;
	private JTextField txtIsbn;
	private JTextField txtLocalPub;
	private JTextField txtAnoPub;
	private JTextField txtAutor;
	private JTextField txtPaginas;
	private JTextField txtVolume;
	private JTextField txtEdicao;
	private JTextField txtSubtitulo;
	private JTextField txtTitulo;
	private JTextField txtCodAcervo;
	private JTextField txtCodClassificacao;
	private JTextField txtAssunto;
	private JTextField txtEditora;
	private JTextField txtIdioma;
	
	private JLabel lblTipoMaterial;
	private JLabel lblCodAcervo;
	private JLabel lblEditora;
	private JLabel lblAnoPub;
	private JLabel lblResumo;
	private JLabel lblCodigoClassificao;
	private JLabel lblEdicao;
	private JLabel lblLocalPub;
	private JLabel lblAssunto;
	private JLabel lblVolume;
	private JLabel lblIsbn;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblDimencoes;
	private JLabel lblSubtitulo;
	private JLabel lblPaginas;
	private JLabel lblInserirImagem;
	private JLabel lblIdioma;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipoMaterial;
	
	private JTextArea areaResumo;
	private JButton btnLimpar;
	private JButton btnSalvar;
	private JButton btnInserirImagem;
	
	private JButton btnRemoverImagem;
	
	private InputStream is= null;
	private JButton btnConsultar;
	private JLabel lblAsterisco;
	
			
	private boolean validarCampos() {
				
		lblTipoMaterial.setForeground(Color.BLACK);
		lblCodAcervo.setForeground(Color.BLACK);
		lblCodigoClassificao.setForeground(Color.BLACK);
		lblTitulo.setForeground(Color.BLACK);
				
		boolean erro = false;
		
		if(cbTipoMaterial.getSelectedItem().equals("-- selecione --")) {
			erro = true;
			lblTipoMaterial.setForeground(Color.RED);
		}
		
		if(txtCodAcervo.getText().equals("")) {
			erro = true;
			lblCodAcervo.setForeground(Color.RED);
		}
		
		if(new JDBCDAO<Acervo, String>(Acervo.class).read(txtCodAcervo.getText()) != null) {
			erro = true;
			lblCodAcervo.setForeground(Color.RED);
		}
		
		if(txtCodClassificacao.getText().equals("")) {
			erro = true;
			lblCodigoClassificao.setForeground(Color.RED);
		}
		
		if(txtTitulo.getText().equals("")) {
			erro = true;
			lblTitulo.setForeground(Color.RED);
		}
				
		return erro;
	}
	
	private void limparCampos() {
		Component[] comp = this.getComponents();
		for (Component c : comp) {
			if (c.getClass().getSimpleName().contains("JTextField") || c.getClass().getSimpleName().contains("Masks")) {
				((JTextField) c).setText("");
			}
		}
		
		cbTipoMaterial.setSelectedItem("-- selecione --");
		areaResumo.setText("");
		is = null;
		lblInserirImagem.setText("Sem Imagem");
		lblInserirImagem.setForeground(Color.RED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Painel_NovoAcervo() {
		
		this.setSize(1300, 800);
		
		lblTipoMaterial = new JLabel("Tipo de Material *");
		
		cbTipoMaterial = new JComboBox();
		cbTipoMaterial.setToolTipText("Escolha um tipo de material");
		
		cbTipoMaterial.addItem("-- selecione --");
		cbTipoMaterial.addItem("Livro");
		cbTipoMaterial.addItem("CD/DVD");
		cbTipoMaterial.addItem("Mapa");
		cbTipoMaterial.addItem("Revista");
		cbTipoMaterial.addItem("Outros");
		
		lblInserirImagem = new JLabel("Sem Imagem");
		lblInserirImagem.setFont(new Font("Arial", Font.BOLD, 11));
		lblInserirImagem.setForeground(Color.RED);
		
		btnInserirImagem = new JButton("Inserir Imagem");
		
		btnRemoverImagem = new JButton("Remover");
		btnRemoverImagem.setFont(new Font("Dialog", Font.BOLD, 12));
		
		
		lblCodAcervo = new JLabel("Cod. Acervo *");
		
		lblEditora = new JLabel("Editora");
		
		lblAnoPub = new JLabel("Ano Publicação");
		
		lblResumo = new JLabel("Resumo");
		
		txtCodAcervo = new Masks(15, false);
		txtCodAcervo.setToolTipText("Campo de Preenchimento Obrigatório.\nVerifique se já existe um acervo cadastrado com o código informado");
		txtCodAcervo.setColumns(10);
		
		txtEditora = new Masks(35);
		txtEditora.setColumns(10);
		
		txtAnoPub = new Masks(4, false);
		txtAnoPub.setColumns(10);
		
		JScrollPane scrollResumo = new JScrollPane();
		
		areaResumo = new JTextArea();
		areaResumo.setToolTipText("Tamanho máximo: 3000 caracteres.");
		areaResumo.setLineWrap(true);
		areaResumo.setWrapStyleWord(true);
		areaResumo.setDocument(new MasksTextArea(3000));
		scrollResumo.setViewportView(areaResumo);
		scrollResumo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		lblCodigoClassificao = new JLabel("Cod. Classificação *");
				
		lblEdicao = new JLabel("Edição");
		
		lblLocalPub = new JLabel("Local Publicação");
		
		txtCodClassificacao = new Masks(15);
		txtCodClassificacao.setToolTipText("Campo de preenchimento obrigratório");
		txtCodClassificacao.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		
		txtEdicao = new Masks(2, false);
		txtEdicao.setColumns(10);
		
		txtLocalPub = new Masks(30);
		txtLocalPub.setColumns(10);
		
		lblAssunto = new JLabel("Assunto");
		
		lblVolume = new JLabel("Volume");
		
		lblIsbn = new JLabel("ISBN");
				
		txtAssunto = new Masks(40);
		txtAssunto.setColumns(10);
		
		txtVolume = new Masks(2);
		txtVolume.setColumns(10);
		
		txtIsbn = new Masks(30);
		txtIsbn.setColumns(10);
		
		panelButtons = new JPanel();
		panelButtons.setLayout(new MigLayout("", "[120]", "[35][35][35]"));
		
		btnSalvar = new JButton("Salvar");
		panelButtons.add(btnSalvar, "cell 0 0,grow");
		btnSalvar.setMnemonic(KeyEvent.VK_S);
		
		btnLimpar = new JButton("Limpar");
		panelButtons.add(btnLimpar, "cell 0 1,grow");
		btnLimpar.setMnemonic(KeyEvent.VK_L);
				
		lblTitulo = new JLabel("Titulo *");
		
		lblAutor = new JLabel("Autor");
		
		lblDimencoes = new JLabel("Dimensões");
				
		txtTitulo = new Masks(200);
		txtTitulo.setToolTipText("Campo de preenchimento obrigatório");
		txtTitulo.setColumns(10);
		
		txtAutor = new Masks(50);
		txtAutor.setText("");
		txtAutor.setColumns(10);
		
		txtDimencoes = new Masks(50);
		txtDimencoes.setColumns(10);
		
		lblSubtitulo = new JLabel("Subtítulo");
		
		lblPaginas = new JLabel("Nº Paginas");
		
		lblIdioma = new JLabel("Idioma");
				
		txtSubtitulo = new Masks(200);
		txtSubtitulo.setColumns(10);
		
		txtPaginas = new Masks(4, false);
		txtPaginas.setColumns(10);
		
		txtIdioma = new Masks(30);
		txtIdioma.setColumns(10);
		
		lblAsterisco = new JLabel("Os campos com asterisco (*) são de preenchimento obrigatório.");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAsterisco, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipoMaterial, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbTipoMaterial, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
							.addGap(587)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnInserirImagem)
									.addGap(6)
									.addComponent(btnRemoverImagem))
								.addComponent(lblInserirImagem, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtAssunto, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(txtVolume, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(138)
							.addComponent(txtIsbn, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitulo)
								.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSubtitulo)
								.addComponent(txtSubtitulo, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAutor)
								.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPaginas)
								.addComponent(txtPaginas, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDimencoes)
								.addComponent(txtDimencoes, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdioma)
								.addComponent(txtIdioma, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
							.addGap(259)
							.addComponent(panelButtons, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCodAcervo, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigoClassificao)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtCodClassificacao, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnConsultar))
								.addComponent(lblAssunto)
								.addComponent(lblCodAcervo))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEditora, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEdicao)
								.addComponent(txtEdicao, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVolume)
								.addComponent(lblEditora))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAnoPub, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLocalPub)
								.addComponent(txtLocalPub, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIsbn)
								.addComponent(lblAnoPub))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblResumo)
								.addComponent(scrollResumo, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblAsterisco)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTipoMaterial)
							.addGap(6)
							.addComponent(cbTipoMaterial, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnInserirImagem)
								.addComponent(btnRemoverImagem))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblInserirImagem)))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodAcervo)
						.addComponent(lblEditora)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAnoPub)
							.addComponent(lblResumo)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtCodAcervo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(lblCodigoClassificao)
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtCodClassificacao, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnConsultar))
									.addGap(27)
									.addComponent(lblAssunto))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtEditora, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(lblEdicao)
									.addGap(6)
									.addComponent(txtEdicao, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(lblVolume))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtAnoPub, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(lblLocalPub)
									.addGap(6)
									.addComponent(txtLocalPub, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(lblIsbn)))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAssunto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtVolume, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtIsbn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollResumo, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(lblTitulo)
							.addGap(6)
							.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblSubtitulo)
							.addGap(6)
							.addComponent(txtSubtitulo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(lblAutor)
							.addGap(6)
							.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblPaginas)
							.addGap(6)
							.addComponent(txtPaginas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(lblDimencoes)
							.addGap(6)
							.addComponent(txtDimencoes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblIdioma)
							.addGap(6)
							.addComponent(txtIdioma, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelButtons, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);
		
		
		btnInserirImagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens (jpg, png, bitmap)", "jpg","png","bitmap");
				
				JFileChooser jf = new JFileChooser("C:");
				jf.setFileFilter(filter);
				jf.setMultiSelectionEnabled(false);
		
				File arquivo = null;
				try{
					jf.showOpenDialog(btnInserirImagem);
					arquivo = jf.getSelectedFile();
					is = new FileInputStream(arquivo);
					if(is != null){
				    lblInserirImagem.setText(arquivo.getName());
				    lblInserirImagem.setForeground(Color.BLUE);
					}
				}
				catch(Exception e1){
					
				}
			}
		});
		
						
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean teste = validarCampos();
				
				if (teste == false) {
					
					IGenericDAO<Acervo, String> jdbcB = new JDBCDAO<Acervo, String>(Acervo.class);
					IGenericDAO<Classificacao, String> jdbcC = new JDBCDAO<Classificacao, String>(Classificacao.class);
					
					Classificacao classif = new Classificacao();
					classif.setCod_classificacao(txtCodClassificacao.getText());
					classif.setAssunto(txtAssunto.getText());
					
					Acervo acervo = new Acervo();
					acervo.setCodigo_acervo(txtCodAcervo.getText());
					acervo.setCod_classificacao(txtCodClassificacao.getText());
					acervo.setClassificacao(classif);
					acervo.setAutor(txtAutor.getText());
					acervo.setDimensoes(txtDimencoes.getText());
					acervo.setEdicao(txtEdicao.getText());
					acervo.setEditora(txtEditora.getText());
					acervo.setIsbn(txtIsbn.getText());
					acervo.setLocal(txtLocalPub.getText());
					acervo.setPaginas(txtPaginas.getText());
					acervo.setResumo(areaResumo.getText());
					acervo.setSubtitulo(txtSubtitulo.getText());
					acervo.setTitulo(txtTitulo.getText());
					acervo.setVolume(txtVolume.getText());
					acervo.setAno(txtAnoPub.getText());
					acervo.setMaterial(cbTipoMaterial.getSelectedItem().toString());
					acervo.setImagem(is);
					acervo.setIdioma(txtIdioma.getText());
									
					if (jdbcC.read(txtCodClassificacao.getText()) == null) {
						jdbcC.create(classif);
					} else {
						jdbcC.update(classif, txtCodClassificacao.getText());
					}

					jdbcB.create(acervo);
					
					limparCampos();
					
				} else {
					JOptionPane.showMessageDialog(null, "Há campos inválidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		txtCodClassificacao.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent evt) {
				
				String codigo = txtCodClassificacao.getText() + evt.getKeyChar();
				
				IGenericDAO<Classificacao, String> jdbcteste = new JDBCDAO<Classificacao, String>(Classificacao.class);
				
				try {
					Classificacao c = (Classificacao) jdbcteste.read(codigo);
					txtAssunto.setText(c.getAssunto());
				} catch (Exception e) {
					txtAssunto.setText("");
				}
				
			}
			
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				limparCampos();
				
			}
		});
		
		btnRemoverImagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				is = null;
			    lblInserirImagem.setText("Sem Imagem");
			    lblInserirImagem.setForeground(Color.RED);
			}
		});	
		
		btnConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Interface_ConsultaClassificacao(txtCodClassificacao, txtAssunto);
			}
		});
	}
}
