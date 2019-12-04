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

public class Perdedor extends Stage {
    private Scene escena;
    private VBox vBox;
    private Button Aceptar;
    private GridPane CampoPerdiste;
    private Label TextoPer, Texto1Per, ImagenPer;
    private HBox hBoxPer,hBox1;

    public Perdedor(){
        CrearGUI();
        this.setTitle("Perdiste");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {
        vBox= new VBox();
        hBoxPer= new HBox();

        Aceptar= new Button("Aceptar.");
        Aceptar.setOnAction(event -> evento());
        TextoPer = new Label("Nimodo");
        Texto1Per= new Label("Suerte para la proxima");


        Texto1Per.setPrefSize(200,0);
        TextoPer.setFont(new Font("courier", 20));

        Texto1Per.setPrefSize(200,0);
        Texto1Per.setFont(new Font("courier", 20));

        hBoxPer.getChildren().addAll(Aceptar);
        hBoxPer.setPadding(new Insets(20));

        vBox.getChildren().addAll(TextoPer, Texto1Per,hBoxPer);
        vBox.setPadding(new Insets((50)));

        escena = new Scene(vBox, 350,300);
    }

    private void evento() {
        this.close();
    }
}
