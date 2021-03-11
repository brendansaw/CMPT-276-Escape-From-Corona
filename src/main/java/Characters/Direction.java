package Characters;

public enum Direction {
    UP(-1),
    DOWN(1),
    LEFT(-1),
    RIGHT(1),
    STAY(0);

    private int val;

    Direction(int val){
        this.val = val;
    }

    public int getVal(){
        return val;
    }
}
