package TileAction;
import Characters.*;

public class Punishment implements Reward {
    boolean isActive = false;
    int scoreIncreaseValue = -100;
    MainCharacter mainCharacter;

    public Punishment(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    @Override
    public void updatePlayerScore() {
        /*
        mainCharacter.increasePlayerScore(scoreIncreaseValue);
         */
    }
}
