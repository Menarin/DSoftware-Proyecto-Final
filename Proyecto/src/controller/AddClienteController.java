package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import TDAs.SqlConection;

/**
 * FXML Controller class
 *
 * @author HOME
 */
public class AddClienteController implements Initializable {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCedula;

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnLimpiar;
    @FXML


    SqlConection conexion = SqlConection.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void guardarCliente(ActionEvent event) {
        if (!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtCedula.getText().isEmpty() ) {
            try {
                conexion.setProcedure("{call nuevoCliente('" + txtCedula.getText().toUpperCase() + "','" + txtNombre.getText().toUpperCase() + "','" + txtApellido.getText().toUpperCase() + "')}");
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
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
    }

}
