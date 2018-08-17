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

public class MenuGerente {

	private Stage ventana;
	private Button btnger,btncon,btnsal;
	private Label label;
	
	
	
	public MenuGerente(Stage ventana) {
		this.ventana = ventana;
		BorderPane Contenedor = new BorderPane();
		
		btnger = new Button ("GENERAR REPORTE");
		btnger.setDisable(true);
		btncon = new Button ("CONSULTAR ELEMENTOS DEL SISTEMA");
		btnsal = new Button ("SALIR");
		
		label = new Label ("MENU GERENTE");
		label.setFont(new Font("Arial", 20));
		
		
		VBox contb = new VBox();
		HBox contl = new HBox();
		
		contb.getChildren().addAll(btnger,btncon,btnsal);
		contb.setSpacing(15);
		contb.setPadding(new Insets(15));
		contb.setAlignment(Pos.CENTER);
		
		contl.getChildren().add(label);
		contl.setSpacing(15);
		contl.setPadding(new Insets(15));
		contl.setAlignment(Pos.CENTER);
		
		
		Contenedor.setTop(contl);
		Contenedor.setCenter(contb);

		Scene scene = new Scene(Contenedor, 300, 200);
        ventana.setScene(scene);
		
    	salir(btnsal);
		btncon.setOnAction(new ClicEl ());
		
    	}
    	
    	public void salir(Button salir) {
    		salir.setOnAction(new EventHandler <ActionEvent> () {

    			@Override
    			public void handle(ActionEvent arg0) {
    				System.exit(0);
    				
    			}
             
                
            });
    		
    	}
    	
    	private class ClicEl implements EventHandler<ActionEvent> {
	        @Override
	        public void handle(ActionEvent event) {
	            new MenuElementos(ventana);
	        }
	}
}
