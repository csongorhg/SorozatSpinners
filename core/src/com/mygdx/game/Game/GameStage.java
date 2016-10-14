package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;
import com.mygdx.game.MytextArea;
import com.mygdx.game.MyTextField;
import com.mygdx.matek.SequenceOperator;

/**
 * Created by Kicsi on 2016. 10. 07..
 */

public class GameStage extends MyStage{

    public GameStage(Game game) {
        super(game);
    }
    public GameStage(Viewport viewport, Batch batch, Game game) { super(viewport, batch, game); }
    public GameStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    //Buttons buttons;
    public static MytextArea myTextArea2,myStopperTextArea, myTextAreaHelp;

    @Override
    protected void init() {
        //addActor(buttons = new Buttons());

        addActor(myTextArea2 = new MytextArea(""));
        myTextArea2.setY(200);
        myTextArea2.setX(450);
        myTextArea2.setWidth(100);
        myTextArea2.setHeight(100);


        myStopperTextArea = new MytextArea("");
        myStopperTextArea.setWidth(120);
        myStopperTextArea.setHeight(30);
        myStopperTextArea.setTouchable(Touchable.disabled);

        myStopperTextArea.setPosition(MyScreen.WORLD_WIDTH-myStopperTextArea.getWidth()-2, MyScreen.WORLD_HEIGHT-myStopperTextArea.getHeight()-2);
        new Idozito();
        addActor(myStopperTextArea);

        //buttons.setTarget(myTextArea_);

        myTextAreaHelp = new MytextArea("");
        myTextAreaHelp.setX((MyScreen.WORLD_WIDTH)/8f*2);
        myTextAreaHelp.setY(MyScreen.WORLD_HEIGHT-(MyScreen.WORLD_WIDTH)/8f-2);
        myTextAreaHelp.setWidth(MyScreen.WORLD_WIDTH-(((MyScreen.WORLD_WIDTH)/8f*2)+(myStopperTextArea.getWidth()))-50);
        myTextAreaHelp.setHeight((MyScreen.WORLD_WIDTH)/8f);
        myTextAreaHelp.setTouchable(Touchable.disabled);
        addActor(myTextAreaHelp);
    }

    public static void setText(String s){myStopperTextArea.setText(s);}

    public static void setHelp(){myTextAreaHelp.setText(SequenceOperator.showIt());}
    public static void setHelpPos(){myTextAreaHelp.setX(5);}


    @Override
    public void act() {
        super.act();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
