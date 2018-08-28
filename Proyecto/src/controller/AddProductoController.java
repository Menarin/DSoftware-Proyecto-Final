package controller;



import TDAs.SqlConection;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class AddProductoController implements Initializable{



    @FXML

    private JFXTextField txtNombreArt;

    @FXML

    private JFXTextField txtModelo;

    @FXML

    private JFXTextField txtCantidad;

    @FXML

    private JFXTextField txtPrecio;

    @FXML

    private JFXTextArea txtDescripcion;




    SqlConection conexion = SqlConection.getInstance();



    @Override

    public void initialize(URL location, ResourceBundle resources) {
    }



    @FXML

    private void agregarProducto(ActionEvent event) {

        if (!txtNombreArt.getText().isEmpty() && !txtModelo.getText().isEmpty() && !txtCantidad.getText().isEmpty() &&
                !txtPrecio.getText().isEmpty() && !txtDescripcion.getText().isEmpty()) {

            try {

                conexion.setProcedure("{call nuevoProducto('" + txtNombreArt.getText().toUpperCase() +
                        "','" + txtModelo.getText().toUpperCase() + "','" + txtDescripcion.getText().toUpperCase() +
                        "','" + (Float.parseFloat((txtPrecio.getText()))) + "','"
                        + (Integer.parseInt(txtCantidad.getText())) +"')}");

                conexion.ejecutarQuery();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Agregar nuevo Producto");

                alert.setHeaderText(null);

                alert.setContentText("Guardado Exitoso");

                alert.showAndWait();

                this.limpiar();

            } catch (SQLException sql) {

                sql.printStackTrace();

            }

        }else{

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Agregar nuevo Producto");

            alert.setHeaderText(null);

            alert.setContentText("Ingresar todos los datos");

            alert.showAndWait();

        }

    }





    private void limpiar(){

        txtNombreArt.setText("");

        txtModelo.setText("");

        txtDescripcion.setText("");

        txtCantidad.setText("");

        txtPrecio.setText("");

    }



    @FXML

    private void limpiar(ActionEvent event) {

        this.limpiar();

    }



}