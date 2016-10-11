package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

/**
 * Created by Vince on 2016. 10. 11..
 */

public class MyTextField_nemjo extends TextField {
    static TextFieldStyle style;

    static {
        style = new TextFieldStyle();
        style.font = Globals.FONT_HOBO_STD;
        style.fontColor = Color.WHITE;
    }

    public MyTextField_nemjo(String text) {
        super(text, style);
        setWidth(MyScreen.WORLD_WIDTH);
        setHeight(MyScreen.WORLD_HEIGHT/2);
    }
}
