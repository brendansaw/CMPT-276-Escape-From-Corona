package BoardDesign;
import Core.*;

public class Exit extends Wall {
    private boolean isOpen = false;
    private Board gameBoard;
    public Exit(Board inputGameBoard) {
        gameBoard = inputGameBoard;
    }

    public boolean checkCheckpoints() { // essentially call this whenever checkpoints are updated
        /*
        if (gameBoard.getCheckpointsLeft <= 0) {
            isOpen = true;
        }
         */
        return isOpen;
    }
}
