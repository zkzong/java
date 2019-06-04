package com.zkzong.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Zong on 2016/6/13.
 * 字节流
 * 读文件内容,节省空间
 */
public class StreamReaderOne {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) in.read();
        }
        in.close();
        System.out.println(new String(b));
    }
}
