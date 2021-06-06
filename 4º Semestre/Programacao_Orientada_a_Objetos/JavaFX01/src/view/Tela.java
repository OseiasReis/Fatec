package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Tela extends Application{

	Label lblTitulo = new Label("Caixa");
	Label lblTotal = new Label("Total");
	
	TextField txtTotal = new TextField();
	
	Button btnConf = new Button("Confirmar");
	Button btnCanc = new Button("Cancelar");
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane tela = new Pane();
		Scene scn = new Scene(tela);
		
		stage.setTitle("Caixa");
		stage.setScene(scn);
		stage.setWidth(900);
		stage.setHeight(600);
		
		
		lblTitulo.relocate(20, 20);
		lblTitulo.setFont(new Font("Arial", 30));
		lblTitulo.setTextFill(Color.web("#DAA520"));
		
		txtTotal.relocate(600, 490);
		txtTotal.setPrefWidth(200);
		
		btnConf.relocate(20, 480);
		btnConf.setPrefSize(120, 50);
		btnConf.setFont(new Font("Arial", 20));
		
		tela.getChildren().addAll(lblTitulo, txtTotal, btnConf, btnCanc);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
