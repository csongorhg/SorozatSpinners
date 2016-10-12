package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.IntArray;
import com.mygdx.game.Game.Buttons;
import com.mygdx.game.Game.GameStage;

/**
 * Created by Vince on 2016. 10. 11..
 */

public class MytextArea_nemjo extends TextArea{
    static TextArea.TextFieldStyle style;
    IntArray linesBreak;
    private MytextArea_nemjo me;
    private Buttons buttons;

    static {
        style = new TextArea.TextFieldStyle();
        style.font = Globals.FONT_C64;
        style.fontColor = Color.valueOf("0088FFFF");//0xRRGGBBAA
        Pixmap p = new Pixmap(1,1, Pixmap.Format.RGBA8888);

        p.setColor(Color.valueOf("0088FFFF"));//0xRRGGBBAA
        p.fill();
        style.cursor = new TextureRegionDrawable(new TextureRegion(new Texture(p)));
        style.cursor.setMinWidth(11);

        p.setColor(Color.valueOf("0000AAFF"));//0xRRGGBBAA
        p.fill();
        style.background = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

        p.setColor(Color.valueOf("0088FF7F"));//0xRRGGBBAA
        p.fill();
        style.selection = new TextureRegionDrawable(new TextureRegion(new Texture(p)));
    }


    public MytextArea_nemjo(String s){
        super(s,style);
        me = this;
        setWidth(440);
        setHeight(150);
        debug();
        setOnscreenKeyboard(new OnscreenKeyboard() {
            @Override
            public void show(boolean visible) {

            }
        });
        addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                super.keyboardFocusChanged(event, actor, focused);
                if (focused)
                {
                    if (buttons==null) {
                        getStage().addActor(buttons = new Buttons());
                        buttons.setTarget(me);
                    }
                }
                else
                {
                    if (buttons!=null) {
                        getStage().getActors().removeValue(buttons, true);
                        buttons = null;
                    }
                }
            }
        });

    }

}
