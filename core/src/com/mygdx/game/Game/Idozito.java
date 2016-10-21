package com.mygdx.game.Game;

import com.badlogic.gdx.Game;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

/**
 * Created by Kicsi on 2016. 10. 08..
 */

public class Idozito {

    static SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
    static Timer ido = new Timer(10, new Esemeny());
    static GregorianCalendar gc = new GregorianCalendar();
    static GregorianCalendar nulla = new GregorianCalendar();

    public Idozito() {
        beallit();
        GameStage.setText(sdf.format(gc.getTime()));
        ido.start();
    }


    void beallit(){
        gc.set(Calendar.MINUTE, 0);
        gc.set(Calendar.MILLISECOND, 0);
        gc.set(Calendar.SECOND, 60);
        gc.set(Calendar.HOUR_OF_DAY, 0);
        nulla.set(Calendar.MILLISECOND, 0);
        nulla.set(Calendar.HOUR_OF_DAY, 0);
        nulla.set(Calendar.SECOND, 0);
        nulla.set(Calendar.MINUTE, 0);
    }

    static class Esemeny implements ActionListener{
        public void actionPerformed(ActionEvent e){
            gc.add(Calendar.MILLISECOND, -10);
            GameStage.setText(sdf.format(gc.getTime()));
            if(gc.getTimeInMillis() == nulla.getTimeInMillis()){
                ido.stop();
                System.out.println("lejárt az idő!");
                GameScreen.setB();
            }
        }
    }
}
