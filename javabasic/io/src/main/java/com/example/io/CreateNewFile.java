package com.example.io;

import java.io.File;

/**
 * Created by Zong on 2016/6/11.
 * 创建一个新文件
 */
public class CreateNewFile {
    public static void main(String[] args) {
//        File f = new File("D:\\hello.txt");
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        try {
            f.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
