package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.IntArray;
import com.mygdx.game.Game.Buttons;

/**
 * Created by Vince on 2016. 10. 11..
 */

public class MyTextField extends TextField {
    static TextArea.TextFieldStyle style;
    IntArray linesBreak;
    private MyTextField me;
    private Buttons buttons;

    static {
        style = new TextArea.TextFieldStyle();

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/c64a.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter meret = new FreeTypeFontGenerator.FreeTypeFontParameter();
        meret.size = Globals.size/2;
        meret.characters = Globals.CHARS;
        style.font =  Assets.assetManager.get(Assets.FONT_C64);
        BitmapFont font = generator.generateFont(meret);
        generator.dispose();
        style.font = font;

        style.fontColor = new Color(getColor(98),getColor(185),getColor(63),1f);
        Pixmap p = new Pixmap(1,1, Pixmap.Format.RGBA8888);

        p.setColor(new Color(getColor(98),getColor(185),getColor(63),1f));//0xRRGGBBAA
        p.fill();
        style.cursor = new TextureRegionDrawable(new TextureRegion(new Texture(p)));
        style.cursor.setMinWidth(20);

        p.setColor(new Color(getColor(121),getColor(192),getColor(57),0.2f));//0xRRGGBBAA
        p.fill();
        style.background = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

        p.setColor(new Color(getColor(121),getColor(192),getColor(57),1f));//0xRRGGBBAA
        p.fill();
        style.selection = new TextureRegionDrawable(new TextureRegion(new Texture(p)));
    }

    public void onSubmit()
    {

    }

    public MyTextField(String s){
        super(s,style);
        me = this;
        setWidth((int)(MyScreen.WORLD_HEIGHT*0.8));
        setHeight((int)(MyScreen.WORLD_HEIGHT*0.03));
        //debug();
        /*setOnscreenKeyboard(new OnscreenKeyboard() {
            @Override
            public void show(boolean visible) {
                System.out.println(1);
            }
        });*/


        addListener(new InputListener() {

            @Override
            public boolean keyTyped(InputEvent event, char character) {
                String s = getText();
                String inputmask = "-0123456789";
                boolean k = true;
                int cp = getCursorPosition();
                for (int j = 0; j<s.length(); j++) {
                    k = true;
                    //System.out.println(k);
                    for (int i = 0; i < inputmask.length(); i++) {
                        System.out.println(i);
                        if (s.charAt(j) == inputmask.charAt(i))
                        {
                            k = false;
                        }
                    }
                    if (k)
                    {
                        String cc = "";
                        if (j>=1) {
                            cc = s.substring(0, j);
                        }
                        if (j+1<=s.length()) {
                            cc += s.substring(j + 1, s.length());
                        }
                        s = cc;
                        j--;
                    }
                    //System.out.printf(s);
                }
                setText(s);
                setCursorPosition(cp);
                if (event.getKeyCode() == 66)
                {
                    onSubmit();
                }
                //return super.keyTyped(event, character);
                return false;
            }

        });

        addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                super.keyboardFocusChanged(event, actor, focused);
                if (focused)
                {
                    if (buttons==null) {
                        getStage().addActor(buttons = new Buttons(){
                            @Override
                            public void onEnterPressed() {
                                super.onEnterPressed();
                                onSubmit();
                            }
                        });
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

    private static float getColor(int s){
        float f = s/255f;
        if(f>1) f = 1f;
        if(f<0) f = 0f;
        return f;
    }



}
