package view;

import control.BoundaryContent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Pagamento implements BoundaryContent{

	Button btnFinCompra = new Button("Finalizar Compra");
	Button btnAplDesc = new Button("Aplicar Desconto");
	Button btnVoltar = new Button("Voltar");
	
	TextField txtDesc = new TextField();
	TextField txtRec = new TextField();
	TextField txtTroco = new TextField();
	TextField txtSTotal = new TextField();
	TextField txtTotal = new TextField();
	
	Label lblFdp = new Label("Forma de Pagamento:");
	Label lblTotal = new Label("Total:");
	Label lblDesc = new Label("Desconto:");
	Label lblRec = new Label("Recebimento:");
	Label lblTroco = new Label("Troco:");
	Label lblSTotal = new Label("Sub.Total:");
	
    ComboBox cbxPag = new ComboBox();
    ComboBox cbxCart = new ComboBox();
    
    
	
	public Pane gerarTela(){
		Pane tela = new Pane();
		Scene scn = new Scene(tela);
		tela.setPrefWidth(200);
		
		txtDesc.relocate(700, 120);
		txtDesc.setPrefWidth(150);
		
		txtRec.relocate(420, 120);
		txtRec.setPrefWidth(150);
		
		txtTroco.relocate(400, 400);
		txtTroco.setPrefWidth(150);
		
		txtSTotal.relocate(400, 450);
		txtSTotal.setPrefWidth(150);
		
		txtTotal.relocate(400, 500);
		txtTotal.setPrefWidth(150);
		
		lblFdp.relocate(300, 50);
		lblFdp.setFont(new Font("Arial", 18));
		
		lblRec.relocate(300, 120);
		lblRec.setFont(new Font("Arial", 18));
		
		lblDesc.relocate(600, 120);
		lblDesc.setFont(new Font("Arial", 18));
		
		lblTroco.relocate(300, 200);
		lblTroco.setFont(new Font("Arial", 18));
		
		lblSTotal.relocate(300, 250);
		lblSTotal.setFont(new Font("Arial", 20));
		
		lblTotal.relocate(300, 300);
		lblTotal.setFont(new Font("Arial", 22));
		
		btnFinCompra.relocate(45, 255);
		btnFinCompra.setPrefSize(225, 50);
		
		btnAplDesc.relocate(45, 170);
		btnAplDesc.setPrefSize(225, 50);
		
		btnVoltar.relocate(45, 525);
		btnVoltar.setPrefSize(60, 20);
		
		cbxPag.relocate(500, 50);
		cbxPag.getItems().addAll(
				/*"Selcione",*/
	    	    "Cartão",
	    	    "Dinheiro"
	    );
		
		cbxCart.relocate(600, 50);
		cbxCart.getItems().addAll(
	    	    "Cartão de Crédito",
	    	    "Cartão de Débito"
	    );

		tela.getChildren().addAll(btnAplDesc, btnVoltar, lblFdp, btnFinCompra, txtDesc, txtRec, txtTroco, txtSTotal, txtTotal, 
				 lblTotal, cbxPag, cbxCart, lblDesc, lblRec, lblTroco, lblSTotal);
		
		EventHandler<Event> evCartao = new EvCartao();
		scn.addEventHandler(Event.ANY, evCartao);

		return tela;
	}
	
	public class EvCartao implements EventHandler<Event> {
		@Override
		public void handle(Event event) {
			if (event.getTarget() == cbxPag) { 
				if(cbxPag.getValue() == "Cartão") {
					cbxCart.setDisable(false);
				}else{
					cbxCart.setDisable(true);
				}
			}

		} 
	}
}
