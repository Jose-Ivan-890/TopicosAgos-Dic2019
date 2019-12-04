package Views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ganador extends Stage {
    private Scene escena;
    private VBox vBox;
    private Button Aceptar;
    private GridPane Campo;
    private Label Texto, Texto1;
    private HBox hBox;

    public Ganador (){
        CrearGUI();
        this.setTitle("Ganador");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {
        vBox= new VBox();
        hBox= new HBox();

        Aceptar= new Button("Aceptar");
        Aceptar.setOnAction(event -> evento());
        Texto = new Label("Felicitaciones");
        Texto= new Label("¡Ganaste el juego!");


        Texto.setPrefSize(100,0);
        Texto.setFont(new Font("courier", 20));

        Texto1.setPrefSize(100,0);
        Texto1.setFont(new Font("courier", 20));

        hBox.getChildren().addAll(Aceptar);
        hBox.setPadding(new Insets(20));

        vBox.getChildren().addAll(Texto,Texto1,hBox);
        vBox.setPadding(new Insets((40)));

        escena = new Scene(vBox, 350,300);
    }

    private void evento() {
        this.close();
    }
}
