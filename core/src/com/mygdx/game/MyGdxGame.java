package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//gondolom titeket is zavar a for tab  hiánya tessék egy kis "lábjegyzet" : for (int i = 0; i < 10 ; i++){}


public class MyGdxGame extends Game {
	SpriteBatch batch;

	@Override
	public void create () {
        Assets.prepare();
		setScreen(new LoadingScreen(this));
		System.out.println(Integer.MAX_VALUE);
	}

    @Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);

		//Gdx.input.setCatchBackKey(false);
	}

	@Override
	public void dispose () {
		super.dispose();
	}
}
