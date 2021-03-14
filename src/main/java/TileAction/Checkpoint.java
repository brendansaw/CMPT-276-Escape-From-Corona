package TileAction;
import Characters.*;

public class Checkpoint implements Reward {
    public static int checkpointsLeft = 10;
    boolean isActive = false;
    int scoreIncreaseValue = 50;

    public Checkpoint(MainCharacter mainCharacter) {

    }

    @Override
    public void updatePlayerScore() {
        /*
        mainCharacter.increasePlayerScore(scoreIncreaseValue);
         */
    }
}
