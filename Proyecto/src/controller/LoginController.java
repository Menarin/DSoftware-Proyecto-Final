package controller;

import TDAs.SqlConection;
import TDAs.Usuario;
import TDAs.roles.Administrador;
import TDAs.roles.Gerente;
import TDAs.roles.SuperAdmin;
import TDAs.roles.Vendedor;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOME
 */
public class LoginController implements Initializable {

    @FXML
    private Label mensaje;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    SqlConection conexion = SqlConection.getInstance();
    Usuario cliente;

    private void showMenu(ActionEvent event, String fxmlDocument) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        try{
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/application/"+fxmlDocument))));
            stage.setTitle(fxmlDocument.substring(0, fxmlDocument.lastIndexOf(".")));
            stage.centerOnScreen();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void login(ActionEvent event){
        String usr = username.getText();
        String pwrd = password.getText();
        String level = "";
        try{
            conexion.setProcedure("{Call login('" + usr + "','" + pwrd + "')}") ;
            conexion.ejecutarQuery();
            if (!conexion.iterarResultado())
                mensaje.setText("Usuario o contraseña incorrecta");
            else{
                level = conexion.getResultFila(6);

                if (level.equals("1")){
                    cliente = new Administrador(conexion.getResultFila(1), conexion.getResultFila(2), conexion.getResultFila(3), conexion.getResultFila(4), conexion.getResultFila(5), level);

                    this.showMenu(event, "Administrador.fxml");
                }else if (level.equals("3")){
                    cliente = new Vendedor(conexion.getResultFila(1), conexion.getResultFila(2), conexion.getResultFila(3), conexion.getResultFila(4), conexion.getResultFila(5), level);
                    SqlConection.asisRest = conexion.getResultFila(1);

                    this.showMenu(event, "vendedorview.fxml");
                }else if (level.equals("0")){
                    cliente = new SuperAdmin(conexion.getResultFila(1), conexion.getResultFila(2), conexion.getResultFila(3), conexion.getResultFila(4), conexion.getResultFila(5), level);
                    SqlConection.asisRest = conexion.getResultFila(1);

                    this.showMenu(event, "SuperAdminview.fxml");
                }else if (level.equals("2")){
                    cliente = new Gerente(conexion.getResultFila(1), conexion.getResultFila(2), conexion.getResultFila(3), conexion.getResultFila(4), conexion.getResultFila(5), level);
                    SqlConection.asisRest = conexion.getResultFila(1);

                    this.showMenu(event, "gerenteview.fxml");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String user = "root";
        String pwrd = "GEARTREAKMYSQL#1";
        try{
            //Esta clase sirve para generar la conexion en SQL
            conexion.setConnexion(user, pwrd);
        }catch(SQLException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}