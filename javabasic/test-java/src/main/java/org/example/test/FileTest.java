package org.example.test;

import java.io.File;

/**
 * Created by zong on 2017/2/16.
 */
public class FileTest {
    public static void main(String[] args) {
        // 不可以用这种方式读取网络文件，需要用URL
        File f = new File("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
        if (f.exists()) {
            System.out.println("exist");
        } else {
            System.out.println("not");
        }
    }
}
