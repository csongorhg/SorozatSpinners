package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Vince on 2016. 10. 11..
 */

public class ButtonToText extends TextButton{
    static TextButton.TextButtonStyle textButtonStyle;
    static
    {
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Globals.FONT_HOBO_STD;

        Pixmap p = new Pixmap(1,1, Pixmap.Format.RGB888);
        p.setColor(1f,0f,0f, 1f);
        p.fill();

        textButtonStyle.fontColor = Color.WHITE;
    }
    public ButtonToText(String text) {
        super(text, textButtonStyle);
        init();
    }


    protected void init() {

    }

}
