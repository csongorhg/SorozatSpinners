package com.mygdx.game.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Game.InformationScreen;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;

/**
 * Created by mordes on 2016.10.06..
 */
public class PlayStage extends MyStage {

    private TextButton textButton,textButton2,textButton3,textButton4;
    public static int difficulty;

    public PlayStage(Game game) {
        super(game);
    }

    public PlayStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    public PlayStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    protected void init() {
        super.init();
        MyButton.setSize((int)(MyScreen.WORLD_WIDTH/2.56),(int)(MyScreen.WORLD_HEIGHT/8));
        textButton2 = new MyButton("Könnyű");
        textButton2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                difficulty = 1;
                game.setScreen(new InformationScreen(game));

            }
        });
        textButton2.setSize((int)(MyScreen.WORLD_WIDTH/2.56),(int)(MyScreen.WORLD_HEIGHT/8));
        textButton2.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton2.getWidth()/2),MyScreen.WORLD_HEIGHT * (3/4f));
        addActor(textButton2);


        textButton3 = new MyButton("Közepes");
        textButton3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                difficulty = 2;
                game.setScreen(new InformationScreen(game));
            }
        });
        textButton3.setSize((int)(MyScreen.WORLD_WIDTH/2.56),(int)(MyScreen.WORLD_HEIGHT/8));
        textButton3.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton3.getWidth()/2),MyScreen.WORLD_HEIGHT * (2/4f));
        addActor(textButton3);


        textButton4 = new MyButton("Nehéz");
        textButton4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                difficulty = 3;
                game.setScreen(new InformationScreen(game));
            }
        });
        textButton4.setSize((int)(MyScreen.WORLD_WIDTH/2.56),(int)(MyScreen.WORLD_HEIGHT/8));
        textButton4.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton4.getWidth()/2),MyScreen.WORLD_HEIGHT * (1/4f));
        addActor(textButton4);

        MyButton.setSize((int)(MyScreen.WORLD_WIDTH/3.76),(int)(MyScreen.WORLD_HEIGHT/8));
        textButton = new MyButton("Vissza");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });
        textButton.setSize((int)(MyScreen.WORLD_WIDTH/3.76),(int)(MyScreen.WORLD_HEIGHT/8));
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
