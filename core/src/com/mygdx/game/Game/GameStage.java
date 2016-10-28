package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Assets;
import com.mygdx.game.Globals;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.Menu.PlayScreen;
import com.mygdx.game.Menu.PlayStage;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyLabel;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;
import com.mygdx.game.MyTextField;
import com.mygdx.game.OneSpriteStaticActor;
import com.mygdx.game.PopupOneSpriteStaticActor;
import com.mygdx.graphics.Background;
import com.mygdx.matek.SequenceOperator;

/**
 * Created by Kicsi on 2016. 10. 07..
 */

public class GameStage extends MyStage{

    public GameStage(Game game) {
        super(game);
    }
    public GameStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
    }
    public GameStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    public static MyTextField myTextArea2;
    public MyLabel stopper, help;
    public MyButton textButton;
    public static MyLabel[] myLabel = new MyLabel[5];
    public static SequenceOperator sc = new SequenceOperator();
    public static int db = 0, jatszottMenet = 0, joValasz=0;
    public boolean playing = true;
    public Background b;
    public OneSpriteStaticActor kerdojel;
    boolean klicked = false;

    private int ido = 60;

    @Override
    public boolean keyDown(int keyCode) {
        if (keyCode == Input.Keys.BACK)
        {
            Globals.musicchange = !Globals.musicchange;
            game.setScreen(new InformationScreen(game));
        }
        return false;
    }

    protected void init() {
        b = new Background();
        addActor(b);
        b.setPosition(0,0);
        Globals.musicchange = false;
        super.init();
        myLabel = new MyLabel[5];
        float leftMargin = 15;

        addActor(myTextArea2 = new MyTextField(""){
            @Override
            public void onSubmit() {
                if ((getText().equals("\n") || getText().equals("")))
                {
                    blinking();
                }

                if (
                (!getText().equals("\n") && !getText().equals(""))
                        && (getText().substring(getText().length() == 1 ? 0 : 1
                        ,getText().length()).matches("[0-9]+"))
                        && ((getText().charAt(0) == '-' && getText().length()>1) || (getText().charAt(0)+"").matches("[0-9]+"))
                )
                {
                    if (sc.getLineNumber(5) == Integer.parseInt(getText())) {
                        addActor(new PopupOneSpriteStaticActor(Assets.assetManager.get(Assets.greenCheck))
                        {
                            @Override
                            protected void init() {
                                super.init();
                                setSize(MyScreen.WORLD_WIDTH, MyScreen.WORLD_HEIGHT);
                                joValasz++;
                                jatszottMenet++;
                                playing=false;
                            }

                            @Override
                            public void act(float delta) {
                                super.act(delta);
                                if (elapsedTime>showTimer)
                                {
                                    xy();
                                }
                            }
                        });
                    }
                    else {
                        addActor(new PopupOneSpriteStaticActor(Assets.assetManager.get(Assets.redX))
                        {
                            @Override
                            protected void init() {
                                super.init();
                                setSize(MyScreen.WORLD_WIDTH, MyScreen.WORLD_HEIGHT);
                                jatszottMenet++;
                                playing = false;
                            }

                            @Override
                            public void act(float delta) {
                                super.act(delta);
                                if (elapsedTime>showTimer)
                                {
                                    xy();
                                }
                            }
                        });
                        helyesValasz();
                    }
                }
                else {
                    myTextArea2.setText("");
                }
            }
        });

        myTextArea2.setWidth((MyScreen.WORLD_WIDTH-(MyScreen.WORLD_WIDTH/15)*2)-leftMargin*2);
        myTextArea2.setHeight(Globals.size);
        myTextArea2.setY(MyScreen.WORLD_HEIGHT/2 );
        myTextArea2.setX((MyScreen.WORLD_WIDTH/15)*2+10f);
        myTextArea2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                try {
                    Integer.parseInt(myTextArea2.getText());
                }
                catch (Exception e)
                {
                    myTextArea2.setText("");
                }

            }
        });

        addActor(new Buttons());

        stopper = new MyLabel("");
        stopper.setWidth(100);
        stopper.setHeight(Globals.size);
        stopper.setPosition(getViewport().getWorldWidth()-stopper.getWidth()-10, getViewport().getWorldHeight()- stopper.getHeight()-10);
        addActor(stopper);


        float currentX = 0;
        float currentY = labelHeight()-stopper.getHeight();

        sc.newSequence(PlayStage.difficulty-1);


        for (int i = 0; i < myLabel.length; i++) {
            addActor(myLabel[i] = new MyLabel(sc.getLineNumber(i)+""));
            myLabel[i].setY(currentY);
            myLabel[i].setX(currentX);
            currentX += MyScreen.WORLD_WIDTH /5;
            myLabel[i].setWidth(MyScreen.WORLD_WIDTH /5);
            myLabel[i].setHeight(Globals.size);
        }


        textButton = new MyButton("Vége");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new EndScreen(game));
            }
        });
        textButton.setSize(MyScreen.WORLD_HEIGHT/3,Globals.hangMagassag);
        textButton.setPosition(Globals.hangMagassag+10, MyScreen.WORLD_HEIGHT-textButton.getHeight());
        addActor(textButton);

        kerdojel = new OneSpriteStaticActor(Assets.assetManager.get(Assets.QUESTION_MARK));
        kerdojel.setSize(Globals.hangMagassag,Globals.hangMagassag);
        kerdojel.setPosition(textButton.getX() + textButton.getWidth()+10,MyScreen.WORLD_HEIGHT-kerdojel.getHeight());
        addActor(kerdojel);
        kerdojel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(!klicked){help.setText(sc.showIt()); klicked = true;}
            }
        });

        help = new MyLabel("");
        help.setSize(MyScreen.WORLD_WIDTH-(kerdojel.getX()+kerdojel.getWidth()+10+(MyScreen.WORLD_WIDTH-stopper.getX())), Globals.hangMagassag);
        help.setPosition(textButton.getX()+10, MyScreen.WORLD_HEIGHT-help.getHeight()*2);
        help.setAlignment(Align.left);
        addActor(help);
        setKeyboardFocus(myTextArea2);
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
        a = MyScreen.WORLD_HEIGHT - (a/2+Globals.size);
        return a;
    }



    @Override
    public void act(float delta) {
        super.act(delta);
        int time = ido - (int)elapsedTime;
        if(time <=10) stopper.setColor(1f,0f,0f, 1f);
        if (time < 0)
        {
            stopper.setText("0");
            if (playing) {
                jatszottMenet++;
                game.setScreen(new EndScreen(game));
            }
        }
        else
        {
            stopper.setText(time + "");
        }
    }

    void xy(){
        if(db!=9){
            game.setScreen(new GameScreen(game));
            db++;
        }else
            game.setScreen(new EndScreen(game));
    }

    public static int getJoValasz() {
        return joValasz;
    }

    public static int getJatszottMenet() {
        return jatszottMenet;
    }

    public static void vissza(){db = 0; jatszottMenet=0; joValasz=0;}

    @Override
    public void dispose() {super.dispose(); }

}
