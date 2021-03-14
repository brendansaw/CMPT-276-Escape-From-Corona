package Core;

import BoardDesign.*;
import Characters.*;
import TileAction.*;


public class Board
{

    public int dimX;
    public int dimY;
    private static int[][] boardID;
    private static Tile[][] board;
    public static int exitXPos;
    public static int exitYPos;

    public static Tile[][] getBoard() {
        return board.clone(); // return a copy that they cannot edit
    }

    public Board() {
        int[][] id = {  {1, 0, 2, 5},
                        {1, 0, 3, 6},
                        {1, 1, 4, 2}
                    };
        MainCharacter mainCharacter = MainCharacter.getMainCharacter(0, 0);
        /**Takes a 2D array...
     *... and initializes each co-ordinate to a Tile object determined by the id at each entry
     *
     */

        // assume id must be a rectangle, and thus each X is the same length
        boardID = id;
        dimX = boardID[0].length; // number of columns
        dimY = boardID.length; // number of rows
        board = new Tile[dimY][dimX]; // y has to go first

        for(int i = 0; i < dimY; i++) {
            for(int j = 0; j < dimX; j++) {
                System.out.println();
                int cur = boardID[i][j];

                switch(cur) {
                    case 0://Tile
                        board[i][j] = new Tile();
                        break;
                        //System.out.println("Tile");
                    case 1://Wall
                        board[i][j] = new Wall();
                        break;
                        //System.out.println("Wall");
                    case 2: //Tile with checkpoint
                        board[i][j] = new Tile(1); // checkpoint is input 1
                        break;
                    case 3: //Tile with punishment
                        board[i][j] = new Tile(2); // punishment is input 2
                        break;
                    case 4:
                        board[i][j] = new Tile(3); // bonus is input 3
                        break;
                    case 5:
                        board[i][j] = new Entrance();
                        break;
                    case 6:
                        board[i][j] = new Exit();
                        break;



//                    case 2://Tile with checkpoint
//                        //board[i][j] = new Reward(/*checkpoint params*/);
//                    case 3://Tile with punishment
//                        //board[i][j] = new Reward(/*punishment params*/);
//                    case 4://Tile with bonus reward. Perhaps the location is predetermined since it is here, to group it with all the other rewards
//                        //board[i][j] = new Reward(/*bonus params*/);
//                    case 5://Tile with entry
//                        entryPos = new int[]{i,j};
//                    case 6://Tile with exit. Cannot be accessed until all checkpoints collected!
//                        exitPos = new int[]{i,j};
//
                }
            }
        }
    }

    public void setID(int i, int j, int val)
    {
        //Changes the ID of a single entry, like for when a reward is stepped on
        boardID[i][j] = val;
    }
}


