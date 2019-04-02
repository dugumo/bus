package io;

import data.Card;
import data.Cards;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class readFile {
    /**
     * @Description: test tools in this class
     */
    public static void main(String arg[]) {
//        "./data/SPTCC-20180331.csv"
        Cards cs = readCard("./data/SPTCC-20180331.csv");
        System.out.println(cs.size());
    }

    public static Cards readCard(String filename) {
//        2280964597,2018-03-31,08:30:51,7号线东安路,地铁,0.00,非优惠
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            Cards cs = new Cards();
            String tmp[] = br.readLine().split(",");
//            System.out.println(tmp.length);
            String mark1 = tmp[4];
            String mark2 = tmp[3].substring(1, 3);
            if (tmp[3].split(mark2).length < 2) {
                System.out.println(tmp[0] + "," + tmp[3]);
            } else
                cs.append(tmp[0], tmp[1] + " " + tmp[2], tmp[3].split(mark2)[0], tmp[3].split(mark2)[1], tmp[5], tmp[6]);

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                String str[] = line.split(",");
                if (str[4].equals(mark1)) {
                    String station[] = str[3].split(mark2);
                    if (station.length < 1) {
                        System.out.println(line);
                        continue;
                    }
                    cs.append(str[0], str[1] + " " + str[2], station[0], station[1], str[5], str[6]);
                }
            }
            br.close();
            return cs;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
/**
 * @Description: readSubway   classify cards
 * @Param: [filename]
 * @Returns: java.util.HashMap<java.lang.String,data.Cards>
 */
    public static HashMap<String, Cards> readSubway(String filename) {
        //      2280964597,2018-03-31 08:30:51,7,东安路,0,非优惠
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            HashMap<String, Cards> result = new HashMap<String, Cards>();
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                String str[] = line.split(",");
                Card c = new Card(str[0], str[1], str[2], str[3], str[4], str[5]);
                if (result.containsKey(c.getId())) {
                    result.get(c.getId()).append(c);
                } else {
                    result.put(c.getId(), new Cards(c));
                }
            }
            br.close();
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
