package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by mordes on 2016.10.06..
 */
public class SettingsScreen extends MyScreen {

    protected SettingsStage settingsStage;

    public SettingsScreen(Game game) {
        super(game);
        settingsStage = new SettingsStage(viewport, spriteBatch, game);
        Gdx.input.setInputProcessor(settingsStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        settingsStage.act(delta);
        settingsStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        settingsStage.dispose();
    }

}
