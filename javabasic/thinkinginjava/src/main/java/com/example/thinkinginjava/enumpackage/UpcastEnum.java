package com.example.thinkinginjava.enumpackage;

/**
 * Created by Zong on 2016/8/25.
 */
enum Search {
    HITHER, YON
}

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER;// Upcast
        // e.values();  // No values() in Enum
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}
