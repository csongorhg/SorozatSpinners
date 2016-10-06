package com.mygdx.matek;

import java.util.Vector;

/**
 * Created by Pocok on 2016.10.06..
 */

public class Sequence extends Operation{

    private Vector<Operation> operations = new Vector();
    private int startNumber = 1;

    public Sequence() {

    }

    public void addOperation(Operation o){
        operations.add(o);
    }

    public int getAnswer(int starter){
        int answer = starter;
        Vector<Operation> newOps = new Vector();
        copyVector(newOps);
        for (int i = newOps.size()-1; i > -1 ; i--){
            if(newOps.get(i).getType() == '*'){
                if(i == 0) {
                    answer*=newOps.get(i).getNumber();
                    newOps.remove(i);
                }else{
                    newOps.get(i-1).setNumber(newOps.get(i-1).getNumber() * newOps.get(i).getNumber());
                    newOps.remove(i);
                }
            }
        }
        for (int i = 0; i < newOps.size() ; i++){
            if(newOps.get(i).getType() == '+'){
                answer+=newOps.get(i).getNumber();
            }else if(newOps.get(i).getType() == '-'){
                answer-=newOps.get(i).getNumber();
            }
        }
        return answer;
    }

    private void copyVector(Vector v) {
        for (int i = 0; i < operations.size() ; i++){
            char c = operations.get(i).getType();
            if(c == '+') v.add(new Plus(operations.get(i).getNumber()));
            else if(c == '-') v.add(new Minus(operations.get(i).getNumber()));
            else if(c == '*') v.add(new Szor(operations.get(i).getNumber()));
        }
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < operations.size(); i++){
            s+= operations.get(i).toString();
        }
        if(operations.size() == 0) s+="Nem található művelet.";
        return s;
    }

    public void setStarter(int starter) {
        this.startNumber = starter;
    }

    public int getStarter() {
        return startNumber;
    }
}
