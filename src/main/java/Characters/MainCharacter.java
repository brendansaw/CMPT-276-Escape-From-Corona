package Characters;
import Core.*;

public class MainCharacter extends NonStationaryCharacter {
    int xCoord;
    int yCoord;
    MainCharacter(int x, int y) {
        xCoord = x;
        yCoord = y;

    }
    /**
     * @author Brendan
     * @version 1
     * @since commit 1
     * @return Nothing
     */
    void move(String direction) {

    }

    int getX() {
        return xCoord;
    }
}
