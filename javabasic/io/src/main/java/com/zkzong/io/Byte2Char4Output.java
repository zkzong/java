package com.zkzong.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by Zong on 2016/6/20.
 * 将字节输出流转化为字符输出流
 */
public class Byte2Char4Output {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File file = new File(fileName);
        Writer out = new OutputStreamWriter(new FileOutputStream(file));
        out.write("hello");
        out.close();
    }
}
