import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.lwjgl.opengl.NVGeometryProgram4;

import java.util.Map;

import static java.util.Map.entry;

public class Global {
    public static final int WORLD_WIDTH = 800;
    public static final int WORLD_HEIGHT = 800;

    public static int[][] grid = new int[4][4];
    public static int[][] prevGrid = new int[4][4];
    public static int SIDE_LENGTH = grid.length;
    public static int SQUARE_SIZE = WORLD_WIDTH/grid.length-2;

    public static final Map<Integer, Texture> textures = Map.ofEntries(
            entry(2, new Texture(Gdx.files.internal("Numbers/2.jpg"))),
            entry(4, new Texture(Gdx.files.internal("Numbers/4.jpg"))),
            entry(8, new Texture(Gdx.files.internal("Numbers/8.jpg"))),
            entry(16, new Texture(Gdx.files.internal("Numbers/16.jpg"))),
            entry(32, new Texture(Gdx.files.internal("Numbers/32.jpg"))),
            entry(64, new Texture(Gdx.files.internal("Numbers/64.jpg"))),
            entry(128, new Texture(Gdx.files.internal("Numbers/128.jpg"))),
            entry(256, new Texture(Gdx.files.internal("Numbers/256.jpg"))),
            entry(512, new Texture(Gdx.files.internal("Numbers/512.jpg"))),
            entry(1024, new Texture(Gdx.files.internal("Numbers/1024.jpg"))),
            entry(2048, new Texture(Gdx.files.internal("Numbers/2048.jpg")))
    );

    public static final Map<Number, Texture> texturesNums = Map.ofEntries(
            entry(Number.n2, new Texture(Gdx.files.internal("Numbers/2.jpg"))),
            entry(Number.n4, new Texture(Gdx.files.internal("Numbers/4.jpg"))),
            entry(Number.n8, new Texture(Gdx.files.internal("Numbers/8.jpg"))),
            entry(Number.n16, new Texture(Gdx.files.internal("Numbers/16.jpg"))),
            entry(Number.n32, new Texture(Gdx.files.internal("Numbers/32.jpg"))),
            entry(Number.n64, new Texture(Gdx.files.internal("Numbers/64.jpg"))),
            entry(Number.n128, new Texture(Gdx.files.internal("Numbers/128.jpg"))),
            entry(Number.n256, new Texture(Gdx.files.internal("Numbers/256.jpg"))),
            entry(Number.n512, new Texture(Gdx.files.internal("Numbers/512.jpg"))),
            entry(Number.n1024, new Texture(Gdx.files.internal("Numbers/1024.jpg"))),
            entry(Number.n2048, new Texture(Gdx.files.internal("Numbers/2048.jpg")))
            );

}
