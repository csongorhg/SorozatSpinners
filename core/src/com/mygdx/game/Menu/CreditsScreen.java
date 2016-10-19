package com.mygdx.game.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.MyScreen;

/**
 * Created by mordes on 2016.10.06..
 */
public class CreditsScreen extends MyScreen {

    protected CreditsStage creditsStage;

    public CreditsScreen(Game game) {
        super(game);
        creditsStage = new CreditsStage(viewport, spriteBatch, game);
        Gdx.input.setInputProcessor(creditsStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        creditsStage.act(delta);
        creditsStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        creditsStage.dispose();
    }

}
