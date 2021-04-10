package Core;


import org.junit.Test;

public class BoardTest {

    static String[] options = {"test", "first", "second", "third"};

    static Board board = new Board(options[2]);

    static Tile[][] boardTest = board.getBoard();

    @Test
    public void testNullTiles(){

        for(int i = 0; i < board.getDimY(); i++) {
            for(int j = 0; j < board.getDimX(); j++) {
                assert(boardTest[i][j] != null);

            }
        }

    }



}
