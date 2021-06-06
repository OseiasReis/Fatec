package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class main extends Application {
 
    @Override
    public void start(Stage stage) throws Exception  {
 
    	//Inicio Casinha
    	Rectangle r1 = new Rectangle();
    	r1.setX(620);
        r1.setY(180);
        r1.setWidth(180);
        r1.setHeight(200);
        r1.setFill(Color.WHITE);
        r1.setStroke(Color.BLACK);
        
        Line l1 = new Line();
        l1.setStartX(720.0f);
        l1.setStartY(80.0f);
        l1.setEndX(620.0f);
        l1.setEndY(180.0f);
        
        Line l2 = new Line();
        l2.setStartX(720.0f);
        l2.setStartY(80.0f);
        l2.setEndX(800.0f);
        l2.setEndY(180.0f);
        //Fim Casinha
        
        Ellipse el1 = new Ellipse();
        el1.setCenterX(280.0f);
        el1.setCenterY(225.0f);
        el1.setRadiusX(250.0f); // Radius X
        el1.setRadiusY(175.0f); // Radius Y
        el1.setFill(null);
    	el1.setStroke(Color.BLACK);
    	
    	Ellipse el2 = new Ellipse();
    	el2.setCenterX(280.0f);
    	el2.setCenterY(225.0f);
    	el2.setRadiusX(240.0f); // Radius X
    	el2.setRadiusY(175.0f); // Radius Y
    	el2.setFill(null);
    	el2.setStroke(Color.BLACK);
    	
    	Ellipse el3 = new Ellipse();
    	el3.setCenterX(280.0f);
    	el3.setCenterY(225.0f);
    	el3.setRadiusX(230.0f); // Radius X
    	el3.setRadiusY(175.0f); // Radius Y
    	el3.setFill(null);
    	el3.setStroke(Color.BLACK);
    	
    	Ellipse el4 = new Ellipse();
    	el4.setCenterX(280.0f);
    	el4.setCenterY(225.0f);
    	el4.setRadiusX(220.0f); // Radius X
    	el4.setRadiusY(175.0f); // Radius Y
    	el4.setFill(null);
    	el4.setStroke(Color.BLACK);
    	
    	Ellipse el5 = new Ellipse();
    	el5.setCenterX(280.0f);
    	el5.setCenterY(225.0f);
    	el5.setRadiusX(210.0f); // Radius X
    	el5.setRadiusY(175.0f); // Radius Y
    	el5.setFill(null);
    	el5.setStroke(Color.BLACK);
    	
    	Ellipse el6 = new Ellipse();
    	el6.setCenterX(280.0f);
    	el6.setCenterY(225.0f);
    	el6.setRadiusX(200.0f); // Radius X
    	el6.setRadiusY(175.0f); // Radius Y
    	el6.setFill(null);
    	el6.setStroke(Color.BLACK);
    	
    	Ellipse el7 = new Ellipse();
    	el7.setCenterX(280.0f);
    	el7.setCenterY(225.0f);
    	el7.setRadiusX(190.0f); // Radius X
    	el7.setRadiusY(175.0f); // Radius Y
    	el7.setFill(null);
    	el7.setStroke(Color.BLACK);
    	
    	Ellipse el8 = new Ellipse();
    	el8.setCenterX(280.0f);
    	el8.setCenterY(225.0f);
    	el8.setRadiusX(180.0f); // Radius X
    	el8.setRadiusY(175.0f); // Radius Y
    	el8.setFill(null);
    	el8.setStroke(Color.BLACK);
    	
    	Ellipse el9 = new Ellipse();
    	el9.setCenterX(280.0f);
    	el9.setCenterY(225.0f);
    	el9.setRadiusX(170.0f); // Radius X
    	el9.setRadiusY(175.0f); // Radius Y
    	el9.setFill(null);
    	el9.setStroke(Color.BLACK);
    	
    	Ellipse el10 = new Ellipse();
    	el10.setCenterX(280.0f);
    	el10.setCenterY(225.0f);
    	el10.setRadiusX(160.0f); // Radius X
    	el10.setRadiusY(175.0f); // Radius Y
    	el10.setFill(null);
    	el10.setStroke(Color.BLACK);
    	
    	Ellipse el11 = new Ellipse();
    	el11.setCenterX(280.0f);
    	el11.setCenterY(225.0f);
    	el11.setRadiusX(150.0f); // Radius X
    	el11.setRadiusY(175.0f); // Radius Y
    	el11.setFill(null);
    	el11.setStroke(Color.BLACK);
    	
    	Ellipse el12 = new Ellipse();
    	el12.setCenterX(280.0f);
    	el12.setCenterY(225.0f);
    	el12.setRadiusX(140.0f); // Radius X
    	el12.setRadiusY(175.0f); // Radius Y
    	el12.setFill(null);
    	el12.setStroke(Color.BLACK);
    	
    	Ellipse el13 = new Ellipse();
    	el13.setCenterX(280.0f);
    	el13.setCenterY(225.0f);
    	el13.setRadiusX(130.0f); // Radius X
    	el13.setRadiusY(175.0f); // Radius Y
    	el13.setFill(null);
    	el13.setStroke(Color.BLACK);
    	
    	Ellipse el14 = new Ellipse();
    	el14.setCenterX(280.0f);
    	el14.setCenterY(225.0f);
    	el14.setRadiusX(120.0f); // Radius X
    	el14.setRadiusY(175.0f); // Radius Y
    	el14.setFill(null);
    	el14.setStroke(Color.BLACK);
    	
    	Ellipse el15 = new Ellipse();
    	el15.setCenterX(280.0f);
    	el15.setCenterY(225.0f);
    	el15.setRadiusX(110.0f); // Radius X
    	el15.setRadiusY(175.0f); // Radius Y
    	el15.setFill(null);
    	el15.setStroke(Color.BLACK);
    	
    	Ellipse el16 = new Ellipse();
    	el16.setCenterX(280.0f);
    	el16.setCenterY(225.0f);
    	el16.setRadiusX(100.0f); // Radius X
    	el16.setRadiusY(175.0f); // Radius Y
    	el16.setFill(null);
    	el16.setStroke(Color.BLACK);
    	
    	Ellipse el17 = new Ellipse();
    	el17.setCenterX(280.0f);
    	el17.setCenterY(225.0f);
    	el17.setRadiusX(90.0f); // Radius X
    	el17.setRadiusY(175.0f); // Radius Y
    	el17.setFill(null);
    	el17.setStroke(Color.BLACK);
    	
    	Ellipse el18 = new Ellipse();
    	el18.setCenterX(280.0f);
    	el18.setCenterY(225.0f);
    	el18.setRadiusX(80.0f); // Radius X
    	el18.setRadiusY(175.0f); // Radius Y
    	el18.setFill(null);
    	el18.setStroke(Color.BLACK);
    	
    	Ellipse el19 = new Ellipse();
    	el19.setCenterX(280.0f);
    	el19.setCenterY(225.0f);
    	el19.setRadiusX(70.0f); // Radius X
    	el19.setRadiusY(175.0f); // Radius Y
    	el19.setFill(null);
    	el19.setStroke(Color.BLACK);
    	
    	Ellipse el20 = new Ellipse();
    	el20.setCenterX(280.0f);
    	el20.setCenterY(225.0f);
    	el20.setRadiusX(60.0f); // Radius X
    	el20.setRadiusY(175.0f); // Radius Y
    	el20.setFill(null);
    	el20.setStroke(Color.BLACK);
    	
    	Ellipse el21 = new Ellipse();
    	el21.setCenterX(280.0f);
    	el21.setCenterY(225.0f);
    	el21.setRadiusX(50.0f); // Radius X
    	el21.setRadiusY(175.0f); // Radius Y
    	el21.setFill(null);
    	el21.setStroke(Color.BLACK);
    	
    	Ellipse el22 = new Ellipse();
    	el22.setCenterX(280.0f);
    	el22.setCenterY(225.0f);
    	el22.setRadiusX(40.0f); // Radius X
    	el22.setRadiusY(175.0f); // Radius Y
    	el22.setFill(null);
    	el22.setStroke(Color.BLACK);
    	
    	Ellipse el23 = new Ellipse();
    	el23.setCenterX(280.0f);
    	el23.setCenterY(225.0f);
    	el23.setRadiusX(30.0f); // Radius X
    	el23.setRadiusY(175.0f); // Radius Y
    	el23.setFill(null);
    	el23.setStroke(Color.BLACK);
    	
    	Ellipse el24 = new Ellipse();
    	el24.setCenterX(280.0f);
    	el24.setCenterY(225.0f);
    	el24.setRadiusX(20.0f); // Radius X
    	el24.setRadiusY(175.0f); // Radius Y
    	el24.setFill(null);
    	el24.setStroke(Color.BLACK);
    	
    	Ellipse el25 = new Ellipse();
    	el25.setCenterX(280.0f);
    	el25.setCenterY(225.0f);
    	el25.setRadiusX(10.0f); // Radius X
    	el25.setRadiusY(175.0f); // Radius Y
    	el25.setFill(null);
    	el25.setStroke(Color.BLACK);
    	
    	Ellipse el26 = new Ellipse();
    	el26.setCenterX(280.0f);
    	el26.setCenterY(225.0f);
    	el26.setRadiusX(0.0f); // Radius X
    	el26.setRadiusY(175.0f); // Radius Y
    	el26.setFill(null);
    	el26.setStroke(Color.BLACK);
    	
    	Ellipse ell1 = new Ellipse();
        ell1.setCenterX(280.0f);
        ell1.setCenterY(225.0f);
        ell1.setRadiusX(250.0f); // Radius X
        ell1.setRadiusY(165.0f); // Radius Y
        ell1.setFill(null);
    	ell1.setStroke(Color.BLACK);
    	
    	Ellipse ell2 = new Ellipse();
    	ell2.setCenterX(280.0f);
    	ell2.setCenterY(225.0f);
    	ell2.setRadiusX(250.0f); // Radius X
    	ell2.setRadiusY(155.0f); // Radius Y
    	ell2.setFill(null);
    	ell2.setStroke(Color.BLACK);
    	
    	Ellipse ell3 = new Ellipse();
    	ell3.setCenterX(280.0f);
    	ell3.setCenterY(225.0f);
    	ell3.setRadiusX(250.0f); // Radius X
    	ell3.setRadiusY(145.0f); // Radius Y
    	ell3.setFill(null);
    	ell3.setStroke(Color.BLACK);
    	
    	Ellipse ell4 = new Ellipse();
    	ell4.setCenterX(280.0f);
    	ell4.setCenterY(225.0f);
    	ell4.setRadiusX(250.0f); // Radius X
    	ell4.setRadiusY(135.0f); // Radius Y
    	ell4.setFill(null);
    	ell4.setStroke(Color.BLACK);
    	
    	Ellipse ell5 = new Ellipse();
    	ell5.setCenterX(280.0f);
    	ell5.setCenterY(225.0f);
    	ell5.setRadiusX(250.0f); // Radius X
    	ell5.setRadiusY(125.0f); // Radius Y
    	ell5.setFill(null);
    	ell5.setStroke(Color.BLACK);
    	
    	Ellipse ell6 = new Ellipse();
    	ell6.setCenterX(280.0f);
    	ell6.setCenterY(225.0f);
    	ell6.setRadiusX(250.0f); // Radius X
    	ell6.setRadiusY(115.0f); // Radius Y
    	ell6.setFill(null);
    	ell6.setStroke(Color.BLACK);
    	
    	Ellipse ell7 = new Ellipse();
    	ell7.setCenterX(280.0f);
    	ell7.setCenterY(225.0f);
    	ell7.setRadiusX(250.0f); // Radius X
    	ell7.setRadiusY(105.0f); // Radius Y
    	ell7.setFill(null);
    	ell7.setStroke(Color.BLACK);
    	
    	Ellipse ell8 = new Ellipse();
    	ell8.setCenterX(280.0f);
    	ell8.setCenterY(225.0f);
    	ell8.setRadiusX(250.0f); // Radius X
    	ell8.setRadiusY(95.0f); // Radius Y
    	ell8.setFill(null);
    	ell8.setStroke(Color.BLACK);
    	
    	Ellipse ell9 = new Ellipse();
    	ell9.setCenterX(280.0f);
    	ell9.setCenterY(225.0f);
    	ell9.setRadiusX(250.0f); // Radius X
    	ell9.setRadiusY(85.0f); // Radius Y
    	ell9.setFill(null);
    	ell9.setStroke(Color.BLACK);
    	
    	Ellipse ell10 = new Ellipse();
    	ell10.setCenterX(280.0f);
    	ell10.setCenterY(225.0f);
    	ell10.setRadiusX(250.0f); // Radius X
    	ell10.setRadiusY(75.0f); // Radius Y
    	ell10.setFill(null);
    	ell10.setStroke(Color.BLACK);
    	
    	Ellipse ell11 = new Ellipse();
    	ell11.setCenterX(280.0f);
    	ell11.setCenterY(225.0f);
    	ell11.setRadiusX(250.0f); // Radius X
    	ell11.setRadiusY(65.0f); // Radius Y
    	ell11.setFill(null);
    	ell11.setStroke(Color.BLACK);
    	
    	Ellipse ell12 = new Ellipse();
    	ell12.setCenterX(280.0f);
    	ell12.setCenterY(225.0f);
    	ell12.setRadiusX(250.0f); // Radius X
    	ell12.setRadiusY(55.0f); // Radius Y
    	ell12.setFill(null);
    	ell12.setStroke(Color.BLACK);
    	
    	Ellipse ell13 = new Ellipse();
    	ell13.setCenterX(280.0f);
    	ell13.setCenterY(225.0f);
    	ell13.setRadiusX(250.0f); // Radius X
    	ell13.setRadiusY(45.0f); // Radius Y
    	ell13.setFill(null);
    	ell13.setStroke(Color.BLACK);
    	
    	Ellipse ell14 = new Ellipse();
    	ell14.setCenterX(280.0f);
    	ell14.setCenterY(225.0f);
    	ell14.setRadiusX(250.0f); // Radius X
    	ell14.setRadiusY(35.0f); // Radius Y
    	ell14.setFill(null);
    	ell14.setStroke(Color.BLACK);
    	
    	Ellipse ell15 = new Ellipse();
    	ell15.setCenterX(280.0f);
    	ell15.setCenterY(225.0f);
    	ell15.setRadiusX(250.0f); // Radius X
    	ell15.setRadiusY(25.0f); // Radius Y
    	ell15.setFill(null);
    	ell15.setStroke(Color.BLACK);
    	
    	Ellipse ell16 = new Ellipse();
    	ell16.setCenterX(280.0f);
    	ell16.setCenterY(225.0f);
    	ell16.setRadiusX(250.0f); // Radius X
    	ell16.setRadiusY(15.0f); // Radius Y
    	ell16.setFill(null);
    	ell16.setStroke(Color.BLACK);
    	
    	Ellipse ell17 = new Ellipse();
    	ell17.setCenterX(280.0f);
    	ell17.setCenterY(225.0f);
    	ell17.setRadiusX(250.0f); // Radius X
    	ell17.setRadiusY(05.0f); // Radius Y
    	ell17.setFill(null);
    	ell17.setStroke(Color.BLACK);
    	
  
        Group root = new Group();
        root.getChildren().addAll(el1, r1, l1, l2, el2, el3, el4, el5, el6, el7, el8, el9, el10, el11, el12, el13, el14, el15, el16, el17, el18, el19, el20, el21, el22, el23, el24, el25, el26, ell1, ell2, ell3, ell4, ell5, ell6, ell7, ell8, ell9, ell10, ell11, ell12, ell13, ell14, ell15, ell16, ell17);
 
        Scene scene = new Scene(root);
        stage.setTitle("Drawing");
        stage.setScene(scene);
        stage.setWidth(900);
		stage.setHeight(500);
        stage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
}
