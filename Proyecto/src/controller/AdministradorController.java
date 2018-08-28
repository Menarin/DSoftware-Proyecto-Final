package controller;



import EmpresaLineaBlanca.Main;
import TDAs.Prototype.Articulo;
import TDAs.SqlConection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AdministradorController implements Initializable {

    @FXML
    private Button btnConsulta;
    @FXML
    private Button btnProducto;
    @FXML
    private Button btnLogout;
    @FXML
    private Label lbltxt;
    @FXML
    private TextField txtNombreProducto;
    @FXML
    private MenuItem menunombre;
    @FXML
    private MenuItem menudescripcion;
    @FXML
    private TextArea txtAreaNombre;
    @FXML
    private TextArea txtAreaPrecio;
    @FXML
    private TextArea txtAreaDescripcion;


    SqlConection conexion = SqlConection.getInstance();
    Articulo art;

    @FXML
    private void consultarInventario(ActionEvent event) throws SQLException{
        String produ = txtNombreProducto.getText();
        //System.out.println(produ);
        try{
            if(lbltxt.getText()=="Nombre") {
                conexion.setProcedure("{Call consultaProducto('" + produ + "')}") ;
                conexion.ejecutarQuery();
                conexion.iterarResultado();

                txtAreaNombre.setText(conexion.getResultFila(2));
                txtAreaPrecio.setText(conexion.getResultFila(4));
                txtAreaDescripcion.setText(conexion.getResultFila(3));
            }else if(lbltxt.getText()=="Descripcion") {
                conexion.setProcedure("{Call consultaProductoDescripcion('" + produ + "')}") ;
                conexion.ejecutarQuery();
                conexion.iterarResultado();

                txtAreaNombre.setText(conexion.getResultFila(2));
                txtAreaPrecio.setText(conexion.getResultFila(4));
                txtAreaDescripcion.setText(conexion.getResultFila(3));
            }
        }catch (SQLException sql){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Seleccion de productos");
            alert.setHeaderText(null);
            alert.setContentText("Error el producto no se encuentra disponible");
            alert.showAndWait();
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
    private void handleButtonClicks(ActionEvent mouseEvent) {
        if ((mouseEvent.getSource() == menunombre)) {
            lbltxt.setText("Nombre");


        } else if (mouseEvent.getSource() == menudescripcion) {
            lbltxt.setText("Descripcion");

        }else if (mouseEvent.getSource() == btnProducto) {

            loadStage("/application/AgregarProducto.fxml");

        } else if (mouseEvent.getSource() == btnConsulta) {

            loadStage("/application/ConsultarElemento.fxml");

        } else if (mouseEvent.getSource() == btnLogout) {

            cerrarSesion(mouseEvent);

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
    private void limpiar(ActionEvent event) {
        this.limpiar();
    }

    private void limpiar(){
        txtNombreProducto.setText("");
        txtAreaNombre.setText("");
        txtAreaDescripcion.setText("");
        txtAreaPrecio.setText("");


    }


}