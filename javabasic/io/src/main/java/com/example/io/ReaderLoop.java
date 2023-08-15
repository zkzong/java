package com.example.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by zong on 2016/6/20.
 */
public class ReaderLoop {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        char[] ch = new char[100];
        Reader read = new FileReader(f);
        int temp = 0;
        int count = 0;
        while ((temp = read.read()) != (-1)) {
            ch[count++] = (char) temp;
        }
        read.close();
        System.out.println("内容为" + new String(ch, 0, count));
    }
}
