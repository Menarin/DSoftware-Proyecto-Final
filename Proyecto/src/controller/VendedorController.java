package controller;

import EmpresaLineaBlanca.Main;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VendedorController implements Initializable {
    @FXML
    private JFXButton nuevocliente;
    @FXML
    private StackPane loaderPane;

    @FXML
    private Button btnCliente;

    @FXML
    private Button btnCotizar;

    @FXML
    private Button btnVenta;

    @FXML
    private Button btnLogout;


    @FXML

    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {

        if ((mouseEvent.getSource() == btnCliente) | (mouseEvent.getSource() == nuevocliente)) {

            loadStage("/application/clienteview.fxml");

        } else if (mouseEvent.getSource() == btnCotizar) {

            loadStage("/application/cotizarview.fxml");

        } else if (mouseEvent.getSource() == btnVenta) {

            cerrarSesion(mouseEvent);

        }else if (mouseEvent.getSource() == btnLogout) {

            cerrarSesion(mouseEvent);

        }

    }

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        try{
            Main.logout();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void limpiarCotizacion(){

    }
}
