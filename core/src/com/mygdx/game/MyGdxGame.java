package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.matek.SequenceOperator;

//gondolom titeket is zavar a for tab  hiánya tessék egy kis "lábjegyzet" : for (int i = 0; i < 10 ; i++){}


public class MyGdxGame extends Game {
	SpriteBatch batch;
	SequenceOperator sc = new SequenceOperator();//kitörölhetitek ha gáz csak teszt

	@Override
	public void create () {
        mathteszt();
        Assets.prepare();
		setScreen(new LoadingScreen(this));
	}

    private void mathteszt() {
        sc.newSequence(2);
        System.out.println(sc.showIt());
        System.out.println("kezdő elem: "+sc.getLineNumber(0));
        System.out.println("6.elem: "+sc.getLineNumber(6));
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
