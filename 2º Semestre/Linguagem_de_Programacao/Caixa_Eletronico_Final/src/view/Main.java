package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import reg.Atualizada;
import reg.Cadastrar;
import reg.Contas;
import reg.Movimentacao;
import reg_cliente.Mov_Cliente;

import java.awt.Canvas;
import java.awt.Color;

public class Main extends JFrame{
	
	private JLabel lblMenu, lblPessoa;
	private JButton btnCcc, btnCm, btnGca, btnCc, btnCco, btnMo, btnAt, btnFim, btnVo;
	private BufferedReader buffer;
	private JScrollPane scrollPane;
	private Canvas canvas, canvas_1, canvas_2, canvas_3;
	
	public Main(){
		super(".::CAIXA::.");
		
		lblMenu = new JLabel ("Caixa");                      lblMenu.setFont(new Font("Script MT Bold", Font.BOLD, 70));
		btnCcc = new JButton ("Cadastrar Contas Correntes"); btnCcc.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnCm = new JButton ("Cadastrar Movimento");         btnCm.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnGca = new JButton ("Gerar Contas Atualizadas");   btnGca.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnCc = new JButton ("Consultar Cadastros");         btnCc.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnCco = new JButton ("Contas Correntes");           btnCco.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnMo = new JButton ("Movimento");                   btnMo.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnAt = new JButton ("Atualizado");                  btnAt.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnFim = new JButton ("Fim");                        btnFim.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		btnVo = new JButton ("Voltar");                      btnVo.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		btnVo.setContentAreaFilled(false);                   btnVo.setFocusPainted(false);       btnVo.setVisible(false);
		
		/*try {
			lblPessoa = new JLabel("Olá " + nome("Oseias"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(1000, 700);
		this.setLocation(200, 100);
		this.setLocationRelativeTo(null);
		
		
		getContentPane().setLayout(null);
	    
	    scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		getContentPane().add(scrollPane);
		scrollPane.setBounds(400, 20, 750, 625);
		
		getContentPane().add(lblMenu);
		lblMenu.setBounds(110, 20, 200, 100);
		
		/*String nome = lblPessoa.getText();
		if(nome.length() <= 50){
			getContentPane().add(lblPessoa);
			lblPessoa.setBounds(110, 100, 200, 80);
		}*/
		
		getContentPane().add(btnCcc);
		btnCcc.setBounds(40, 200, 330, 80);
		btnCcc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				scrollPane.setViewportView(new Cadastrar());
				scrollPane.repaint();
			}
		});
		
		getContentPane().add(btnCm);
		btnCm.setBounds(40, 300, 330, 80);
		btnCm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				scrollPane.setViewportView(new Movimentacao());
				scrollPane.repaint();
			}
		});
		
		getContentPane().add(btnGca);
		btnGca.setBounds(40, 400, 330, 80);
		btnGca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				scrollPane.setViewportView(new Atualizada());
				scrollPane.repaint();
			}
		});
		
		getContentPane().add(btnCco);
		btnCco.setBounds(40, 200, 330, 80);
		btnCco.setVisible(false);
		btnCco.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				scrollPane.setViewportView(new Contas());
				scrollPane.repaint();
			}
		});
		
		getContentPane().add(btnMo);
		btnMo.setBounds(40, 300, 330, 80);
		btnMo.setVisible(false);
		btnMo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				scrollPane.setViewportView(new Mov_Cliente());
				scrollPane.repaint();
			}
		});
		
		getContentPane().add(btnAt);
		btnAt.setBounds(40, 400, 330, 80);
		btnAt.setVisible(false);
		btnAt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				scrollPane.setViewportView(new Atualizada());
				scrollPane.repaint();
			}
		});
		
		getContentPane().add(btnFim);
		btnFim.setBounds(40, 623, 86, 22);
		//btnFim.setVisible(false);
		btnFim.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		getContentPane().add(btnCc);
		btnCc.setBounds(40, 500, 330, 80);
		btnCc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lblMenu.setText("Consulta"); lblMenu.setFont(new Font("Script MT Bold", Font.BOLD, 70)); lblMenu.setBounds(70, 20, 300, 100);
				btnCcc.setVisible(false);
				btnCm.setVisible(false);
				btnGca.setVisible(false);
				btnCc.setVisible(false);
				btnCco.setVisible(true);
				btnMo.setVisible(true);
				btnAt.setVisible(true);
				btnFim.setVisible(true);
				btnVo.setVisible(true);
			}
		});
		
		getContentPane().add(btnVo);
		btnVo.setBounds(284, 623, 86, 22);
		btnVo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lblMenu.setText("Caixa"); lblMenu.setFont(new Font("Script MT Bold", Font.BOLD, 70)); lblMenu.setBounds(110, 20, 200, 100);
				btnCcc.setVisible(true);
				btnCm.setVisible(true);
				btnGca.setVisible(true);
				btnCc.setVisible(true);
				btnCco.setVisible(false);
				btnMo.setVisible(false);
				btnAt.setVisible(false);
				//btnFim.setVisible(false);
				btnVo.setVisible(false);
			}
		});
		
		canvas = new Canvas();
		canvas.setBackground(Color.GRAY);
		canvas.setBounds(393, 10, 3, 651);
		getContentPane().add(canvas);
		
		canvas_1 = new Canvas();
		canvas_1.setBackground(Color.GRAY);
		canvas_1.setBounds(10, 10, 386, 3);
		getContentPane().add(canvas_1);
		
		canvas_2 = new Canvas();
		canvas_2.setBackground(Color.GRAY);
		canvas_2.setBounds(10, 10, 3, 651);
		getContentPane().add(canvas_2);
		
		canvas_3 = new Canvas();
		canvas_3.setBackground(Color.GRAY);
		canvas_3.setBounds(10, 658, 386, 3);
		getContentPane().add(canvas_3);
		
		
		//scrollPane.setViewportView(new Login());
		//scrollPane.repaint();
	}
	
	public String nome(String login) throws IOException{
		File inf = new File("Pessoa/"+login+".txt");
		String nome = "";
		try {
			buffer = new BufferedReader(new FileReader(inf));  
			
			nome = buffer.readLine();  
			nome = buffer.readLine();  
			nome = buffer.readLine();  
			nome = buffer.readLine();  
			nome = buffer.readLine();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return nome;
	}
	public static void main(String args[]){
		Main m = new Main();
	}
}
