package Characters;
import Core.*;

/**
 * Enemy class implements methods to update the
 * enemy object. This includes movement handling
 * and entity collision.
 *
 * @author Brendan
 * @author Stephen Dao
 * @version 1.0
 * @since 1.0
 */
public class Enemy extends NonStationaryCharacter {
    private static MainCharacter player = MainCharacter.getMainCharacter(0, 0); // reference to main character

    /**
     * Calculates the position the
     * enemy should move to.
     *
     * @return an enum corresponding to a direction of movement
     */
    private Direction checkBestMovement() {
        Direction checkedDirection = Direction.STAY;
        int playerPosX = player.getX();
        int playerPosY = player.getY();

        int distanceX = playerPosX - x;
        int distanceY = playerPosY - y;
        // Chooses a direction that sets their coordinates closer to the player
        // Checks x movement first then y movement
        // should check if directions are valid. maybe check wallPositions[x][y]
        // to see if there is a wall there.
        if(distanceX > 0) {
            checkedDirection = Direction.RIGHT;
        }
        else if(distanceX < 0) {
            checkedDirection = Direction.LEFT;
        }
        else if(distanceY > 0) {
            checkedDirection = Direction.DOWN;
        }
        else if(distanceY < 0) {
            checkedDirection = Direction.UP;
        }

        return checkedDirection;
    }

    /**
     * Updates the position of the enemy.
     */
    public void move() {
        Direction direction = checkBestMovement();

        if (direction == Direction.UP) {
            y += Direction.UP.getVal();
        }
        if (direction == Direction.DOWN) {
            y += Direction.DOWN.getVal();
        }
        if (direction == Direction.LEFT) {
            x += Direction.LEFT.getVal();
        }
        if (direction == Direction.RIGHT) {
            x += Direction.RIGHT.getVal();
        }

        if(isColliding()) {
            //onPlayerEntered();
        }
    }

    /**
     * Checks current position for collision with the player.
     *
     * @return true if the player is on the same tile, else false
     */
    private boolean isColliding() {
        if((player.getX() == x) && (player.getY() == y)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Causes the player to lose the game.
     */
    private void onPlayerEntered() {
        //player.setScore(-1); // set score to -1
    }
}
