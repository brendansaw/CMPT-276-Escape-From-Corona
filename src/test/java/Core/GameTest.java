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
        Game.setCurrentStage("first");
        Game.setWinStatus("");
        Game.setPaused(false);
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
        assertFalse(Game.getPaused(), "should be false");
    }

    @Test
    public void testEndGameWinSecond() {
        Game.setCurrentStage("second");
        Game.endGame(true);
        assertEquals("third", Game.getCurrentStage(), "should be set to third");
        assertEquals("", Game.getWinStatus(), "should not have been set");
        assertFalse(Game.getPaused(), "should be false");
    }

    @Test
    public void testEndGameWinThird() {
        Game.setCurrentStage("third");
        Game.endGame(true);
        assertEquals("win", Game.getCurrentStage(), "should be set to win");
        assertEquals("You won!", Game.getWinStatus(), "should be set to You won!");
        assertTrue(Game.getPaused(), "should be true");
    }

    @Test
    public void testEndGameLose() {
        Game.endGame(false);
        assertEquals("lose", Game.getCurrentStage(), "should be set to lose");
        assertEquals("You lost. :(", Game.getWinStatus(), "should be set to You lost. :(");
        assertTrue(Game.getPaused(), "should be true");
    }

    @Test
    public void testRestartGame() {
        Game.setScore(1);
        Game.setTime(2);
        Game.setTicksElapsed(100);
        Game.setTimeOfInput(4);
        Game.setWinStatus("win");
        Game.setCurrentStage("second");
        Game.setPaused(true);
        Game.setGameOver(true);

        game.restartGame();

        assertEquals(0, Game.getScoreStatic(), "score should be 0");
        assertEquals(0, Game.getTime(), "time should be 0");
        assertTrue(Game.getTicksElapsed() < 100, "ticksElapsed should have been reset");
        assertEquals(0, Game.getTimeOfInput(), "timeOfInput should be 0");
        assertEquals("", Game.getWinStatus(), "winStatus should be empty");
        assertEquals("first", Game.getCurrentStage(), "currentStage should be first");
        assertFalse(Game.getPaused(), "paused should be false");
        assertFalse(Game.getGameOver(), "gameOver should be false");
    }
}
