package IntegrationTests;

import BoardDesign.Exit;
import Characters.MainCharacter;
import Core.Board;
import Core.Game;
import Core.Tile;
import TileAction.Checkpoint;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;
import static org.junit.jupiter.api.Assertions.*;

public class InteractTilesIT {
    MainCharacter mainCharacter = MainCharacter.getMainCharacter(0, 0);
    Game game = new Game();

    int[][] id = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };
    Board board = new Board(id);

    @BeforeEach
    public void initGame() {
        Game.setScore(0);
        Game.setTime(0);
        Game.setTicksElapsed(0);
        Game.setTimeOfInput(0);
        Game.setCurrentStage("first");
        Game.setWinStatus("");
        Game.setPaused(false);
        Game.setGameOver(false);
        Game.getEnemyArrayList().clear();
    }

    @Test
    public void testInteractCheckpoint() {
        int[][] checkpoints = {
                {2, 2, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        Board.setBoard(checkpoints);

        mainCharacter.setPos(1, 1);
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.UP, false, false, false, false));
        assertEquals(50, game.getScore(), "0 + 50 should be 50");
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.LEFT, false, false, false, false));
        assertEquals(100, game.getScore(), "50 + 50 should be 100");
    }

    @Test
    public void testInteractPunishment() {
        int[][] punishments = {
                {3, 3, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        Board.setBoard(punishments);

        Game.setScore(150);

        mainCharacter.setPos(1, 1);
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.UP, false, false, false, false));
        assertEquals(50, game.getScore(), "150 - 100 should be 50");
    }

    @Test
    public void testInteractBonus() {
        int[][] bonuses = {
                {4, 4, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        Board.setBoard(bonuses);

        mainCharacter.setPos(1, 1);
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.UP, false, false, false, false));
        assertEquals(100, game.getScore(), "0 + 100 should be 100");
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.LEFT, false, false, false, false));
        assertEquals(200, game.getScore(), "100 + 100 should be 200");
    }

    @Test
    public void testWinGame() {
        Game.setCurrentStage("third");
        Checkpoint.setCheckpointsLeft(0);
        int[][] testBoard = {
                {1, 1, 1, 1, 1, 1, 1},
                {5, 0, 2, 0, 2, 0, 6},
                {1, 1, 1, 1, 1, 1, 1}
        };

        Board.setBoard(testBoard);
        Tile exit = board.getTile(Board.getExitYPos(), Board.getExitXPos());

        game.startGame();

        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.RIGHT, false, false, false, false));
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.RIGHT, false, false, false, false));
        assertFalse(exit.isOpen());
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.RIGHT, false, false, false, false));
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.RIGHT, false, false, false, false));
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.RIGHT, false, false, false, false));
        assertTrue(exit.isOpen());
        mainCharacter.keyPressed(new KeyEvent(KEY_PRESSED, "", "", KeyCode.RIGHT, false, false, false, false));
        ((Exit) exit).checkCheckpoints();
        assertEquals("You won!", Game.getWinStatus());
    }
}