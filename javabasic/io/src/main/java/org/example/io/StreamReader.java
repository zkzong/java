package com.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Zong on 2016/6/13.
 * 字节流
 * 读文件内容
 */
public class StreamReader {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[1024];
        int len = in.read(b);
//        in.read(b);
        in.close();
        System.out.println("读入长度为：" + len);
        System.out.println(new String(b));
    }
}
