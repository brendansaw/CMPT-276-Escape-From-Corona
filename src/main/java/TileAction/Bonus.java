package TileAction;
import Characters.*;
import Core.Game;
import java.lang.Math.*;

/**
 * Bonus class implements the Reward interface.
 * Contains method to update player score by the
 * value of the object.
 * Also contains members that manage the lifetime
 * of the reward.
 *
 * @author Brendan
 * @author Stephen Dao
 * @version 1.0
 * @since 1.0
 */
public class Bonus implements Reward {
    int scoreIncreaseValue = 100;
    int ticksRemaining = 0;
    private int x;
    private int y;

    public Bonus(int x, int y) { // constructor sets bonus coordinates and lifetime
        ticksRemaining = (int)((Math.random() * 7) + 3); // max lifetime = 10, min lifetime = 3
        this.x = x;
        this.y = y;
        //System.out.println("created bonus at" + x + "," + y);
    }

    /**
     * Updates player score by value of reward.
     */
    @Override
    public void updatePlayerScore() {
        Game.score += scoreIncreaseValue;
        //System.out.println(Game.score);
        /*
        mainCharacter.increasePlayerScore(scoreIncreaseValue);
         */
    }

    /**
     * Getter for the x coordinate of object.
     *
     * @return an int corresponding to an x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for the y coordinate of object.
     *
     * @return an int corresponding to a y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Getter for the remaining lifetime of the object.
     *
     * @return an int corresponding to the lifetime remaining in ticks
     */
    public int getTicksRemaining() {
        return ticksRemaining;
    }

    /**
     * Method to decrement the lifetime of the object by 1 tick.
     */
    public void decrementTicksRemaining() {
        ticksRemaining -= 1;
    }
}
