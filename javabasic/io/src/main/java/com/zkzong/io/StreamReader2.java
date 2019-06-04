package com.zkzong.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Zong on 2016/6/13.
 * 字符流
 * 读文件内容,节省空间
 */
public class StreamReader2 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        in.read(b);
        System.out.println("文件长度为：" + f.length());
        in.close();
        System.out.println(new String(b));
    }
}
