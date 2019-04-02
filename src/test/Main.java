package test;

import data.Card;
import data.Cards;
import io.readFile;
import io.writeFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String arg[]) {
        //first step
//        System.out.println("begin to read all cards records");
//        Cards cs = readFile.readCard("./data/SPTCC-20180331.csv");
//        System.out.println("read over: "+cs.size()+"; begin to write");
//        writeFile.writeCards("./data/180331dt.txt",cs);

        //second step
        HashMap<String, Cards> groupByPersion=readFile.readSubway("./data/180331dt.txt");
        System.out.println("read over, size:"+groupByPersion.keySet().size());
        ArrayList<Cards> css=new ArrayList<Cards>();
        for(String key:groupByPersion.keySet())
        {
            Cards value=groupByPersion.get(key);
            if(value.size()>1)
                css.add(value);
        }
        Cards all=new Cards();
        for(Cards cs:css){
            for(Card c:cs.getCs())
                all.append(c);
        }
        writeFile.writeCards("./data/180331step2.txt",all);
        System.out.println(css.size());
    }

}
