package com.mygdx.game.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.EasyLevel.EasyLevelScreen;
import com.mygdx.game.HardLevel.HardLevelScreen;
import com.mygdx.game.MediumLevel.MediumLevelScreen;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;

/**
 * Created by mordes on 2016.10.06..
 */
public class PlayStage extends MyStage {

    private TextButton textButton,textButton2,textButton3,textButton4;

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
        textButton2 = new MyButton("Könnyű");
        textButton2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new EasyLevelScreen(game));
            }
        });
        textButton2.setSize(250f,60f);
        textButton2.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton2.getWidth()/2),MyScreen.WORLD_HEIGHT * (3/4f));
        addActor(textButton2);


        textButton3 = new MyButton("Közepes");
        textButton3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MediumLevelScreen(game));
            }
        });
        textButton3.setSize(250f,60f);
        textButton3.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton3.getWidth()/2),MyScreen.WORLD_HEIGHT * (2/4f));
        addActor(textButton3);


        textButton4 = new MyButton("Nehéz");
        textButton4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new HardLevelScreen(game));
            }
        });
        textButton4.setSize(250f,60f);
        textButton4.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton4.getWidth()/2),MyScreen.WORLD_HEIGHT * (1/4f));
        addActor(textButton4);


        textButton = new MyButton("Vissza");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
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
