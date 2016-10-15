package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.ButtonToText;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;
import com.mygdx.game.MytextArea;

/**
 * Created by Kicsi on 2016. 10. 14..
 */

public class EndStage extends MyStage {

    public EndStage(Game game) {
        super(game);
    }
    public EndStage(Viewport viewport, Batch batch, Game game) { super(viewport, batch, game); }
    public EndStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    private MytextArea textAreaEnd;
    private TextButton bBack;


    protected void init(){

        addActor(textAreaEnd = new MytextArea("Vége"));
        textAreaEnd.setWidth(100);
        textAreaEnd.setHeight(50);
        textAreaEnd.setY(MyScreen.WORLD_HEIGHT/2-textAreaEnd.getHeight()/2);
        textAreaEnd.setX(MyScreen.WORLD_WIDTH/2-textAreaEnd.getWidth()/2);

        bBack = new MyButton("Vissza a menübe");
        bBack.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });
        bBack.setSize(MyScreen.WORLD_WIDTH, 50);
        bBack.setPosition(MyScreen.WORLD_WIDTH/2-bBack.getWidth()/2, 0f);
        addActor(bBack);
    }



    @Override
    public void act() {
        super.act();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
