package io;

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

}

