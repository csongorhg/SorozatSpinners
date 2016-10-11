package com.mygdx.game.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;

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
        textButton = new MyButton("Játék");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new PlayScreen(game));
            }
        });

        textButton2 = new MyButton("Beállítások");
        textButton2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new SettingsScreen(game));
            }
        });

        textButton.setSize(250f,60f);
        textButton.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton.getWidth()/2),MyScreen.WORLD_HEIGHT * (2/3f));
        addActor(textButton);
        textButton2.setSize(250f,60f);
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