package com.zkzong.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zong on 2016/12/10.
 * 内存溢出一般是出现在申请了较多的内存空间没有释放的情形
 */
public class OutOfMemoryTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (; ; ) {
            int[] tmp = new int[1000000];
            list.add(tmp);
        }
    }
}
