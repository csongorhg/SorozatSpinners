package com.mygdx.game.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyLabel;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;

/**
 * Created by mordes on 2016.10.06..
 */
public class CreditsStage extends MyStage {

    private TextButton textButton;
    private MyLabel myLabel;

    public CreditsStage(Game game) {
        super(game);
    }

    public CreditsStage(Viewport viewport, Batch batch, Game game) {

        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
    }

    public CreditsStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    @Override
    public boolean keyDown(int keyCode) {
        if (keyCode == Input.Keys.BACK)
        {
            game.setScreen(new MenuScreen(game));
        }
        return false;
    }

    protected void init() {
        super.init();
        myLabel = new MyLabel("Készítették:\nEgyed Vince\nHegedüs Csongor\nHorváth Patrik\nKiss Norbert\nFelkészítő tanár: Tüske Balázs");
        myLabel.setSize(100f,100f);
        myLabel.setY((MyScreen.WORLD_HEIGHT/1.7f)-50f);
        myLabel.setX((MyScreen.WORLD_WIDTH/2f)-50f);
        addActor(myLabel);

        MyButton.setSize((int)(MyScreen.WORLD_WIDTH/3.2),(int)(MyScreen.WORLD_HEIGHT/8));
        textButton = new MyButton("Vissza");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });
        addActor(textButton);
        textButton.setSize((int)(MyScreen.WORLD_WIDTH/3.2),(int)(MyScreen.WORLD_HEIGHT/8));
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
