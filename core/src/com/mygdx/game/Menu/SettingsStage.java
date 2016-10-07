package com.mygdx.game.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyStage;

/**
 * Created by mordes on 2016.10.06..
 */
public class SettingsStage extends MyStage {

    private TextButton textButton;

    public SettingsStage(Game game) {
        super(game);
    }

    public SettingsStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    public SettingsStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    protected void init() {
        textButton = new MyButton("Vissza");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });
        addActor(textButton);
        textButton.setSize(200f,60f);
        textButton.setPosition(0f,0f);
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
