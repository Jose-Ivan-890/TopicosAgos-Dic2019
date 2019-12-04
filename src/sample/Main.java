package sample;

import Componets.ClienteSocket;
import Componets.Corredor;
import Evento.EventoVentana;
import Views.BuscaMinas;
import Views.ProductosBD;
import Views.Taquimecanografo;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.stage.WindowEvent;


public class Main extends Application  implements  EventHandler {

    private Scene escena ;
    private BorderPane contenedor;
    private MenuBar mnbMenu;
    private Menu menCompetencia1, menCompetencia12, menSalir;
    private MenuItem mitBuscaMinas,mitSalir,mitTaquimecanografo,mitProductosBD;
    private Button PruebaEvent;

    @Override
    public void start(Stage primaryStage) throws Exception{




    contenedor= new BorderPane();
    mnbMenu =new MenuBar();

    menCompetencia1 = new Menu("1° Competencia");
    menCompetencia12 = new Menu("2° Competencia");
    menSalir = new Menu("Salir");


    mnbMenu.getMenus().addAll(menCompetencia1,menCompetencia12,menSalir);

    contenedor.setTop(mnbMenu);

    mitBuscaMinas=new MenuItem("Busca_Minas");
    mitSalir= new MenuItem("Salir");//le pones el nombre de como se llamara el item
        mitTaquimecanografo = new MenuItem("Taquimecanografo");
        mitProductosBD= new MenuItem("Tienda");

                mitBuscaMinas.setOnAction(event -> EventosMenu(1));
                mitTaquimecanografo.setOnAction(event -> EventosMenu(2));
                mitProductosBD.setOnAction(event -> EventosMenu(3));
       mitSalir.setOnAction(event -> EventosMenu(100));

   menSalir.getItems().addAll(mitSalir);//sirve para agregar un item al menu bar
    menCompetencia1.getItems().addAll(mitBuscaMinas,mitTaquimecanografo,mitProductosBD);

     //  PruebaEvent=new Button("evento handle"); //crear boton
      // contenedor.setCenter(PruebaEvent);
       // PruebaEvent.addEventHandler(MouseEvent.MOUSE_CLICKED,this);//evento que se ejecutara mouse cliket (click completo)
        //PruebaEvent.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventoBoton());//evento que es de otra clase es con new *Este nos recomienda el profe*
       /* PruebaEvent.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {       //este no necesite del implement del EvenHadler
            @Override
            public void handle(MouseEvent event) {
                System.out.println("otro metodo");
            }
        });*/
        //PruebaEvent.setOnAction(event -> System.out.println("directo"));  //Se crea un evento lamda
        //setOnAction(event -> EventoMenu(1));  //Se crea un evento lamda y creas un private void [nombre ()]

        escena= new Scene(contenedor, 300,60);
        escena.getStylesheets().add(getClass().getResource("../CSS/Bootstrap3.css").toExternalForm());// carga el estilo de cascadas
        escena.getStylesheets().add(getClass().getResource("../CSS/estilos.css").toExternalForm());

        //*************************HILOS************************************

        new Corredor("Juan").start(); //Clase + funcion
        new Corredor("flash").start();
        new Corredor("pepe pepe").start();
        new Corredor("Chabelo").start();
        new Corredor("Rubensin").start();

        //*************************HILOS************************************
        // EventoVentana Ev= new EventoVentana();  //mio propuesta
        // primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST,Ev()); // estos dos codigos  es lo mismo que el de abajo

        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWN,new EventoVentana());

        primaryStage.setMaximized(true);
        primaryStage.setTitle("Bienvenidos humanos"); //titulo del stage
        primaryStage.setScene(escena);
        primaryStage.show();

        ClienteSocket objC = new ClienteSocket();
    }

private  void EventosMenu(int opc){
    switch (opc){
        case 1: new BuscaMinas();

        break;
        case 2: new Taquimecanografo();
        break;
        case 3: new ProductosBD();
            break;

    }
    }

    @Override
    public void handle(Event event) {

        BuscaMinas objBm=new BuscaMinas();
    }
}
