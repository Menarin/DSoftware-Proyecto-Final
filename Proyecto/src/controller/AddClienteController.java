package controller;

import TDAs.SqlConection;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author HOME
 */
public class AddClienteController implements Initializable {
    @FXML
    private JFXTextField txtnombre;
    @FXML
    private JFXTextField txtapellido;
    @FXML
    private JFXTextField txtcedula;


    SqlConection conexion = SqlConection.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void guardarCliente(ActionEvent event) {
        if (!txtnombre.getText().isEmpty() && !txtapellido.getText().isEmpty() && !txtcedula.getText().isEmpty() ) {
            try {
                conexion.setProcedure("{call nuevoCliente('" + txtcedula.getText().toUpperCase() + "','" + txtnombre.getText().toUpperCase() + "','" + txtapellido.getText().toUpperCase() + "')}");
                conexion.ejecutarQuery();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Agregar nuevo Cliente");
                alert.setHeaderText(null);
                alert.setContentText("Guardado Exitoso");
                alert.showAndWait();
                this.limpiar();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Agregar nuevo Cliente");
            alert.setHeaderText(null);
            alert.setContentText("Ingresar todos los datos");
            alert.showAndWait();
        }
    }

    @FXML
    private void limpiar(ActionEvent event) {
        this.limpiar();
    }

    private void limpiar(){
        txtnombre.setText("");
        txtapellido.setText("");
        txtcedula.setText("");
    }

}
