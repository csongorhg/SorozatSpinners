package com.mygdx.game.MediumLevel;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;
import com.mygdx.game.Menu.PlayScreen;

/**
 * Created by Vince on 2016. 10. 07..
 */

public class MediumLevelStage extends MyStage {
    private TextButton textButton,textButton2;

    public MediumLevelStage(Game game) {
        super(game);
    }

    public MediumLevelStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    public MediumLevelStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    @Override
    protected void init() {
        textButton2 = new MyButton("Közepes szint kezdése!");
        textButton2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });
        textButton2.setSize(600f,60f);
        textButton2.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton2.getWidth()/2),MyScreen.WORLD_HEIGHT * (3/4f));
        addActor(textButton2);


        textButton = new MyButton("Vissza");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new PlayScreen(game));
            }
        });
        textButton.setSize(170f,60f);
        textButton.setPosition(0f,MyScreen.WORLD_HEIGHT * (0/4f));
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