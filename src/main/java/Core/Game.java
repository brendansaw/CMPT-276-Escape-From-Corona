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
import java.util.Timer;
import java.util.TimerTask;

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

    // no constructor needed since this will contain the main for now

    // launch automatically calls start
    public void start(Stage mainGame) {
        mainGame.setTitle("Maze Game");

        startGame();
        Board boardGame = createBoard();
        int squaredBoard = 10;

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

        //Label labelCenter = new Label("this is BorderPane center");
        //Label labelTop = new Label("this is BorderPane top");
        //Label labelBottom = new Label("this is BorderPane bottom");
        //Label labelLeft = new Label("this is BorderPane left");
        //Label labelRight = new Label("this is BorderPane right");

        AnchorPane root = new AnchorPane();
        //BorderPane positions = new BorderPane(root, labelTop, labelRight, labelBottom, labelLeft);
        BorderPane positions = new BorderPane();
        //positions.setPrefSize(500,500);

        //positions.setCenter(root);
        //positions.setTop(labelTop);
        //positions.setBottom(labelBottom);
        //positions.setLeft(labelLeft);
        //positions.setRight(labelRight);
        //positions.setAlignment(labelTop, Pos.CENTER);
        //positions.setAlignment(labelBottom, Pos.CENTER);
        //positions.setAlignment(labelLeft, Pos.CENTER);
        //positions.setAlignment(labelRight, Pos.CENTER);



        //root.setMinWidth(squaredBoard*(boardGame.getDimX()));
        //root.setMaxWidth(squaredBoard*(boardGame.getDimX()));
        //root.setMinHeight(squaredBoard*(boardGame.getDimY()));
        //root.setMaxHeight(squaredBoard*(boardGame.getDimY()));
        //positions.setCenter(root);

        Group rootGroup = new Group(root);
        positions.setCenter(rootGroup);
        positions.setAlignment(rootGroup, Pos.CENTER);




        //positions.setCenter(root);


        //mainGame.setFullScreen(true);

        Scene scene = new Scene(positions);
        scene.setRoot(positions);
        /*


        StackPane stack = new StackPane();

        stack.getChildren().add(root);
        stack.setLayoutX((mainGame.getWidth()/2) - stack.getWidth()/2);
        stack.setLayoutY((mainGame.getHeight()/2) - stack.getHeight()/2);

        */
        //positions.setCenter(stack);

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

        //xTileSize = (int)(mainGame.getHeight()/boardGame.getDimY());
        //yTileSize = (int)(mainGame.getHeight()/boardGame.getDimY());
        scene.setRoot(positions);
        mainGame.setScene(scene);

        //root.setLayoutX((mainGame.getWidth()/2) - root.getWidth()/2);
        //root.setLayoutY((mainGame.getHeight()/2) - root.getHeight()/2);


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
                                if (onFullSecondNextRound) {
                                    time = time + 1;
                                    onFullSecondNextRound = false;
                                } else {
                                    onFullSecondNextRound = true;
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

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            int timeOfInput = ticksElapsed;
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.ESCAPE) {
                    if (!paused) {
                        everySecond.pause();
                    } else {
                            everySecond.play();
                    }
                    paused = !paused;
                } else if (!paused && ((ticksElapsed-timeOfInput) >= 1)) {
                    timeOfInput = ticksElapsed;
                    mainCharacter.keyPressed(e);
                    drawRectangles(root, boardGame);
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

    public static void generateEnemies() { //GENERATING ENEMIES
        Enemy e1 = new Enemy(8, 2);
        Enemy e2 = new Enemy(3, 8);
        enemyArrayList.add(e1);
        enemyArrayList.add(e2);
    }
    public static void updateGame() {
        for(Enemy e : enemyArrayList) {
            e.move();
            e.printPos();
        }
        Board.generateBonus();
    }

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
                rect.setStroke(Color.BLACK);
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

                //Give rectangles an outline so I can see rectangles

                root.getChildren().add(rect);
                //Add Rectangle to board

            }
        }
    }

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

    public void startGame(){
        score = 0;
        time = 0;
        startTimer();
    }

    public static void endGame(boolean win){
        if (winStatus == null) {    // prevents winStatus from changing
            if(win) {
                winStatus = "You win.";
            }
            else {
                winStatus = "You lose.";
            }
            gameTicks.cancel();
        }
    }
    public int getScore(){
        return score;
    }

    public int getTime(){
        return time;
    }

    public static void updateScore(int amount){
        score += amount;
        //System.out.println("Score:" + score);
        if(score < 0) {
            endGame(false);
        }
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
