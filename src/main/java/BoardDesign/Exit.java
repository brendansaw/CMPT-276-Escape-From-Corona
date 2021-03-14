package BoardDesign;
import Core.*;
import TileAction.*;

public class Exit extends Wall {
    private boolean isOpen = false;
    private Board gameBoard;
    public Exit() {

    }

    public boolean checkCheckpoints() { // essentially call this whenever checkpoints are updated
        if (Checkpoint.checkpointsLeft == 0) {
            isOpen = true;
        }
        /*
        if (gameBoard.getCheckpointsLeft <= 0) {
            isOpen = true;
        }
         */
        return isOpen;
    }
}
