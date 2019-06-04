package com.zkzong.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Zong on 2016/6/13.
 * 字符流
 * 写入数据
 */
public class WriteTest {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        Writer out = new FileWriter(f, true);
        String str = "\r\nhello";
        out.write(str);
        out.close();
    }
}
