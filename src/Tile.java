public class Tile {
    private int row;
    private int col;
    private int value;
    private int position;

    public Tile(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
        value = 0;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    //public void
}
