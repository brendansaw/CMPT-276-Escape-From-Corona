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

    @BeforeAll
    public void testFirstCheckpointCreation() {
        punishment = new Punishment();
    }

    @Test
    public void testNegativeScoreIncrease() {
        assertTrue(punishment.getScoreIncreaseValue() <= 0);
    }
}
