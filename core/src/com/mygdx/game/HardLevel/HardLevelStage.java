package com.mygdx.game.HardLevel;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Game.GameScreen;
import com.mygdx.game.Menu.PlayScreen;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;
import com.mygdx.game.ButtonToText;

/**
 * Created by Vince on 2016. 10. 07..
 */

public class HardLevelStage extends MyStage{
    private TextButton textButton,textButton2, szovegButton;

    public HardLevelStage(Game game) {
        super(game);
    }

    public HardLevelStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    public HardLevelStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    @Override
    protected void init() {
        textButton2 = new MyButton("Teszt indítása!");
        textButton2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game));
            }
        });
        textButton2.setSize(600f,60f);
        textButton2.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton2.getWidth()/2),MyScreen.WORLD_HEIGHT * (3/4f));
        addActor(textButton2);

        szovegButton = new ButtonToText("Nehéz szint!\r\nEgyes feladványok 2 vagy 3 műveletet tartalmaznak!\r\nA feladatok tartalmazhatnak zárójelet!\r\nA feladatok megoldására 1 perc áll rendelkezésre!\r\n10 feladatra kell válaszolt adni!\r\nSok sikert!");
        szovegButton.setSize(MyScreen.WORLD_WIDTH,MyScreen.WORLD_HEIGHT/2);
        szovegButton.setPosition(MyScreen.WORLD_WIDTH/2 - (szovegButton.getWidth()/2),MyScreen.WORLD_HEIGHT * (2/10f));
        addActor(szovegButton);

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
