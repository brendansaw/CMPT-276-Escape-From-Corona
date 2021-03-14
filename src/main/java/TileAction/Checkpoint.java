package TileAction;
import Characters.*;

public class Checkpoint implements Reward {
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
