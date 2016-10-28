package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
További tartalmak:
-animáció a betöltő képernyőn
-zene a menükben, illetve a játék alatt (zene megállító, indító gomb)
-készítők menüpont
-nehézségi fokozatok (könnyű, közepes, nehéz)
-saját beviteli mező a számoknak, kilépés a futó játékból a menübe
-időzítő (minden feladatra 60másodperc)
*/

public class MyGdxGame extends Game {
	SpriteBatch batch;

	@Override
	public void create () {
        Assets.prepare();
		setScreen(new LoadingScreen(this));
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
	}

	@Override
	public void dispose () {
		super.dispose();
	}
}
