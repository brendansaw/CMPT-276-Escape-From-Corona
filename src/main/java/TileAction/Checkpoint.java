package TileAction;
import Characters.*;
import Core.Game;

public class Checkpoint implements Reward {
    public static int checkpointsLeft = 10;
    int scoreIncreaseValue = 50;

    public Checkpoint() {

    }

    @Override
    public void updatePlayerScore() {
        Game.score += scoreIncreaseValue;
        /*
        mainCharacter.increasePlayerScore(scoreIncreaseValue);
         */
    }
}
