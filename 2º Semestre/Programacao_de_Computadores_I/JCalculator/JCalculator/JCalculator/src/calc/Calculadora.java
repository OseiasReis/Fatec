package calc;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculadora extends JFrame{
	
	private JTextField txtVisor = new JTextField("");
	private JButton btnCE = new JButton("CE");
	private JButton btnMais = new JButton("M+");
	private JButton btnMenos = new JButton("M-");
	
	private JButton btn1 = new JButton("1");
	private JButton btn2 = new JButton("2");
	private JButton btn3 = new JButton("3");
	
	private JButton btn4 = new JButton("4");
	private JButton btn5 = new JButton("5");
	private JButton btn6 = new JButton("6");
	
	private JButton btn7 = new JButton("7");
	private JButton btn8 = new JButton("8");
	private JButton btn9 = new JButton("9");
	
	private JButton btn0 = new JButton("0");
	
	private JButton btnIgual = new JButton("=");
	
	private JButton btnSoma = new JButton("+");
	private JButton btnSubtracao = new JButton("-");
	private JButton btnMultiplicacao = new JButton("*");
	private JButton btnDivisao = new JButton("/");
	
	private Operacoes op = new Operacoes();
	private String operador;
	private double valor1, valor2;
	
	public Calculadora(){
		super("JCalculator");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		txtVisor.setBounds(20, 20, 320, 60);
		txtVisor.disable();
		paine.add(txtVisor);
		
		btnCE.setBounds(20, 100, 140, 60);
		btnCE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtVisor.setText("");
			}
		});
		paine.add(btnCE);
		
		btnMais.setBounds(170, 100, 80, 60);
		paine.add(btnMais);
		
		btnMenos.setBounds(260, 100, 80, 60);
		paine.add(btnMenos);
		
		
		btn1.setBounds(20, 170, 100, 60);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtVisor.setText(txtVisor.getText() + "1");
			}
		});
		paine.add(btn1);
		
		btn2.setBounds(130, 170, 100, 60);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtVisor.setText(txtVisor.getText() + "2");
			}
		});
		paine.add(btn2);
		
		btn3.setBounds(240, 170, 100, 60);
		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtVisor.setText(txtVisor.getText() + "3");
			}
		});
		paine.add(btn3);
		
		
		btn4.setBounds(20, 240, 100, 60);
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtVisor.setText(txtVisor.getText() + "4");
			}
		});
		paine.add(btn4);
		
		btn5.setBounds(130, 240, 100, 60);
		btn5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtVisor.setText(txtVisor.getText() + "5");
			}
		});
		paine.add(btn5);
		
		btn6.setBounds(240, 240, 100, 60);
		btn6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtVisor.setText(txtVisor.getText() + "6");
			}
		});
		paine.add(btn6);
		
		
		btn7.setBounds(20, 310, 100, 60);
		btn7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtVisor.setText(txtVisor.getText() + "7");
			}
		});
		paine.add(btn7);
		
		btn8.setBounds(130, 310, 100, 60);
		btn8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtVisor.setText(txtVisor.getText() + "8");
			}
		});
		paine.add(btn8);
		
		btn9.setBounds(240, 310, 100, 60);
		btn9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtVisor.setText(txtVisor.getText() + "9");
			}
		});
		paine.add(btn9);
		
		
		btn0.setBounds(20, 380, 210, 60);
		btn0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtVisor.setText(txtVisor.getText() + "0");
			}
		});
		paine.add(btn0);
		
		btnIgual.setBounds(240, 380, 100, 60);
		btnIgual.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double resultado; 
				valor2 = Double.parseDouble(txtVisor.getText());
				
				if( operador == "+"){
					
					resultado = op.somar(valor1, valor2);
					//txtVisor.setText(resultado);
				
				}else if( operador == "-"){
					
				}else if( operador == "*"){
					
				}else{
					
				}
			}
		});
		paine.add(btnIgual);
		
		
		btnSoma.setBounds(20, 450, 75, 60);
		btnSoma.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				valor1 = Double.parseDouble(txtVisor.getText());
				operador = "+";
				
			}
		});
		paine.add(btnSoma);
		
		btnSubtracao.setBounds(102, 450, 75, 60);
		btnSubtracao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		paine.add(btnSubtracao);
		
		btnMultiplicacao.setBounds(183, 450, 75, 60);
		btnMultiplicacao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		paine.add(btnMultiplicacao);
		
		btnDivisao.setBounds(265, 450, 75, 60);
		btnDivisao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				
			}
		});
		paine.add(btnDivisao);
		
		this.setSize(375, 570);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
	}

}
