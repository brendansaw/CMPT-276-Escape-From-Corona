package Characters;

public class Enemy extends NonStationaryCharacter {
    /**
     * @author Brendan
     * @version 1
     * @since commit 1
     * @return Nothing
     */
    void checkBestMovement() {
        String checkedDirection = "";

        moveTowardsMC(checkedDirection);
    }
    /**
     * @author Brendan
     * @version 1
     * @since commit 1
     * @return Nothing
     */
    void moveTowardsMC(String direction) {
        if (direction == "") {
            return;
        }
    }
}
