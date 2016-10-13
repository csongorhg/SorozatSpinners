package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.matek.SequenceOperator;

import java.util.Scanner;

//gondolom titeket is zavar a for tab  hiánya tessék egy kis "lábjegyzet" : for (int i = 0; i < 10 ; i++){}


public class MyGdxGame extends Game {
	SpriteBatch batch;
	public static SequenceOperator sc = new SequenceOperator();//kitörölhetitek ha gáz csak teszt

	@Override
	public void create () {
        mathteszt();
        Assets.prepare();
		setScreen(new LoadingScreen(this));
	}

    private void mathteszt() {
        sc.newSequence(2);
        System.out.println(sc.showIt());
		for (int i=1; i<=6; i++) {
			System.out.println(i+". elem: "+sc.getLineNumber((i-1)));
		}

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
