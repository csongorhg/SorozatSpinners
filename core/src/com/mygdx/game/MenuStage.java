package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by mordes on 2016.10.05..
 */
public class MenuStage extends MyStage {

    private TextButton textButton, textButton2;

    public MenuStage(Game game) {
        super(game);
    }

    public MenuStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    public MenuStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    public void init()
    {
        textButton = new MyButton("Play");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });

        textButton2 = new MyButton("Settings");
        textButton2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
            }
        });

        textButton.setSize(200f,60f);
        textButton.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton.getWidth()/2),MyScreen.WORLD_HEIGHT * (2/3f));
        addActor(textButton);
        textButton2.setSize(200f,60f);
        textButton2.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton.getWidth()/2),MyScreen.WORLD_HEIGHT * (1/3f));
        addActor(textButton2);
    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void dispose() {
        super.dispose();

    }
}
