package Core;

import sample.Tile;

public class Board
{

    private int dim;
    private int[][] boardID;
    private Tile[][] board;
    int numCheckptsLeft;
    private int[] entryPos;
    private int[] exitPos;
//        int hasReward; //-1 by default; 0-2 depending on type of reward
//        Boolean hasEnemy;
//        Boolean hasMain; THESE BELONG IN CLASS TILE
    /*
    private int[][] barrierPositions;
    private Tile[][] tiles;
    Not sure if these are necessary based on tilemap implementation
    */

    public Board()
    {

        /**Reads a file with a 2D array...
     *... and initializes each co-ordinate to a Tile object determined by the id at each entry
     *
     */
        int cur;
        for(int i = 0; i < dim; i++)
        {
            for(int j = 0; j < dim; j++)
            {
                cur = boardID[i][j];

                switch(cur)
                {
                    case 0://Tile
                        board[i][j] = new Tile(0);
                    case 1://Barrier

                    case 2://Tile with checkpoint
                    case 3://Tile with bonus reward
                    case 4://Tile with punishment

                }
            }
        }


    }

}


