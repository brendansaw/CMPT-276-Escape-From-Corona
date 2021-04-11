package Core;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;

public class BoardTest {

    static ArrayList<Board> boards;
    static String[] options;

    @Before
    public void setup() {
        boards = new ArrayList<>();
        options = new String[]{"first", "second", "third"};
        for(int i = 0; i < options.length; i++){

//            boards.add(new Board(options[i]));

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
    public void invalidBoardInput() {
        String test = "wee hoo I'm an invalid input";
//        Board probe = new Board(test);
    }

}
