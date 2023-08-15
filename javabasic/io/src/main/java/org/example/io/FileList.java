package com.example.io;

import java.io.File;

/**
 * Created by Zong on 2016/6/11.
 * 列出指定目录的全部文件（包括隐藏文件）
 */
public class FileList {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator;
        File f = new File(fileName);
        String[] str = f.list();
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
