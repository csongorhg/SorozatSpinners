package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.mygdx.game.MyScreen;

/**
 * Created by Kicsi on 2016. 10. 14..
 */

public class EndScreen extends MyScreen{

    protected EndStage endStage;

    public EndScreen(Game game) {
        super(game);
        endStage = new EndStage(this.viewport, this.spriteBatch, game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        endStage.act(delta);
        endStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        endStage.dispose();
    }
}
