package Core;
import TileAction.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.function.Executable;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class TileTest {

    /*@Rule
    public ExpectedException thrown = ExpectedException.none();*/
    @Test
    public void testFalseInput()
    {
        /*thrown.expect(NullPointerException.class);*/
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Tile myTile = new Tile(4, 5, 8);
                assertNull(myTile.reward);
            }
        });
        //assertTrue(myTile.getHasReward());
    }
    @Test
    public void testCheckpoint()
    {
        Tile myTile2 = new Tile(1, 5, 8);
        Reward Tile2reward = myTile2.getReward();
        String rewardType = Tile2reward.getClass().getSimpleName();
        assertEquals("Checkpoint", rewardType);
        //System.out.println(rewardType);
    }
    @Test
    public void testPunishment()
    {
        Tile myTile2 = new Tile(2, 5, 8);
        Reward Tile2reward = myTile2.getReward();
        String rewardType = Tile2reward.getClass().getSimpleName();
        assertEquals("Punishment", rewardType);
        //System.out.println(rewardType);
    }
    @Test
    public void testBonus()
    {
        Tile myTile2 = new Tile(3, 5, 8);
        Reward Tile2reward = myTile2.getReward();
        String rewardType = Tile2reward.getClass().getSimpleName();
        assertEquals("Bonus", rewardType);
        //System.out.println(rewardType);
    }
}
