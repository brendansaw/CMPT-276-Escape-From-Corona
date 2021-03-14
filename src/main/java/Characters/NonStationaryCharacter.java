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

abstract public class NonStationaryCharacter {
    //Tile tile = new Tile(); // currently not working since not implemented in this branch
    protected int x = 0; // x coord
    protected int y = 0; // y coord

//    /**
//     * Abstract method to check for collision with another object.
//     *
//     * @return true or false
//     */
//    abstract protected boolean isColliding();

    /**
     * Returns the value of x.
     *
     * @return an int corresponding to an x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the value of y.
     *
     * @return an int corresponding to a y coordinate
     */
    public int getY() {
        return y;
    }
}
