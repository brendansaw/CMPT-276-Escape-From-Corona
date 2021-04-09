package TileAction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;


import static org.junit.Assert.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BonusTest {
    Bonus bonus;
    int x;
    int y;

    @BeforeEach
    public void setup() {
        int max = 1000;
        int min = 1;
        x = (int)Math.floor(Math.random()*(max-min+1)+min);
        y = (int)Math.floor(Math.random()*(max-min+1)+min);
        bonus = new Bonus(x, y);
        assertNotNull(bonus);
    }

    @RepeatedTest(10)
    public void testX() {
        assertEquals(bonus.getX(), x);
    }

    @RepeatedTest(10)
    public void testY() {
        assertEquals(bonus.getY(), y);
    }

    @RepeatedTest(10)
    public void testDecrement() {
        int init = bonus.getTicksRemaining();
        for (int i = 0; i < 5; i++) {
            bonus.decrementTicksRemaining();
            init--;
            assertEquals(bonus.getTicksRemaining(), init);
        }
    }

    @Test
    public void testPositiveScoreIncrease() {
        assertTrue(bonus.getScoreIncreaseValue() >= 0);
    }
}
