package TileAction;
import Characters.*;

public class Bonus implements Reward {
    boolean isActive = false;
    int scoreIncreaseValue = 100;
    int ticksRemaining = 0;

    public Bonus() {

    }

    @Override
    public void updatePlayerScore() {
        /*
        mainCharacter.increasePlayerScore(scoreIncreaseValue);
         */
    }
}
