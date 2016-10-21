package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game.EndScreen;
import com.mygdx.game.Game.GameScreen;
import com.mygdx.game.Game.GameStage;

/**
 * Created by tanulo on 2016. 10. 20..
 */
public class PopupOneSpriteStaticActor extends OneSpriteStaticActor {
    private float showTimer = 2;

    public PopupOneSpriteStaticActor(Texture texture) {
        super(texture);
        sprite.setSize(0,0);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (elapsedTime<=showTimer)
        {
            sprite.setSize((elapsedTime/showTimer)*getWidth(), (elapsedTime/showTimer)*getHeight());
            sprite.setPosition(getWidth()/2-sprite.getWidth()/2, getHeight()/2-sprite.getHeight()/2);
            System.out.println(elapsedTime);
        }else{
            if(GameStage.db!=9){GameStage.getNewGame().setScreen(new GameScreen(GameStage.getNewGame())); GameStage.db++;}
            else GameStage.getNewGame().setScreen(new EndScreen(GameStage.getNewGame()));
        }
    }

}
