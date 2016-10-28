package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
További tartalmak:
-animáció a betöltő képernyőn
-zene a menükben, illetve a játék alatt (zene megállító, indító gomb)
-készítők menüpont
-nehézségi fokozatok
 könnyű (-200 és 200 közötti lehet a 6. elem 1 vagy 2 művelet)
 közepes (-1000 és 1000 közötti lehet a 6. elem 1,2 vagy 3 művelet)
 nehéz (-10000 és 10000 közötti lehet a 6. elem 2 vagy 3 művelet)
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
