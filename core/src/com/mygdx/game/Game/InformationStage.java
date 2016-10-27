package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Assets;
import com.mygdx.game.ButtonToText;
import com.mygdx.game.Globals;
import com.mygdx.game.Menu.MenuStage;
import com.mygdx.game.Menu.PlayScreen;
import com.mygdx.game.Menu.PlayStage;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyLabel;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;

/**
 * Created by mordes on 2016.10.12..
 */

public class InformationStage extends MyStage{

    private TextButton textButton,textButton2;
    private ButtonToText buttonToText;
    private MyLabel szovegLabel;

    private static String difficultyEasyInformation = "Könnyű szint!\r\nEgyes feladványok 1 vagy 2 műveletet tartalmaznak!\r",
            difficultyMediumInformation = "Közepes szint!\r\nEgyes feladványok 1, 2 vagy 3 műveletet tartalmaznak!\r",
            difficultyHardInformation = "Nehéz szint!\r\nEgyes feladványok 2 vagy 3 műveletet tartalmaznak!\r",
            currentDifficultyInformation;


    public InformationStage(Game game) {
        super(game);
    }

    public InformationStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    public InformationStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    protected void init() {
        super.init();//..

        switch (PlayStage.difficulty) {
            case 1:currentDifficultyInformation = difficultyEasyInformation; break;
            case 2:currentDifficultyInformation = difficultyMediumInformation; break;
            case 3:currentDifficultyInformation = difficultyHardInformation; break;
        }

        MyButton.setSize((int)(MyScreen.WORLD_WIDTH/1.07),(int)(MyScreen.WORLD_HEIGHT/8));
        textButton2 = new MyButton("Teszt indítása!");
        textButton2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game));
            }
        });
        textButton2.setSize((int)(MyScreen.WORLD_WIDTH/1.07),(int)(MyScreen.WORLD_HEIGHT/8));
        textButton2.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton2.getWidth()/2), MyScreen.WORLD_HEIGHT - (2*Globals.hangMagassag));
        addActor(textButton2);

        buttonToText = new ButtonToText(currentDifficultyInformation+
                "\nA sorozat első 5 elemét fogja látni, a cél: a 6. elem kitalálása!\r"+
                "\nA feladatok megoldására 1 perc áll rendelkezésre!\r" +
                "\n10 feladatra kell választ adni!\r\nSok sikert!");
        buttonToText.setSize(MyScreen.WORLD_WIDTH,MyScreen.WORLD_HEIGHT/2);
        buttonToText.setPosition(MyScreen.WORLD_WIDTH/2 - (buttonToText.getWidth()/2),MyScreen.WORLD_HEIGHT * (2/10f));
        addActor(buttonToText);

        MyButton.setSize((int)(MyScreen.WORLD_WIDTH/3.76),(int)(MyScreen.WORLD_HEIGHT/8));
        textButton = new MyButton("Vissza");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new PlayScreen(game));
            }
        });
        textButton.setSize((int)(MyScreen.WORLD_WIDTH/3.76),(int)(MyScreen.WORLD_HEIGHT/8));
        textButton.setPosition(0f,MyScreen.WORLD_HEIGHT * (0/4f));
        addActor(textButton);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void act() {
        super.act();
    }
}
