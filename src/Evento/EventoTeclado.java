package Evento;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EventoTeclado implements EventHandler <KeyEvent> {

    @Override
    public void handle(KeyEvent event) {

        System.out.println(event.getCode());

        if (event.getCode()== KeyCode.ENTER){
            System.out.println("pulso enter");
        }
    }


}
