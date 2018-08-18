package EmpresaLineaBlanca;
	

import application.Cliente;
import application.Login;
import application.MenuGerente;
import application.MenuVendedor;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
    private static Parent root;
    private static Scene scene;
    private static Stage stage;
	    
    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;

        root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));

        scene = new Scene(root);

        Main.stage.setScene(scene);
        Main.stage.setTitle("Ingreso");
        Main.stage.setResizable(false);
        Main.stage.show();
        
        /*primaryStage.setTitle("Proyecto DS");
        primaryStage.setResizable(false);
        
        //Login lg = new Login(primaryStage);
        //Cliente cl = new Cliente(primaryStage);
        //MenuVendedor mv = new MenuVendedor (primaryStage);
        MenuGerente mg = new MenuGerente (primaryStage);
        primaryStage.show();
        */
    }

 
    public static void main(String[] args) {
        launch(args);
    }

    public static void logout() throws Exception{
        root = FXMLLoader.load(Main.class.getResource("/application/Login.fxml"));

        scene = new Scene(root);

        Main.stage.setScene(scene);
        Main.stage.setTitle("Ingreso");
        Main.stage.centerOnScreen();
        Main.stage.show();
    }
    
}
