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
    static int w = 300;
    static int h = 100;
    static TextButton.TextButtonStyle textButtonStyle;
    static
    {
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font =  Assets.assetManager.get(Assets.FONT_HOBO_STD);

        Pixmap p = Buttons.getImg(w,h,false);
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

        p = Buttons.getImg(w,h,true);
        textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

    }
    public MyButton(String text,boolean b) {
        super(text, textButtonStyle);
        reload();
        setStyle(textButtonStyle);
        init();
    }

    private void reload(){
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Assets.assetManager.get(Assets.FONT_HOBO_STD);

        Pixmap p = Buttons.getImg(w,h,false);
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

        p = Buttons.getImg(w,h,true);
        textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture(p)));
    }

    public static void setSize(int w2,int h2){
        w = w2;
        h = h2;
    }

    protected void init() {

    }
}
