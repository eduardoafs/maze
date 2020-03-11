package maze;

public class Cell {
    protected int x;
    protected int y;
    protected int value;

    public Cell(int x, int y) {
        this.x=x;
        this.y=y;

        if (x%2!=0 && y%2!=0) {
            value = ' ';
        } else {
            value = '#';
        }
    }

    public void clear() {
        this.value = ' ';
    }

    public String toString() {
        return "("+this.x+","+this.y+")";
    }
}
