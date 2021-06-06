package HW;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorld extends Application{

	Label lblHW = new Label("Hello World");
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane tela = new Pane();
		Scene scn = new Scene(tela);
		
		stage.setTitle("Hello World");
		stage.setScene(scn);
		stage.setWidth(500);
		stage.setHeight(400);
		
		lblHW.relocate(20, 20);
		lblHW.setFont(new Font("Arial", 16));
		
		tela.getChildren().addAll(lblHW);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
