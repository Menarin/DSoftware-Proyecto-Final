package application;
	

import javafx.application.Application;

import javafx.stage.Stage;



public class Main extends Application {
	    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Proyecto DS");
        primaryStage.setResizable(false);
        
        //Login lg = new Login(primaryStage);
        //Consulta con = new Consulta(primaryStage);
        //Cliente cl = new Cliente(primaryStage);
        MenuVendedor mv = new MenuVendedor (primaryStage);
        //MenuGerente mg = new MenuGerente (primaryStage);
        //MenuElementos me = new MenuElementos (primaryStage);
        primaryStage.show();
    }

 
    public static void main(String[] args) {
        launch(args);
    }
    
}
