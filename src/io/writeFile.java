package io;

import data.Card;
import data.Cards;

import java.io.FileWriter;
import java.io.IOException;

public class writeFile {
    public static void writeString(String filename, String str) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCards(String filename, Cards cs) {
        try {
            FileWriter fw = new FileWriter(filename);
            for(Card c:cs.getCs()){
                fw.write(c.toString()+"\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

