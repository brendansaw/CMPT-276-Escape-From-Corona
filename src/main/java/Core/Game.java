package Core;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


import java.util.Locale;

public class Game extends Application{

    private int score;
    private int time;

    // no constructor needed since this will contain the main for now

    // launch automatically calls start
    public void start(Stage mainGame) {
        mainGame.setTitle("Maze Game");

        startGame();
        createBoard();
        Group root = new Group();
        Scene theScene = new Scene(root);
        mainGame.setScene(theScene);

        Canvas canvas = new Canvas(400, 200);
        root.getChildren().add( canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill( Color.GREEN );
        gc.setStroke( Color.GREEN );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
        gc.setFont( theFont );
        gc.fillText( "Start Game", 60, 50 );
        gc.strokeText( "Start Game", 60, 50 );

        mainGame.show();

    }

    public void startGame(){
        score = 0;
        time = 0;
    }


    public void endGame(){

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

    private void createBoard() {

        Board boardGame = new Board();
        for (int i = 0; i < boardGame.dimY; i++) {
            for (int j = 0; j < boardGame.dimX; j++) {
                System.out.print(boardGame.board[j][i].getClass().getSimpleName() + boardGame.board[j][i].typeOfReward + " ");
            }
            System.out.println("");
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
    }

}
