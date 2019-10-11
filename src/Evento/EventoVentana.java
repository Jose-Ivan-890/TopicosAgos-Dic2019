package Evento;

import Models.Conexion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import sample.Main;

import java.util.Optional;

public class EventoVentana implements EventHandler {
    @Override
    public void handle(Event event) {
    /*    Alert objAlert = new Alert(Alert.AlertType.ERROR);
        objAlert.setTitle("hola");
        objAlert.setHeaderText("Aqui va el encabezado");
        objAlert.setContentText("Aqui esta todo el contenido que aparece xD");
        objAlert.showAndWait();
*/

        // este es el de confirmacion
        Conexion.getConexion();


    }
}
