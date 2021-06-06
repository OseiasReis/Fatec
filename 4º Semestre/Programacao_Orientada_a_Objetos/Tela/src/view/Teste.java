package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Teste extends Application{

	Label lblId = new Label("Id");
	Label lblNome = new Label("Nome");
	Label lblTel = new Label("Telefone");
	
	TextField txtId = new TextField();
	TextField txtNome = new TextField();
	TextField txtTel = new TextField();
	
	Button btnSalv = new Button("Salvar");
	Button btnPesq = new Button("Pesquisar");
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane tela = new Pane();
//		TilePane tela = new TilePane();
//		BorderPane bpTela = new BorderPane();
//		bpTela.setTop(bpTela);
//		bpTela.setCenter(bpTela);
//		tela.setPrefColumns(4);
//		tela.setPrefRows(4);
		Scene scn = new Scene(tela);
		
		stage.setTitle("Calculadora");
		stage.setScene(scn);
		stage.setWidth(800);
		stage.setHeight(400);
		
		lblId.relocate(20, 20);
		lblId.setFont(new Font("Arial", 16));
		//lblId.setTextFill(Color.web("#DAA520"));
		
		lblNome.relocate(20, 120);
		lblNome.setFont(new Font("Arial", 16));
		
		lblTel.relocate(20, 220);
		lblTel.setFont(new Font("Arial", 16));
		
		txtId.relocate(170, 20);
		txtId.setPrefWidth(600);
		
		txtNome.relocate(170, 120);
		txtNome.setPrefWidth(600);
		
		txtTel.relocate(170, 220);
		txtTel.setPrefWidth(600);
		
		btnSalv.relocate(20, 300);
		btnSalv.setPrefSize(80, 25);
		btnSalv.setFont(new Font("Arial", 16));
		
		btnPesq.relocate(100, 300);
		btnPesq.setPrefSize(100, 25);
		btnPesq.setFont(new Font("Arial", 16));
		
		tela.getChildren().addAll(lblId, lblNome, lblTel, txtId, txtNome, txtTel, btnSalv, btnPesq);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
