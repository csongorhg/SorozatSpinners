package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.Assets;
import com.mygdx.game.Globals;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.MyScreen;

/**
 * Created by Kicsi on 2016. 10. 07..
 */

    public class GameScreen extends MyScreen {

        public GameStage gameStage;


        public GameScreen(Game game) {
            super(game);
            gameStage = new GameStage(viewport, spriteBatch, game);
            Gdx.input.setOnscreenKeyboardVisible(false);
            Gdx.input.setInputProcessor(gameStage);
        }

        @Override
        public void render(float delta) {
            super.render(delta);
            gameStage.act(delta);
            gameStage.draw();

        }

        @Override
        public void dispose() {
            super.dispose();
            gameStage.dispose();
        }


    }

