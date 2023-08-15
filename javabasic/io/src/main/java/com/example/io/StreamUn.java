package com.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Zong on 2016/6/13.
 * 字节流
 * 读文件
 */
public class StreamUn {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[1024];
        int count = 0;
        int temp = 0;
        while ((temp = in.read()) != (-1)) {
            b[count++] = (byte) temp;
        }
        in.close();
        System.out.println(new String(b));
    }
}
