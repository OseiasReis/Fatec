package view;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Tela_Caluladora extends Application{

	Button btnCE = new Button("CE");
	Button btnUm = new Button("1");
	Button btnDois = new Button("2");
	Button btnTres = new Button("3");
	Button btnQuatro = new Button("4");
	Button btnCinco = new Button("5");
	Button btnSeis = new Button("6");
	Button btnSete = new Button("7");
	Button btnOito = new Button("8");
	Button btnNove = new Button("9");
	Button btnZero = new Button("0");
	Button btnVirg = new Button(",");
	Button btnIg = new Button("=");
	Button btnDiv = new Button("/");
	Button btnMult = new Button("*");
	Button btnSub = new Button("-");
	Button btnSoma = new Button("+");
	
	TextField txtResp = new TextField();
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane tela = new Pane();
		Scene scn = new Scene(tela);
		
		stage.setTitle("Calculadora");
		stage.setScene(scn);
		stage.setWidth(290);
		stage.setHeight(320);

		txtResp.relocate(20, 30);
		txtResp.setPrefWidth(170);
		
		btnCE.relocate(200, 20);
		btnCE.setPrefSize(50, 40);
		
		btnUm.relocate(20, 80);
		btnUm.setPrefSize(50, 40);
		
		btnDois.relocate(80, 80);
		btnDois.setPrefSize(50, 40);
		
		btnTres.relocate(140, 80);
		btnTres.setPrefSize(50, 40);
		
		btnQuatro.relocate(20, 130);
		btnQuatro.setPrefSize(50, 40);
		
		btnCinco.relocate(80, 130);
		btnCinco.setPrefSize(50, 40);
		
		btnSeis.relocate(140, 130);
		btnSeis.setPrefSize(50, 40);
		
		btnSete.relocate(20, 180);
		btnSete.setPrefSize(50, 40);
		
		btnOito.relocate(80, 180);
		btnOito.setPrefSize(50, 40);
		
		btnNove.relocate(140, 180);
		btnNove.setPrefSize(50, 40);
		
		btnZero.relocate(80, 230);
		btnZero.setPrefSize(50, 40);
		
		btnVirg.relocate(20, 230);
		btnVirg.setPrefSize(50, 40);
		
		btnIg.relocate(140, 230);
		btnIg.setPrefSize(50, 40);
		
		btnDiv.relocate(200, 230);
		btnDiv.setPrefSize(50, 40);
		
		btnMult.relocate(200, 180);
		btnMult.setPrefSize(50, 40);
		
		btnSub.relocate(200, 130);
		btnSub.setPrefSize(50, 40);
		
		btnSoma.relocate(200, 80);
		btnSoma.setPrefSize(50, 40);
		
		tela.getChildren().addAll(btnCE , btnUm, btnDois, btnTres, btnQuatro, btnCinco, btnSeis, btnSete, btnOito, btnNove, btnZero,
		btnVirg, btnIg, btnDiv, btnMult, btnSub, btnSoma, txtResp);
		
		EventHandler<Event> ev = new Eventos();
		EventHandler<Event> ev2 = new EventoResp();
		scn.addEventHandler(Event.ANY, ev);
		scn.addEventHandler(Event.ANY, ev2);
		
		stage.show();
	}
	
	public class EventoResp implements EventHandler<Event> {
		@Override
		public void handle(Event event) {
			String res;
			if (event.getTarget() == btnIg) { 
				res= txtResp.getText();
		        String resultado = calculadora(res);
		        txtResp.setText(String.valueOf(resultado));
			}
		}
	}
	
	public String calculadora(String expressao) {
        String resultado;
        List<Double> listaNumeros = new ArrayList<Double>();
        List<Character> listaOperadores = new ArrayList<Character>();
 
        listaNumeros = obterNumeros(expressao);
        listaOperadores = obterOperadores(expressao);
 
        resultado = calcularValor(listaNumeros, listaOperadores);
 
        return resultado;
 
    }
 
    private String calcularValor(List<Double> listaNumeros, List<Character> listaOperadores) {
        String resultado = "";
        double total = 0.0;
        int j=0;
        for (int i = 0; i < listaNumeros.size()-1; i++) {
 
            if ( total==0.0) {
                double numero1 = listaNumeros.get(i).doubleValue();
                double numero2 = listaNumeros.get(i + 1).doubleValue();
                char operador = listaOperadores.get(i).charValue();
                total = executarOperacao(numero1, operador, numero2);
            }
            else if (total>0.0) {
                 
                double numero2 = listaNumeros.get(i).doubleValue();
                char operador = listaOperadores.get(j).charValue();
                total = executarOperacao(total, operador, numero2);
                j++;
            }
        }
 
        resultado = ""+total;
        return resultado;
    }
 
    private double executarOperacao(double numero1, char operador, double numero2) {
        double resultado = 0.0;
 
        if (operador == '+') {
            resultado = numero1 + numero2;
        } else if (operador == '-') {
            resultado = numero1 - numero2;
        } else if (operador == '/') {
            resultado = numero1 / numero2;
        } else if (operador == '*') {
            resultado = numero1 * numero2;
        }
        return resultado;
    }
 
    private List<Double> obterNumeros(String expressao) {
 
        List<Double> listaNumeros = new ArrayList<Double>();
 
        String numeroEmString = "";
        for (int i = 0; i < expressao.length(); i++) {
 
            if (isOperador(expressao.charAt(i))) {
                Double numero = Double.valueOf(numeroEmString);
                listaNumeros.add(numero);
                numeroEmString = "";
            } else {
                numeroEmString = numeroEmString.concat("" + expressao.charAt(i));
            }
        }
        if(!numeroEmString.isEmpty())
        {
                Double numero = Double.valueOf(numeroEmString);
                listaNumeros.add(numero);
             
        }
        return listaNumeros;
    }
 
    private List<Character> obterOperadores(String expressao) {
 
        List<Character> listaOperadores = new ArrayList<Character>();
 
 
        for (int i = 0; i < expressao.length(); i++) {
 
            if (isOperador(expressao.charAt(i))) {
                listaOperadores.add(new Character(expressao.charAt(i)));
            }
        }
 
        return listaOperadores;
    }
	
    private boolean isOperador(char caracter) {
        boolean isOperador = false;
        if (caracter == '-' || caracter == '+' || caracter == '/' || caracter == '*') {
            isOperador = true;
        }
        return isOperador;
    }
    
	public class Eventos implements EventHandler<Event> {
		@Override
		public void handle(Event event) {
			String aux;
			if (event.getTarget() == btnUm) { 
				aux = txtResp.getText();
				txtResp.setText(aux + Integer.valueOf(1));
			}
			if (event.getTarget() == btnDois) { 
				aux = txtResp.getText();
				txtResp.setText(aux + Integer.valueOf(2));
			}
			if (event.getTarget() == btnTres) { 
				aux = txtResp.getText();
				txtResp.setText(aux + Integer.valueOf(3));
			}
			if (event.getTarget() == btnQuatro) { 
				aux = txtResp.getText();
				txtResp.setText(aux + Integer.valueOf(4));
			}
			if (event.getTarget() == btnCinco) { 
				aux = txtResp.getText();
				txtResp.setText(aux + Integer.valueOf(5));
			}
			if (event.getTarget() == btnSeis) { 
				aux = txtResp.getText();
				txtResp.setText(aux + Integer.valueOf(6));
			}
			if (event.getTarget() == btnSete) { 
				aux = txtResp.getText();
				txtResp.setText(aux + Integer.valueOf(7));
			}
			if (event.getTarget() == btnOito) { 
				aux = txtResp.getText();
				txtResp.setText(aux + Integer.valueOf(8));
			}
			if (event.getTarget() == btnNove) { 
				aux = txtResp.getText();
				txtResp.setText(aux + Integer.valueOf(9));
			}
			if (event.getTarget() == btnZero) { 
				aux = txtResp.getText();
				txtResp.setText(aux + Integer.valueOf(0));
			}
			if (event.getTarget() == btnCE) { 
				txtResp.setText("");
			}
			if (event.getTarget() == btnSub) { 
				aux = txtResp.getText();
				txtResp.setText(aux + "-");
			}
			if (event.getTarget() == btnSoma) { 
				aux = txtResp.getText();
				txtResp.setText(aux + "+");
			}
			if (event.getTarget() == btnMult) { 
				aux = txtResp.getText();
				txtResp.setText(aux + "*");
			}
			if (event.getTarget() == btnDiv) { 
				aux = txtResp.getText();
				txtResp.setText(aux + "/");
			}
			if (event.getTarget() == btnVirg) { 
				aux = txtResp.getText();
				txtResp.setText(aux + ",");
			}
		} 
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
