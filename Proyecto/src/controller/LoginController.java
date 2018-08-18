package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import TDAs.Decorator.Usuario;
import TDAs.roles.Administrador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import TDAs.SqlConection;
import TDAs.roles.Vendedor;
import TDAs.roles.Gerente;
import TDAs.roles.SuperAdmin;

/**
 *
 * @author HOME
 */
public class LoginController implements Initializable {

    @FXML
    private Label lblNada;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnIngresar;
    @FXML
    private Label lblUsuario;
    @FXML
    private Label lblContrasenia;

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
        String usr = txtUsuario.getText();
        String pwrd = txtPassword.getText();
        String level = "";
        try{
            conexion.setProcedure("{Call login('" + usr + "','" + pwrd + "')}") ;
            conexion.ejecutarQuery();
            if (!conexion.iterarResultado())
                lblNada.setText("Usuario o contraseña incorrecta");
            else{
                level = conexion.getResultFila(6);
                System.out.println(level);
                if (level.equals("1")){
                    cliente = new Administrador(conexion.getResultFila(1), conexion.getResultFila(2), conexion.getResultFila(3), conexion.getResultFila(4), conexion.getResultFila(5), level);
                    System.out.println(cliente.toString());
                    this.showMenu(event, "Administrador.fxml");
                }else{
                    cliente = new Vendedor(conexion.getResultFila(1), conexion.getResultFila(2), conexion.getResultFila(3), conexion.getResultFila(4), conexion.getResultFila(5), level);
                    SqlConection.asisRest = conexion.getResultFila(1);
                    //System.out.println(asistente.toString());
                    this.showMenu(event, "Vendedor.fxml");
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