package EmpresaLineaBlanca;
	

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application {
    private static Parent root;
    private static Scene scene;
    private static Stage stage;
	    
    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;

        root = FXMLLoader.load(getClass().getResource("/application/log_in.fxml"));

        scene = new Scene(root);

        Main.stage.setScene(scene);
        Main.stage.setTitle("Login");
        Main.stage.setResizable(false);
        Main.stage.show();

    }

 
    public static void main(String[] args) {
        launch(args);
    }

    public static void logout() throws Exception{
        root = FXMLLoader.load(Main.class.getResource("/application/log_in.fxml"));

        scene = new Scene(root);

        Main.stage.setScene(scene);
        Main.stage.setTitle("Login");
        Main.stage.centerOnScreen();
        Main.stage.show();
    }
    
}
