package Core;
import javafx.application.Application;
import javafx.stage.Stage;


import java.util.Locale;

public class Game{

    private int score;
    private int time;

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


    public static void main(String[] args) {
        Game game = new Game();
        int testscore = game.getScore();
        System.out.println(testscore);
        game.changeScore(23);
        int testscore2 = game.getScore();
        System.out.println(testscore2);
    }

}
