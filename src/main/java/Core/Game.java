package Core;
import BoardDesign.*;
import Characters.*;
import TileAction.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.input.*;

import java.util.ArrayList;
import java.util.Locale;

public class Game extends Application{

    public static int score;
    private int time;

    private static ArrayList<Enemy> enemyArrayList = new ArrayList<>();

    // no constructor needed since this will contain the main for now

    // launch automatically calls start
    public void start(Stage mainGame) throws FileNotFoundException {
        mainGame.setTitle("Maze Game");

        startGame();
        Board boardGame = createBoard();

        int width = boardGame.getDimX();
        int height = boardGame.getDimY();


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

        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root);
        mainGame.setScene(scene);

//        FileInputStream inputStream = new FileInputStream("assets/Mossy Tileset/Mossy - TileSet.png");
//        Image image = new Image(inputStream);
//        ImageView imageView = new ImageView(image);


        int horizontal = 256, vertical = 256;
        Rectangle rect = null;
        for(int i = 0; i < width; ++i)
        {//Iterate through columns
            for(int j = 0; j < height; ++j)
            {//Iterate through rows
//              Color choice = chooseColor(rectColors);
                //Method that chooses a color

                rect = new Rectangle(horizontal*j, vertical*i, horizontal, vertical);
                //Create a new rectangle(PosY,PosX,width,height)

                //rect.setFill(new ImagePattern(image));
                int cur = boardGame.getID(i,j);
                rect.setStroke(Color.RED);
                rect.setFill(Color.WHITE);
                switch(cur)
                {
                    case 0:
                        break;
                    case 1:
                        rect.setStroke((Color.GREEN));
                        break;
                    case 2:
                        rect.setFill(Color.GREEN);
                        break;
                    case 3:
                        rect.setFill(Color.RED);
                        break;
                    case 4:
                        rect.setFill(Color.BLUE);
                }


                //Give rectangles an outline so I can see rectangles

                root.getChildren().add(rect);
                //Add Rectangle to board

            }
        }
        scene.setRoot(root);
        mainGame.show();


//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        gc.setFill( Color.GREEN );
//        gc.setStroke( Color.GREEN );
//        gc.setLineWidth(2);
//        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
//        gc.setFont( theFont );
//        gc.fillText( "Start Game", 60, 50 );
//        gc.strokeText( "Start Game", 60, 50 );
        Group root = new Group();
        Scene theScene = new Scene(root);
        mainGame.setScene(theScene);
        MainCharacter mainCharacter = MainCharacter.getMainCharacter(0, 0);

        theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                mainCharacter.keyPressed(e);
            }
        });

        theScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                mainCharacter.keyReleased(e);
            }
        });

        Canvas canvas = new Canvas(100 + width*100 , 100 + height*100);
        root.getChildren().add( canvas);

 /*       Rectangle rect = new Rectangle();

        for (int i = 0; i < boardGame.getDimY(); i++){
            for (int j = 0; j < boardGame.getDimX(); j++){
                Rectangle rect = new Rectangle();
                rect.setX(150.0f);
                rect.setY(75.0f);
                rect.setWidth(300.0f);
                rect.setHeight(150.0f);
            }
        }
*/
        AnchorPane rectroot = new AnchorPane();
        Scene scene = new Scene(rectroot);
        mainGame.setScene(scene);

        int columns = height, rows = width, horizontal = 100, vertical = 100;
        Rectangle rect = null;
        for(int i = 1; i <= columns; ++i)
        {//Iterate through columns
            for(int j = 1; j <= rows; ++j)
            {//Iterate through rows
//              Color choice = chooseColor(rectColors);
                //Method that chooses a color

                rect = new Rectangle(horizontal*j, vertical*i, horizontal, vertical);
                //Create a new rectangle(PosY,PosX,width,height)

                rect.setStroke(Color.RED);
                //Give rectangles an outline so I can see rectangles

                rectroot.getChildren().add(rect);
                //Add Rectangle to board

            }
        }
        scene.setRoot(rectroot);
        mainGame.show();
        //Rectangle rectangle = new Rectangle(x, y, width, height)


        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill( Color.GREEN );
        gc.setStroke( Color.GREEN );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
        gc.setFont( theFont );
        gc.fillText( "MAZE GAME", 50, 50 );
        gc.strokeText( "MAZE GAME", 50, 50 );

    }

    public void startGame(){
        score = 0;
        time = 0;
    }

    public static void endGame(boolean win){
        if(win) {
            System.out.println("You win.");
        }
        else {
            System.out.println("You lose.");
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

        Game game = new Game();
        int testscore = game.getScore();
        System.out.println(testscore);
        game.changeScore(23);
        int testscore2 = game.getScore();
        System.out.println(testscore2);
        MainCharacter mainCharacter = MainCharacter.getMainCharacter(0, 0);
    }

}
