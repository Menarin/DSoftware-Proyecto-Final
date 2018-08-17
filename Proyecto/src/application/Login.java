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

public class Login {
	Stage ventana;
	
	
	public Login(Stage ventana) {
			this.ventana = ventana;
			BorderPane root = new BorderPane();
			HBox usu = new HBox ();
			HBox con = new HBox();
			HBox cen = new HBox();
			HBox bot = new HBox();
			
			VBox Centro = new VBox();
			
			Label lblgeneral = new Label("LOGIN..");
			lblgeneral.setFont(new Font("Arial",50));
			
			Label lblusuario = new Label("USUARIO");
			Label lblcontra = new Label ("CONTRASEÑA");
			
			TextField txtusuario = new TextField();
			TextField txtcontra = new TextField();
			
			Button btnAc = new Button ("ACEPTAR");
			Button btnSa = new Button ("SALIR");
			
			usu.getChildren().addAll(lblusuario,txtusuario);
			usu.setAlignment(Pos.CENTER);
			usu.setSpacing(10);
			con.getChildren().addAll(lblcontra,txtcontra);
			con.setAlignment(Pos.CENTER);			
			con.setSpacing(5);
			cen.getChildren().add(lblgeneral);
			cen.setAlignment(Pos.CENTER);
			cen.setSpacing(15);
			cen.setPadding(new Insets(15));
			bot.getChildren().addAll(btnSa,btnAc);
			bot.setAlignment(Pos.CENTER);
			bot.setSpacing(15);
			bot.setPadding(new Insets(15)); 
			Centro.getChildren().addAll(usu,con);
			Centro.setAlignment(Pos.CENTER);
			Centro.setSpacing(15);	
			
		
		
			
			root.setCenter(Centro);
			root.setTop(cen);
			root.setBottom(bot);
			
			Scene scene = new Scene(root,300,250);		
			ventana.setScene(scene);
			
			salir(btnSa);
			
			
			
			btnAc.setOnAction(new ClicAc());
			
	}
	
	public void salir(Button salir) {
		salir.setOnAction(new EventHandler <ActionEvent> () {

			@Override
			public void handle(ActionEvent arg0) {
				System.exit(0);
				
			}
         
            
        });
		
	}

	private class ClicAc implements EventHandler<ActionEvent> {
	        @Override
	        public void handle(ActionEvent event) {
	            new ConsultaInventario(ventana);
	        }
	}
}
