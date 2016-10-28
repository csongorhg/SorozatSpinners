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
    public static final Music menumusic = Assets.assetManager.get(Assets.BENDSOUND_ACOUSTICBREEZE);
    public static final Music gamemusic = Assets.assetManager.get(Assets.BENSOUND_CUTE);
    public static final int size = 50;
    public static boolean vanHang = true; //ne legyen final!!!!!!!!!!!!!!!
    public static boolean musicchange = true;
    public static final float loadingScreenSize = MyScreen.WORLD_HEIGHT *(2/3);
    public static final float hangMagassag = MyScreen.WORLD_HEIGHT/8;

}
