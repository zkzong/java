package com.example.interview.io;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.zip.GZIPInputStream;

/**
 * Created by Zong on 2016/12/9.
 */
public class IOTest {
    public static void main(String[] args) throws IOException {
        new BufferedWriter(new FileWriter("a.txt"));
        // 编译出错
        //new BufferedReader(new FileInputStream("a.dat"));
        new GZIPInputStream(new FileInputStream("a.zip"));
        new ObjectInputStream(new FileInputStream("a.dat"));
    }

    /**
     * 创建父级目录
     * @throws IOException
     */
    @Test
    public void createParentDir() throws IOException {
        File file = new File("/data/image/test.txt");
        file.getParentFile().mkdirs();
        file.createNewFile();
    }
}
