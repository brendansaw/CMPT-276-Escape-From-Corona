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
                assertFalse(myTile.getHasReward());
            }
        });
        //assertTrue(myTile.getHasReward());
    }
    @Test
    public void testCheckpoint()
    {
        Tile myTile2 = new Tile(1, 5, 8);
        Reward Tile2reward = myTile2.getReward();
        Boolean isRewardPresent = myTile2.getHasReward();
        String rewardType = Tile2reward.getClass().getSimpleName();
        assertEquals("Checkpoint", rewardType);
        assertNotNull(Tile2reward);
        assertTrue(isRewardPresent);
        //System.out.println(rewardType);
    }
    @Test
    public void testPunishment()
    {
        Tile myTile2 = new Tile(2, 5, 8);
        Reward Tile2reward = myTile2.getReward();
        Boolean isRewardPresent = myTile2.getHasReward();
        String rewardType = Tile2reward.getClass().getSimpleName();
        assertEquals("Punishment", rewardType);
        assertEquals("Punishment", myTile2.getTypeReward());
        assertNotNull(Tile2reward);
        assertTrue(isRewardPresent);
        //System.out.println(rewardType);
    }
    @Test
    public void testBonus()
    {
        Tile myTile2 = new Tile(3, 5, 8);
        Reward Tile2reward = myTile2.getReward();
        Boolean isRewardPresent = myTile2.getHasReward();
        String rewardType = Tile2reward.getClass().getSimpleName();
        assertEquals("Bonus", rewardType);
        assertEquals("Bonus", myTile2.getTypeReward());
        assertNotNull(Tile2reward);
        assertTrue(isRewardPresent);
        //System.out.println(rewardType);
    }

    @Test
    public void removeRewardTest()
    {
        Tile myTile2 = new Tile(3, 5, 8);
        myTile2.removeReward();
        assertNull(myTile2.getReward());
        assertFalse(myTile2.getHasReward());
        assertEquals("", myTile2.getTypeReward());

    }
}


