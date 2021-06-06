package Calculadora;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculadora_Interface extends JFrame {
	
	private JButton btnCE = new JButton("CE");
	private JButton btnMais = new JButton("M+");
	private JButton btnMenos = new JButton("M-");
	
	private JButton btnUm = new JButton("1");
	private JButton btnDois = new JButton("2");
	private JButton btnTres = new JButton("3");
	private JButton btnQuatro = new JButton("4");
	private JButton btnCinco = new JButton("5");
	private JButton btnSeis = new JButton("6");
	private JButton btnSete = new JButton("7");
	private JButton btnOito = new JButton("8");
	private JButton btnNove = new JButton("9");
	private JButton btnZero = new JButton("0");
	
	private JButton btnResult = new JButton("=");
	private JButton btnSoma = new JButton("+");
	private JButton btnSub = new JButton("-");
	private JButton btnMult = new JButton("*");
	private JButton btnDiv = new JButton("/");
	 
	private JTextField txtResult = new JTextField();

	private Calculadora_Resultados CalR = new Calculadora_Resultados();
	private String operador;
	private double Valor1, Valor2;
	
	public Calculadora_Interface(){
		super (".:Calculadora:.");

		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(txtResult);
		txtResult.setBounds(40, 8, 240, 35);
		txtResult.setEditable(false); 
		
		paine.add(btnCE);
		btnCE.setBounds(40, 50, 80, 50);
		btnCE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText("");
			}
		});
		
		paine.add(btnMais);
		btnMais.setBounds(120, 50, 80, 50);
		btnMais.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		
		paine.add(btnMenos);
		btnMenos.setBounds(200, 50, 80, 50);
		btnMenos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		paine.add(btnUm);
		btnUm.setBounds(40, 120, 80, 50);
		btnUm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "1");
			}
		});
		
		paine.add(btnDois);
		btnDois.setBounds(120, 120, 80, 50);
		btnDois.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "2"); 			
			}
		});
		
		paine.add(btnTres);
		btnTres.setBounds(200, 120, 80, 50);
		btnTres.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "3"); 			
			}
		});
		
		paine.add(btnQuatro);
		btnQuatro.setBounds(40, 170, 80, 50);
		btnQuatro.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "4"); 			
			}
		});
		
		paine.add(btnCinco);
		btnCinco.setBounds(120, 170, 80, 50);
		btnCinco.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "5"); 			
			}
		});
		
		paine.add(btnSeis);
		btnSeis.setBounds(200, 170, 80, 50);
		btnSeis.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "6"); 			
			}
		});
		
		paine.add(btnSete);
		btnSete.setBounds(40, 220, 80, 50);
		btnSete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "7"); 			
			}
		});
		
		paine.add(btnOito);
		btnOito.setBounds(120, 220, 80, 50);
		btnOito.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "8"); 			
			}
		});
		
		paine.add(btnNove);
		btnNove.setBounds(200, 220, 80, 50);
		btnNove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "9"); 			
			}
		});
		
		paine.add(btnZero);
		btnZero.setBounds(40, 270, 160, 50);
		btnZero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "0");
			}
		});
		
		paine.add(btnResult);
		btnResult.setBounds(200, 270, 80, 50);
		btnResult.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double resultado;
				Valor2 = Double.parseDouble(txtResult.getText());
				
				if( operador == "+"){
					
					resultado = CalR.Soma(Valor1, Valor2);
					txtResult.setText(resultado);
				
				}
				
				else
					if( operador == "-"){
					
					resultado = CalR.Sub(Valor1, Valor2);
					txtResult.setText(resultado);
					
				}
				
				else 
					if( operador == "*"){
					
					resultado = CalR.Multi(Valor1, Valor2);
					txtResult.setText(resultado);
					
				}
				
				else{
					
					resultado = CalR.Div(Valor1, Valor2);
					txtResult.setText(resultado);
					
				}
			}
		});
		
		paine.add(btnSoma);
		btnSoma.setBounds(40, 340, 60, 50);
		btnSoma.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "+");
				Valor1 = Double.parseDouble(txtResult.getText());
				operador = "+";
			}
		});
		
		paine.add(btnSub);
		btnSub.setBounds(100, 340, 60, 50);
		btnSub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "-");
				Valor1 = Double.parseDouble(txtResult.getText());
				operador = "-";
			}
		});
		
		paine.add(btnMult);
		btnMult.setBounds(160, 340, 60, 50);
		btnMult.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "*");
				Valor1 = Double.parseDouble(txtResult.getText());
				operador = "*";
			}
		});
		
		paine.add(btnDiv);
		btnDiv.setBounds(220, 340, 60, 50);
		btnDiv.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtResult.setText(txtResult.getText() + "/");
				Valor1 = Double.parseDouble(txtResult.getText());
				operador = "/";
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(320, 430);
		this.setResizable(false);
	}
	public static void main(String args[]){
		Calculadora_Interface Cal = new Calculadora_Interface();
	}
}
