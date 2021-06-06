package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import model.Cliente;
import persist.IGenericDAO;
import persist.JDBCDAO;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class RemoverMulta extends JFrame {
	
	private JTextField txtRegistroCliente;
	private JTextField txtValorMulta;
	private JLabel lblRegistroCliente;
	private JLabel lblValorMulta;
	private JButton btnRemover;
	private JLabel lblRemoverMulta;
	private JButton btnCancelar;
	private JButton btnVerificar;
	private Cliente cliente = new Cliente();
	
	private void desbloquearBotoes(Boolean opcao) {
		if (opcao == true) {
			btnCancelar.setVisible(true);
			btnRemover.setVisible(true);
			btnVerificar.setVisible(false);
			txtRegistroCliente.setEnabled(false);
		} else {
			btnCancelar.setVisible(false);
			btnRemover.setVisible(false);
			btnVerificar.setVisible(true);
			txtValorMulta.setText("");
			txtRegistroCliente.setEnabled(true);
		}
	}
	
	public RemoverMulta() {
		
		super("..::     Remover Multa     ::..");
		Container tela = getContentPane();
		setSize(329, 298);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		ImageIcon icone = new ImageIcon("images/logotitulo.png");
		setIconImage(icone.getImage());
		
		lblRegistroCliente = new JLabel("Registro Cliente");
		tela.add(lblRegistroCliente);
		lblRegistroCliente.setBounds(26, 73, 131, 15);
		
		txtRegistroCliente = new JTextField();
		tela.add(txtRegistroCliente);
		txtRegistroCliente.setBounds(26, 92, 164, 25);
		txtRegistroCliente.setColumns(10);
		
		btnVerificar = new JButton("Verificar");
		tela.add(btnVerificar);
		btnVerificar.setBounds(202, 92, 99, 25);
		
		txtValorMulta = new JTextField();
		tela.add(txtValorMulta);
		txtValorMulta.setColumns(10);
		txtValorMulta.setBounds(26, 178, 131, 25);
		txtValorMulta.setEditable(false);
		txtValorMulta.setBorder(null);
		
		lblValorMulta = new JLabel("Valor da Multa");
		tela.add(lblValorMulta);
		lblValorMulta.setBounds(26, 158, 150, 15);
		
		btnRemover = new JButton("Remover");
		tela.add(btnRemover);
		btnRemover.setBounds(202, 178, 99, 30);
		
		lblRemoverMulta = new JLabel("REMOVER MULTA");
		tela.add(lblRemoverMulta);
		lblRemoverMulta.setFont(new Font("Arial", Font.BOLD, 17));
		lblRemoverMulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverMulta.setBounds(26, 12, 275, 49);
		
		btnCancelar = new JButton("Cancelar");
		tela.add(btnCancelar);
		btnCancelar.setBounds(202, 219, 99, 30);
		
		desbloquearBotoes(false);
		
		btnVerificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IGenericDAO<Cliente, String> jdbcCliente = new JDBCDAO<Cliente, String>(Cliente.class);
				cliente = jdbcCliente.read(txtRegistroCliente.getText());
				
				if (cliente != null) {
					if (cliente.getMulta_pendente() != 0.0) {
						txtValorMulta.setText("R$ " + String.format("%.2f", cliente.getMulta_pendente()));
						desbloquearBotoes(true);
					} else {
						JOptionPane.showMessageDialog(null, "Cliente não possui multa pendente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover a multa?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (opcao == 0) {
					IGenericDAO<Cliente, String> jdbcCliente = new JDBCDAO<Cliente, String>(Cliente.class);
					cliente.setMulta_pendente(0.0);
					jdbcCliente.update(cliente, cliente.getRegistro());
					JOptionPane.showMessageDialog(null, "Multa removida com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					desbloquearBotoes(false);
					cliente = null;
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desbloquearBotoes(false);
				cliente = null;
			}
		});
		
	}
}
