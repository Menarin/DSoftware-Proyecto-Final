package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ConsultaInventario {

	private Stage ventana;
	private TableView table = new TableView();
	
	
	public ConsultaInventario(Stage ventana) {
		this.ventana=ventana;
		BorderPane Contenedor = new BorderPane();
		
		Button btnmod = new Button ("MODIFICAR");
		btnmod.setDisable(true);
		Button btnsal = new Button ("SALIR");
		Button btnagg = new Button("AGREGAR");
		
		VBox BotonesV = new VBox();
		VBox ContenedorART = new VBox();
		HBox top = new HBox();
		
		final Label label = new Label("PRODUCTOS");
		label.setFont(new Font("Arial", 20));
		
		table.setEditable(true);
		
		TableColumn NombrePro = new TableColumn("Nombre");
        TableColumn DescripPro = new TableColumn("Descripción");
        TableColumn PrecioPro = new TableColumn("Precio");
		
		
		
        table.getColumns().addAll(NombrePro, DescripPro, PrecioPro);
        
        ContenedorART.setPadding(new Insets(15));
        ContenedorART.getChildren().add(table);
        
        top.getChildren().add(label);
        top.setPadding(new Insets(15));
        top.setAlignment(Pos.CENTER);
        
		BotonesV.getChildren().addAll(btnagg,btnmod,btnsal);
		BotonesV.setSpacing(15);
		BotonesV.setAlignment(Pos.CENTER);
		BotonesV.setPadding(new Insets(15));
		
		Contenedor.setTop(top);
		Contenedor.setRight(BotonesV);
		Contenedor.setCenter(ContenedorART);
		
		Scene scene = new Scene(Contenedor, 500, 300);
        ventana.setScene(scene);
		
		salir(btnsal);
		
		
	}
	
	public void salir(Button salir) {
		salir.setOnAction(new EventHandler <ActionEvent> () {

			@Override
			public void handle(ActionEvent arg0) {
				System.exit(0);
				
			}
         
            
        });
		
	}
}
