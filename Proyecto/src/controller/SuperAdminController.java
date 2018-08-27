package controller;

import EmpresaLineaBlanca.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SuperAdminController {

    public Button btnConsultas;
    public Button btnLogout;
    @FXML
    private Button btnUsuario;
    @FXML

    private StackPane loaderPane;

    @FXML

    private TextField txtNombre;



    @FXML

    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {

        if (mouseEvent.getSource() == btnUsuario) {

            loadStage("/application/AgregarUsuario.fxml");

        } else if (mouseEvent.getSource() == btnConsultas) {

            cerrarSesion(mouseEvent);

        } else if (mouseEvent.getSource() == btnLogout) {

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

    private void showAgregarProducto(ActionEvent event) throws IOException {

        loaderPane.getChildren().clear();

        Node n = FXMLLoader.load(getClass().getResource("/application/AgregarProducto.fxml"));

        loaderPane.getChildren().add(n);

        StackPane.setAlignment(n, Pos.CENTER);

    }



    @FXML

    private void showConsultarElemento(ActionEvent event) throws IOException {

        loaderPane.getChildren().clear();

        Node n = FXMLLoader.load(getClass().getResource("/application/ConsultarElemento.fxml"));

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


    @FXML

    private void cerrarSesion(ActionEvent event) {

        try{

            Main.logout();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    @FXML

    private void limpiar(ActionEvent event) {

        this.limpiar();

    }



    private void limpiar(){

        txtNombre.setText("");



    }

    @FXML

    private void cerrar(ActionEvent event) {

        System.exit(0);

    }
}
