package com.mygdx.game.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Assets;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;
import com.mygdx.game.OneSpriteStaticActor;

/**
 * Created by mordes on 2016.10.05..
 */
public class MenuStage extends MyStage {

    private TextButton textButton, textButton2;
    private boolean vanHang = true;

    public MenuStage(Game game) {
        super(game);
    }

    public MenuStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    public MenuStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    public void init()
    {


        textButton = new MyButton("Játék");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new PlayScreen(game));
            }
        });

        textButton2 = new MyButton("Készítők");
        textButton2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new CreditsScreen(game));
            }
        });

        textButton.setSize(250f,60f);
        textButton.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton.getWidth()/2),MyScreen.WORLD_HEIGHT * (2/3f));
        addActor(textButton);
        textButton2.setSize(250f,60f);
        textButton2.setPosition(MyScreen.WORLD_WIDTH/2 - (textButton.getWidth()/2),MyScreen.WORLD_HEIGHT * (1/3f));
        addActor(textButton2);

        addActor(new OneSpriteStaticActor(Assets.assetManager.get(vanHang?Assets.SOUND_ICON:Assets.MUTE_ICON))
        {
            @Override
            protected void init() {
                super.init();
                setPosition(0f, 0f);
                float e = MyScreen.WORLD_HEIGHT/6;
                setSize(e,e);
                this.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        vanHang = !vanHang;
                        game.setScreen(new MenuScreen(game));
                    }
                });
            }
        });


    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void dispose() {
        super.dispose();

    }
}
