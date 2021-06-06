package view;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import control.BoundaryContent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>, BoundaryContent{

	BorderPane tela;
	
	MenuBar menuBar = new MenuBar();
	
	Menu menu1 = new Menu("Caixa");
	MenuItem menuItem1 = new MenuItem("Abrir");
	
	Menu menu2 = new Menu("Histórico");
	MenuItem menuItem2 = new MenuItem("Saldo");
	MenuItem menuItem3 = new MenuItem("Pedidos");
	
	Menu menu3 = new Menu("Opções");
	MenuItem menuItem4 = new MenuItem("Configurações");
	MenuItem menuItem5 = new MenuItem("Texto");
	MenuItem menuItem6 = new MenuItem("Informações");
	
	private Map<MenuItem, BoundaryContent> telas = new HashMap<>();
	
	Button btnEnc = new Button("Encerrar");

	@Override
	public void start(Stage stage) throws Exception {
		tela = new BorderPane();
		tela.computeAreaInScreen();//setCenter().(setPrefSize(200, 650));
		Scene scn = new Scene(tela, 900, 600);
		Pane otherPane = new Pane();
        tela.getChildren().add(otherPane);

		stage.setTitle("Principal");
		stage.setScene(scn);

		Image image = new Image(new FileInputStream("images\\pv.png"));
		ImageView imgView = new ImageView(image);

		imgView.setFitHeight(400); 
		imgView.setFitWidth(360);
		//imgView.relocate(20, 30);
		tela.setCenter(imgView);

		menu1.getItems().addAll(menuItem1);
		menu2.getItems().addAll(menuItem2, menuItem3);
		menu3.getItems().addAll(menuItem4, menuItem5, menuItem6);
		
		//telas.put(menuItem1, new Venda());
		//telas.put(menuItem2, new Pagamento());
		
		menuItem1.addEventHandler(ActionEvent.ANY, this);
		menuItem2.addEventHandler(ActionEvent.ANY, this);

		btnEnc.relocate(220, 100);
		btnEnc.setPrefSize(60, 20);
		
		menuBar.getMenus().addAll(menu1, menu2, menu3);
		tela.setTop(menuBar);

		
		stage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void handle(ActionEvent event) {
		BoundaryContent t = telas.get(event.getTarget());
		if (t != null) { 
			tela.setCenter(t.gerarTela());
		}
	}


	@Override
	public Pane gerarTela() {
		return null;
	}
}


//menu.setGraphic(new ImageView("file:volleyball.png"));
//colocar imagem no icone

//Slider slider = new Slider(0, 100, 50);		
//
//CustomMenuItem customMenuItem = new CustomMenuItem();
//customMenuItem.setContent(slider);
//customMenuItem.setHideOnClick(false);
//menu.getItems().add(customMenuItem);
//
//Button button = new Button("Custom Menu Item Button");
//CustomMenuItem customMenuItem2 = new CustomMenuItem();
//customMenuItem2.setContent(button);
//customMenuItem2.setHideOnClick(false);
//menu.getItems().add(customMenuItem2);
