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

    /**
     * Checking checkpoint count upon first initialization
     * Set checkpoints left has to be called just in-case a checkpoint was made beforehand in another test
     */
    @BeforeAll
    public void setup() {
        Checkpoint.setCheckpointsLeft(0);
        countCheckpoints = 0;
        assertEquals(Checkpoint.getCheckpointsLeft(), countCheckpoints);
        checkpoint = new Checkpoint();
        countCheckpoints++;
        assertEquals(Checkpoint.getCheckpointsLeft(), countCheckpoints);
    }

    /**
     * Ensure that when checkpoints are being made, the static variable is increasing
     */
    @RepeatedTest(10)
    public void testCheckpointsLeft() {
        checkpoint = new Checkpoint();
        countCheckpoints++;
        assertEquals(Checkpoint.getCheckpointsLeft(), countCheckpoints);
    }


    /**
     * Ensure that checkpoints have a positive score increase
     */
    @Test
    public void testPositiveScoreIncrease() {
        assertTrue(checkpoint.getScoreIncreaseValue() >= 0);
    }

    /**
     * Test if the counter for decrementing the checkpoints works properly
     */
    @RepeatedTest(10)
    public void testDecrementingCheckpoints() {
        checkpoint.decrementCheckpointsLeft();
        countCheckpoints--;
        assertEquals(Checkpoint.getCheckpointsLeft(), countCheckpoints);
    }
}
