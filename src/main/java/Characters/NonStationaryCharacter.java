package Characters;

/**
 * NonStationaryCharacter class provides base methods
 * and members for subclasses.
 *
 * @author Brendan
 * @author Stephen Dao
 * @version 1.0
 * @since 1.0
 */

public class NonStationaryCharacter {
    protected int x = 0; // x coord
    protected int y = 0; // y coord

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
}
