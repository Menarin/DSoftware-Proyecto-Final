package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Cliente {
	
	private Stage ventana;
	private Label lblnombre,lblapellido,label;
	private TextField txtnombre,txtapellido;
	private Button btnreg,btnsal;
	private HBox top,bot;
	
	public Cliente(Stage ventana) {
		this.ventana = ventana;
		BorderPane Contenedor = new BorderPane();
		
		label = new Label("REGRISTRO CLIENTE");
		label.setFont(new Font("Arial", 20));
		
		lblnombre = new Label("Ingrese el nombre");
		lblapellido = new Label("Ingrese el apelido");
		
		txtnombre = new TextField();
		txtapellido = new TextField();
		
		btnreg = new Button("REGISTRAR");
		btnsal = new Button("SALIR");
		
		
		HBox cont1 = new HBox();
		HBox cont2 = new HBox();
		
		VBox conte3 = new VBox();
		
		
		cont1.getChildren().addAll(lblnombre, txtnombre);
		cont1.setPadding(new Insets(15));
		cont1.setSpacing(15); 
		cont1.setAlignment(Pos.CENTER);
		
		cont2.getChildren().addAll(lblapellido,txtapellido);
		cont2.setSpacing(15); 
		cont2.setPadding(new Insets(15));
		cont2.setAlignment(Pos.CENTER);
		
		conte3.getChildren().addAll(cont1,cont2);
		
		top = new HBox();
		top.getChildren().add(label);
		top.setSpacing(15); 
		top.setPadding(new Insets(15));
        top.setAlignment(Pos.CENTER);
		
        
        bot = new HBox();
        bot.getChildren().addAll(btnsal,btnreg);
        bot.setSpacing(15);
        bot.setPadding(new Insets(15));
        bot.setAlignment(Pos.CENTER);
        
        Contenedor.setTop(top);
        Contenedor.setCenter(conte3);
        Contenedor.setBottom(bot);
        
        
        
        
        Scene scene = new Scene(Contenedor, 300, 250);
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
