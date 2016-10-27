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
            }
        });
        final OneSpriteStaticActor text = new OneSpriteStaticActor("justszoveg.png");
        text.setSize(MyScreen.WORLD_HEIGHT/2, MyScreen.WORLD_HEIGHT/2);
        text.setX(WORLD_WIDTH/2-text.getWidth()/2);
        text.setY(WORLD_HEIGHT/2-text.getHeight()/2);
        stage.addActor(text);
    }

    @Override
    public void show() {
        Assets.load();
        Assets.assetManager.finishLoading();
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (elapsedTime > 3.0 && Assets.assetManager.update()) {
            //Assets.afterLoaded();
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
