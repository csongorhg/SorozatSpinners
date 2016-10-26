package com.mygdx.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

/**
 * Created by mordes on 2016.10.06..
 */
public class Assets {

    public static AssetManager assetManager;


    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter_HOBO_STD = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter_HOBO_STD.fontFileName = "alegreyaregular.otf";
        fontParameter_HOBO_STD.fontParameters.size = Globals.size;
        fontParameter_HOBO_STD.fontParameters.characters = Globals.CHARS;
    }

    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter_C64 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter_HOBO_STD.fontFileName = "font/c64a.ttf";
        fontParameter_HOBO_STD.fontParameters.size = 25;
        fontParameter_HOBO_STD.fontParameters.characters = Globals.CHARS;
    }

    public static final AssetDescriptor<BitmapFont> FONT_C64
            = new AssetDescriptor<BitmapFont>("font/c64a.ttf", BitmapFont.class, fontParameter_C64);
    public static final AssetDescriptor<BitmapFont> FONT_HOBO_STD
            = new AssetDescriptor<BitmapFont>("alegreyaregular.otf", BitmapFont.class, fontParameter_HOBO_STD);


    public static final AssetDescriptor<Texture> BADLOGIC_TEXTURE
            = new AssetDescriptor<Texture>("badlogic.jpg", Texture.class);
    public static final AssetDescriptor<Texture> redX
            = new AssetDescriptor<Texture>("redX.png", Texture.class);
    public static final AssetDescriptor<Texture> greenCheck
            = new AssetDescriptor<Texture>("greenCheck.png", Texture.class);
    public static final AssetDescriptor<Music> BENSOUND_CUTE
            = new AssetDescriptor<Music>("bensound_cute.mp3", Music.class);
    public static final AssetDescriptor<Music> BENDSOUND_ACOUSTICBREEZE
            = new AssetDescriptor<Music>("bensound_acousticbreeze.mp3", Music.class);
    public static final AssetDescriptor<Texture> SOUND_ICON
            = new AssetDescriptor<Texture>("sound_icon.png", Texture.class);
    public static final AssetDescriptor<Texture> MUTE_ICON
            = new AssetDescriptor<Texture>("mute_icon.png", Texture.class);

    public static void prepare() {
        assetManager = new AssetManager();
        Texture.setAssetManager(assetManager);
    }

    public static void load() {

        FileHandleResolver resolver = new InternalFileHandleResolver();
        assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        assetManager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
        assetManager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

        assetManager.load(BADLOGIC_TEXTURE);
        assetManager.load(redX);
        assetManager.load(greenCheck);
        assetManager.load(BENDSOUND_ACOUSTICBREEZE);
        assetManager.load(BENSOUND_CUTE);
        assetManager.load(SOUND_ICON);
        assetManager.load(MUTE_ICON);
    }

    public static void unload() {
        assetManager.dispose();
    }

}
