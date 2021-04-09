package TileAction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;


import static org.junit.Assert.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PunishmentTest {
    Punishment punishment;

    /**
     * Create the punishment object for setup
     */
    @BeforeAll
    public void setup() {
        punishment = new Punishment();
    }

    /**
     * Ensure that the score is being increased by a negative value,
     * or that score is being decreased
     */
    @Test
    public void testNegativeScoreIncrease() {
        assertTrue(punishment.getScoreIncreaseValue() <= 0);
    }
}
