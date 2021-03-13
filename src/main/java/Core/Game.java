package Core;
import javafx.application.Application;
import javafx.stage.Stage;


import java.util.Locale;

public class Game extends Application{

    private int score;
    private int time;



    public void start(Stage mainGame)
    {
        mainGame.setTitle("Maze Game");
        mainGame.show();
        startGame();
    }
    public void startGame(){
        score = 0;
        time = 0;
    }


    public void endGame(){
        stop();
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
