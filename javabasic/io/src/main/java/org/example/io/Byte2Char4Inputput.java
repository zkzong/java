package org.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Zong on 2016/6/20.
 * 将字节输入流变为字符输入流
 */
public class Byte2Char4Inputput {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File file = new File(fileName);
        Reader read = new InputStreamReader(new FileInputStream(file));
        char[] b = new char[100];
        int len = read.read(b);
        System.out.println(new String(b, 0, len));
        read.close();
    }
}
