package Characters;

import java.awt.event.KeyEvent;
import Core.*;

/**
 * MainCharacter class implements methods to update the
 * character. This includes character movement
 * and input handling for player controls.
 *
 * @author Brendan
 * @author Stephen Dao
 * @version 1.0
 * @since 1.0
 */
public class MainCharacter extends NonStationaryCharacter {
    private static MainCharacter mainCharacter = null;

    //private Board board = Board.getBoard();

    boolean keyIsPressed; // if a key is held down or not

    private MainCharacter(int x, int y) { // private constructor
        this.x = x;
        this.y = y;
        keyIsPressed = false;
    }

    /**
     * Creates an instance of MainCharacter and sets
     * the starting coordinates if there is currently no other
     * instance of this class.
     *
     * @param x starting x position
     * @param y starting y position
     * @return an instance of a MainCharacter object
     */
    public static MainCharacter getMainCharacter(int x, int y) { // x,y are starting coordinates
        if (mainCharacter == null) { // only create object if none exist
            mainCharacter = new MainCharacter(x, y);
        }

        return mainCharacter;
    }

    /**
     * Handles game behaviour when player changes position.
     */
    @Override
    private void move() {
//        Tile currentTile = board.getTile(x, y);
//        if(isColliding(currentTile)) {
//            currentTile.onPlayerEntered();
//        }
    }

    /**
     * Checks if the player is colliding with a reward tile.
     *
     * @param currentTile a Tile object corresponding to the player's current position
     * @return true if the player is on a reward tile, else false
     */
    @Override
    protected boolean isColliding(Tile currentTile) {
//        if(currentTile.getHasReward()) {
//            return true;
//        }
//        else {
//            return false;
//        }
    }

    /**
     * Handles player movement in
     * response to a key input.
     *
     * @param e a KeyEvent key input
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // origin is top left
        // x,y increases by going right,down
        if (!keyIsPressed) { // check if previous key was released to only allow singular key presses
            if (key == KeyEvent.VK_UP) {
                y += -1;
            }
            if (key == KeyEvent.VK_DOWN) {
                y += 1;
            }
            if (key == KeyEvent.VK_LEFT) {
                x += -1;
            }
            if (key == KeyEvent.VK_RIGHT) {
                x += 1;
            }

            keyIsPressed = true;
        }
    }

    }
    /**
     * Resets the keyIsPressed condition
     * when a key is released.
     *
     * @param e a KeyEvent that is the key being released
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode(); // currently unneeded

        if (keyIsPressed) {
            keyIsPressed = false;
        }
    }

    int getX() {
        return xCoord;
    }
}
