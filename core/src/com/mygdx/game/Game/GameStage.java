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
import com.mygdx.game.MyTextField_nemjo;
import com.mygdx.game.MytextArea_nemjo;

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

    //Buttons buttons;
    MytextArea_nemjo mytextArea_nemjo, mytextArea_nemjo2;
    MyTextField_nemjo myTextField_nemjo;

    @Override
    protected void init() {
        //addActor(buttons = new Buttons());
        addActor(mytextArea_nemjo = new MytextArea_nemjo("\n    **** COMMODORE 64 BASIC V2 ****\n\n 64K RAM SYSTEM 38911 BASIC BYTES FREE\n\nREADY\n"));
        mytextArea_nemjo.setY(200);
        mytextArea_nemjo.setX(0);
        mytextArea_nemjo.setWidth(440);

        addActor(mytextArea_nemjo2 = new MytextArea_nemjo("Ide is lehet írni!"));
        mytextArea_nemjo2.setY(200);
        mytextArea_nemjo2.setX(450);
        mytextArea_nemjo2.setWidth(70);

        addActor(myTextField_nemjo = new MyTextField_nemjo("Katt ide is!"));
        myTextField_nemjo.setY(200);
        myTextField_nemjo.setX(540);
        myTextField_nemjo.setWidth(100);
        //buttons.setTarget(mytextArea_nemjo);
        new Idozito();
    }



/*
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
*/
    public static void setText(String s){
        System.out.println(s.length()!=9?s.substring(0,6)+"0"+s.substring(6,7):s.substring(0,s.length()-1));
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
