package com.mygdx.game.MediumLevel;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.MyScreen;

/**
 * Created by Vince on 2016. 10. 07..
 */

public class MediumLevelScreen extends MyScreen{
    protected MediumLevelStage mediumLevelStage;

    public MediumLevelScreen(Game game) {
        super(game);
        mediumLevelStage = new MediumLevelStage(this.viewport, this.spriteBatch, game);
        Gdx.input.setInputProcessor(mediumLevelStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        mediumLevelStage.act(delta);
        mediumLevelStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        mediumLevelStage.dispose();
    }
}
