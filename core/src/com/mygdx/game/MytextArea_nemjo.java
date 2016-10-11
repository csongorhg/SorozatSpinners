package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.IntArray;

/**
 * Created by Vince on 2016. 10. 11..
 */

public class MytextArea_nemjo extends TextField{
    static TextArea.TextFieldStyle style;
    IntArray linesBreak;

    static {
        style = new TextArea.TextFieldStyle();
        style.font = Globals.FONT_HOBO_STD;
        style.fontColor = Color.WHITE;
    }

    @Override
    protected void initialize () {
        super.initialize();
        writeEnters = true;
    }

    public MytextArea_nemjo(String s){
        super(s,style);
        setWidth(MyScreen.WORLD_WIDTH);
        setHeight(MyScreen.WORLD_HEIGHT/2);
    }

}
