package com.example.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Zong on 2016/12/4.
 */
public class ReadWrite {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("file.txt")));

        // 写入文件
        String input = null;
        while (!(input = br.readLine()).equals("#")) {
            bw.write(input);
            bw.newLine();
        }
        bw.close();
        br.close();

        // 读出
        br = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));
        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        br.close();
    }
}
