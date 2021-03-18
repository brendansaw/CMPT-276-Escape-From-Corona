package Core;
import BoardDesign.*;
import Characters.*;
import TileAction.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.input.*;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Locale;

public class Game extends Application{

    public static int score;
    private int time;
    private static String winStatus;

    private static ArrayList<Enemy> enemyArrayList = new ArrayList<>();

    // no constructor needed since this will contain the main for now

    // launch automatically calls start
    public void start(Stage mainGame) throws FileNotFoundException {
        mainGame.setTitle("Maze Game");

        startGame();
        Board boardGame = createBoard();




//        Group root = new Group();
//        Scene theScene = new Scene(root);
//        mainGame.setScene(theScene);

//        Canvas canvas = new Canvas(100 + width*100 , 100 + height*100);
//        root.getChildren().add( canvas);

//        Rectangle[][] rect = new Rectangle[height][width];
//
//        for(int i = 0; i < height; i++){
//            for(int j = 0; j < width; j++){
//                rect[i][j] = new Rectangle();
//            }
//        }

        Label labelCenter = new Label("this is BorderPane center");
        Label labelTop = new Label("this is BorderPane top");
        Label labelBottom = new Label("this is BorderPane bottom");
        Label labelLeft = new Label("this is BorderPane left");
        Label labelRight = new Label("this is BorderPane right");

        AnchorPane root = new AnchorPane();
        BorderPane positions = new BorderPane(root, labelTop, labelRight, labelBottom, labelLeft);

        positions.setCenter(root);
        //positions.setTop(labelTop);
        positions.setAlignment(labelTop, Pos.CENTER);
        positions.setAlignment(labelBottom, Pos.CENTER);
        positions.setAlignment(labelLeft, Pos.CENTER);
        positions.setAlignment(labelRight, Pos.CENTER);

        positions.setAlignment(root, Pos.CENTER);

        Scene scene = new Scene(positions);
        scene.setRoot(positions);
//        FileInputStream inputStream = new FileInputStream("assets/Mossy Tileset/Mossy - TileSet.png");
//        Image image = new Image(inputStream);
//        ImageView imageView = new ImageView(image);

//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        gc.setFill( Color.GREEN );
//        gc.setStroke( Color.GREEN );
//        gc.setLineWidth(2);
//        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
//        gc.setFont( theFont );
//        gc.fillText( "Start Game", 60, 50 );
//        gc.strokeText( "Start Game", 60, 50 );

        MainCharacter mainCharacter = MainCharacter.getMainCharacter(0, 0);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                mainCharacter.keyPressed(e);
                drawRectangles(root, boardGame);
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                mainCharacter.keyReleased(e);
            }
        });

        mainGame.setScene(scene);



        drawRectangles(root, boardGame);


        Timeline everySecond = new Timeline(
                new KeyFrame(Duration.millis(500),
                        new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                Integer getScoreInt = new Integer(getScore());
                                VBox b = new VBox();
                                Text test = new Text(getScoreInt.toString() + "                                  ");
                                Text test2 = new Text(winStatus);
                                //test.setX(0);
                                //test.setY(0);
                                //test2.setX(0);
                                //test2.setY(50);
                                b.getChildren().add(test);
                                b.getChildren().add(test2);
                                positions.setLeft(b);
                                //positions.setLeft(test2);
                            }
                        }));
        everySecond.setCycleCount(Timeline.INDEFINITE);
        everySecond.play();
        mainGame.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        mainGame.setX((primScreenBounds.getWidth() - mainGame.getWidth()) / 2);
        mainGame.setY((primScreenBounds.getHeight() - mainGame.getHeight()) / 2);

    }

    void drawRectangles(AnchorPane root, Board boardGame) {
        int width = boardGame.getDimX();
        int height = boardGame.getDimY();
        int horizontal = 256, vertical = 256;
        Rectangle rect = null;
        for(int i = 0; i < height; ++i)
        {//Iterate through columns
            for(int j = 0; j < width; ++j)
            {//Iterate through rows
//              Color choice = chooseColor(rectColors);
                //Method that chooses a color

                rect = new Rectangle(vertical*j, horizontal*i, horizontal, vertical);
                //Create a new rectangle(PosY,PosX,width,height)

                //rect.setFill(new ImagePattern(image));
                Tile currentTile = boardGame.getTile(i,j);
                String currentTileString = currentTile.getClass().getSimpleName();
                int currentTileInt = 0;
                if (currentTileString.equals("Tile")) {
                    currentTileInt = 0;
                } else if (currentTileString.equals("Wall")) {
                    currentTileInt = 1;
                }
                else if (currentTileString.equals("Entrance")) {
                    currentTileInt = 2;
                }
                else if (currentTileString.equals("Exit")) {
                    currentTileInt = 3;
                }
                rect.setStroke(Color.BLACK);
                rect.setFill(Color.WHITE);
                switch(currentTileInt)
                {
                    case 0: // empty tile
                        break;
                    case 1: // wall
                        rect.setFill(Color.BLACK);
                        break;
                    case 2: // entrance
                        rect.setFill(Color.GREEN);
                        break;
                    case 3: // exit
                        rect.setFill(Color.RED);
                        break;
                }
                boolean tileHasReward = currentTile.getHasReward();
                if (tileHasReward) {
                    if (currentTile.typeOfReward.equals("Checkpoint")) {
                        rect.setStroke(Color.BLUE);
                    } else if (currentTile.typeOfReward.equals("Punishment")) {
                        rect.setStroke(Color.PINK);
                    } else if (currentTile.typeOfReward.equals("Bonus")) {
                        rect.setStroke(Color.YELLOW);
                    }
                }

                //Give rectangles an outline so I can see rectangles

                root.getChildren().add(rect);
                //Add Rectangle to board

            }
        }
    }

    public void startGame(){
        score = 0;
        time = 0;
    }

    public static void endGame(boolean win){
        if(win) {
            winStatus = "You win.";
        }
        else {
            winStatus = "You lose.";
        }
    }
    public int getScore(){
        return score;
    }

    public int getTime(){
        return time;
    }

    public int changeScore(int amount){
        score = score + amount;
        return score;
    }


    private Board createBoard() {

        Board boardGame = new Board();
        for (int i = 0; i < boardGame.dimY; i++) {
            for (int j = 0; j < boardGame.dimX; j++) {
                System.out.print(Board.getBoard()[i][j].getClass().getSimpleName() + Board.getBoard()[i][j].typeOfReward + " ");
            }
            System.out.println("");
        }
        return boardGame;
    }

    public static void inputReceived() {
        for(Enemy e : enemyArrayList) {
            e.move();
        }
    }

    public static void main(String[] args) {
        launch(args);
//
//        Game game = new Game();
//        int testscore = game.getScore();
//        System.out.println(testscore);
//        game.changeScore(23);
//        int testscore2 = game.getScore();
//        System.out.println(testscore2);
//        MainCharacter mainCharacter = MainCharacter.getMainCharacter(0, 0);
    }

}
