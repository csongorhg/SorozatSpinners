package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by mordes on 2016.10.05..
 */
public class MyButton extends TextButton {
    static TextButton.TextButtonStyle textButtonStyle;
    static
    {
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Globals.FONT_HOBO_STD;

        Pixmap p = new Pixmap(1,1, Pixmap.Format.RGB888);
        p.setColor(0f,0f,0f, 1f);
        p.fill();
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

        p.setColor(1f,0.549f,0f, 1f);
        p.fill();
        textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

        textButtonStyle.overFontColor = Color.BLACK;
        textButtonStyle.fontColor = Color.WHITE;
    }
    public MyButton(String text) {
        super(text, textButtonStyle);
        init();
    }


    protected void init() {

    }
}
