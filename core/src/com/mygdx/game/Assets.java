package com.mygdx.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by mordes on 2016.10.06..
 */
public class Assets {

    public static AssetManager assetManager;

    public static final AssetDescriptor<Texture> BADLOGIC_TEXTURE
            = new AssetDescriptor<Texture>("badlogic.jpg", Texture.class);

    public static void prepare() {
        assetManager = new AssetManager();
        Texture.setAssetManager(assetManager);
    }

    public static void load() {
        assetManager.load(BADLOGIC_TEXTURE);
    }

    public static void unload() {
        assetManager.dispose();
    }

}
