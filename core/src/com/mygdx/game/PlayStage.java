package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by mordes on 2016.10.06..
 */
public class PlayStage extends MyStage {

    private TextButton textButton;

    public PlayStage(Game game) {
        super(game);
    }

    public PlayStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    public PlayStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    @Override
    protected void init() {
        textButton = new MyButton("Vissza");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });
        textButton.setSize(200f,60f);
        textButton.setPosition(0f,0f);
        addActor(textButton);
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
