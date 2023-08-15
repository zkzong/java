package com.example.bigdata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadData {
    private static String FILE_NAME = "/Users/admin/User.dat";

    private static void readData() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), StandardCharsets.UTF_8));
        long start = System.currentTimeMillis();
        int count = 1;
        while (br.readLine() != null) {
            // 按行读取
//            SplitData.splitLine(line);
            if (count % 100 == 0) {
                System.out.println("读取100行,总耗时间: " + (System.currentTimeMillis() - start) / 1000 + " s");
                System.gc();
            }
            count++;
        }
        //running = false;
        br.close();

    }

    public static void main(String[] args) throws IOException {
        readData();
    }

}
