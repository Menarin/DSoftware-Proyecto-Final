package controller;



import EmpresaLineaBlanca.Main;
import TDAs.Prototype.Articulo;
import TDAs.SqlConection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class GerenteController {

    @FXML
    private Button btnConsulta;

    @FXML
    private Button btnLogout;



    private void loadStage(String fxml) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource(fxml));

            Stage stage = new Stage();

            stage.setScene(new Scene(root));

            stage.initModality(Modality.APPLICATION_MODAL);

            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void handleButtonClicks(ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnConsulta) {

            loadStage("/application/ConsultarElemento.fxml");

        } else if (mouseEvent.getSource() == btnLogout) {

            cerrarSesion(mouseEvent);

        }
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        try{
            Main.logout();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}