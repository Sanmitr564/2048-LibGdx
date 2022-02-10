import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.*;

import java.security.Key;

public class FirstDrawing extends ApplicationAdapter {
    private OrthographicCamera camera; //the camera to our world
    private Viewport viewport; //maintains the ratios of your world
    private ShapeRenderer renderer; //used to draw textures and fonts 
    private BitmapFont font; //used to draw fonts (text)
    private SpriteBatch batch; //also needed to draw fonts (text)

    private GameState state;
    private Vector2 v;

    @Override//called once when we start the game
    public void create() {

        camera = new OrthographicCamera();
        viewport = new FitViewport(Global.WORLD_WIDTH, Global.WORLD_HEIGHT, camera);
        renderer = new ShapeRenderer();
        font = new BitmapFont();
        batch = new SpriteBatch();//if you want to use images instead of using ShapeRenderer
        new Working();

        v = new Vector2(0, Global.WORLD_WIDTH / 2);
        state = GameState.wait;
    }

    @Override//called 60 times a second
    public void render() {
        preRender();
        drawBoard();
        control();
        drawNumbers();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        renderer.dispose();
        batch.dispose();
    }

    public void preRender() {
        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        float delta = Gdx.graphics.getDeltaTime();//1/60 

        //draw everything on the screen
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        batch.setProjectionMatrix(viewport.getCamera().combined);
    }

    public void drawBoard() {
        renderer.begin(ShapeType.Filled);

        for (int y = 0; y < Global.SIDE_LENGTH; y++) {
            for (int x = 0; x < Global.SIDE_LENGTH; x++) {
                renderer.setColor(Color.WHITE);
                renderer.rect(1 + x * (Global.SQUARE_SIZE + 2), 1 + y * (Global.SQUARE_SIZE + 2), Global.SQUARE_SIZE, Global.SQUARE_SIZE);
            }
        }
        renderer.end();
    }

    public void drawNumbers() {
        batch.begin();
        for (int row = 0; row < Global.grid.length; row++) {
            for (int col = 0; col < Global.grid[row].length; col++) {
                int temp = Global.grid[row][col];
                if (temp == 0)
                    continue;
                batch.draw(Global.textures.get(temp), 1 + col * (Global.SQUARE_SIZE + 2), 1 + row * (Global.SQUARE_SIZE + 2), Global.SQUARE_SIZE, Global.SQUARE_SIZE);
            }
        }
        batch.end();
    }

    public void control() {
        if (Gdx.input.isKeyJustPressed(Keys.UP))
            Working.goDown();
        if (Gdx.input.isKeyJustPressed(Keys.DOWN))
            Working.goUp();
        if (Gdx.input.isKeyJustPressed(Keys.LEFT))
            Working.goLeft();
        if (Gdx.input.isKeyJustPressed(Keys.RIGHT))
            Working.goRight();
    }
}
