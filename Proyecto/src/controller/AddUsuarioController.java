package controller;

import TDAs.SqlConection;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddUsuarioController implements Initializable {
    public JFXTextField txtnombre;
    public JFXTextField txtapellido;
    public JFXTextField txtcedula;
    public JFXTextField txtusuario;
    public JFXTextField txtpassword;
    public JFXComboBox cmbacceso;
    SqlConection conexion = SqlConection.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbacceso.getItems().addAll("SuperAdministrador","Administrador","Gerente","Vendedor");
    }

    private String acess(String s){
        if(s =="SuperAdministrador") return "0";
        if(s =="Administrador") return "1";
        if(s =="Gerente") return "2";
        return "3";
    }


    @FXML
    private void guardarUsuario(ActionEvent event) {
        if (!txtnombre.getText().isEmpty() && !txtapellido.getText().isEmpty() && !txtcedula.getText().isEmpty() && !txtusuario.getText().isEmpty() && !txtpassword.getText().isEmpty()) {
            try {
                conexion.setProcedure("{call nuevoUsuario('" + txtcedula.getText().toUpperCase() + "','" +
                        txtnombre.getText().toUpperCase() + "','" + txtapellido.getText().toUpperCase() + "','" +
                        txtusuario.getText().toUpperCase() + "','" + txtpassword.getText().toUpperCase() + "','" +
                        acess((String) cmbacceso.getValue()) + "')}");
                conexion.ejecutarQuery();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Agregar nuevo Usuario");
                alert.setHeaderText(null);
                alert.setContentText("Guardado Exitoso");
                alert.showAndWait();
                this.limpiar();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Agregar nuevo Usuario");
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
        txtusuario.setText("");
        txtpassword.setText("");
    }
}

