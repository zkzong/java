package com.example.io;

import java.io.File;

/**
 * Created by Zong on 2016/6/11.
 * 列出指定目录的全部内容
 */
public class ListAllFile {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator;
        File f = new File(fileName);
        print(f);
    }

    public static void print(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                File[] fileArray = f.listFiles();
                if (fileArray != null) {
                    for (int i = 0; i < fileArray.length; i++) {
                        //递归调用
                        print(fileArray[i]);
                    }
                }
            } else {
                System.out.println(f);
            }
        }
    }
}
