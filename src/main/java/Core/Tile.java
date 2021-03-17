package Core;

import javax.sound.midi.SysexMessage;
import TileAction.*;

public class Tile
{
    private int x;
    private int y;
    private boolean hasEnemy;
    private boolean hasMain;
    private boolean hasReward = false;
    protected boolean isOpen = true;
    Reward reward;
    public String typeOfReward = "";

    public Tile() {
        hasReward = false;
    }

    public Tile(int inputType, int x, int y) {
        hasReward = true;
        switch (inputType) {
            case 1:
                reward = new Checkpoint();
                break;
            case 2:
                reward = new Punishment();
                break;
            case 3:
                reward = new Bonus(x, y);
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
        typeOfReward = reward.getClass().getSimpleName();
    }

    public boolean getHasEnemy()
    {
        return hasEnemy;
    }

    public boolean getHasMain()
    {
        return hasMain;
    }

    public boolean getHasReward(){
        return hasReward;
    }

    public Reward getReward() {
        return reward;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setHasReward(boolean hasReward) {
        this.hasReward = hasReward;
    }

    /**
     * Sets the reward object for the tile.
     *
     * @param reward a type of Reward object
     */
    public void setReward(Reward reward) {
        hasReward = true;
        this.reward = reward;
        typeOfReward = reward.getClass().getSimpleName();
    }

    public void removeReward() {
        hasReward = false;
        reward = null;
        typeOfReward = "";
    }
}
