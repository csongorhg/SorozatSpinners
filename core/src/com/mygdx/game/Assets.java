package com.mygdx.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by mordes on 2016.10.06..
 */
public class Assets {

    public static AssetManager assetManager;

    public static final AssetDescriptor<Texture> greenCheck
            = new AssetDescriptor<Texture>("greenCheck.png", Texture.class);
    public static final AssetDescriptor<Texture> redX
            = new AssetDescriptor<Texture>("redX.png", Texture.class);

    public static void prepare() {
        assetManager = new AssetManager();
        Texture.setAssetManager(assetManager);
    }

    public static void load() {
        assetManager.load(greenCheck);
        assetManager.load(redX);
    }

    public static void unload() {
        assetManager.dispose();
    }

}
