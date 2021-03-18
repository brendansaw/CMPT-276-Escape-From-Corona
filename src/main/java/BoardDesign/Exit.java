package BoardDesign;
import Characters.MainCharacter;
import Core.*;
import TileAction.*;
//import sun.applet.Main;

public class Exit extends Wall {
    //private static boolean isOpen = false;
    static MainCharacter mainCharacter = MainCharacter.getMainCharacter(0, 0);

    public Exit() {
        isOpen = false;
    }

    /**
     * Checks if all checkpoints have been collected
     * to open the exit.
     *
     * @return true if exit is opened, else false
     */
    public boolean checkCheckpoints() { // essentially call this whenever checkpoints are updated
        if (Checkpoint.checkpointsLeft == 0) {
            isOpen = true;
        }


        if (mainCharacter.getX() == Board.exitXPos && mainCharacter.getY() == Board.exitYPos) {
            Game.endGame(true);
        }
        /*
        if (gameBoard.getCheckpointsLeft <= 0) {
            isOpen = true;
        }
         */
        return isOpen;
    }
}
