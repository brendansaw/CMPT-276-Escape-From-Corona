package Characters;
import Core.*;

/**
 * Enemy class implements methods to update the
 * enemy object. This includes movement handling
 * and collision handling.
 *
 * @author Brendan
 * @author Stephen Dao
 * @version 1.0
 * @since 1.0
 */
public class Enemy extends NonStationaryCharacter {
    private static MainCharacter player = MainCharacter.getMainCharacter(0, 0); // reference to main character

    public Enemy(int x, int y) { // constructor sets starting position of Enemy
        this.x = x;
        this.y = y;
    }

    /**
     * Updates the position of the enemy.
     */
    public void move() {
        Direction direction = checkBestMovement();
        Tile[][] board = Board.getBoard();
        int dimX = board[0].length;
        int dimY = board.length;

        if(direction == Direction.UP) {
            y += -1;
        }
        if(direction == Direction.DOWN) {
            y += 1;
        }
        if(direction == Direction.LEFT) {
            x += -1;
        }
        if(direction == Direction.RIGHT) {
            x += 1;
        }

        if(isColliding()) {
            onPlayerEntered();
        }
    }

    /**
     * Calculates the position the
     * enemy should move to.
     *
     * @return an enum corresponding to a direction of movement
     */
    private Direction checkBestMovement() {
        Tile[][] board = Board.getBoard();
        int dimX = board[0].length;
        int dimY = board.length;

        boolean moved = false;
        Direction checkedDirection = Direction.STAY;
        int playerPosX = player.getX();
        int playerPosY = player.getY();

        int distanceX = playerPosX - x;
        int distanceY = playerPosY - y;
        // Chooses a direction that sets their coordinates closer to the player
        // Checks x movement first then y movement
        if(!moved) {
            if ((distanceX > 0) && (x + 1 <= dimX)) {
                if (board[y][x + 1].isOpen()) {
                    checkedDirection = Direction.RIGHT;
                    moved = true;
                }
            }
        }
        if(!moved) {
            if ((distanceX < 0) && (x - 1 >= 0)) {
                if (board[y][x - 1].isOpen()) {
                    checkedDirection = Direction.LEFT;
                    moved = true;
                }
            }
        }
        if(!moved) {
            if ((distanceY > 0) && (y + 1 <= dimY)) {
                if (board[y + 1][x].isOpen()) {
                    checkedDirection = Direction.DOWN;
                    moved = true;
                }
            }
        }
        if(!moved) {
            if ((distanceY < 0) && (y - 1 >= 0)) {
                if (board[y - 1][x].isOpen()) {
                    checkedDirection = Direction.UP;
                    moved = true;
                }
            }
        }

        return checkedDirection;
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
     * Causes the player to lose the game by calling Game method endGame().
     */
    private void onPlayerEntered() {
        Game.endGame(false);
    }
}
