package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.MasksTextArea;
import model.Acervo;
import persist.JDBCDAO;

@SuppressWarnings("serial")
public class Interface_InfoAcervo extends JFrame {
	
	private JLabel lblTitulo = new JLabel("Titulo");
	private JLabel lblSubtitulo = new JLabel("Subtitulo");
	private JLabel lblCodA, lblEdicao, lblAutor, lblLocPublic, lblCodC, lblVolumee, lblNumPaginas, lblISBN, lblTipoMaterial, lblEditoraa, lblAnoPublic, lblDimensoes, lblAssunto, lblAssuntoApresenta;
	private JTextArea areaResumo;
	private ImageIcon icone;
	private JLabel lblCodAcervo;
	private JLabel lblEdio;
	private JLabel lblNomeAutor;
	private JLabel lblLocalPublicao;
	private JLabel lblNewLabel;
	private JLabel lblVolume;
	private JLabel lblNPaginas;
	private JLabel lblIsbn;
	private JLabel lblEditora;
	private JLabel lblAnoPublicao;
	private JLabel lblDimenses;
	private JLabel lblCodClassificao;
	private JLabel lblResumo;
	private JScrollPane spResumo;
	
	private void apresentarTxt(String cod_acervo) {

		Acervo acervo = new JDBCDAO<Acervo, String>(Acervo.class).read(cod_acervo); 
		lblTitulo.setBounds(26, 12, 875, 22);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setText(acervo.getTitulo());
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setBounds(26, 46, 875, 56);
		lblSubtitulo.setVerticalAlignment(SwingConstants.TOP);
		lblSubtitulo.setForeground(Color.BLACK);
		lblSubtitulo.setText("<html><p align='center'>" + acervo.getSubtitulo() + "</p></html>");
		lblCodA.setText(acervo.getCodigo_acervo());
		lblEdicao.setText(acervo.getEdicao());
		lblAutor.setText(acervo.getAutor());
		lblLocPublic.setText(acervo.getLocal());
		lblCodC.setText(acervo.getCod_classificacao());
		lblVolumee.setText(acervo.getVolume());
		lblNumPaginas.setText(acervo.getPaginas());
		lblISBN.setText(acervo.getIsbn());
		lblTipoMaterial.setText(acervo.getMaterial());
		lblEditoraa.setText(acervo.getEditora());
		lblAnoPublic.setText(acervo.getAno());
		lblDimensoes.setText(acervo.getDimensoes());
		lblAssuntoApresenta.setText(acervo.getClassificacao().getAssunto());
		areaResumo.setText(acervo.getResumo());

	}
	
	public Interface_InfoAcervo(String cod_acervo) {
		
		super("..::    ILibrary - Informações Acervo    ::..");
		
		setSize(930, 546);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		icone = new ImageIcon("images/logotitulo.png");
		setIconImage(icone.getImage());
		
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 18));
		
		lblSubtitulo.setFont(new Font("Dialog", Font.BOLD, 13));
				
		lblCodAcervo = new JLabel("Cod. Acervo");
		lblCodAcervo.setBounds(26, 142, 114, 20);
		lblCodAcervo.setFont(lblCodAcervo.getFont().deriveFont(lblCodAcervo.getFont().getStyle() | Font.BOLD, lblCodAcervo.getFont().getSize() + 5f));
		
		lblEdio = new JLabel("Edição");
		lblEdio.setBounds(300, 142, 62, 20);
		lblEdio.setFont(lblEdio.getFont().deriveFont(lblEdio.getFont().getStyle() | Font.BOLD, lblEdio.getFont().getSize() + 5f));
		
		lblNomeAutor = new JLabel("Autor");
		lblNomeAutor.setBounds(300, 267, 52, 20);
		lblNomeAutor.setFont(lblNomeAutor.getFont().deriveFont(lblNomeAutor.getFont().getStyle() | Font.BOLD, lblNomeAutor.getFont().getSize() + 5f));
		
		lblLocalPublicao = new JLabel("Local Publicação");
		lblLocalPublicao.setBounds(733, 209, 154, 20);
		lblLocalPublicao.setFont(lblLocalPublicao.getFont().deriveFont(lblLocalPublicao.getFont().getStyle() | Font.BOLD, lblLocalPublicao.getFont().getSize() + 5f));
		
		lblCodA = new JLabel("New label");
		lblCodA.setFont(new Font("Dialog", Font.BOLD, 10));
		lblCodA.setBounds(26, 168, 245, 15);
		
		lblEdicao = new JLabel("New label");
		lblEdicao.setFont(new Font("Dialog", Font.BOLD, 10));
		lblEdicao.setBounds(300, 168, 206, 15);
		
		lblAutor = new JLabel("New label");
		lblAutor.setFont(new Font("Dialog", Font.BOLD, 10));
		lblAutor.setBounds(300, 293, 206, 15);
		
		lblLocPublic = new JLabel("New label");
		lblLocPublic.setFont(new Font("Dialog", Font.BOLD, 10));
		lblLocPublic.setBounds(733, 235, 181, 15);

		lblNewLabel = new JLabel("Tipo Material");
		lblNewLabel.setBounds(26, 205, 124, 20);
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 5f));
		
		lblVolume = new JLabel("Volume");
		lblVolume.setBounds(300, 205, 71, 20);
		lblVolume.setFont(lblVolume.getFont().deriveFont(lblVolume.getFont().getStyle() | Font.BOLD, lblVolume.getFont().getSize() + 5f));
		
		lblNPaginas = new JLabel("Nº Paginas");
		lblNPaginas.setBounds(528, 267, 102, 20);
		lblNPaginas.setFont(lblNPaginas.getFont().deriveFont(lblNPaginas.getFont().getStyle() | Font.BOLD, lblNPaginas.getFont().getSize() + 5f));
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(527, 142, 45, 20);
		lblIsbn.setFont(lblIsbn.getFont().deriveFont(lblIsbn.getFont().getStyle() | Font.BOLD, lblIsbn.getFont().getSize() + 5f));
		
		lblTipoMaterial = new JLabel("New label");
		lblTipoMaterial.setFont(new Font("Dialog", Font.BOLD, 10));
		lblTipoMaterial.setBounds(26, 231, 245, 15);
		
		lblVolumee = new JLabel("New label");
		lblVolumee.setFont(new Font("Dialog", Font.BOLD, 10));
		lblVolumee.setBounds(300, 231, 206, 15);
		
		lblNumPaginas = new JLabel("New label");
		lblNumPaginas.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNumPaginas.setBounds(528, 293, 193, 15);
		
		lblISBN = new JLabel("New label");
		lblISBN.setFont(new Font("Dialog", Font.BOLD, 10));
		lblISBN.setBounds(527, 168, 194, 15);
				
		lblEditora = new JLabel("Editora");
		lblEditora.setBounds(26, 264, 68, 20);
		lblEditora.setFont(lblEditora.getFont().deriveFont(lblEditora.getFont().getStyle() | Font.BOLD, lblEditora.getFont().getSize() + 5f));
		
		lblAnoPublicao = new JLabel("Ano Publicação");
		lblAnoPublicao.setBounds(733, 142, 141, 20);
		lblAnoPublicao.setFont(lblAnoPublicao.getFont().deriveFont(lblAnoPublicao.getFont().getStyle() | Font.BOLD, lblAnoPublicao.getFont().getSize() + 5f));
		
		lblDimenses = new JLabel("Dimensões");
		lblDimenses.setBounds(527, 209, 103, 20);
		lblDimenses.setFont(lblDimenses.getFont().deriveFont(lblDimenses.getFont().getStyle() | Font.BOLD, lblDimenses.getFont().getSize() + 5f));
		
		lblEditoraa = new JLabel("New label");
		lblEditoraa.setFont(new Font("Dialog", Font.BOLD, 10));
		lblEditoraa.setBounds(26, 289, 245, 15);
		
		lblAnoPublic = new JLabel("New label");
		lblAnoPublic.setFont(new Font("Dialog", Font.BOLD, 10));
		lblAnoPublic.setBounds(733, 168, 181, 15);
		
		lblDimensoes = new JLabel("New label");
		lblDimensoes.setFont(new Font("Dialog", Font.BOLD, 10));
		lblDimensoes.setBounds(527, 235, 194, 15);
				
		lblCodClassificao = new JLabel("Cod. Classificação");
		lblCodClassificao.setBounds(26, 331, 167, 20);
		lblCodClassificao.setFont(lblCodClassificao.getFont().deriveFont(lblCodClassificao.getFont().getStyle() | Font.BOLD, lblCodClassificao.getFont().getSize() + 5f));
		
		lblResumo = new JLabel("Resumo");
		lblResumo.setBounds(300, 331, 75, 20);
		lblResumo.setFont(lblResumo.getFont().deriveFont(lblResumo.getFont().getStyle() | Font.BOLD, lblResumo.getFont().getSize() + 5f));
		
		lblCodC = new JLabel("New label");
		lblCodC.setFont(new Font("Dialog", Font.BOLD, 10));
		lblCodC.setBounds(26, 356, 245, 15);
		
		spResumo = new JScrollPane();
		spResumo.setBounds(300, 356, 587, 109);
		spResumo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		lblAssunto = new JLabel("Assunto");
		lblAssunto.setBounds(26, 400, 75, 20);
		lblAssunto.setFont(lblAssunto.getFont().deriveFont(lblAssunto.getFont().getStyle() | Font.BOLD, lblAssunto.getFont().getSize() + 5f));
		
		lblAssuntoApresenta = new JLabel((String) null);
		lblAssuntoApresenta.setFont(new Font("Dialog", Font.BOLD, 10));
		lblAssuntoApresenta.setBounds(26, 420, 245, 15);
		getContentPane().setLayout(null);
		getContentPane().add(lblTitulo);
		getContentPane().add(lblSubtitulo);
		getContentPane().add(lblCodAcervo);
		getContentPane().add(lblEdio);
		getContentPane().add(lblNomeAutor);
		getContentPane().add(lblLocalPublicao);
		getContentPane().add(lblCodA);
		getContentPane().add(lblEdicao);
		getContentPane().add(lblAutor);
		getContentPane().add(lblLocPublic);
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblVolume);
		getContentPane().add(lblNPaginas);
		getContentPane().add(lblIsbn);
		getContentPane().add(lblTipoMaterial);
		getContentPane().add(lblVolumee);
		getContentPane().add(lblNumPaginas);
		getContentPane().add(lblISBN);
		getContentPane().add(lblEditora);
		getContentPane().add(lblAnoPublicao);
		getContentPane().add(lblDimenses);
		getContentPane().add(lblEditoraa);
		getContentPane().add(lblAnoPublic);
		getContentPane().add(lblDimensoes);
		getContentPane().add(lblCodClassificao);
		getContentPane().add(lblResumo);
		getContentPane().add(lblCodC);
		getContentPane().add(spResumo);
		
		areaResumo = new JTextArea();
		areaResumo.setDocument(new MasksTextArea(3000));
		areaResumo.setLineWrap(true);
		areaResumo.setWrapStyleWord(true);
		areaResumo.setEditable(false);
		spResumo.setViewportView(areaResumo);
		
		
		getContentPane().add(lblAssunto);
		getContentPane().add(lblAssuntoApresenta);

		apresentarTxt(cod_acervo);
	}
}

