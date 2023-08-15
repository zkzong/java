package com.example.io;

import java.io.File;

/**
 * Created by Zong on 2016/6/11.
 * 删除一个文件
 */
public class DeleteFile {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        if (f.exists()) {
            f.delete();
        } else {
            System.out.println("文件不存在");
        }
    }
}
