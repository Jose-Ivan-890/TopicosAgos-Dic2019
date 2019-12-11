package Evento;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

public class EventoTeclado implements EventHandler <KeyEvent> {



    @Override
    public void handle(KeyEvent event) {

        System.out.println(event.getCode());

}



//String code = event.getCode().toString();

    }



