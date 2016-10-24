package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Menu.MenuScreen;

/**
 * Created by mordes on 2016.10.05..
 */
public class MyStage extends Stage {
    protected Game game;
    protected OneSpriteStaticActor hang;

    public MyStage(Game game) {
        this.game = game;
        init();
    }

    public MyStage(Viewport viewport, Game game) {
        super(viewport);
        this.game = game;
        init();
    }

    public MyStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch);
        this.game = game;
        init();
    }

    @Override
    public void dispose() {
        super.dispose();
    }


    protected void init(){
        musicGenerator();
        music();

    };

    void musicGenerator(){
        hang = new OneSpriteStaticActor(Assets.assetManager.get(Globals.vanHang?Assets.SOUND_ICON:Assets.MUTE_ICON));
        float e = MyScreen.WORLD_HEIGHT/6;
        hang.setPosition(0f,MyScreen.WORLD_HEIGHT-e);
        hang.setSize(e,e);
        addActor(hang);
        hang.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                hang.remove();
                Globals.vanHang = !Globals.vanHang;
                musicGenerator();
                music();
            }
        });
    }

    void music (){
        if(Globals.musicchange && Globals.vanHang){
            Globals.gamemusic.stop();
            Globals.menumusic.play();
        }
        else if(!Globals.musicchange && Globals.vanHang){
            Globals.menumusic.stop();
            Globals.gamemusic.play();
        }
        else{
            Globals.menumusic.stop();
            Globals.gamemusic.stop();
        }

    }

}

