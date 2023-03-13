package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Zong on 2017/4/25.
 */
public class DateUtil {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DateUtil() {
    }

    // todo 未完成
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        for (int i = 0; i < 500; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        try {
                            DATE_FORMAT.parse("2017-04-25 00:00:00");
                            System.out.println(i);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        Thread.sleep(30000);
    }
}
