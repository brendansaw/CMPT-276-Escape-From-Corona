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

    public Board(int[][] id)
    {

        /**Takes a 2D array...
     *... and initializes each co-ordinate to a Tile object determined by the id at each entry
     *
     */

        boardID = id;

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
                        //board[i][j] = new Reward(/*checkpoint params*/);
                    case 3://Tile with punishment
                        //board[i][j] = new Reward(/*punishment params*/);
                    case 4://Tile with bonus reward. Perhaps the location is predetermined since it is here, to group it with all the other rewards
                        //board[i][j] = new Reward(/*bonus params*/);
                    case 5://Tile with entry
                        entryPos = new int[]{i,j};
                    case 6://Tile with exit. Cannot be accessed until all checkpoints collected!
                        exitPos = new int[]{i,j};

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


