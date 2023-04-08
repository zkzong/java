package org.example.csv.read;

import org.example.csv.read.ReadFile.ProcessDataByPostgisListeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BuildData {
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\1396341974289.csv");
        FileInputStream fis = null;
        try {
            ReadFile readFile = new ReadFile();
            fis = new FileInputStream(file);
            int available = fis.available();
            int maxThreadNum = 50;
            // 线程粗略开始位置
            int i = available / maxThreadNum;
            for (int j = 0; j < maxThreadNum; j++) {
                // 计算精确开始位置
                long startNum = j == 0 ? 0 : readFile.getStartNum(file, i * j);
                long endNum = j + 1 < maxThreadNum ? readFile.getStartNum(file, i * (j + 1)) : -2;
                // 具体监听实现
                ProcessDataByPostgisListeners listeners = new ProcessDataByPostgisListeners("gbk");
                new ReadFileThread(listeners, startNum, endNum, file.getPath()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

