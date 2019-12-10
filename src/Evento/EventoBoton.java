package Evento;

import Views.BuscaMinas;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class EventoBoton implements EventHandler {

    private int nFilas;
    private int nColumnas;
    private int tipo;
    private boolean visible;

    public boolean getVisible() {
        return visible;
    }

    private Color color[];



    @Override
    public void handle(Event event) {


          BuscaMinas obj = new BuscaMinas();

        /*
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
    */
        /*
public EventoBoton(int nFilas, int nColumnas) {

            this.nFilas =  nFilas;
            this.nColumnas = nColumnas;
            this.visible= false;
            this.color= new Color[]{Color.BLUEVIOLET, Color.TURQUOISE,Color.AQUA,Color.DARKORANGE,Color.RED,Color.CHOCOLATE};
            this.setPrefSize(100,100);
            this.setStyle("-fx-base: #33a06f");
            this.setOnAction(event -> eventos());

        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }

        public int getTipo() {
            return tipo;
        }

        private void eventos() {

            clic();
            int contado=0;
            for (int i = 0; i <7 ; i++) {
                for (int j = 0; j <7 ; j++) {
                    if(BuscaMinas.Botones[i][j].getVisible()){
                        contado++;
                    }
                }
            }
            if (contado==49-BuscaMinas.Minas){
                BuscaMinas.Ganó=true;
                Ganador objGanaste = new Ganador();
            }
        }

        public void clic() {
            if (!visible && BuscaMinas.Ganó == false) {
                this.visible = true;

                switch (this.tipo) {
                    case 0:
                        for (int i = 0; i < 7; i++) {
                            for (int j = 0; j < 7; j++) {

                                if (BuscaMinas.Botones[i][j].getTipo() == 0) {
                                    BuscaMinas.Botones[i][j].setGraphic(new ImageView("Images/Mina.png"));

                                }
                            }
                        }
                        Perdedor obj = new Perdedor();
                        //BuscaMinas.Ganó = false;
                        break;
                    case 1:

                        int cont = 0;
                        this.setStyle("-fx-base: #2dc5d9");
                        for (int i = -1; i <= 1; i++) {
                            if (nFilas + i >= 0 && nFilas + i < 7) {
                                for (int j = -1; j <= 1; j++) {
                                    if ((nColumnas + j) >= 0 && (nColumnas + j) < 7 && BuscaMinas.Botones[nFilas + i][nColumnas + j].getTipo() == 0) {
                                        cont++;
                                    }
                                }
                            }
                        }
                        this.setText("" + cont);

                        break;
                    default:
                        this.setStyle("-fx-base: #82D971");
                        for (int i = -1; i < 1; i++) {
                            if (nFilas + i >= 0 && nFilas + i < 7) {
                                for (int j = -1; j < 1; j++) {
                                    if ((nColumnas + j) >= 0 && (nColumnas + j) < 7 && BuscaMinas.Botones[nFilas + i][nColumnas + j].getTipo() != 0) {
                                        if (!BuscaMinas.Botones[nFilas + i][nColumnas + j].getVisible()) {

                                            BuscaMinas.Botones[nFilas + i][nColumnas + j].clic();
                                        }
                                    }
                                }
                            }
                        }
                }
            }
        }
   */ }

}
