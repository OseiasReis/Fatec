package caixa_ele;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class Retirada extends JPanel{
	protected int ret=0, valor, ced=0, i=5, f, qt;
	protected int[] ce = new int[6];
	protected int v[]={2,5,10,20,50,100};
	protected boolean ca, co=true, es;

	private JScrollPane spBanco, spRetA, spRetM, spRol;
	
	private JLabel lblMenu, lblValor, lbln1, lbln2, lbln3, lble1, lble2, lble3, lble4, lble5, lble6;
	
	private JTextField txtValor, txtQt;
	
	private JButton btnRca, btnRcm, btnOu, btnVo, btnVerifM, btnVerifA;
	
	private Canvas canvas_1, canvas_2, canvas_3;
	
	private JTextArea taCed;
	
	public Retirada(boolean es, int b) {
		
		this.setLayout(null);
		this.setSize(400, 460);
		this.setVisible(true);
		
		Dados dd = new Dados();
		
		int k=b;
		
		lblMenu = new JLabel("Retirada");                    lblMenu.setFont(new Font("Script MT Bold", Font.BOLD, 70));
		btnRca = new JButton ("Retirar Cédulas Automatic."); btnRca.setFont(new Font("Script MT Bold", Font.BOLD, 23));
		btnRcm = new JButton ("Retirar Cédulas Manualmente");btnRcm.setFont(new Font("Script MT Bold", Font.BOLD, 22));
		btnOu = new JButton ("Outro banco");                 btnOu.setFont(new Font("Script MT Bold", Font.BOLD, 24));
		btnVo = new JButton ("Voltar");                      btnVo.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		btnVo.setContentAreaFilled(false);                   btnVo.setFocusPainted(false);       //btnVo.setVisible(false);
		btnVerifM = new JButton ("Verificar");
		btnVerifM.setVisible(false);
		btnVerifA = new JButton ("Verificar");
		btnVerifA.setVisible(false);
		
		lbln1 = new JLabel(""); lbln2 = new JLabel(""); lbln3 = new JLabel("");
		lble1 = new JLabel(""); lble2 = new JLabel(""); lble3 = new JLabel(""); lble4 = new JLabel(""); lble5 = new JLabel(""); lble6 = new JLabel("");
		lblValor = new JLabel("Valor");
		
		
		txtQt = new JTextField();
		txtValor = new JTextField();
		taCed = new JTextArea();
        
		spBanco = new JScrollPane();
		spBanco.setBorder(null);
		spRetA = new JScrollPane();
		spRetA.setBorder(null);
		spRetM = new JScrollPane();
		spRetM.setBorder(null);
		spRol = new JScrollPane(taCed);
		spRol.setBorder(null);
		
		if(es==false) {
			
		add(lblMenu);
		lblMenu.setBounds(50, 15, 300, 100);
		
		add(lblValor);
		lblValor.setBounds(80, 100, 330, 60);
		lblValor.setVisible(false);
		
		add(txtValor);
		txtValor.setBounds(130, 120, 160, 20);
		txtValor.setVisible(false);
		
		add(txtQt);
		txtQt.setBounds(200, 200, 80, 20);
		txtQt.setVisible(false);
		
		add(btnRca);
		btnRca.setBounds(30, 150, 330, 60);
		btnRca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				btnRca.setVisible(false);
				btnRcm.setVisible(false);
				btnOu.setVisible(false);
				btnVo.setVisible(false);
				add(spRetA);
				spRetA.setBounds(0, 0, 750, 625);
				
				lblValor.setVisible(true);
				btnVerifA.setVisible(true);
				txtValor.setVisible(true);
			}
		});
		
		add(btnRcm);
		btnRcm.setBounds(30, 230, 330, 60);
		btnRcm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				btnRca.setVisible(false);
				btnRcm.setVisible(false);
				btnOu.setVisible(false);
				btnVo.setVisible(false);
				add(spRetM);
				spRetM.setBounds(0, 0, 750, 625);
				
				btnVerifM.setVisible(true);
				lblValor.setVisible(true);
				txtValor.setVisible(true);
			}
		});
		
		add(btnOu);
		btnOu.setBounds(30, 310, 330, 60);
		btnOu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lblMenu.setVisible(false);
				btnRca.setVisible(false);
				btnRcm.setVisible(false);
				btnOu.setVisible(false);
				btnVo.setVisible(false);
				taCed.setVisible(false);
				add(spBanco);
				spBanco.setBounds(0, 0, 750, 625);
				spBanco.setViewportView(new Banco(ca, es));
				spBanco.repaint();
			}
		});
		
		add(btnVo);
		btnVo.setBounds(275, 400, 86, 22);
		btnVo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lblMenu.setVisible(true);
				btnRca.setVisible(true);
				btnRcm.setVisible(true);
				btnOu.setVisible(true);
				btnVo.setVisible(false);
				taCed.setVisible(false);
				lbln1.setVisible(false);
				lbln2.setVisible(false);
				lbln3.setVisible(false);
				lblValor.setVisible(false);
				txtValor.setVisible(false);
			}
		});
		
		add(lbln1);
		lbln1.setBounds(60, 150, 290, 40);
		
		add(lbln2);
		lbln2.setBounds(145, 200, 250, 100);
		
		add(lbln3);
		lbln3.setBounds(150, 339, 140, 31);
		
		spRol.setBounds(90, 151, 199, 179);
		add(spRol);
		taCed.setEditable(false);
		taCed.setVisible(false);
		
		add(btnVerifA);
		btnVerifA.setBounds(275, 400, 86, 22);
		btnVerifA.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				valor = Integer.parseInt(txtValor.getText());
				
				if(valor>1){
					//Conta Estatisticas
					if(valor >= v[i]){
						if(valor>dd.mab[k]){
							dd.mab[k]=valor;
						}
						if(valor<dd.meb[k]){
							dd.meb[k]=valor;
						}
						dd.med[k][0]+=valor;
						dd.med[k][1]+=1;
	
						dd.tot[k][0]+=valor;
					}
					//Conta Estatisticas
					
					while(i >= 0){
						if(dd.sb[b]-valor >= 0){
							if(valor >= v[i]){
								if(dd.c[b][i]==0){
									lbln1.setText("Não possui mais cédulas de "+ v[i]+"\n");
									i--;
								}else{
									taCed.setVisible(true);
									taCed.append("R$" + valor + ": Cédula de "+ v[i] +"\n");
									valor -= v[i];
									dd.sb[b] -= v[i];
									dd.c[b][i] -= 1;
									ced++;
									//System.out.println(dd.c[b][5] + "\n" + dd.c[b][4] + "\n" + dd.c[b][3] + "\n" + dd.c[b][2] + "\n" + dd.c[b][1] + "\n" + dd.c[b][0] + "\n");
								}
							}else{
								i--;
							}
						}else{
							lbln1.setText("Não possui mais notas ou excede o limite do caixa");
							lbln2.setText("\nSaldo: "+ dd.sb[b]);
							i=-1;
						}
					}
					}else{
						lbln1.setText("Digite um valor maior");
					}
					lbln3.setText("\n"+ced+ " cédulas\n");
					
					btnVerifA.setVisible(false);
					btnVo.setVisible(true);
					
			}
		});

		add(btnVerifM);
		btnVerifM.setBounds(275, 400, 86, 22);
		btnVerifM.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				valor = Integer.parseInt(txtValor.getText());
				
				if(valor>1){
					//Contas Estatisticas
					if(valor >= v[i]){
						if(valor>dd.mab[k]){
							dd.mab[k]=valor;
						}
						if(valor<dd.meb[k]){
							dd.meb[k]=valor;
						}
						dd.med[k][0]+=valor;
						dd.med[k][1]+=1;
	
						dd.tot[k][0]+=valor;
					}
					//Contas Estatisticas
					
					while(i >= 0){
						if(dd.sb[b]-valor >= 0){
							if(valor >= v[i] && co==true){
								//lbln1.setText("Quantas cédulas de "+ v[i]+" a ser retirada?\n");
								//txtQt.setVisible(true);
								
								qt = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantas cédulas de "+ v[i]+" a ser retirada?"));
								taCed.append(qt + "\n");
								 if(dd.sb[b]-valor >= 0 && qt*v[i] <= valor){
									 if(dd.c[b][i]==0){
										lbln2.setText("Não possui mais cédulas de "+ v[i]+"\n");
										i--;
									}else{
										taCed.setVisible(true);
										valor -= qt*v[i];
										taCed.append("R$" + valor + ": " + qt + " cédula de " + v[i]+ "\n");
										dd.sb[b] -= qt*v[i];
										dd.c[b][i] -= qt;
										ced= ced+qt;
									}
								}else{
									lbln2.setText("Não é possivel retirar essa quantidade");
									taCed.setVisible(false);
									co=false;
								}
								
							}else{
								i--;
							}
						}else{
							lbln1.setText("Não possui mais cédulas ou excede o limite");
							lbln2.setText("\nSaldo: "+ dd.sb[b]);
							i=-1;
						}
					}
					}else{
						lbln1.setText("Digite um valor maior");
					}
					lbln3.setText("\n"+ced+ " cédulas\n");
					
					btnVerifM.setVisible(false);
					btnVo.setVisible(true);
			}
		});
		
		}else {
			add(lblMenu);
			lblMenu.setBounds(50, 15, 300, 100);
			
			add(lble1);
			lble1.setBounds(60, 130, 290, 40);
			lble1.setFont(new Font("Script MT Bold", Font.BOLD, 35));
			lble1.setForeground(Color.red);
			
			add(lble2); 
			lble2.setBounds(60, 190, 290, 40);
			lble2.setFont(new Font("Script MT Bold", Font.BOLD, 23));
			
			add(lble3);
			lble3.setBounds(60, 230, 290, 40);
			lble3.setFont(new Font("Script MT Bold", Font.BOLD, 23));
			
			add(lble4);
			lble4.setBounds(60, 270, 290, 40);
			lble4.setFont(new Font("Script MT Bold", Font.BOLD, 23));
			
			add(lble5);
			lble5.setBounds(60, 310, 290, 40);
			lble5.setFont(new Font("Script MT Bold", Font.BOLD, 23));
			
			add(lble6);
			lble6.setBounds(60, 350, 290, 40);
			lble6.setFont(new Font("Script MT Bold", Font.BOLD, 23));
			
			Estatisticas(b);
		}
		
		Canvas canvas = new Canvas();
		canvas = new Canvas();
		canvas.setBackground(Color.GRAY);
		canvas.setBounds(10, 10, 3, 427);
		add(canvas);
		canvas_1 = new Canvas();
		canvas_1.setBackground(Color.GRAY);
		canvas_1.setBounds(10, 434, 368, 3);
		add(canvas_1);
		canvas_2 = new Canvas();
		canvas_2.setBackground(Color.GRAY);
		canvas_2.setBounds(10, 10, 368, 3);
		add(canvas_2);
		canvas_3 = new Canvas();
		canvas_3.setBackground(Color.GRAY);
		canvas_3.setBounds(375, 10, 3, 427);
		add(canvas_3);
	}
	
	public void Estatisticas(int b) {
		Dados dd = new Dados();
		
		int k=b;
		
		lblMenu.setText("Estatisticas");
		lblMenu.setFont(new Font("Script MT Bold", Font.BOLD, 58));
		
		if(dd.mab[k]==0 && dd.meb[k] == 9999){
			lble1.setText("Sem valores\n\n");
		}else{
			String nb1="Banco do Brasil", nb2="Santander", nb3="Itaú", nb4="Caixa";
			if(b==1){
				lble1.setText(nb1+ "\n");
			}
			if(b==2){
				lble1.setText(nb2+ "\n");
			}
			if(b==3){
				lble1.setText(nb3+ "\n");
			}
			if(b==4){
				lble1.setText(nb4+ "\n");
			}
			lble2.setText("Maior valor sacado: R$" + dd.mab[b] + "\n");
			lble3.setText("Menor valor sacado: R$" + dd.meb[b] + "\n");
			if(dd.med[4][0]==0){
				dd.med[4][0]=1;
			}
			dd.med[b][0]=dd.med[b][0]/dd.med[k][1];
			lble4.setText("Media dos saques: R$" + dd.med[b][0] + "\n");
			lble5.setText("Total dos saques: R$" + dd.tot[b][0] + "\n");
			lble6.setText("Sobra dos caixas: R$" + dd.sb[b] + "\n");
		}
	}
}
