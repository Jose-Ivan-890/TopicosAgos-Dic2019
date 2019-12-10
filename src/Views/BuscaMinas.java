package Views;

import Evento.EventoBoton;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuscaMinas extends Stage {
    /*
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


    vBox= new VBox();
    hbox= new HBox();
    lblMinas = new Label("No. Minas");
    txtNoMinas =new TextField();

    btnGenerar = new Button("MinarCam");
    hbox.getChildren().addAll(lblMinas,txtNoMinas,btnGenerar); //agragamos el labe la caja de texto y el boton en el HBox
    grpCampo=new GridPane();
    arCeldas = new Button[15][15];
   // minas= Integer.parseInt(txtNoMinas.getText());//lo que las minas agregaran

//btnGenerar.setOnAction(event -> EventoBoton;


        for (int i = 0; i <15 ; i++) {
            for (int j = 0; j <15 ; j++) {
                arCeldas[i][j]=new Button();//"-" o '-'
                arCeldas[i][j].setPrefSize(20,20);
                arCeldas[i][j].setStyle("-fx-base: #FFFFFF ");
               // arCeldas[i][j].setsetTipo(numeroAleatorio());// agregado
                grpCampo.add(arCeldas[i][j],i,j);


            }//finalisa el for j
        }//finalisa for i
    /*
        for (int i = 0; i <minas ; i++) {
            arCeldas[nminas[0][i]][nminas[1][i]].setTipo(0); // agregado
        }
   //aqui se pasa
        vBox.getChildren().addAll(hbox,grpCampo);
        escena= new Scene(vBox, 300,400);


    }//clase GUI
 */ //este se pasa arriba

    public BuscaMinas (){
        scene = new Scene(createContent());
        this.setTitle("Buscaminas :)");
        this.setScene(scene);
        this.show();
    }

    private static final int TILE_SIZE = 40;
    private static final int W = 300;
    private static final int H = 200;

    private static final int X_TILES = W / TILE_SIZE;
    private static final int Y_TILES = H / TILE_SIZE;

    private Tile[][] grid = new Tile[X_TILES][Y_TILES];
    private Scene scene;

    private Parent createContent() {
        Alert aler=new Alert(Alert.AlertType.INFORMATION);
        aler.setTitle("Bienvenido al juego de Buscaminas");
        aler.setHeaderText(null);
        aler.setContentText("Crees poder con el reto????");
        aler.showAndWait();

        Pane root = new Pane();
        root.setPrefSize(W, H);

        for (int y = 0; y < Y_TILES; y++) {
            for (int x = 0; x < X_TILES; x++) {
                Tile tile = new Tile(x, y, Math.random() < 0.1);


                grid[x][y] = tile;
                root.getChildren().add(tile);
            }
        }

        for (int y = 0; y < Y_TILES; y++) {
            for (int x = 0; x < X_TILES; x++) {
                Tile tile = grid[x][y];
                tile.setStyle("-fx-base: #00FF04 ");
                if (tile.hasBomb)
                    continue;

                long bombs = getNeighbors(tile).stream().filter(t -> t.hasBomb).count();

                if (bombs > 0)
                    tile.text.setText(String.valueOf(bombs));
            }

        }

        return root;

    }

    private List<Tile> getNeighbors(Tile tile) {
        List<Tile> neighbors = new ArrayList<>();

        // ttt
        // tXt
        // ttt

        int[] points = new int[] {
                -1, -1,
                -1, 0,
                -1, 1,
                0, -1,
                0, 1,
                1, -1,
                1, 0,
                1, 1
        };

        for (int i = 0; i < points.length; i++) {
            int dx = points[i];
            int dy = points[++i];

            int newX = tile.x + dx;
            int newY = tile.y + dy;

            if (newX >= 0 && newX < X_TILES
                    && newY >= 0 && newY < Y_TILES) {
                neighbors.add(grid[newX][newY]);
            }
        }

        return neighbors;
    }

    private class Tile extends StackPane {
        private int x, y;
        private boolean hasBomb;
        private boolean isOpen = false;

        private Rectangle border = new Rectangle(TILE_SIZE - 2, TILE_SIZE - 2);
        private Text text = new Text();

        public Tile(int x, int y, boolean hasBomb) {
            this.x = x;
            this.y = y;
            this.hasBomb = hasBomb;

            border.setStroke(Color.rgb(188,110,155));

            text.setFont(Font.font(18));
            text.setText(hasBomb ? "X" : "");
            text.setVisible(false);

            getChildren().addAll(border, text);

            setTranslateX(x * TILE_SIZE);
            setTranslateY(y * TILE_SIZE);

            setOnMouseClicked(e -> open());

        }

        public void open() {
            if (isOpen)

                return;

            if (hasBomb) {
                Alert aler=new Alert(Alert.AlertType.ERROR);
                aler.setTitle("BOOOM!!!!");
                aler.setHeaderText(null);
                aler.setContentText("Haz tocado una mina :(");
                aler.showAndWait();

                scene.setRoot(createContent());
                return;
            }

            isOpen = true;
            text.setVisible(true);
            border.setFill(null);

            if (text.getText().isEmpty()) {
                getNeighbors(this).forEach(Tile::open);
            }
        }
    }





}
