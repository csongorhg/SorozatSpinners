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

        protected GameStage gameStage;
        private static boolean b = true;


        public GameScreen(Game game) {
            super(game);
            gameStage = new GameStage(this.viewport, this.spriteBatch, game);
            Gdx.input.setOnscreenKeyboardVisible(false);
            Gdx.input.setInputProcessor(gameStage);
            Globals.menumusic.stop();
            Globals.gamemusic.play();
        }

        @Override
        public void render(float delta) {
            super.render(delta);
            gameStage.act(delta);
            gameStage.draw();
            if(!b){ game.setScreen(new EndScreen(game)); b=true;}
        }

        @Override
        public void dispose() {
            super.dispose();
            gameStage.dispose();
        }

        public static void setB(){b = false;}
    }

