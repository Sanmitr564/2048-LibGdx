import com.badlogic.gdx.graphics.Texture;

public class Tile {
    private int row;
    private int col;
    private int prevRow;
    private int prevCol;
    private Number value;
    private Texture sprite;
    private float x;
    private float y;
    private float targetX;
    private float targetY;
    private float prevX;
    private float prevY;

    public Tile(int row, int col, Number value, Texture sprite, float x, float y) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        prevRow = row;
        prevCol = col;
        sprite = Global.texturesNums.get(value);
    }
}
