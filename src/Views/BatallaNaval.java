package Views;


import Evento.EventoBoard;
import Evento.EventoShip;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;



public class BatallaNaval extends Stage {

    private boolean running = false;
    private EventoBoard enemyEventoBoard, playerEventoBoard;

    private int shipsToPlace = 5;

    private boolean enemyTurn = false;

    private Random random = new Random();

    private Parent createContent() {
        BorderPane root = new BorderPane();
        root.setPrefSize(600, 800);

        root.setRight(new Text("RIGHT SIDEBAR - CONTROLS"));

        enemyEventoBoard = new EventoBoard(true, event -> {
            if (!running)
                return;

            EventoBoard.Cell cell = (EventoBoard.Cell) event.getSource();
            if (cell.wasShot)
                return;

            enemyTurn = !cell.shoot();

            if (enemyEventoBoard.ships == 0) {
                System.out.println("YOU WIN");
                System.exit(0);
            }

            if (enemyTurn)
                enemyMove();
        });

        playerEventoBoard = new EventoBoard(false, event -> {
            if (running)
                return;

            EventoBoard.Cell cell = (EventoBoard.Cell) event.getSource();
            if (playerEventoBoard.placeShip(new EventoShip(shipsToPlace, event.getButton() == MouseButton.PRIMARY), cell.x, cell.y)) {
                if (--shipsToPlace == 0) {
                    startGame();
                }
            }
        });

        VBox vbox = new VBox(50, enemyEventoBoard, playerEventoBoard);
        vbox.setAlignment(Pos.CENTER);

        root.setCenter(vbox);

        return root;
    }

    private void enemyMove() {
        while (enemyTurn) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            EventoBoard.Cell cell = playerEventoBoard.getCell(x, y);
            if (cell.wasShot)
                continue;

            enemyTurn = cell.shoot();

            if (playerEventoBoard.ships == 0) {
                System.out.println("YOU LOSE");
                System.exit(0);
            }
        }
    }

    private void startGame() {
        // place enemy ships
        int type = 5;

        while (type > 0) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if (enemyEventoBoard.placeShip(new EventoShip(type, Math.random() < 0.5), x, y)) {
                type--;
            }
        }

        running = true;
    }


    public BatallaNaval() {
        Scene scene = new Scene(createContent());
        this.setTitle("Battleship");
        this.setScene(scene);
        this.setResizable(false);
        this.show();
    }


}