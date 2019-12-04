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
    private int minas,contador =0;
    private  boolean gano;


    public BuscaMinas(){ //se crea la interfaz grafica
        CrearGUI();
        this.setTitle("BuscaMinas :)");
        this.setScene(escena);
        this.show();
    }


    private void CrearGUI(){
        gano= new Boolean(false);

    vBox= new VBox();
    hbox= new HBox();
    lblMinas = new Label("No. Minas");
    txtNoMinas =new TextField();

    btnGenerar = new Button("MinarCam");
    hbox.getChildren().addAll(lblMinas,txtNoMinas,btnGenerar); //agragamos el labe la caja de texto y el boton en el HBox
    grpCampo=new GridPane();
    arCeldas = new Button[15][15];
    minas= Integer.parseInt(txtNoMinas.getText());//lo que las minas agregaran
    int nminas[][] = NumerosSinRepetir(minas+1); // agregado
 btnGenerar.setOnAction(event -> Generar());


        for (int i = 0; i <15 ; i++) {
            for (int j = 0; j <15 ; j++) {
                arCeldas[i][j]=new Button();//"-" o '-'
                arCeldas[i][j].setPrefSize(20,20);
                arCeldas[i][j].setStyle("-fx-base: #00FF04 ");
               // arCeldas[i][j].setsetTipo(numeroAleatorio());// agregado
                grpCampo.add(arCeldas[i][j],i,j);


            }//finalisa el for j
        }//finalisa for i
    /*
        for (int i = 0; i <minas ; i++) {
            arCeldas[nminas[0][i]][nminas[1][i]].setTipo(0); // agregado
        }
    */
        vBox.getChildren().addAll(hbox,grpCampo);
        escena= new Scene(vBox, 300,400);


    }//clase GUI

    private Object numeroAleatorio() {
        Random rd= new Random();
        int NumeroAl=(int)(rd.nextDouble()*2);
        return NumeroAl+1;
    }

    private void Generar() {
        gano= false;
        contador=0;
    }


    public int[][] NumerosSinRepetir(int cantidad){ //creando mio
        Random rd = new Random();
        int b[][] = new int[2][cantidad];
        int cont=0;
        boolean v;

        while (cont<cantidad){
            int n1 =(int)(rd.nextDouble() * 7);
            int n2 =(int)(rd.nextDouble() * 7);
            v=false;
            for (int i = 0; i < cantidad; i++) {
                if (n1 == b[0][i] && n2 == b[1][i])
                {v=false; }
            }
            if (!v){
                b[0][contador] = n1;
                b[1][contador] = n2;
                contador++;
            }

        }return b;

    }
}
