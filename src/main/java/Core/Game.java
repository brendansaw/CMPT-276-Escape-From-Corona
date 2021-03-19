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
import javafx.scene.layout.*;
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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

public class Game extends Application{


    public static int score;
    private static int time;
    private int SizeXTile = 64;
    private int SizeYTile = 64;




    private static String winStatus;

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

        Label labelCenter = new Label("this is BorderPane center");
        Label labelTop = new Label("this is BorderPane top");
        Label labelBottom = new Label("this is BorderPane bottom");
        Label labelLeft = new Label("this is BorderPane left");
        Label labelRight = new Label("this is BorderPane right");

        AnchorPane root = new AnchorPane();
        //BorderPane positions = new BorderPane(root, labelTop, labelRight, labelBottom, labelLeft);
        BorderPane positions = new BorderPane(root);
        //positions.setPrefSize(500,500);
        //positions.setCenter(root);
        positions.setTop(labelTop);
        positions.setBottom(labelBottom);
        positions.setLeft(labelLeft);
        positions.setRight(labelRight);
        positions.setAlignment(labelTop, Pos.CENTER);
        positions.setAlignment(labelBottom, Pos.CENTER);
        positions.setAlignment(labelLeft, Pos.CENTER);
        positions.setAlignment(labelRight, Pos.CENTER);


        root.setMinWidth(squaredBoard*(boardGame.getDimX()));
        root.setMaxWidth(squaredBoard*(boardGame.getDimX()));
        root.setMinHeight(squaredBoard*(boardGame.getDimY()));
        root.setMaxHeight(squaredBoard*(boardGame.getDimY()));




        //positions.setCenter(root);
        mainGame.setFullScreen(true);

        Scene scene = new Scene(positions);
        scene.setRoot(positions);



        StackPane stack = new StackPane();
       /* BorderPane.setAlignment(stack, Pos.CENTER);
*/
        stack.getChildren().add(root);
        stack.setLayoutX(stack.getLayoutX()-stack.getWidth()/2);
        stack.setLayoutY(stack.getLayoutY()-stack.getHeight()/2);

        //stack.translateXProperty(-(stack.widthProperty().divide(2)));
        //stack.translateXProperty().subtract(stack.widthProperty().divide(2));
        //stack.translateXProperty().bind(mainGame.widthProperty().subtract(stack.widthProperty().divide(2)));
        //stack.translateYProperty().subtract(stack.heightProperty().divide(2));
        //stack.translateYProperty().bind(mainGame.heightProperty().subtract(stack.heightProperty().divide(2)));

        positions.setCenter(stack);

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
                new KeyFrame(Duration.millis(1000),
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
                                Text timeDisplay = new Text("Time Remaining: " + getTimeInt.toString());
                                Text checkpointDisplay = new Text("Checkpoints Remaining: " + getCheckpointsRemainingInt.toString());
                                Text winDisplay = new Text("Win Status: " + winStatus);
                                firstChild.getChildren().add(scoreDisplay);
                                secondChild.getChildren().add(timeDisplay);
                                thirdChild.getChildren().add(checkpointDisplay);
                                fourthChild.getChildren().add(winDisplay);
                                statistics.setPrefWidth(boardGame.getDimX() * 256);
                                firstChild.setPrefWidth(statistics.getPrefWidth()/numberOfChildren);
                                secondChild.setPrefWidth(statistics.getPrefWidth()/numberOfChildren);
                                thirdChild.setPrefWidth(statistics.getPrefWidth()/numberOfChildren);
                                fourthChild.setPrefWidth(statistics.getPrefWidth()/numberOfChildren);
                                // maybe use escape to pause game or something?

                                if (time <= 0) {
                                    endGame(false);
                                } else {
                                    time = time-1;
                                }


                                statistics.getChildren().add(firstChild);
                                statistics.getChildren().add(secondChild);
                                statistics.getChildren().add(thirdChild);
                                statistics.getChildren().add(fourthChild);

                                positions.setTop(statistics);
                            }
                        }));
        everySecond.setCycleCount(Timeline.INDEFINITE);
        everySecond.play();
        mainGame.show();

    }

    public static void generateEnemies() {
        Enemy e1 = new Enemy(8, 2);
        Enemy e2 = new Enemy(3, 8);
        enemyArrayList.add(e1);
        enemyArrayList.add(e2);
    }
    public static void inputReceived() {
        for(Enemy e : enemyArrayList) {
            e.move();
            //e.printPos();
        }
    }

    void drawRectangles(AnchorPane root, Board boardGame) {
        int width = boardGame.getDimX();
        int height = boardGame.getDimY();
        int horizontal = 64, vertical = 64;
        Rectangle rect = null;
        for(int i = 0; i < height; ++i)
        {//Iterate through columns
            for(int j = 0; j < width; ++j)
            {//Iterate through rows
//              Color choice = chooseColor(rectColors);
                //Method that chooses a color
                rect = new Rectangle(vertical*j, horizontal*i, horizontal, vertical);
                //Create a new rectangle(PosY,PosX,width,height)

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
                rect.setStrokeWidth(1);
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



                //Give rectangles an outline so I can see rectangles
                root.getChildren().add(rect);
                //Add Rectangle to board

            }
        }
    }

    public void startGame(){
        score = 0;
        time = 10;
    }

    public static void endGame(boolean win){
        if (winStatus == null) {    // prevents winStatus from changing
            if(win) {
                winStatus = "You win.";
            }
            else {
                winStatus = "You lose.";
            }
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
