package org.example.test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Zong on 2016/11/25.
 */
public class PathTest {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(new File("").getPath());
    }
}
