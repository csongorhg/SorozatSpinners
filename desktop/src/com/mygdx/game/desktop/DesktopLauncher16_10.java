package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

/**
 * Created by mordes on 2016.10.06..
 */
public class DesktopLauncher16_10 {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = 1280; //16
        config.height = 800; //10

        new LwjglApplication(new MyGdxGame(), config);
    }
}
