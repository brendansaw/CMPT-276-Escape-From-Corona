package TileAction;
import Characters.*;
import Core.Game;

public class Checkpoint implements Reward {
    public static int checkpointsLeft = 0;
    int scoreIncreaseValue = 50;

    public Checkpoint() {
        checkpointsLeft += 1;
        System.out.println(checkpointsLeft);
    }

    @Override
    public void updatePlayerScore() {
        Game.score += scoreIncreaseValue;
        checkpointsLeft -= 1;
        //System.out.println(Game.score);
        /*
        mainCharacter.increasePlayerScore(scoreIncreaseValue);
         */
    }
}
