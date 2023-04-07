package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderExample {
    public static void main(String[] args) throws Exception {
        String csvFilePath = "file.csv";
        List<String[]> lines = readCsvFile(csvFilePath, 4);
        for (String[] line : lines) {
            System.out.println(String.join(",", line));
        }
    }

    public static List<String[]> readCsvFile(String csvFilePath, int numThreads) throws Exception {
        List<String[]> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
        String[] headers = br.readLine().split(",");
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line.split(","));
        }
        br.close();
        int size = lines.size();
        int step = size / numThreads;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            int start = i * step;
            int end = i == numThreads - 1 ? size : (i + 1) * step;
            Thread thread = new Thread(new CsvReaderTask(lines.subList(start, end), headers));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return lines;
    }

    static class CsvReaderTask implements Runnable {
        private final List<String[]> lines;
        private final String[] headers;

        public CsvReaderTask(List<String[]> lines, String[] headers) {
            this.lines = lines;
            this.headers = headers;
        }

        @Override
        public void run() {
            for (String[] line : lines) {
                for (int i = 0, len = line.length; i < len; i++) {
                    System.out.println(headers[i] + ":" + line[i]);
                }
            }
        }
    }
}
