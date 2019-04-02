package data;

import tool.DataTranslate;

/**
 * @program: bus
 * @description: the record of one swipe card
 * @author: Jiaye Liu
 * @create: 2019-03-31 16:44
 **/
public class Card {
    private String id;
    private long data;
    private String lineID;
    private String station;
    private double cost;//cost=0,up,0;cost>0,down,1;other,2
    private String mark;

    public Card(String id,long data,String lineID,String station,double cost,String mark) {
        this.id=id;
        this.data=data;
        this.lineID=lineID;
        this.station=station;
        this.cost=cost;
        this.mark=mark;
    }
    public Card(String id,String data,String line,String station,String cost,String mark) {
        this.id=id;
        this.data= DataTranslate.stringToLong(data);
        this.lineID=line;
        this.station=station;
        this.cost=Double.parseDouble(cost);
        this.mark=mark;
    }

    @Override
    public String toString() {
        return id+","+DataTranslate.longToString(data)+","+lineID+","+station+","+cost+","+mark;
    }

    public String getId() {
        return id;
    }
}
