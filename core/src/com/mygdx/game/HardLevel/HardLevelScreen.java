package com.mygdx.game.HardLevel;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.MyScreen;

/**
 * Created by Vince on 2016. 10. 07..
 */

public class HardLevelScreen extends MyScreen{

    protected HardLevelStage hardLevelStage;

    public HardLevelScreen(Game game) {
        super(game);
        hardLevelStage = new HardLevelStage(this.viewport, this.spriteBatch, game);
        Gdx.input.setInputProcessor(hardLevelStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        hardLevelStage.act(delta);
        hardLevelStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        hardLevelStage.dispose();
    }
}
