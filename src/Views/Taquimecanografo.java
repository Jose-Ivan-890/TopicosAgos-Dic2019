package Views;

import Evento.EventoTeclado;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Taquimecanografo extends Stage {
private Scene escena;
private VBox vbox, vTeclado;
private ToolBar tlbMenu;
public TextArea txtContenido,txtEscritura;
private HBox[] filas;
private Button btnAbrir;
private FileChooser flcArchivo;
private Button[] artFuncion,artNumeros,arTTabulador,arTEspacio,arTMayus,arTShift;




    public Taquimecanografo(){
        CrearGUI();
        this.setTitle("Taquimecanogrfo");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {
       vbox =new VBox();

       /** Crear el toolbar*/
       tlbMenu=new ToolBar();
       btnAbrir = new Button();
       btnAbrir.setOnAction(event -> BuscarArchivo());
       btnAbrir.setGraphic(new ImageView("Images/open.png"));
       tlbMenu.getItems().add(btnAbrir);
        /** Caja de texto donde cargaremos el contenido del archivo*/
        txtContenido = new TextArea();
        txtContenido.setPrefColumnCount(100);/*revisarlo*/
        txtContenido.setPrefRowCount(10);
        txtContenido.setEditable(false);
        int inicial=0;
        /** Caja de texto donde escribiremos*/
        txtEscritura = new TextArea();
        txtEscritura.setPrefRowCount(5);
        txtEscritura.setOnKeyPressed(new EventoTeclado());
        txtEscritura.getText();
        /** creamos la seccion del teclado*/

        CrearTeclado ();
        vbox.getChildren().addAll(tlbMenu,txtContenido,txtEscritura,vTeclado);
       // int postBTN=0;
//arTTabulador[postBTN].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventoVentana(txtEscritura));

        escena= new Scene(vbox,400, 500);

    }

    private void BuscarArchivo() {

        flcArchivo=new FileChooser();
        flcArchivo.setTitle("Buscar archivo");
       File archivo = flcArchivo.showOpenDialog(this);


    }

    private void CrearTeclado() {
        vTeclado=new VBox();
        filas= new HBox[6];
        String[] teclaF={"esc","F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12"};
        String[] teclaN={"1","2","3","4","5","6","7","8","9","0","'","¿"};
        String[] teclaT={"Tab","Q","W","E","R","T","Y","U","I","O","P","´","+","enter"};
        String[] teclaM={"BMA","A","S","D","F","G","H","J","K","L","Ñ","{","}"};
        String[] teclaS={"S","<","Z","X","C","V","B","N","M",",",".","-","S","UP"};
        String[] teclaE={"ctrl","fn","i","alt","      Espacio     ","alt gr","libro","ctrl"};
        for (int i = 0; i < 6; i++) {

            filas[i]=new HBox();
            vTeclado.getChildren().addAll(filas[i]);
        }
        CrearFila(teclaF,artFuncion,filas[0]);
        CrearFila(teclaN,artNumeros,filas[1]);
        CrearFila(teclaT,arTTabulador,filas[2]);
        CrearFila(teclaM,arTMayus,filas[3]);
        CrearFila(teclaS,arTShift,filas[4]);
        CrearFila(teclaE,arTEspacio,filas[5]);

        //for
        /*String[] tecla={"esc","F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12"};
        artFuncion=new Button[13 ];    //
        for (int i = 0; i <13 ; i++) {
            artFuncion[i]= new Button(tecla[i]);
            filas[0].getChildren().add(artFuncion[i]);
        */


    }

    private void CrearFila(String[] tecla,Button []arBotones,HBox hFilas){ //Parámetros por referencia lo que hace es generar una funcion que hay de dos referenciala de referencia lo que esta adentro de la funcion(aqui )  comia lo que esta y lo replica y de la otra manera lo de afuera se queda adentro
        arBotones=new Button[tecla.length ]; // que es el .lengt
        for (int i = 0; i <tecla.length ; i++) {  //este ciclo sirve para que el paramatro que este afuera lo solicite
            arBotones[i]= new Button(tecla[i]);
            hFilas.getChildren().add(arBotones[i]);
        }
    }
}
