package TileAction;
import Characters.*;
import Core.Game;

public class Punishment implements Reward {
    int scoreIncreaseValue = -100;
    MainCharacter mainCharacter;

    public Punishment() {
    }

    @Override
    public void updatePlayerScore() {
        Game.score += scoreIncreaseValue;
        //System.out.println(Game.score);
        /*
        mainCharacter.increasePlayerScore(scoreIncreaseValue);
         */
    }
}
