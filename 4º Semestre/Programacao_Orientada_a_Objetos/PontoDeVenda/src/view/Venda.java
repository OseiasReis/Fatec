package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.BoundaryContent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.EntityProdutos;
import model.paneButton;

public class Venda extends Application{

	int codProdGlob = 1;
	
	Button btnEnc = new Button("Encerrar");
	Button btnRegItem = new Button("Registrar Itens");
	Button btnCancItem = new Button("Cancelar Item");
	Button btnCancCompra = new Button("Cancelar Compra");
	Button btnPag = new Button("Pagamento");
	
	TextField txtPrecUnit = new TextField();
	TextField txtTotal = new TextField();
	
	Label lblNome = new Label("Titulo");
	Label lblLista = new Label("Lista de Produtos");
	Label lblCaixaA = new Label("CAIXA ABERTO");
	Label lblCaixaF = new Label("CAIXA FECHADO");
	Label lblPrecUnit = new Label("Preço Unit:");
	Label lblTotal = new Label("Total:");
	
	TableView tbItens = new TableView<EntityProdutos>();
	TableColumn tcItem = new TableColumn("Nº Item");
    TableColumn tcCod = new TableColumn("Código");
    TableColumn tcDesc = new TableColumn("Descrição");
    TableColumn tcQtd = new TableColumn("Qtd");
    TableColumn tcVUnit = new TableColumn("Val. Unit");
    TableColumn tcTotal = new TableColumn("Total");
	
	@Override
	public void start(Stage stage) throws Exception{
		Pane tela = new Pane();
		Scene scn = new Scene(tela);

		stage.setTitle("Ponto de Venda");
		stage.setScene(scn);
		stage.setWidth(900);
		stage.setHeight(600);
		
		txtPrecUnit.relocate(420, 450);
		txtPrecUnit.setPrefWidth(150);
		txtPrecUnit.setPrefHeight(70);
		txtPrecUnit.setFont(new Font("Arial", 18));
		txtPrecUnit.setEditable(false);
		txtPrecUnit.setVisible(false);
		
		txtTotal.relocate(675, 450);
		txtTotal.setPrefWidth(175);
		txtTotal.setPrefHeight(70);
		txtTotal.setFont(new Font("Arial", 22));
		txtTotal.setEditable(false);
		
		lblNome.relocate(100, 30);
		lblNome.setFont(Font.font("Arial", FontWeight.BOLD, 28));
		
		lblLista.relocate(512, 40);
		lblLista.setFont(new Font("Arial", 18));
		
		lblCaixaA.relocate(40, 100);
		lblCaixaA.setFont(new Font("Arial", 20));
		
		lblCaixaF.relocate(40, 100);
		lblCaixaF.setFont(new Font("Arial", 20));
		lblCaixaF.setVisible(false);
		
		lblPrecUnit.relocate(315, 450);
		lblPrecUnit.setFont(Font.font("Arial", FontWeight.BOLD, 18));
		lblPrecUnit.setVisible(false);
		
		lblTotal.relocate(605, 450);
		lblTotal.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		
		btnEnc.relocate(220, 100);
		btnEnc.setPrefSize(60, 20);
		
		btnRegItem.relocate(45, 170);
		btnRegItem.setPrefSize(225, 50);
		
		btnCancItem.relocate(45, 255);
		btnCancItem.setPrefSize(225, 50);
		
		btnCancCompra.relocate(45, 340);//380
		btnCancCompra.setPrefSize(225, 50);
		
		btnPag.relocate(45, 425);//450
		btnPag.setPrefSize(225, 50);
		
		tbItens.setEditable(false);
		tbItens.relocate(315, 80);
		tbItens.setPrefWidth(535);
		tbItens.setPrefHeight(325);
		tcItem.setPrefWidth(49);
		tcCod.setPrefWidth(90);
		tcCod.setCellValueFactory(new PropertyValueFactory<>("tcCodProd"));
		tcDesc.setPrefWidth(243);//(195);
		tcDesc.setCellValueFactory(new PropertyValueFactory<>("tcDescricao"));
		tcQtd.setPrefWidth(40);
		tcQtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
		tcVUnit.setPrefWidth(80);
		tcVUnit.setCellValueFactory(new PropertyValueFactory<>("tcVUnit"));
		tcTotal.setPrefWidth(80);
		tcTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
		tbItens.getColumns().addAll(/*tcItem,*/ tcCod, tcDesc, tcQtd, tcVUnit, tcTotal);
        
		Rectangle r1 = new Rectangle();
    	r1.setX(25);
        r1.setY(80);
        r1.setWidth(270);
        r1.setHeight(65);
        r1.setFill(null);
        r1.setStroke(Color.BLACK);

        
		tela.getChildren().addAll(lblNome, /*btnVoltar,*/ btnEnc , btnRegItem, btnCancItem, /*btnAplDesc,*/ btnCancCompra, 
				btnPag, txtPrecUnit, txtTotal, lblPrecUnit, lblTotal, tbItens, lblLista, lblCaixaA, lblCaixaF, r1 /*,r2*/);
		
		EventHandler<Event> ev = new EvReg();
//		EventHandler<Event> ev2 = new EvCalc();
		EventHandler<Event> ev3 = new EvCancel();
		EventHandler<Event> ev4 = new EvCancelCompra();
		scn.addEventHandler(Event.ANY, ev);
//		scn.addEventHandler(Event.ANY, ev2);
		scn.addEventHandler(Event.ANY, ev3);
		scn.addEventHandler(Event.ANY, ev4);
		
		stage.show();
	}
	
	private ObservableList<EntityProdutos> listaProdutos() {
    	return FXCollections.observableArrayList(
    			new EntityProdutos(123456,"Arroz",10.00),
    			new EntityProdutos(654321,"Feijão",7.00),
    			new EntityProdutos(123654,"Chocolate",8.00),
    			new EntityProdutos(134652,"Macarrão",5.00),
    			new EntityProdutos(356210,"Miojo",1.00)
    	);
    }
	
	public class EvReg implements EventHandler<Event> {
		@Override
		public void handle(Event event) {
			if (event.getTarget() == btnRegItem) { 
				int codProd = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do produto"));
				int qtd = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de produtos"));
				tbItens.getItems().add(buscarProduto(codProd, qtd));
			}
		} 
	}
	
	public EntityProdutos buscarProduto(int codProd, int qtd) {
		ArrayList<EntityProdutos> produtos = new ArrayList<EntityProdutos>();
		produtos.add(new EntityProdutos(1,"Arroz",10.00));
		produtos.add(new EntityProdutos(2,"Feijão",7.00));
		produtos.add(new EntityProdutos(3,"Chocolate",8.00));
		produtos.add(new EntityProdutos(4,"Macarrão",5.00));
		produtos.add(new EntityProdutos(5,"Miojo",1.00));
		produtos.add(new EntityProdutos(6,"Milho",2.00));
		produtos.add(new EntityProdutos(7,"Tomate",4.00));
		produtos.add(new EntityProdutos(8,"Alface",2.50));
		produtos.add(new EntityProdutos(9,"Cebola",3.00));
		
		for(EntityProdutos produto: produtos) {
			if(produto.getTcCodProd() == codProd) {
				produto.setQtd(qtd);
				produto.setTotal(produto.getQtd() * produto.getTcVUnit());
				return produto;
			}
		}
		return new EntityProdutos();
	}
	
	public class EvCancel implements EventHandler<Event> {
		@Override
		public void handle(Event event) {
			String aux;
			if (event.getTarget() == btnCancItem) { 
				aux = JOptionPane.showInputDialog("Insira a linha do produto a ser cancelada");
				int codProd = Integer.parseInt(aux) - 1;
				tbItens.getItems().remove(codProd);
			}
		} 
	}
	
	public class EvCancelCompra implements EventHandler<Event> {
		@Override
		public void handle(Event event) {
			String aux;
			if (event.getTarget() == btnCancCompra) { 
				tbItens.getItems().clear();
			}
		} 
	}
	
	
	public class EvPag implements EventHandler<Event> {
	@Override
	public void handle(Event event) {
		if (event.getTarget() == btnPag) { 
			Pagamento p = new Pagamento();
		}
	} 
}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
