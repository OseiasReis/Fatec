package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
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
		
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
