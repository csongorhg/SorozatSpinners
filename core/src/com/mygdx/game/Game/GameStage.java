package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyStage;
import com.mygdx.game.MytextArea;
import com.mygdx.game.MyTextField;

/**
 * Created by Kicsi on 2016. 10. 07..
 */

public class GameStage extends MyStage{

    private TextButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bTorol, bEnter, bHelp, bMinus;

    public GameStage(Game game) {
        super(game);
    }
    public GameStage(Viewport viewport, Batch batch, Game game) { super(viewport, batch, game); }
    public GameStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    //Buttons buttons;
    public static MytextArea myTextArea_, myTextArea2;
    MyTextField myTextField_;

    @Override
    protected void init() {
        //addActor(buttons = new Buttons());

        addActor(myTextArea2 = new MytextArea(""));
        myTextArea2.setY(200);
        myTextArea2.setX(450);
        myTextArea2.setWidth(100);
        myTextArea2.setHeight(100);

        addActor(myTextField_ = new MyTextField("Katt ide is!"));
        myTextField_.setY(200);
        myTextField_.setX(540);
        myTextField_.setWidth(100);
        //buttons.setTarget(myTextArea_);
        //new Idozito();
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
