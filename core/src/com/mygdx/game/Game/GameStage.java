package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Assets;
import com.mygdx.game.Globals;
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
    public static MyTextArea myTextArea2;
    public static MyLabel stopper;
    public static MyTextArea[] elements1_5 = new MyTextArea[5];
    public static MyLabel[] myLabel = new MyLabel[5];
    public static SequenceOperator sc = new SequenceOperator();

    @Override
    protected void init() {
        myLabel = new MyLabel[5];
        float leftMargin = 15;

        //6. elem
        addActor(myTextArea2 = new MyTextArea(""){
            @Override
            public void onSubmit() {
                if (sc.getLineNumber(5) == Integer.parseInt(getText())) {
                    System.out.println("Helyes megfejtés!");
                    addActor(new PopupOneSpriteStaticActor(Assets.assetManager.get(Assets.greenCheck))
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
        myTextArea2.setWidth(MyScreen.WORLD_WIDTH-leftMargin*2);
        myTextArea2.setHeight(Globals.size);
        myTextArea2.setY(MyScreen.WORLD_HEIGHT/2 );
        myTextArea2.setX(leftMargin);


        //stopper
        stopper = new MyLabel("");
        stopper.setWidth(100);
        stopper.setHeight(Globals.size);
        stopper.setPosition(MyScreen.WORLD_WIDTH-stopper.getWidth()-10, MyScreen.WORLD_HEIGHT-10);  //monitoron kilóg, de telefonon nem!!!!!
        new Idozito();
        addActor(stopper);


        float currentX = 0;
        float currentY = labelHeight();
        sc.newSequence(2);

        /*for (int i = 0; i < 6; i++) {
            System.out.println(sc.getLineNumber(i));
        }*/

        for (int i = 0; i < myLabel.length; i++) {
            addActor(myLabel[i] = new MyLabel(sc.getLineNumber(i)+""));
            myLabel[i].setY(currentY);
            myLabel[i].setX(currentX);
            currentX += MyScreen.WORLD_WIDTH /5;
            myLabel[i].setWidth(MyScreen.WORLD_WIDTH /5);
            myLabel[i].setHeight(Globals.size);
        }


    }

    private float labelHeight(){
        float a=0;
        a = stopper.getY() - stopper.getHeight();
        System.out.println(a);
        System.out.println(Globals.size);
        System.out.println(stopper.getHeight()+ " "+stopper.getY());
        a -= myTextArea2.getY();
        System.out.println(a);
        a = MyScreen.WORLD_HEIGHT - (a/2+Globals.size/2);
        System.out.println(a);
        return a;
    }

    public static void setText(String s){stopper.setText(s);}


    @Override
    public void act() {
        super.act();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
