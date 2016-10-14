package com.mygdx.matek;

/**
 * Created by Pocok on 2016.10.06..
 */

public class SequenceOperator {

    static Sequence sequence = new Sequence();
    private int numberIntervallumMax = 10;
    private int piece;

    public void newSequence(int diff){//0(easy),1(medium),2(hard)
        sequence.setStarter(random(1,9));
        if(diff>-1 && diff<3){
            if(diff == 0) createEasy();
            else if(diff == 1) createMedium();
            else createHard();
        }else{
            System.out.println("Hiba a műveletkészítéskor: Rossz nehézség");
        }
    }

    private Operation randomOp(){
        int r = random(0,10);
        Operation o;
        if(r>0 && r<4){
            o = new Plus(random(1,9));
        }else if(r>=4 && r<8){
            o = new Minus(random(1,9));
        }else{
            o = new Szor(random(1,9));
        }
        return o;
    }

    public int getLineNumber(int whitch){
        int answer = sequence.getStarter();
        int beforeAnswer = 0;
        for (int i = 0; i < whitch ; i++){
            beforeAnswer = answer;
            answer = sequence.getAnswer(beforeAnswer);
        }
        return answer;
    }

    public boolean isIt(int whitch,int number){
        int good = getLineNumber(whitch);
        return good == number;
    }

    private void createEasy() {
        piece = 1;
        for (int i = 0; i < piece ; i++){
            sequence.addOperation(randomOp());
        }
    }

    private void createMedium() {
        piece = random(1,2);
        for (int i = 0; i < piece ; i++){
            sequence.addOperation(randomOp());
        }
    }

    private void createHard() {
        piece = random(2,3);
        for (int i = 0; i < piece ; i++){
            sequence.addOperation(randomOp());
        }
    }

    static public String showIt() {
        String s = "x "+sequence.toString()+"= ?";
        return s;
    }


    public int random(int a,int b){return (int)Math.round(Math.random()*(b-a+1)+a);}
    public int random(int a){return (int)Math.round(Math.random()*a);}
}
