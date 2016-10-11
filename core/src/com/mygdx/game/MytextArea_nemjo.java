package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.IntArray;

/**
 * Created by Vince on 2016. 10. 11..
 */

public class MytextArea_nemjo extends TextArea{
    static TextArea.TextFieldStyle style;
    IntArray linesBreak;

    static {
        style = new TextArea.TextFieldStyle();
        style.font = Globals.FONT_C64;
        style.fontColor = Color.valueOf("0088FF");
        Pixmap p = new Pixmap(1,1, Pixmap.Format.RGB888);
        p.setColor(Color.valueOf("0088FF"));//0xRRGGBBAA
        p.fill();
        style.cursor = new TextureRegionDrawable(new TextureRegion(new Texture(p)));
        style.cursor.setMinWidth(11);
        p.setColor(Color.valueOf("0000AA"));//0xRRGGBBAA
        p.fill();
        style.background = new TextureRegionDrawable(new TextureRegion(new Texture(p)));
    }


    public MytextArea_nemjo(String s){
        super(s,style);
        setWidth(440);
        setHeight(150);
        debug();
    }
}
