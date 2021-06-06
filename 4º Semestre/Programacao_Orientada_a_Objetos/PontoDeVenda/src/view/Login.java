package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import control.BoundaryContent;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Login extends Application{
	Pane tela;
	
	Button btnEntrar = new Button("Logar");

	TextField txtLogin = new TextField();
	//TextField txtSenha = new TextField();
	PasswordField txtSenha = new PasswordField();

	Label lblLogin = new Label("Login");
	Label lblSenha = new Label("Senha");
	Label lblEscSenha = new Label("Esqueceu a senha?");
	Label lblReg = new Label("Registrar");

	private Map<Button, BoundaryContent> telas = new HashMap<>();
	
	@Override
	public void start(Stage stage) throws Exception {
		tela = new Pane();
		Scene scn = new Scene(tela);
		Pane otherPane = new Pane();
		tela.getChildren().add(otherPane);

		stage.setTitle("Ponto de Venda");
		stage.setScene(scn);
		stage.setWidth(900);
		stage.setHeight(600);

		Image image = new Image(new FileInputStream("images\\pv.png")); 
		ImageView imgView = new ImageView(image);

		imgView.setFitHeight(375); 
		imgView.setFitWidth(310); 

		btnEntrar.relocate(500, 300);
		btnEntrar.setPrefSize(270, 40);
		btnEntrar.setFont(new Font("Arial", 20));

		txtLogin.relocate(560, 200);
		txtLogin.setPrefWidth(210);

		txtSenha.relocate(560, 250);
		txtSenha.setPrefWidth(210);

		lblLogin.relocate(500, 200);
		lblLogin.setFont(new Font("Arial", 18));

		lblSenha.relocate(500, 250);
		lblSenha.setFont(new Font("Arial", 18));

		lblEscSenha.relocate(640, 365);
		lblEscSenha.setFont(new Font("Arial", 12));

		lblReg.relocate(535, 365);
		lblReg.setFont(new Font("Arial", 12));
		
		telas.put(btnEntrar, new Main());

		tela.getChildren().addAll(lblLogin, lblSenha, txtLogin, txtSenha, btnEntrar, lblEscSenha, lblReg, imgView);

		EventHandler<Event> evLogar = new EvLogar();
		EventHandler<MouseEvent> mevSenha = new EvEscSenha();
		EventHandler<MouseEvent> mevReg = new EvReg();
		scn.addEventHandler(Event.ANY, evLogar);
		scn.addEventHandler(MouseEvent.ANY, mevSenha);
		scn.addEventHandler(MouseEvent.ANY, mevReg);

		stage.show();

		Animacao(imgView);
	}

	public void Animacao(ImageView imgView){
		Line line = new Line();
		line.setStartX(-80.0f);
		line.setStartY(280.0f);
		line.setEndX(250.0f);
		line.setEndY(280.0f);

		PathTransition trans = new PathTransition();
		trans.setNode(imgView);
		trans.setDuration(Duration.seconds(0.5));
		trans.setPath(line);
		trans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		trans.play();
	}

	public class EvLogar implements EventHandler<Event> {
		@Override
		public void handle(Event event) {
			if (event.getTarget() == btnEntrar) { 
				String login = txtLogin.getText();
				String senha = txtSenha.getText();
				if(login.equals("admin") && senha.equals("123")) {
					btnEntrar.setDisable(true);
					txtLogin.setDisable(true);
					txtSenha.setDisable(true);
					Main m = new Main();
				}else {
					System.out.println("Senha incorreta");
				}
			}

		}
	}

	public class EvEscSenha implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			lblEscSenha.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					lblEscSenha.setScaleX(1.15);
					lblEscSenha.setScaleY(1.15);
				}
			});
			lblEscSenha.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					lblEscSenha.setScaleX(1);
					lblEscSenha.setScaleY(1);
				}
			});
			lblEscSenha.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					System.out.println("Esqueci");
				}

			});
		} 
	}

	public class EvReg implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			lblReg.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					lblReg.setScaleX(1.15);
					lblReg.setScaleY(1.15);
				}
			});
			lblReg.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					lblReg.setScaleX(1);
					lblReg.setScaleY(1);
				}
			});
			lblReg.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					System.out.println("Registrar");
				}
			});
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
