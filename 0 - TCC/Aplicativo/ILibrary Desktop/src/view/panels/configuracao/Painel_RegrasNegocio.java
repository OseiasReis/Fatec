package view.panels.configuracao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.Masks;
import model.Penalidade;
import net.miginfocom.swing.MigLayout;
import persist.IGenericDAO;
import persist.SerDAO;

@SuppressWarnings("serial")
public class Painel_RegrasNegocio extends JPanel {
	
	private JLabel lblPermitirAoOperador;
	private JLabel lblUtilizarClculoDe;
	private JLabel lblEmprestarMultado;
	private JLabel lblEmprestarSuspenso;
	private JLabel lblMulta;
	private JLabel lblSuspensao;
	private JLabel lblValMulta;
	
	private JTextField txtSuspensao;
	private JTextField txtValMulta;
	
	private final ButtonGroup bgCalc = new ButtonGroup();
	private final ButtonGroup bgSuspManual = new ButtonGroup();
	private final ButtonGroup bgMulta = new ButtonGroup();
	private final ButtonGroup bgEmprestarSuspenso = new ButtonGroup();
	private final ButtonGroup bgEmprestarMultado = new ButtonGroup();
	
	private JRadioButton rdbPermitir;
	private JRadioButton rdbNaoPermitir;
	private JRadioButton rdbAceitarCalc;
	private JRadioButton rdbRejeitarCalc;
	private JRadioButton rdbOpcionalSusp;
	private JRadioButton rdbRestritaSusp;
	private JRadioButton rdbOpcionalMult;
	private JRadioButton rdbRestritaMult;
	private JRadioButton rdbMultaSim;
	private JRadioButton rdbMultaNao;

	private JButton btnAplicar;
	
	private Penalidade penalidade = null;
	
	private void inicializarComponentes() {
		IGenericDAO<Penalidade, String> serDao = new SerDAO<Penalidade, String>(Penalidade.class);		
		penalidade = (Penalidade) serDao.read(null);
		
		if(penalidade.getSuspensao_manual().equals(true))
			rdbPermitir.setSelected(true);
		else
			rdbNaoPermitir.setSelected(true);
		
		if(penalidade.getSuspensao_automatica().equals(true))
			rdbAceitarCalc.setSelected(true);
		else
			rdbRejeitarCalc.setSelected(true);
		
		txtSuspensao.setText(penalidade.getDias_suspensao());
		
		if(penalidade.getMulta().equals(true))
			rdbMultaSim.setSelected(true);
		else
			rdbMultaNao.setSelected(true);
		
		if(penalidade.getEmprestar_suspenso().equals(true))
			rdbOpcionalSusp.setSelected(true);
		else
			rdbRestritaSusp.setSelected(true);
		
		if(penalidade.getEmprestar_multado().equals(true))
			rdbOpcionalMult.setSelected(true);
		else
			rdbRestritaMult.setSelected(true);
		
		txtValMulta.setText(penalidade.getValor_multa().toString());
		
		atualizarComponentes();

	}
	
	private void atualizarComponentes(){		
		if(rdbAceitarCalc.isSelected()){
			lblSuspensao.setVisible(true);
			txtSuspensao.setVisible(true);
		}else{
			lblSuspensao.setVisible(false);
			txtSuspensao.setVisible(false);
		}
		
		
		if(rdbMultaSim.isSelected()){
			lblValMulta.setVisible(true);
			txtValMulta.setVisible(true);
		}else{
			lblValMulta.setVisible(false);
			txtValMulta.setVisible(false);
		}
		
	}
	
	public Painel_RegrasNegocio() {
		
		setLayout(new MigLayout("", "[15][200.00:162.00:184.00][223.00]", "[5][][][20][][][25][20][25][][][20][][][20][][][18.00][29.00]"));
		
		lblPermitirAoOperador = new JLabel("Permitir operador aplicar suspensão manualmente? *");
		lblPermitirAoOperador.setFont(new Font("Dialog", Font.BOLD, 12));
		this.add(lblPermitirAoOperador, "cell 1 1 2 1");
		
		rdbPermitir = new JRadioButton("Permitir");
		bgSuspManual.add(rdbPermitir);
		this.add(rdbPermitir, "cell 1 2");
		
		rdbNaoPermitir = new JRadioButton("Não permitir");
		bgSuspManual.add(rdbNaoPermitir);
		this.add(rdbNaoPermitir, "cell 2 2");
		
		lblUtilizarClculoDe = new JLabel("Utilizar cálculo de suspensão automático? *");
		this.add(lblUtilizarClculoDe, "cell 1 4 2 1");
		
		rdbAceitarCalc = new JRadioButton("Sim");
		bgCalc.add(rdbAceitarCalc);
		this.add(rdbAceitarCalc, "cell 1 5");
		rdbAceitarCalc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				atualizarComponentes();
			}
		});
		
		rdbRejeitarCalc = new JRadioButton("Não");
		bgCalc.add(rdbRejeitarCalc);
		this.add(rdbRejeitarCalc, "cell 2 5");
		rdbRejeitarCalc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				atualizarComponentes();
			}
		});
		
		lblSuspensao = new JLabel("Qtde. dias p/ atraso");
		this.add(lblSuspensao, "cell 1 6,alignx trailing");
		
		txtSuspensao = new Masks(2, false);
		this.add(txtSuspensao, "cell 2 6,alignx left");
		txtSuspensao.setColumns(10);
		
		lblMulta = new JLabel("Utilizar cálculo de multa monetária? *");
		this.add(lblMulta, "cell 1 8 2 1,growx");
		
		rdbMultaSim = new JRadioButton("Sim");
		bgMulta.add(rdbMultaSim);
		this.add(rdbMultaSim, "cell 1 9");
		rdbMultaSim.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				atualizarComponentes();
			}
		});
		
		rdbMultaNao = new JRadioButton("Não");
		bgMulta.add(rdbMultaNao);
		this.add(rdbMultaNao, "cell 2 9");
		rdbMultaNao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				atualizarComponentes();
			}
		});

		
		lblValMulta = new JLabel("Val. p/ atraso R$");
		this.add(lblValMulta, "cell 1 10,alignx trailing");
			
		txtValMulta = new JTextField();
		this.add(txtValMulta, "cell 2 10,alignx left");
		txtValMulta.setColumns(10);
		
		lblEmprestarSuspenso = new JLabel("Empréstimo para cliente suspenso?");
		this.add(lblEmprestarSuspenso, "cell 1 12,growy");
		
		rdbOpcionalSusp = new JRadioButton("Opcional");
		bgEmprestarSuspenso.add(rdbOpcionalSusp);
		this.add(rdbOpcionalSusp, "cell 1 13");
		
		rdbRestritaSusp = new JRadioButton("Restrita");
		bgEmprestarSuspenso.add(rdbRestritaSusp);
		this.add(rdbRestritaSusp, "cell 2 13");
		
		lblEmprestarMultado = new JLabel("Empréstimo para cliente multado?");
		this.add(lblEmprestarMultado, "cell 1 15");
		
		rdbOpcionalMult = new JRadioButton("Opcional");
		bgEmprestarMultado.add(rdbOpcionalMult);
		this.add(rdbOpcionalMult, "cell 1 16");
		
		rdbRestritaMult = new JRadioButton("Restrita");
		bgEmprestarMultado.add(rdbRestritaMult);
		this.add(rdbRestritaMult, "cell 2 16");
		
		btnAplicar = new JButton("Aplicar");
		this.add(btnAplicar, "cell 2 18,alignx right,growy");
		
		inicializarComponentes();
		
		btnAplicar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(txtSuspensao.isVisible() && txtSuspensao.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Preencha o campo suspensão!", "Aviso", JOptionPane.WARNING_MESSAGE);
				else{
					if(txtValMulta.isVisible() && txtValMulta.getText().equals("  .  "))
						JOptionPane.showMessageDialog(null, "Preencha o campo multa!", "Aviso", JOptionPane.WARNING_MESSAGE);
					else {
						
						if(rdbPermitir.isSelected())
							penalidade.setSuspensao_manual(true);
						else
							penalidade.setSuspensao_manual(false);
						
						if(rdbAceitarCalc.isSelected())
							penalidade.setSuspensao_automatica(true);
						else
							penalidade.setSuspensao_automatica(false);
						
						penalidade.setDias_suspensao(txtSuspensao.getText());
						
						if(rdbMultaSim.isSelected())
							penalidade.setMulta(true);
						else
							penalidade.setMulta(false);
												
						if(rdbOpcionalMult.isSelected())
							penalidade.setEmprestar_multado(true);
						else
							penalidade.setEmprestar_multado(false);
						
						if(rdbOpcionalSusp.isSelected())
							penalidade.setEmprestar_suspenso(true);
						else
							penalidade.setEmprestar_suspenso(false);
						
						try {
							penalidade.setValor_multa(Double.parseDouble(txtValMulta.getText()));

							IGenericDAO<Penalidade, String> serDao = new SerDAO<Penalidade, String>(Penalidade.class);
							serDao.create(penalidade);
							JOptionPane.showMessageDialog(null, "Configurações alteradas com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Valor inválido para multa", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});	
	}
}
