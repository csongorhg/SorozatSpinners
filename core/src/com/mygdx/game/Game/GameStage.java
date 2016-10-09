package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;
import com.badlogic.gdx.graphics.*;

/**
 * Created by Kicsi on 2016. 10. 07..
 */

public class GameStage extends MyStage{

    private TextButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bTorol, bEnter, bHelp;

    public GameStage(Game game) {
        super(game);
    }
    public GameStage(Viewport viewport, Batch batch, Game game) { super(viewport, batch, game); }
    public GameStage(Viewport viewport, Game game) {
        super(viewport, game);
    }


    @Override
    protected void init() {
        buttons();

    }




    void buttons(){
        Buttons b = new Buttons();
        b0 = b.getB0();
        addActor(b0);
        b1 = b.getB1();
        addActor(b1);
        b2 = b.getB2();
        addActor(b2);
        b3 = b.getB3();
        addActor(b3);
        b4 = b.getB4();
        addActor(b4);
        b5 = b.getB5();
        addActor(b5);
        b6 = b.getB6();
        addActor(b6);
        b7 = b.getB7();
        addActor(b7);
        b8 = b.getB8();
        addActor(b8);
        b9 = b.getB9();
        addActor(b9);
        bEnter = b.getbEnter();
        addActor(bEnter);
        bTorol = b.getbTorol();
        addActor(bTorol);
        bHelp = b.getbHelp();
        addActor(bHelp);
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
