package com.mygdx.game.Sceens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.GameUI.JoystickArea;
import com.mygdx.game.HighCastle;
import com.mygdx.game.Unit;

import static com.mygdx.game.Tools.Assets.CEgate;
import static com.mygdx.game.Tools.Assets.doortouw;
import static com.mygdx.game.Tools.Assets.joystickArea;
import static com.mygdx.game.Tools.Assets.texture_sam;
import static com.mygdx.game.Tools.Assets.townmap;
import static com.mygdx.game.Tools.Assets.uverworld;

public class UverWorldScreen implements Screen, InputProcessor {
    HighCastle game;
    SpriteBatch batch;
    Texture img = texture_sam;
    float size = 100;
    int count = 1;
    int samX;
    int samY;
    Vector3 touch;
    private Unit[] units = new Unit[count];

    public static final float UNIT_SCALE = 10;

    private World world;
    private OrthographicCamera camera = new OrthographicCamera();
    private OrthogonalTiledMapRenderer renderer;

    private Stage stage = new Stage();

    public UverWorldScreen(HighCastle game) {
        this.game = game;
        batch = new SpriteBatch();
        renderer = new OrthogonalTiledMapRenderer(uverworld);
        camera.setToOrtho(false, 1920, 1080);
        world = new World(new Vector2(), false);
        //box2DDebugRenderer =new Box2DDebugRenderer();
        samX = 960 - 64;
        samY = 540 - 64;
        touch = new Vector3();

        units[0] = new Unit(960, 300, world, img);
        units[0].applyForce(new Vector2(100000, 0));

        stage.addActor(joystickArea);

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(this);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        if(joystickArea.isJoystickDown()){
            float x = 100 * joystickArea.getValueX();
            float y = 100 * joystickArea.getValueY();
            units[0].setVelocity(x, y);
        }
        else{
            units[0].setVelocity(0, 0);
        }
        world.step(delta, 4, 4);

        camera.update();
        renderer.setView(camera);
        renderer.render();
        generalupdate(touch, camera);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        //batch.draw(img, 20, 20, size * UNIT_SCALE, size * UNIT_SCALE);
        for (int i = 0; i < count; i++) {
            units[i].draw(batch);
        }

        batch.end();

        stage.act(delta);
        stage.draw();
    }

    public void generalupdate(Vector3 touch, OrthographicCamera camera){
        if(Gdx.input.isTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            samX = (int)touch.x;
            samY = (int)touch.y;
        }
        if(samY<40){
            game.setScreen(new FirstScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}