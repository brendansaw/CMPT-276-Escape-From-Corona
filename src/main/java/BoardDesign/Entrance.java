package BoardDesign;
import Core.*;

public class Entrance extends Wall {
    boolean isOpen = true;
    public Entrance() {

        closeEntrance();
    }

    public static void closeEntrance() { // call this when the MC moves // keep it open at all times for now
        /*
        if (gameBoard.mainCharacter.locationX != xLocation || gameBoard.mainCharacter.locationY != yLocation) {
            isOpen = false;
        }
        */
    }

}
