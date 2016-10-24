package com.mygdx.game.Menu;

import com.badlogic.gdx.Game;
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
    }

    public CreditsStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    protected void init() {
        super.init();
        myLabel = new MyLabel("Készítették:\nHegedüs Csongor\nEgyed Vince\nHorváth Patrik\nKiss Norbert");
        myLabel.setSize(100f,100f);
        myLabel.setY((MyScreen.WORLD_HEIGHT/2f)-50f);
        myLabel.setX((MyScreen.WORLD_WIDTH/2f)-50f);
        addActor(myLabel);

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
