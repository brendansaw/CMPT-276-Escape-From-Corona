package Core;
import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;
import org.junit.Before;

public class BoardTest {

    static ArrayList<Board> boards;
    static String[] options;

    @Before
    public void setup() {
        boards = new ArrayList<>();
        int numBoards = 1;
        int x = 100;
        int y = 100;
        Random rand = new Random();
        for (int k = 0; k < numBoards; k++) {
            int[][] cur = new int[y][x];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    cur[i][j] = rand.nextInt();
                    System.out.println(cur[i][j]);
                }
            }
            boards.add(new Board(cur));
        }
    }
//    @Test
//    public void helper() {
////        setup();
//    }

    @Test
    public void testNullTiles(){
        /**
         * is every tile instantiated?
         */
        for(int k = 0; k < boards.size(); k++) {

            Board cur = boards.get(k);
            Tile[][] boardTile = cur.getBoard();

            for (int i = 0; i < cur.getDimY(); i++) {
                for (int j = 0; j < cur.getDimX(); j++) {
                    assert (boardTile[i][j] != null);
                    //more tests

                }
            }
        }
    }

    @Test
    public void assertTiles() {
        for(int k = 0; k < boards.size(); k++) {

            Board cur = boards.get(k);
            Tile[][] boardTile = cur.getBoard();

            for (int i = 0; i < cur.getDimY(); i++) {
                for (int j = 0; j < cur.getDimX(); j++) {

                }
            }
        }
    }
    }


