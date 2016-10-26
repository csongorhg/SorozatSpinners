package com.mygdx.matek;

/**
 * Created by Pocok on 2016.10.06..
 */

public class SequenceOperator {

    static Sequence sequence = new Sequence();
    private int numberIntervallumMax = 10;
    private int piece;

    public void newSequence(int diff){//0(easy),1(medium),2(hard)
        sequence.setSzor(false);
        sequence.setStarter(random(1,9));
        if(diff>-1 && diff<3){
            if(diff == 0){
                do{
                    createEasy();
                }while(getLineNumber(6)>200 || getLineNumber(6)<-200);
            }
            else if(diff == 1){
                do{
                    createMedium();
                }while(getLineNumber(6)>1000 || getLineNumber(6)<-1000);
            }
            else {
                do{
                    createHard();
                }while(getLineNumber(6)>10000 || getLineNumber(6)<-10000);
            }
        }else{
            System.out.println("Hiba a műveletkészítéskor: Rossz nehézség");
        }
    }

    private Operation randomOp(){
        int r = random(0,10);
        Operation o;
        if(r>0 && r<4){
            o = new Plus(random(1,9));
        }else if(r>=4 && r<6 && !sequence.getSzor()){
            o = new Szor(random(1,9));
            sequence.setSzor(true);
        }else{
            o = new Minus(random(1,9));
        }
        return o;
    }

    public int getLineNumber(int whitch){
        int answer = sequence.getStarter();
        int beforeAnswer = 0;
        for (int i = 0; i < whitch ; i++){
            beforeAnswer = answer;
            answer = sequence.getAnswer(beforeAnswer);
            System.out.println(4);
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
