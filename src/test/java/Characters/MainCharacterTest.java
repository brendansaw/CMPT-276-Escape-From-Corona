package Characters;

import Core.Board;
import Core.Tile;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MainCharacterTest {
    MainCharacter mainCharacter = MainCharacter.getMainCharacter(0, 0);

    int[][] id = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    Board board = new Board(id);

    @BeforeEach
    public void initMainCharacter() {
        mainCharacter = MainCharacter.restartMainCharacter(0, 0);
    }

    @Test
    void testKeyPressed() {
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.UP, false, false, false, false));
        assertEquals(0, mainCharacter.getX(), "x coordinate should not change");
        assertEquals(0, mainCharacter.getY(), "y coordinate should not go out of bounds");
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.DOWN, false, false, false, false));
        assertEquals(0, mainCharacter.getX(), "x coordinate should not change");
        assertEquals(1, mainCharacter.getY(), "y coordinate should increase by 1");
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.LEFT, false, false, false, false));
        assertEquals(0, mainCharacter.getX(), "x coordinate should not go out of bounds");
        assertEquals(1, mainCharacter.getY(), "y coordinate should not change");
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.RIGHT, false, false, false, false));
        assertEquals(1, mainCharacter.getX(), "x coordinate should increase by 1");
        assertEquals(1, mainCharacter.getY(), "y coordinate should not change");

        mainCharacter = MainCharacter.restartMainCharacter(2, 2);

        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.DOWN, false, false, false, false));
        assertEquals(2, mainCharacter.getX(), "x coordinate should not change");
        assertEquals(2, mainCharacter.getY(), "y coordinate should not go out of bounds");
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.UP, false, false, false, false));
        assertEquals(2, mainCharacter.getX(), "x coordinate should not change");
        assertEquals(1, mainCharacter.getY(), "y coordinate should decrease by 1");
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.RIGHT, false, false, false, false));
        assertEquals(2, mainCharacter.getX(), "x coordinate should go out of bounds");
        assertEquals(1, mainCharacter.getY(), "y coordinate should not change");
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.LEFT, false, false, false, false));
        assertEquals(1, mainCharacter.getX(), "x coordinate should decrease by 1");
        assertEquals(1, mainCharacter.getY(), "y coordinate should not change");
    }
}
