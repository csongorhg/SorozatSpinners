package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * Created by mordes on 2016.10.05...
 */
abstract public class MyScreen implements Screen {
    public final static float WORLD_WIDTH = Gdx.app.getGraphics().getWidth(), WORLD_HEIGHT = Gdx.app.getGraphics().getHeight();
    protected SpriteBatch spriteBatch = new SpriteBatch();
    protected OrthographicCamera camera = new OrthographicCamera(WORLD_WIDTH, WORLD_HEIGHT);
    protected ExtendViewport viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

    public float r=0.9f,g=0.9f,b=0.9f;

    protected Game game;

    public MyScreen(Game game) {
        this.game = game;
        camera.translate(WORLD_WIDTH/2, WORLD_HEIGHT/2);
        camera.update();
        Gdx.input.setOnscreenKeyboardVisible(false);
        Gdx.input.setCatchBackKey(false);
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(r, g, b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        camera.translate(((viewport.getWorldWidth() - WORLD_WIDTH) / 2) < 0 ? 0 : -((viewport.getWorldWidth() - WORLD_WIDTH) / 2),
                ((viewport.getWorldHeight() - WORLD_HEIGHT) / 2) < 0 ? 0 : -((viewport.getWorldHeight() - WORLD_HEIGHT) / 2));
        camera.update();
    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {
        MyLabel.refresh();
        MyTextField.refresh();
        MyButton.refresh();
        ButtonToText.refresh();

        Gdx.app.error("asd",Globals.menumusic + "");
        Gdx.app.error("asd",Globals.gamemusic + "");
        Gdx.app.error("asd",Globals.menumusic.isPlaying() + " Menumusic");
        Gdx.app.error("asd",Globals.gamemusic.isPlaying() + " Gamemusic");

        Globals.music();
    }

    public Game getGame() {
        return game;
    }

    public void setBackGroundColor(float r, float g, float b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }

}

