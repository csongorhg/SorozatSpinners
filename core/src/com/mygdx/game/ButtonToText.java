package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Vince on 2016. 10. 11..
 */

public class ButtonToText extends TextButton{
    static TextButton.TextButtonStyle textButtonStyle;

    static {
        refresh();
    }


    public static void refresh(){
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Assets.assetManager.get(Assets.FONT_HOBO_STD);


        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("alegreyaregular.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter meret = new FreeTypeFontGenerator.FreeTypeFontParameter();
        meret.size = (int)(MyScreen.WORLD_HEIGHT*0.05);
        meret.characters = Globals.CHARS;
        BitmapFont font = generator.generateFont(meret);
        generator.dispose();
        textButtonStyle.font = font;

        Pixmap p = new Pixmap(1,1, Pixmap.Format.RGB888);
        p.setColor(0.3f,0.3f,0.3f, 1f);
        p.fill();

        textButtonStyle.fontColor = new Color(0.3f,0.3f,0.3f, 1f);
    }
    public ButtonToText(String text) {
        super(text, textButtonStyle);
        reload();
        init();
    }

    private void reload(){
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Assets.assetManager.get(Assets.FONT_HOBO_STD);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("alegreyaregular.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter meret = new FreeTypeFontGenerator.FreeTypeFontParameter();
        meret.size = (int)(MyScreen.WORLD_HEIGHT*0.05);
        meret.characters = Globals.CHARS;
        BitmapFont font = generator.generateFont(meret);
        generator.dispose();
        textButtonStyle.font = font;

        Pixmap p = new Pixmap(1,1, Pixmap.Format.RGB888);
        p.setColor(0.3f,0.3f,0.3f, 1f);
        p.fill();

        textButtonStyle.fontColor = new Color(0.3f,0.3f,0.3f, 1f);
    }

    protected void init() {
    }

}
