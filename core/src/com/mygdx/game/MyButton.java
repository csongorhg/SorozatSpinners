package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.graphics.Buttons;

/**
 * Created by mordes on 2016.10.05..
 */
public class MyButton extends TextButton {
    static TextButton.TextButtonStyle textButtonStyle;
    static
    {
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Globals.FONT_HOBO_STD;

        Pixmap p = Buttons.getImg(20,30,false);
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

        p = Buttons.getImg(200,300,false);
        textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

    }
    public MyButton(String text) {
        super(text, textButtonStyle);
        init();
    }


    protected void init() {

    }
}
