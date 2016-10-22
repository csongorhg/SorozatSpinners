package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Assets;
import com.mygdx.game.Globals;
import com.mygdx.game.Menu.PlayStage;
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
    public static int db = 0;
    public static Game newGame;

    @Override
    protected void init() {
        newGame = this.game;
        myLabel = new MyLabel[5];
        float leftMargin = 15;

        //6. elem
        addActor(myTextArea2 = new MyTextArea("A billentyű eléréséhez kattints ide!"){
            @Override
            public void onSubmit() {
                if (
                (!getText().equals("\n") && !getText().equals("")) //üres String, enter vizsgálata
                && (getText().substring(getText().length() == 1 ? 0 : 1 //ha csak 1 hosszú, és az előjel vagy sem
                    ,getText().length()).matches("[0-9]+")) //számokból áll-e
                && ((getText().charAt(0) == '-' && getText().length()>1) || (getText().charAt(0)+"").matches("[0-9]+")) //előjel, ha van akkor követi-e érték
                )
                {
                    if (sc.getLineNumber(5) == Integer.parseInt(getText())) {
                        //System.out.println("Helyes megfejtés!");
                        addActor(new PopupOneSpriteStaticActor(Assets.assetManager.get(Assets.greenCheck))
                        {
                            @Override
                            protected void init() {
                                super.init();
                                setSize(MyScreen.WORLD_WIDTH, MyScreen.WORLD_HEIGHT);
                                EndStage.joValasz++;
                                EndStage.jatszottMenet++;
                                Idozito.ido.stop();
                            }
                        });
                    }
                    else {
                        //System.out.println("Helytelen megfejtés!");
                        addActor(new PopupOneSpriteStaticActor(Assets.assetManager.get(Assets.redX))
                        {
                            @Override
                            protected void init() {
                                super.init();
                                setSize(MyScreen.WORLD_WIDTH, MyScreen.WORLD_HEIGHT);
                                Idozito.ido.stop();
                                EndStage.jatszottMenet++;
                                helyesValasz();
                            }
                        });
                    }
                }
                else {
                    //System.out.println("szar input");
                    myTextArea2.setText("Nem megfelelő tartalmat írtál be!");
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
        myTextArea2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                myTextArea2.setText("");
            }
        });


        //stopper
        stopper = new MyLabel("");
        stopper.setWidth(100);
        stopper.setHeight(Globals.size);
        stopper.setPosition(MyScreen.WORLD_WIDTH-stopper.getWidth()-10, MyScreen.WORLD_HEIGHT-10);  //monitoron kilóg, de telefonon nem!!!!!
        new Idozito();
        addActor(stopper);


        float currentX = 0;
        float currentY = labelHeight();
        sc.newSequence(PlayStage.difficulty-1);

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

    public void helyesValasz(){
        MyLabel l = new MyLabel("A helyes válasz: "+sc.getLineNumber(5));
        l.setPosition(MyScreen.WORLD_WIDTH/2 - l.getWidth()/2, MyScreen.WORLD_HEIGHT/2 - l.getHeight()/2);
        addActor(l);
    }

    private float labelHeight(){
        float a;
        a = stopper.getY() - stopper.getHeight();
        a -= myTextArea2.getY();
        a = MyScreen.WORLD_HEIGHT - (a/2+Globals.size/2);
        return a;
    }

    public static void setText(String s){stopper.setText(s);}
    public static Game getNewGame(){
        return newGame;
    }


    @Override
    public void act() {
        super.act();
    }

    @Override
    public void dispose() {super.dispose(); }

}
