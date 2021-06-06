package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Graphic extends Application{

	Label lblPhone = new Label("Enter your phone number:");
	Label lblNome = new Label("Enter your name:");
	
	TextField txtPhone = new TextField();
	TextArea txtNome = new TextArea();
	
	Button btnOk = new Button("Ok");
	Button btnCancel = new Button("Cancel");
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane tela = new Pane();
		Scene scn = new Scene(tela);
		
		stage.setTitle("Graphic User Interface Test");
		stage.setScene(scn);
		stage.setWidth(700);
		stage.setHeight(280);
		
		lblPhone.relocate(10, 10);
		lblPhone.setFont(new Font("Arial", 16));
		
		lblNome.relocate(10, 80);
		lblNome.setFont(new Font("Arial", 16));
		
		txtPhone.relocate(200, 10);
		txtPhone.setPrefWidth(400);
		
		txtNome.relocate(150, 80);
		txtNome.setPrefWidth(400);
		txtNome.setPrefHeight(80);
		
		btnOk.relocate(20, 180);
		btnOk.setPrefSize(300, 25);
		
		btnCancel.relocate(340, 180);
		btnCancel.setPrefSize(300, 25);
		
		tela.getChildren().addAll(lblPhone, lblNome, txtPhone, txtNome, btnOk, btnCancel);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
