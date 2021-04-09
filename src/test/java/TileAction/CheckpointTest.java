package TileAction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;


import static org.junit.Assert.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CheckpointTest {
    Checkpoint checkpoint;
    int countCheckpoints;

    @BeforeAll
    public void testFirstCheckpointCreation() {
        Checkpoint.setCheckpointsLeft(0);
        countCheckpoints = 0;
        assertEquals(Checkpoint.getCheckpointsLeft(), countCheckpoints);
        checkpoint = new Checkpoint();
        countCheckpoints++;
        assertEquals(Checkpoint.getCheckpointsLeft(), countCheckpoints);
    }


    @RepeatedTest(10)
    public void testCheckpointsLeft() {
        checkpoint = new Checkpoint();
        countCheckpoints++;
        assertEquals(Checkpoint.getCheckpointsLeft(), countCheckpoints);
    }



    @Test
    public void testPositiveScoreIncrease() {
        assertTrue(checkpoint.getScoreIncreaseValue() >= 0);
    }
}
