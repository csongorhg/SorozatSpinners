package com.mygdx.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by mordes on 2016.10.06..
 */
public class Assets {

    public static AssetManager assetManager;

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

    public static void afterLoaded(){

    }

}
