package controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Metodos extends JFrame{
	public Metodos() {
		super();
	}
	
	//Tela tl = new Tela();
	
	public JTextField Procurar(JTextField txtPesq) {
		//txtPesq.setText("Hello Dark my old friend");
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos Executáveis (.exe)", "exe");
		
		String diretorioBase = System.getProperty("user.home")+"/c/users";
		File dir = new File(diretorioBase);
		
		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setAcceptAllFileFilterUsed(false);
		choose.addChoosableFileFilter(filtro);
		String caminhoArquivo = "";
		
		int retorno = choose.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = choose.getSelectedFile().getAbsolutePath();
			txtPesq.setText(caminhoArquivo);
		}
		
		return txtPesq;
	}
	
	public void Executar(JTextField txtPesq, JFrame frame) {
		String Pesq = txtPesq.getText();
		if(Pesq == null) {
			JOptionPane.showMessageDialog(null, "Digite um caminho", "Erro", JOptionPane.ERROR_MESSAGE);
		}else {
			try {
				Runtime.getRuntime().exec(Pesq.toString());
				frame.dispose();
			} catch (IOException e) {
				if(e.getMessage().contains("740")) {
					StringBuffer buffer = new StringBuffer();
					buffer.append("cmd /c ");
					buffer.append(Pesq.toString());
					try {
						Runtime.getRuntime().exec(buffer.toString());
						frame.dispose();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Caminho invalido", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Caminho invalido", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	public void Cancelar(JFrame frame) {
		frame.dispose();
	}
}
