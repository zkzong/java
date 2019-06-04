package com.zkzong.jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zong on 2016/8/10.
 */
public class GC {
    public static void main(String[] args) {
        List list = new LinkedList();
        do {
            list.add(new String("Hello World"));
        } while (true);
    }
}
