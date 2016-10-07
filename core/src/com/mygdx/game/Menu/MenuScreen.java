package com.mygdx.game.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Menu.MenuStage;
import com.mygdx.game.MyScreen;

/**
 * Created by mordes on 2016.10.05..
 */
public class MenuScreen extends MyScreen {
    protected MenuStage menuStage;
    public MenuScreen(Game game) {
        super(game);
        menuStage  = new MenuStage(viewport, spriteBatch, game);
        Gdx.input.setInputProcessor(menuStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        menuStage.act(delta);
        menuStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        menuStage.dispose();
    }
}

