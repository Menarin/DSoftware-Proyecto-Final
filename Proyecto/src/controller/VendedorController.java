package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import EmpresaLineaBlanca.Main;

public class VendedorController implements Initializable {

    @FXML
    private StackPane loaderPane;

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
    private void cerrar(ActionEvent event) {
        System.exit(0);
    }
}
