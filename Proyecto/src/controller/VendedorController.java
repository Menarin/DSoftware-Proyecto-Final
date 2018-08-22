package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import EmpresaLineaBlanca.Main;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VendedorController implements Initializable {

    public JFXButton nuevocliente;
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


    @FXML
    private void showAgregarCliente(ActionEvent event) throws IOException {
        loaderPane.getChildren().clear();
        Node n = FXMLLoader.load(getClass().getResource("/application/AgregarCliente.fxml"));
        loaderPane.getChildren().add(n);
        StackPane.setAlignment(n, Pos.CENTER);
    }
/*
    @FXML
    private void showGenerarCotizacion(ActionEvent event) throws IOException {
        loaderPane.getChildren().clear();
        Node n = FXMLLoader.load(getClass().getResource("/FXML/GenerarCotizacion.fxml"));
        loaderPane.getChildren().add(n);
        StackPane.setAlignment(n, Pos.CENTER);
    }
*/
/*
    @FXML
    private void showVenta(ActionEvent event) throws IOException {
        loaderPane.getChildren().clear();
        Node n = FXMLLoader.load(getClass().getResource("/FXML/Venta.fxml"));
        loaderPane.getChildren().add(n);
        StackPane.setAlignment(n, Pos.CENTER);
    }
*/
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

    @FXML
    private void cerrar(ActionEvent event) {
        System.exit(0);
    }
}
