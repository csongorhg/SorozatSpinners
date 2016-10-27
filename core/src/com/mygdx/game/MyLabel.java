package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;


/**
 * Created by tuskeb on 2016. 10. 01..
 */
public class MyLabel extends Label {
    float elapsedtime =0;
    public static LabelStyle style;

    static
    {
        refresh();
    }

    public static void refresh()
    {
        style = new LabelStyle();
        style.font =  Assets.assetManager.get(Assets.FONT_HOBO_STD);
        style.fontColor = new Color(0.3f,0.3f,0.3f,1f);
    }

    public MyLabel(String text) {
        super(text, style);
        setAlignment(Align.center);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
