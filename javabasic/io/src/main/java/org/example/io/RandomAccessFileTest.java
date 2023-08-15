package com.example.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Zong on 2016/6/11.
 * 使用RandomAccessFile写入文件
 */
public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "a" + File.separator + "b" + File.separator + "hello.txt";
        File f = new File(fileName);
        if (!f.exists()) {
            f.getParentFile().mkdirs();
            f.createNewFile();
        }
        RandomAccessFile demo = new RandomAccessFile(f, "rwd");
        demo.writeBytes("asdsad");
        demo.writeInt(12);
        demo.writeBoolean(true);
        demo.writeChar('A');
        demo.writeFloat(1.21f);
        demo.writeDouble(12.123);
        demo.close();
    }
}
