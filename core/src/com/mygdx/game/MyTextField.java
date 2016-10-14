package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Vince on 2016. 10. 11..
 */

public class MyTextField extends TextField {
    static TextFieldStyle style;

    static {
        style = new TextFieldStyle();
        style.font = Globals.FONT_HOBO_STD;
        style.fontColor = Color.WHITE;
        Pixmap p = new Pixmap(1,1, Pixmap.Format.RGBA8888);
        p.setColor(Color.valueOf("0088FFFF"));//0xRRGGBBAA
        p.fill();
        style.cursor = new TextureRegionDrawable(new TextureRegion(new Texture(p)));
        style.cursor.setMinWidth(11);
    }

    public MyTextField(String text) {
        super(text, style);
        setWidth(MyScreen.WORLD_WIDTH);
        setHeight(MyScreen.WORLD_HEIGHT/2);
    }

}
