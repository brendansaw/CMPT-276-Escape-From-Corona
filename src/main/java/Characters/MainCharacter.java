package Characters;

import java.awt.event.KeyEvent;
import Core.*;

/**
 * <h1>MainCharacter</h1>
 * This class implements methods to update the
 * character. This includes character movement
 * and input handling for player controls.
 *
 * @author Brendan
 * @author Stephen Dao
 * @version 1
 * @since commit 1
 * @return Nothing
 */
public class MainCharacter extends NonStationaryCharacter {
    private static MainCharacter mainCharacter = null;

    private int x; // x coord
    private int y; // y coord

    boolean keyIsPressed; // if a key is held down or not

    private MainCharacter(int x, int y) { // private constructor
        this.x = x;
        this.y = y;
        keyIsPressed = false;
    }

    /**
     * This method creates an instance of MainCharacter and sets
     * the starting coordinates if there is currently no other
     * instance of this class.
     * @return MainCharacter
     */
    public static MainCharacter getMainCharacter(int x, int y) { // x,y are starting coordinates
        if (mainCharacter == null) { // only create object if none exist
            mainCharacter = new MainCharacter(x, y);
        }

        return mainCharacter;
    }

    public void move() {
        // do something
    }

    /**
     * This method returns the value of x.
     * @return int x
     */
    public int getX() {
        return x;
    }

    /**
     * This method returns the value of y.
     * @return int y
     */
    public int getY() {
        return y;
    }

    /**
     * This method handles player movement in
     * response to a key input.
     * @param e A key input.
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

    /**
     * This method resets the keyIsPressed condition
     * when a key is released.
     * @param e The key that is released.
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode(); // currently unneeded

        if (keyIsPressed) {
            keyIsPressed = false;
        }
    }
}
