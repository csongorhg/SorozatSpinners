package com.mygdx.game.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.MyScreen;

/**
 * Created by mordes on 2016.10.06..
 */
public class PlayScreen extends MyScreen {

    protected PlayStage playStage;

    public PlayScreen(Game game) {
        super(game);
        playStage = new PlayStage(viewport, spriteBatch, game);
        Gdx.input.setInputProcessor(playStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        playStage.act(delta);
        playStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        playStage.dispose();
    }
}
