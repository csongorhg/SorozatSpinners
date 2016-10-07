package com.mygdx.game.EasyLevel;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.MyScreen;


/**
 * Created by Vince on 2016. 10. 07..
 */

public class EasyLevelScreen extends MyScreen {

        protected EasyLevelStage easyLevelStage;

        public EasyLevelScreen(Game game) {
            super(game);
            easyLevelStage = new EasyLevelStage(this.viewport, this.spriteBatch, game);
            Gdx.input.setInputProcessor(easyLevelStage);
        }

        @Override
        public void render(float delta) {
            super.render(delta);
            easyLevelStage.act(delta);
            easyLevelStage.draw();
        }

        @Override
        public void dispose() {
            super.dispose();
            easyLevelStage.dispose();
        }
}
