package com.zkzong.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Zong on 2016/6/12.
 * 字节流
 * 向文件中追加新内容：
 */
public class StreamAppend {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        OutputStream out = new FileOutputStream(f, true);
//        String str = "Rollen";
        String str = "\r\nRollen";
        byte[] b = str.getBytes();
        for (int i = 0; i < b.length; i++) {
            out.write(b[i]);
        }
        out.close();
    }
}
