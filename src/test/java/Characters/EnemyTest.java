package Characters;

import Core.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EnemyTest {
    Enemy enemy = new Enemy(1, 1);

    MainCharacter mainCharacter = MainCharacter.getMainCharacter(0, 0);

    int[][] id = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    @Mock
    Board board;

    @BeforeEach
    public void initEnemy() {
        board.setBoard(id);
        enemy.setPos(1, 1);
    }

    @Test
    public void testMoveUp() {
        enemy.move(Direction.UP);
        assertEquals(1, enemy.getX(), "x coordinate should not change");
        assertEquals(0, enemy.getY(), "y coordinate should decrease by 1");
    }

    @Test
    public void testMoveDown() {
        enemy.move(Direction.DOWN);
        assertEquals(1, enemy.getX(), "x coordinate should not change");
        assertEquals(2, enemy.getY(), "y coordinate should increase by 1");
    }

    @Test
    public void testMoveLeft() {
        enemy.move(Direction.LEFT);
        assertEquals(0, enemy.getX(), "x coordinate should decrease by 1");
        assertEquals(1, enemy.getY(), "y coordinate should not change");
    }

    @Test
    public void testMoveRight() {
        enemy.move(Direction.RIGHT);
        assertEquals(2, enemy.getX(), "x coordinate should increase by 1");
        assertEquals(1, enemy.getY(), "y coordinate should not change");
    }

//    @Test
//    public void testMoveTowardsPlayerX() {
//        Enemy enemySpy = spy(enemy);
//
//        ArrayList<Enemy> enemyArrayList = new ArrayList<>();
//        enemyArrayList.add(enemy);
//
//        mainCharacter.setPos(0, 0);
//
//        doNothing().when(enemySpy).onPlayerEntered();
//
//        int[][] testId = {
//                {0, 1, 0},
//                {0, 0, 0},
//                {1, 1, 0}
//        };
//        board.setBoard(testId);
//
//        enemy.move(enemyArrayList);
//        assertEquals(0, enemy.getX(), "x coordinate should decrease by 1");
//        assertEquals(1, enemy.getY(), "y coordinate should not change");
//    }
//
//    @Test
//    public void testMoveTowardsPlayerY() {
//        Enemy enemySpy = spy(enemy);
//
//        ArrayList<Enemy> enemyArrayList = new ArrayList<>();
//        enemyArrayList.add(enemy);
//
//        mainCharacter.setPos(2, 2);
//
//        doNothing().when(enemySpy).onPlayerEntered();
//
//        int[][] testId = {
//                {0, 1, 0},
//                {0, 0, 1},
//                {1, 0, 0}
//        };
//        board.setBoard(testId);
//
//        enemy.move(enemyArrayList);
//        assertEquals(1, enemy.getX(), "x coordinate should not change");
//        assertEquals(2, enemy.getY(), "y coordinate should increase by 1");
//    }
//
//    @Test
//    public void testMoveOntoPlayer() {
//        Enemy enemySpy = spy(enemy);
//
//        ArrayList<Enemy> enemyArrayList = new ArrayList<>();
//        enemyArrayList.add(enemy);
//
//        mainCharacter.setPos(0, 0);
//
//        doNothing().when(enemySpy).onPlayerEntered();
//
//        enemy.move(enemyArrayList);
//        assertEquals(0, enemy.getX(), "x coordinate should decrease by 1");
//        assertEquals(1, enemy.getY(), "y coordinate should not change");
//    }
}
