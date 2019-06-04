package com.zkzong.io;

import java.io.File;

/**
 * Created by Zong on 2016/6/11.
 * 创建一个文件夹
 */
public class CreateFolder {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator + "hello";
        File f = new File(fileName);
        f.mkdir();
    }
}
