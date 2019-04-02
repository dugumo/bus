package data;

import tool.DataTranslate;

import java.util.ArrayList;

public class Cards {
    private ArrayList<Card> cs=new ArrayList<Card>() ;

    public Cards(Card c){
        cs.add(c);
    }
    public Cards(){}

    public void append(String id,String data,String line,String station,String cost,String mark){
        Card tmp=new Card(id,data,line,station,cost,mark);
        cs.add(tmp);
    }
    public void append(Card c){
        cs.add(c);
    }
    public int size(){
        return cs.size();
    }

    @Override
    public String toString() {
        String result="";
        for(Card c:cs){
            result+=c.toString()+"/n";
        }
        return result;
    }

    public ArrayList<Card> getCs() {
        return cs;
    }
}


