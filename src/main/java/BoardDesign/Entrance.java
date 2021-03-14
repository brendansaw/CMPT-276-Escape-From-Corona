package BoardDesign;
import Core.*;

public class Entrance extends Wall {
    boolean isOpen = true;
    private Board gameBoard;
    int xLocation, yLocation;
    public Entrance(Board inputGameBoard, int xLoc, int yLoc) {
        this.gameBoard = inputGameBoard;
        this.xLocation = xLoc;
        this.yLocation = yLoc;
        closeEntrance();
    }

    public void closeEntrance() { // call this when the MC moves
        /*
        if (gameBoard.mainCharacter.locationX != xLocation || gameBoard.mainCharacter.locationY != yLocation) {
            isOpen = false;
        }
        */
    }

}
