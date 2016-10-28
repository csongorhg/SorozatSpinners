package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Globals;
import com.mygdx.game.MyScreen;

/**
 * Created by mordes on 2016.10.12..
 */

public class InformationScreen extends MyScreen {

    protected InformationStage informationStage;

    public InformationScreen(Game game) {
        super(game);
        informationStage = new InformationStage(this.viewport, this.spriteBatch, game);
        Gdx.input.setInputProcessor(informationStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        informationStage.act();
        informationStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        informationStage.dispose();
    }
}
