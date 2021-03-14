package TileAction;
import Characters.*;

public class Bonus implements Reward {
    boolean isActive = false;
    int scoreIncreaseValue = 100;
    int ticksRemaining = 0;

    public Bonus(MainCharacter mainCharacter) {

    }

    @Override
    public void updatePlayerScore() {
        /*
        mainCharacter.increasePlayerScore(scoreIncreaseValue);
         */
    }
}
