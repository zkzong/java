package org.example.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by Zong on 2016/6/13.
 * 字符流
 * 从文件中读出内容
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        char[] ch = new char[100];
        Reader read = new FileReader(f);
        int count = read.read(ch);
        read.close();
        System.out.println("读入的长度为：" + count);
        System.out.println("内容为" + new String(ch, 0, count));
    }
}
