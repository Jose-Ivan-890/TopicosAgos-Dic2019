package Views;

import Evento.EventoBoton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class BuscaMinas extends Stage {
    private Label lblMinas;
    private TextField txtNoMinas;
    private Button btnGenerar;
    private VBox vBox;
    private HBox hbox;
    private GridPane grpCampo;
    private Scene escena;
    private Button [][] arCeldas;


    public BuscaMinas(){ //se crea la interfaz grafica
        CrearGUI();
        this.setTitle("BuscaMinas :)");
        this.setScene(escena);
        this.show();
    }


    private void CrearGUI(){
    vBox= new VBox();
    hbox= new HBox();
    lblMinas = new Label("No. Minas");
    txtNoMinas =new TextField();

    btnGenerar = new Button("MinarCam");
    hbox.getChildren().addAll(lblMinas,txtNoMinas,btnGenerar); //agragamos el labe la caja de texto y el boton en el HBox
    grpCampo=new GridPane();
    arCeldas = new Button[15][15];

    btnGenerar.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoBoton());

        for (int i = 0; i <15 ; i++) {
            for (int j = 0; j <15 ; j++) {
                arCeldas[i][j]=new Button();//"-" o '-'
                arCeldas[i][j].setPrefSize(20,20);
                arCeldas[i][j].setStyle("-fx-base: #00FF04 ");
                grpCampo.add(arCeldas[i][j],i,j);


            }//finalisa el for j
        }//finalisa for i
        vBox.getChildren().addAll(hbox,grpCampo);
        escena= new Scene(vBox, 300,400);


    }//clase GUI

    public int[] NumerosSinRepetir(int cantidad,int auxiliar){ //creando mio
        Random rd = new Random();
        int b[] = new int[cantidad];
        int cont=0;
        boolean v,cero=false;

        while (cont<cantidad){
            int numero =(int)(rd.nextDouble() * auxiliar);
            v=true;
            for (int i = 0; i < cantidad; i++) {
                if (numero == b[i])
                {v=false; }

                if (!cero&&numero==1){cero=true;numero=0;}
                if (v){b [cont]=numero; cont++;}

            }
        }return b;

    }
}
