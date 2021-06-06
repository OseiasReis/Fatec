package model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class paneButton extends Application{

	Button btnRegItem = new Button("Registrar Itens");
	Button btnCancItem = new Button("Cancelar Item");
	Button btnCancCompra = new Button("Cancelar Compra");
	Button btnPag = new Button("Pagamento");
	
	Label lblNome = new Label("Titulo");
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane telaB = new Pane();
		Scene scnB = new Scene(telaB);
		
		stage.setTitle("Ponto de Venda");
		stage.setScene(scnB);
		stage.setWidth(900);
		stage.setHeight(600);
		
		lblNome.relocate(100, 30);
		lblNome.setFont(Font.font("Arial", FontWeight.BOLD, 28));
		
		btnRegItem.relocate(45, 170);
		btnRegItem.setPrefSize(225, 50);
		
		btnCancItem.relocate(45, 255);
		btnCancItem.setPrefSize(225, 50);
		
		btnCancCompra.relocate(45, 340);//380
		btnCancCompra.setPrefSize(225, 50);
		
		btnPag.relocate(45, 425);//450
		btnPag.setPrefSize(225, 50);
        
		telaB.getChildren().addAll(lblNome, btnRegItem, btnCancItem,  btnCancCompra, 
				btnPag);

		
//		EventHandler<Event> ev = new Eventos();
//		scn.addEventHandler(Event.ANY, ev);
		
		stage.show();
	}
	
//	
//	public class Eventos implements EventHandler<Event> {
//		@Override
//		public void handle(Event event) {
////			String aux;
////			if (event.getTarget() == btnUm) { 
////				aux = txtDesc.getText();
////				txtDesc.setText(aux + Integer.valueOf(1));
////			}
//		} 
//	}
}
