package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

/**
 * Created by mordes on 2016.10.06..
 */
public class DesktopLauncher16_9 {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = 848; //16
        config.height = 480; //9

        new LwjglApplication(new MyGdxGame(), config);
    }
}
