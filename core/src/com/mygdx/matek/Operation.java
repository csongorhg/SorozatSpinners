package com.mygdx.matek;

/**
 * Created by Pocok on 2016.10.06..
 */

abstract class Operation {

    private int number;
    private char type;

    public String toString(){
        String s = type+" "+number+" ";
        return s;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public char getType() {
        return type;
    }
}
