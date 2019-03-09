package tool;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTranslate {
    public static long stringToLong(String str) {
        try {
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dt=df.parse(str);
            return dt.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static String longToString(long l) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt=new Date(l);
        return df.format(dt);
    }
    public static void main(String[] args) {
        //测试专用
        long l=stringToLong("2018-10-16 22:49:00");
        if(longToString(l).equals("2018-10-16 22:49:00"))
            System.out.println("ok");
        else
            System.out.println("gg");
    }
}
