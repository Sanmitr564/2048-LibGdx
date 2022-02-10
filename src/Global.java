import com.badlogic.gdx.graphics.Texture;

import java.util.Map;

import static java.util.Map.entry;

public class Global {
    public static final int WORLD_WIDTH = 800;
    public static final int WORLD_HEIGHT = 800;

    public static int[][] grid = new int[4][4];
    public static int[][] prevGrid = new int[4][4];
    public static int SIDE_LENGTH = grid.length;
    public static int SQUARE_SIZE = WORLD_WIDTH/grid.length-2;

    public static Map<Integer, Texture> textures = Map.ofEntries(
            entry(2, new Texture("2.jpg")),
            entry(4, new Texture("4.jpg")),
            entry(8, new Texture("8.jpg")),
            entry(16, new Texture("16.jpg")),
            entry(32, new Texture("32.jpg")),
            entry(64, new Texture("64.jpg")),
            entry(128, new Texture("128.jpg")),
            entry(256, new Texture("256.jpg")),
            entry(512, new Texture("512.jpg")),
            entry(1024, new Texture("1024.jpg")),
            entry(2048, new Texture("2048.jpg"))
    );
}
