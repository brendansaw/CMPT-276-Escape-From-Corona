package TileAction;
import Characters.*;
import Core.Game;
import java.lang.Math.*;
// might have to import random for random ticks remaining

public class Bonus implements Reward {
    int scoreIncreaseValue = 100;
    int ticksRemaining = 0;

    public Bonus() {
        ticksRemaining = (int)(Math.random() * 30);
    }

    @Override
    public void updatePlayerScore() {
        Game.score += scoreIncreaseValue;
        /*
        mainCharacter.increasePlayerScore(scoreIncreaseValue);
         */
    }
}
