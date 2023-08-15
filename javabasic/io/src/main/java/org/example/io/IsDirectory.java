package com.example.io;

import java.io.File;

/**
 * Created by Zong on 2016/6/11.
 * 使用isDirectory判断一个指定的路径是否为目录
 */
public class IsDirectory {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator;
        File f = new File(fileName);
        if (f.isDirectory()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
