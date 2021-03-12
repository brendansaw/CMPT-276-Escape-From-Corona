package Core;

import BoardDesign.Wall;

public class Board
{

    private int dim;
    private int[][] boardID;
    private Tile[][] board;
    int numCheckptsLeft;
    private int[] entryPos;
    private int[] exitPos;

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
                        board[i][j] = new Tile();
                    case 1://Barrier
                        board[i][j] = new Wall();
                    case 2://Tile with checkpoint
                        board[i][j] = new Reward();
                    case 3://Tile with punishment
                        board[i][j] = new Reward();

                    case 4://Tile with bonus reward. Perhaps the location   
                        board[i][j] = new Reward();

                }
            }
        }


    }

}


