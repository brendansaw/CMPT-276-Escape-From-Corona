package Core;
import Characters.MainCharacter;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
        Board boardGame = createBoard();

        int width = boardGame.getDimX();
        int height = boardGame.getDimY();

        Group root = new Group();
        Scene theScene = new Scene(root);
        mainGame.setScene(theScene);

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

    private Board createBoard() {

        Board boardGame = new Board();
        for (int i = 0; i < boardGame.dimX; i++) {
            for (int j = 0; j < boardGame.dimY; j++) {
                System.out.print(boardGame.board[i][j].getClass().getSimpleName() + boardGame.board[i][j].typeOfReward + " ");
            }
            System.out.println("");
        }
        return boardGame;
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
