package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Teste extends Application{

	Label lblOla = new Label("Ola ... !!!!");
	
	Button btnSair = new Button("Sair");
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane tela = new Pane();
		Scene scn = new Scene(tela);
		
		stage.setTitle("Janela de Teste");
		stage.setScene(scn);
		stage.setWidth(216);
		stage.setHeight(165);
		
		lblOla.relocate(10, 30);
		lblOla.setPrefSize(80, 20);
		
		btnSair.relocate(00, 100);
		btnSair.setPrefSize(200, 25);
		
		EventHandler<Event> ev = new Eventos();
		scn.addEventHandler(Event.ANY, ev);
		
		tela.getChildren().addAll(lblOla, btnSair);
		
		stage.show();
	}
	
//	public class Saindo implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			
//		}
//	}
	
	public class Eventos implements EventHandler<Event> {
		@Override
		public void handle(Event event) {
			if (event.getTarget() == btnSair) { 
				System.exit(0);
			}
		} 
	}
		
	public static void main(String[] args) {
		Application.launch(args);
	}
}
