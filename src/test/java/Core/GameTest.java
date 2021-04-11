package Core;

import BoardDesign.Exit;
import Core.Board;
import Core.Tile;
import TileAction.Checkpoint;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameTest {
    Game game = new Game();

    @BeforeEach
    public void initGame() {
        game = new Game();
    }

    @Test
    public void testStartGame() {
        game.startGame();
        assertEquals(0, game.getScore(), "should be 0");
        assertEquals(0, game.getTime(), "should be 0");
    }

    @Test
    public void testEndGameWinFirst() {
        Game.endGame(true);
        assertEquals("second", Game.getCurrentStage(), "should be set to second");
        assertEquals("", Game.getWinStatus(), "should not have been set");
    }
}
