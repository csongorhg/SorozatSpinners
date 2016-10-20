package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Assets;
import com.mygdx.game.MyLabel;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;
import com.mygdx.game.MyTextArea;
import com.mygdx.game.OneSpriteStaticActor;
import com.mygdx.game.PopupOneSpriteStaticActor;
import com.mygdx.matek.SequenceOperator;

/**
 * Created by Kicsi on 2016. 10. 07..
 */

public class GameStage extends MyStage{

    public GameStage(Game game) {
        super(game);
    }
    public GameStage(Viewport viewport, Batch batch, Game game) { super(viewport, batch, game); }
    public GameStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    //Buttons buttons;
    public static MyTextArea myTextArea2,myStopperTextArea;
    public static MyTextArea[] elements1_5 = new MyTextArea[5];
    public static MyLabel[] myLabel = new MyLabel[5];
    public static SequenceOperator sc = new SequenceOperator();

    @Override
    protected void init() {
        //addActor(buttons = new Buttons());
        myLabel = new MyLabel[5];
        float leftMargin = 15;
        float currentX = leftMargin;
        float currentY = 200;
        sc.newSequence(2);

        for (int i = 0; i < 6; i++) {
            System.out.println(sc.getLineNumber(i));
        }

        for (int i = 0; i < myLabel.length; i++) {
            addActor(myLabel[i] = new MyLabel(sc.getLineNumber(i)+""));
            myLabel[i].setY(currentY);
            myLabel[i].setX(currentX);
            currentX += (MyScreen.WORLD_WIDTH - leftMargin*2)/5;
            myLabel[i].setWidth(50);
            myLabel[i].setHeight(25);
        }

        //6. elem
        addActor(myTextArea2 = new MyTextArea(""){
            @Override
            public void onSubmit() {
                if (sc.getLineNumber(5) == Integer.parseInt(getText())) {
                    System.out.println("Helyes megfejtés!");
                    addActor(new PopupOneSpriteStaticActor(Assets.assetManager.get(Assets.redX))
                    {
                        @Override
                        protected void init() {
                            super.init();
                            setSize(MyScreen.WORLD_WIDTH, MyScreen.WORLD_HEIGHT);
                        }
                    });
                }
                else {
                    System.out.println("Helytelen megfejtés!");
                    addActor(new PopupOneSpriteStaticActor(Assets.assetManager.get(Assets.redX))
                    {
                        @Override
                        protected void init() {
                            super.init();
                            setSize(MyScreen.WORLD_WIDTH, MyScreen.WORLD_HEIGHT);
                        }
                    });
                }
            }
        });
        /*
        for (Actor a : getActors()) {
            if (a instanceof PopupOneSpriteStaticActor)
            {
                getActors().removeValue(a,true);
            }
        }
               */
        myTextArea2.setY(300);
        myTextArea2.setX(leftMargin);
        myTextArea2.setWidth(MyScreen.WORLD_WIDTH-leftMargin*2);
        myTextArea2.setHeight(25);

        //stopper
        myStopperTextArea = new MyTextArea("");
        myStopperTextArea.setWidth(100);
        myStopperTextArea.setHeight(25);
        myStopperTextArea.setTouchable(Touchable.disabled);
        myStopperTextArea.setPosition(MyScreen.WORLD_WIDTH-myStopperTextArea.getWidth(), MyScreen.WORLD_HEIGHT-myStopperTextArea.getHeight());
        new Idozito();
        addActor(myStopperTextArea);

        //buttons.setTarget(myTextArea_);

    }

    public static void setText(String s){myStopperTextArea.setText(s);}


    @Override
    public void act() {
        super.act();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
