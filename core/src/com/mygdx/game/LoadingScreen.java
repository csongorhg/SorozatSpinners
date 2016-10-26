package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Game.GameScreen;
import com.mygdx.game.Menu.MenuScreen;

/**
 * Created by mordes on 2016.10.06..
 */
public class LoadingScreen extends MyScreen {

    Stage stage;
    private float elapsedTime = 0;

    public LoadingScreen(Game game) {
        super(game);
        setBackGroundColor(0f,0f,0f);
        stage = new Stage(viewport, spriteBatch);
        stage.addActor(new OneSpriteAnimatedActor("load.txt")
        {
            @Override
            protected void init() {
                super.init();
                setFps(12);
                setWidth(WORLD_WIDTH);
                setHeight(WORLD_HEIGHT);
            }
        });
    }

    @Override
    public void show() {
        super.show();
        Assets.load();
        Assets.assetManager.finishLoading();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (elapsedTime > 2.0 && Assets.assetManager.update()) {
            Assets.afterLoaded();
            game.setScreen(new MenuScreen(game));
        }
        elapsedTime += delta;
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
