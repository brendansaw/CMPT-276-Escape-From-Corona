package Core;

import javax.sound.midi.SysexMessage;
import TileAction.*;

public class Tile
{
    private boolean hasEnemy;
    private boolean hasMain;
    private boolean hasReward = false;
    Reward reward;
    public int typeOfReward = 0;

    public Tile() {
        hasReward = false;
    }

    public Tile(int inputType) {
        typeOfReward = inputType;
        hasReward = true;
        switch (typeOfReward) {
            case 1:
                reward = new Bonus();
                break;
            case 2:
                reward = new Punishment();
                break;
            case 3:
                reward = new Checkpoint();
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
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
}
