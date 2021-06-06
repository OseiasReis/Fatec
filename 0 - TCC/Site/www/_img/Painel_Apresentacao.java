package view.panels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class Painel_Apresentacao extends JPanel {
	
	private JLabel lblImagem;
				
	public Painel_Apresentacao() {

		this.setLayout(new MigLayout("", "[150.00,grow]", "[209.00,grow][90]"));
		
		lblImagem = new JLabel(new ImageIcon("images/image_grande.png"));
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblImagem, "cell 0 0,grow");
		
	}
}
