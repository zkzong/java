package com.zkzong.io;

import java.io.File;

/**
 * Created by Zong on 2016/6/11.
 * 使用listFiles列出指定目录的全部文件
 * listFiles输出的是完整路径
 */
public class FileList2 {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator;
        File f = new File(fileName);
        File[] str = f.listFiles();
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
