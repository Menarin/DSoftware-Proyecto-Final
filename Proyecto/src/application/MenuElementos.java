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

public class MenuElementos {
	private Stage ventana;
	private Button btncc,btncv,btnsal,btncz,btniv;
	private Label label;
	
	public MenuElementos(Stage ventana) {
		this.ventana = ventana;
		BorderPane Contenedor = new BorderPane();
		
		
		btncc = new Button("CONSULTAR CLIENTE");
		btncc.setDisable(true);
		btncv = new Button("CONSULTAR VENTA");
		btncv.setDisable(true);
		btncz = new Button("CONSULTAR COTIZACION");
		btncz.setDisable(true);
		btniv = new Button("CONSULTAR INVENTARIO");
		btnsal = new Button("SALIR");
		
		
		label = new Label ("CONSULTAS - ELEMENTOS DEL SISTEMA");
		label.setFont(new Font("Arial", 20));
		

		VBox contb = new VBox();
		HBox contl = new HBox();
		
		contb.getChildren().addAll(btncc,btncv,btncz,btniv,btnsal);
		contb.setSpacing(15);
		contb.setPadding(new Insets(15));
		contb.setAlignment(Pos.CENTER);
		
		contl.getChildren().add(label);
		contl.setSpacing(15);
		contl.setPadding(new Insets(15));
		contl.setAlignment(Pos.CENTER);
		
		
		Contenedor.setTop(contl);
		Contenedor.setCenter(contb);

		Scene scene = new Scene(Contenedor, 300, 300);
        ventana.setScene(scene);
		
    	salir(btnsal);
		btniv.setOnAction(new ClicIv());
		
    	}
    	
    	public void salir(Button salir) {
    		salir.setOnAction(new EventHandler <ActionEvent> () {

    			@Override
    			public void handle(ActionEvent arg0) {
    				System.exit(0);
    				
    			}
             
                
            });
    		
    	}
    	
    	private class ClicIv implements EventHandler<ActionEvent> {
	        @Override
	        public void handle(ActionEvent event) {
	            new ConsultaInventario(ventana);
	        }
	}
	
}
