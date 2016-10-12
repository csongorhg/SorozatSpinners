package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.Game.GameScreen;
import com.mygdx.game.Menu.MenuScreen;

/**
 * Created by mordes on 2016.10.06..
 */
public class LoadingScreen extends MyScreen {

    public LoadingScreen(Game game) {
        super(game);
        setBackGroundColor(1f,1f,1f);
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
        if (Assets.assetManager.update()) {
            game.setScreen(new MenuScreen(game));
            //game.setScreen(new GameScreen(game));
        }
        System.out.println("töltés...");
    }

    @Override
    public void hide() {
        super.hide();
    }
}
