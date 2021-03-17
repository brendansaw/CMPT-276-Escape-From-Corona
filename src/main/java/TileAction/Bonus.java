package TileAction;
import Characters.*;
import Core.Game;
import java.lang.Math.*;
// might have to import random for random ticks remaining

public class Bonus implements Reward {
    int scoreIncreaseValue = 100;
    int ticksRemaining = 0;
    private int x;
    private int y;

    public Bonus(int x, int y) {
        ticksRemaining = (int)(Math.random() * 30);
        this.x = x;
        this.y = y;
        //System.out.println("created bonus at" + x + "," + y);
    }

    @Override
    public void updatePlayerScore() {
        Game.score += scoreIncreaseValue;
        //System.out.println(Game.score);
        /*
        mainCharacter.increasePlayerScore(scoreIncreaseValue);
         */
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTicksRemaining() {
        return ticksRemaining;
    }

    public void decrementTicksRemaining() {
        ticksRemaining -= 1;
    }
}
