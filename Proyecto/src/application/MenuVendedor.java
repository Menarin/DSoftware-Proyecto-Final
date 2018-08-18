package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuVendedor {
	
	private Stage ventana;
	private Button btnreg,btnregc,btnregv,btnge,btnsal;
	private Label label;
	
	public MenuVendedor(Stage ventana) {
		this.ventana = ventana;
		BorderPane Contenedor = new BorderPane();
		
		VBox contb = new VBox();
		HBox contl = new HBox();
		
		btnreg = new Button ("REGISTRAR CLIENTE");

		btnregc = new Button ("REGISTRAR COTIZACION");
		btnregc.setDisable(true);
		btnregv = new Button ("REGISTRAR VENTA");
		btnregv.setDisable(true);
		btnge = new Button ("GENERAR DOCUMENTO");
		btnge.setDisable(true);
		btnsal = new Button ("SALIR");
		
		contb.getChildren().addAll(btnreg,btnregc,btnregv,btnge,btnsal);
		contb.setSpacing(15);
		contb.setPadding(new Insets(15));
		contb.setAlignment(Pos.CENTER);
		
		label = new Label ("MENU VENDEDOR");
		label.setFont(new Font("Arial", 20));
		
		contl.getChildren().add(label);
		contl.setSpacing(15);
		contl.setPadding(new Insets(15));
		contl.setAlignment(Pos.CENTER);
		
		
		Contenedor.setTop(contl);
		Contenedor.setCenter(contb);
		
		
		Scene scene = new Scene(Contenedor, 300, 300);
        ventana.setScene(scene);
		
    	salir(btnsal);
		btnreg.setOnAction(new ClicCl ());
		
    	}
    	
    	public void salir(Button salir) {
    		salir.setOnAction(new EventHandler <ActionEvent> () {

    			@Override
    			public void handle(ActionEvent arg0) {
    				System.exit(0);
    				
    			}
             
                
            });
    		
    	}
    	
    	private class ClicCl implements EventHandler<ActionEvent> {
	        @Override
	        public void handle(ActionEvent event) {
	            new Cliente(ventana);
	        }
	}
}
