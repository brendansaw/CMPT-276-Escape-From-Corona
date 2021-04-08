package Characters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NonStationaryCharacterTest {
    NonStationaryCharacter character = new NonStationaryCharacter();

    @Test
    public void testSetPos() {
        character.setPos(12, 34);
        assertEquals(12, character.getX(), "x should be set to 12");
        assertEquals(34, character.getY(), "y should be set to 34");
    }
}
