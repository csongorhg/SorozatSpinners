package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by mordes on 2016.10.05..
 */
public class Globals {
    public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";
    /*public static final BitmapFont FONT_HOBO_STD;
    public static final BitmapFont FONT_C64;*/
    public static final Music menumusic = Assets.assetManager.get(Assets.BENDSOUND_ACOUSTICBREEZE);
    public static final Music gamemusic = Assets.assetManager.get(Assets.BENSOUND_CUTE);
    public static final int size = 50;
    public static boolean vanHang = true; //ne legyen final!!!!!!!!!!!!!!
    public static boolean musicchange = true;
    public static final float loadingScreenSize = MyScreen.WORLD_HEIGHT *(2/3);
    public static final float hangMagassag = MyScreen.WORLD_HEIGHT/6;


    /*
    static {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("alegreyaregular.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.characters = CHARS;
        FONT_HOBO_STD = generator.generateFont(parameter);
        FONT_HOBO_STD.setColor(1, 1, 1, 1f);
        generator.dispose();

        FreeTypeFontGenerator generator2 = new FreeTypeFontGenerator(Gdx.files.internal("font/c64a.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter2 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter2.size = 15;
        parameter2.characters = CHARS;
        FONT_C64 = generator2.generateFont(parameter2);
        FONT_C64.setColor(1, 1, 1, 1f);
        generator2.dispose();
    }
*/
}
