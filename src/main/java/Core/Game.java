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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.*;

import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import java.lang.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import javafx.util.Duration;
//import org.graalvm.compiler.nodeinfo.StructuralInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

import javafx.scene.Node.*;
import javafx.scene.control.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Game class implements the JavaFX Application class.
 * This class handles game rendering as well as game data
 * including the player score and time elapsed. The game
 * is started and ended from this class. Input listening
 * is also done from this class using EventHandler.
 *
 * @author Danyaal
 * @author Peter
 * @author Brendan
 * @author Stephen
 * @version 1.0
 * @since 1.0
 */
public class Game extends Application{
    public static int score;
    private static int time;

    private static TimerTask gameTicksTask;
    private static Timer gameTicks;
    private static int ticksElapsed = 0; // a tick is 2 seconds
    private static boolean paused = false;

    private int xTileSize = 96;
    private int yTileSize = 96;
    private boolean onFullSecondNextRound = false;

    private static String winStatus;

    private static MainCharacter mainCharacter = MainCharacter.getMainCharacter(0, 0);
    private static ArrayList<Enemy> enemyArrayList = new ArrayList<>();

    private static String currentStage = "first"; // can be "first", "second", "third", "win", "lose"
    private static Board boardGame;

    // no constructor needed since this will contain the main for now

    // launch automatically calls start

    /**
     * Creates the first level of the game
     */
    private static Board firstStage() {
        enemyArrayList.clear();
        Board temp = createBoard("first");
        return temp;
    }

    /**
     * Creates the second level of the game
     * Ensures that all enemies that were in the first level are cleared
     */
    private static Board secondStage() {
        enemyArrayList.clear(); // delete old enemies
        Board temp = createBoard("second");
        return temp;
    }

    /**
     * Creates the third and final level of the game
     */
    private static Board thirdStage() {
        enemyArrayList.clear(); // delete old enemies
        Board temp = createBoard("third");
        return temp;
    }

    public void start(Stage mainGame) {
        mainGame.setTitle("Maze Game");

        startGame();
        boardGame = firstStage();
        int squaredBoard = 10;

        AnchorPane root = new AnchorPane();
        BorderPane positions = new BorderPane();

        Group rootGroup = new Group(root);
        positions.setCenter(rootGroup);
        positions.setAlignment(rootGroup, Pos.CENTER);

        Scene scene = new Scene(positions);
        scene.setRoot(positions);

        Group g2 = new Group();
        Scene mainmenu = new Scene(g2, 150, 100);

        Group g1 = new Group();


        scene.setRoot(positions);
        mainGame.setScene(scene);



        drawRectangles(root, boardGame, mainCharacter);

        Timeline everySecond = new Timeline(
                new KeyFrame(Duration.millis(500),
                        new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {

                                Integer getScoreInt = new Integer(getScore());
                                Integer getTimeInt = new Integer(time);
                                Integer getCheckpointsRemainingInt = new Integer(Checkpoint.checkpointsLeft);
                                HBox statistics = new HBox();
                                VBox firstChild = new VBox();
                                VBox secondChild = new VBox();
                                VBox thirdChild = new VBox();
                                VBox fourthChild = new VBox();
                                int numberOfChildren = 4;
                                Text scoreDisplay = new Text("Current Score: " + getScoreInt.toString());
                                Text timeDisplay = new Text("Time Elapsed: " + getTimeInt.toString());
                                Text checkpointDisplay = new Text("Checkpoints Remaining: " + getCheckpointsRemainingInt.toString());
                                Text winDisplay = new Text("Win Status: " + winStatus);
                                firstChild.getChildren().add(scoreDisplay);
                                secondChild.getChildren().add(timeDisplay);
                                thirdChild.getChildren().add(checkpointDisplay);
                                fourthChild.getChildren().add(winDisplay);
                                statistics.setPrefWidth(mainGame.getWidth());
                                firstChild.setPrefWidth(mainGame.getWidth()/numberOfChildren);
                                secondChild.setPrefWidth(mainGame.getWidth()/numberOfChildren);
                                thirdChild.setPrefWidth(mainGame.getWidth()/numberOfChildren);
                                fourthChild.setPrefWidth(mainGame.getWidth()/numberOfChildren);
                                // maybe use escape to pause game or something?
                                if (!paused) {
                                    if (onFullSecondNextRound) {
                                        time = time + 1;
                                        onFullSecondNextRound = false;
                                    } else {
                                        onFullSecondNextRound = true;
                                    }
                                }

                                statistics.getChildren().add(firstChild);
                                statistics.getChildren().add(secondChild);
                                statistics.getChildren().add(thirdChild);
                                statistics.getChildren().add(fourthChild);

                                xTileSize = (int)(mainGame.getHeight()/boardGame.getDimY())-6-(int)Math.ceil(statistics.getHeight()/boardGame.getDimY());
                                yTileSize = (int)(mainGame.getHeight()/boardGame.getDimY())-6-(int)Math.ceil(statistics.getHeight()/boardGame.getDimY());
                                drawRectangles(root, boardGame, mainCharacter);

                                positions.setTop(statistics);
                            }
                        }));
        everySecond.setCycleCount(Timeline.INDEFINITE);
        everySecond.play();

        //game timer
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            int timeOfInput = ticksElapsed;
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.ESCAPE) {
                    if (!paused) {
                        everySecond.pause();
                        Label t2 = new Label("This is the main menu. Press ESCAPE to resume");
                        Button b2 = new Button("Go to the maingame");
                        t2.setTranslateY(15);
                        //b2.setTranslateY(50);
                        //b2.setOnMouseClicked(f -> { positions.setCenter(rootGroup);});
                        g2.getChildren().clear();
                        //g2.getChildren().addAll(t2, b2);
                        g2.getChildren().add(t2);
                        positions.setCenter(g2);
                    } else {
                        everySecond.play();
                        positions.setCenter(rootGroup);
                    }
                    if (winStatus == null) {
                        paused = !paused;
                    }

                } else if (!paused && ((ticksElapsed-timeOfInput) >= 1)) {
                    timeOfInput = ticksElapsed;
                    mainCharacter.keyPressed(e);
                    drawRectangles(root, boardGame, mainCharacter);
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                mainCharacter.keyReleased(e);
            }
        });
        mainGame.show();
    }

    /**
     * Generates enemies on the in a static manner.
     */
    public static void generateEnemies() { //GENERATING ENEMIES
        Enemy e1 = new Enemy(8, 8);
        Enemy e2 = new Enemy(3, 8);
        enemyArrayList.add(e1);
        enemyArrayList.add(e2);
    }

    public static void generateEnemies2() {
        Enemy e1 = new Enemy(8, 8);
        Enemy e2 = new Enemy(3, 8);
        Enemy e3 = new Enemy(10, 3);
        enemyArrayList.add(e1);
        enemyArrayList.add(e2);
        enemyArrayList.add(e3);
    }

    public static void generateEnemies3() {
        Enemy e1 = new Enemy(4, 3);
        Enemy e2 = new Enemy(13, 3);
        Enemy e3 = new Enemy(4, 6);
        Enemy e4 = new Enemy(13, 6);
        enemyArrayList.add(e1);
        enemyArrayList.add(e2);
        enemyArrayList.add(e3);
        enemyArrayList.add(e4);
    }

    /**
     * Called every tick. Handles game updates including
     * enemy movement and Bonus reward generation.
     */
    public static void updateGame() {
        for(Enemy e : enemyArrayList) {
            e.move();
            e.printPos();
        }
        Board.generateBonus();
    }

    /**
     * Draws the mainCharacter.
     *
     * @param root a JavaFX Pane
     * @param boardGame Board used in current game
     * @param mainCharacter the player controlled MainCharacter
     */
    void drawMainCharacter(AnchorPane root, Board boardGame, MainCharacter mainCharacter) {

        Rectangle rect = null;
        InputStream inputStream;
        Image image = null;
        try{
            inputStream = new FileInputStream("assets/spriteguy.png");
            image = new Image(inputStream);
        } catch(FileNotFoundException e) { inputStream = null; image = null;}
        int x = mainCharacter.getX();
        int y = mainCharacter.getY();
        int width = xTileSize;
        int height = yTileSize;
        rect = new Rectangle(width*x, height*y, width, height);
        if(image != null)
            rect.setFill(new ImagePattern(image));
        else
            rect.setFill(Color.BLACK);
        root.getChildren().add(rect);

    }

    /**
     * Draws the enemies.
     *
     * @param root a JavaFX Pane
     * @param boardGame Board used in current game
     */
    void drawEnemies(AnchorPane root, Board boardGame) {
        Rectangle rect = null;
        InputStream inputStream;
        Image image = null;
        try {
            inputStream = new FileInputStream("assets/enemy.png");
            image = new Image(inputStream);
        } catch(FileNotFoundException e) { inputStream = null; image = null;}
        int width = xTileSize;
        int height = yTileSize;
        for (int i = 0; i < enemyArrayList.size(); i++) {
            int x = enemyArrayList.get(i).getX();
            int y = enemyArrayList.get(i).getY();
            rect = new Rectangle(width*x, height*y, width, height);
            if(image != null)
                rect.setFill(new ImagePattern(image));
            else
                rect.setFill(Color.BLACK);
            root.getChildren().add(rect);
        }
    }

    /**
     * Draws the board Tiles.
     *
     * @param root a JavaFX Pane
     * @param boardGame Board used in current game
     * @param mainCharacter the player controlled MainCharacter
     */
    void drawRectangles(AnchorPane root, Board boardGame, MainCharacter mainCharacter) {
        root.getChildren().clear();
        int width = boardGame.getDimX();
        int height = boardGame.getDimY();
        int horizontal = xTileSize, vertical = yTileSize;
        Rectangle rect = null;
        for(int i = 0; i < height; ++i)
        {//Iterate through columns
            for(int j = 0; j < width; ++j)
            {//Iterate through rows
//              Color choice = chooseColor(rectColors);
                //Method that chooses a color
                //Create a new rectangle(PosY,PosX,width,height)
                rect = new Rectangle(horizontal*j, vertical*i, horizontal, vertical);
                //temporary asset loading for textures; should eventually be done from one file and be more elegant
                InputStream inputTile;
                InputStream inputWall;
                try {
                    inputTile = new FileInputStream("assets/grass.png");
                    inputWall = new FileInputStream("assets/wall.png");
                } catch(FileNotFoundException e) { inputTile = null; inputWall = null;}

                Image imageTile = new Image(inputTile);
                Image imageWall = new Image(inputWall);

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
//                rect.setStrokeWidth(1);
                //rect.setStroke(Color.BLACK);
                rect.setFill(Color.WHITE);
                rect.toBack();
                switch(currentTileInt)
                {
                    case 0: // empty tile
                        rect.setFill(new ImagePattern(imageTile));
                        break;
                    case 1: // wall
                        rect.setFill(new ImagePattern(imageWall));
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
                    rect.setStrokeWidth(5);
                    rect.toFront();
                    if (currentTile.typeOfReward.equals("Checkpoint")) {
                        rect.setFill(Color.BLUE);
                    } else if (currentTile.typeOfReward.equals("Punishment")) {
                        rect.setFill(Color.PINK);
                    } else if (currentTile.typeOfReward.equals("Bonus")) {
                        rect.setFill(Color.YELLOW);
                    }
                }

                drawMainCharacter(root, boardGame, mainCharacter);
                drawEnemies(root, boardGame);
                //Give rectangles an outline so I can see rectangles

                root.getChildren().add(rect);
                //Add Rectangle to board

            }
        }
    }

    /**
     * Starts the gameTicks timer.
     */
    private void startTimer() {
        gameTicksTask = new TimerTask() {
            @Override
            public void run() {
                if(!paused) {
                    updateGame();
                    ticksElapsed += 1;
                }
            }
        };
        gameTicks = new Timer();
        gameTicks.scheduleAtFixedRate(gameTicksTask, 20, 2000);
    }

    /**
     * Initializes the starting variables score and time.
     * Also start the gameTicks timer.
     */
    public void startGame(){
        score = 0;
        time = 0;
        startTimer();
    }

    /**
     * Ends the current game.
     *
     * @param win true if player wins, else false
     */
    public static void endGame(boolean win){
        /*if (winStatus == null) {    // prevents winStatus from changing
            if(win) {
                winStatus = "You win.";
            }
            else {
                winStatus = "You lose.";
            }
            //gameTicks.cancel();
            //paused = true;
        }*/
        if (currentStage.equals("win") || currentStage.equals("lose")) {
            // do nothing
            gameTicks.cancel();
            paused = true;
        }
        else {
            if (win) {
                if (currentStage.equals("first")) {
                    currentStage = "second";
                    boardGame = secondStage();
                } else if (currentStage.equals("second")) {
                    currentStage = "third";
                    boardGame = thirdStage();
                } else if (currentStage.equals("third")) {
                    currentStage = "win";
                    gameTicks.cancel();
                    paused = true;
                    winStatus = "You won!";
                } else if (currentStage.equals("win")) {
                    // do nothing
                } else {
                    System.out.println("Not a valid current stage");
                }
            }
            else {
                currentStage = "lose";
                winStatus = "You lost. :(";
                gameTicks.cancel();
                paused = true;
            }
        }
    }

    /**
     * Getter for score.
     *
     * @return the current game score
     */
    public int getScore(){
        return score;
    }

    /**
     * Getter for time.
     *
     * @return the current game time
     */
    public int getTime(){
        return time;
    }

    /**
     * Adds to the game score by specified amount.
     *
     * @param amount the value to add to the total score
     */
    public static void updateScore(int amount){
        score += amount;
        //System.out.println("Score:" + score);
        if(score < 0) {
            endGame(false);
        }
    }

    private static Board createBoard(String input) {

        Board boardGame = new Board(input);
        for (int i = 0; i < boardGame.dimY; i++) {
            for (int j = 0; j < boardGame.dimX; j++) {
                System.out.print(Board.getBoard()[i][j].getClass().getSimpleName() + Board.getBoard()[i][j].typeOfReward + " ");
            }
            System.out.println("");
        }
        return boardGame;
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
