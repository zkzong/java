package org.example.http.thread;

import org.example.http.HttpClientUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * HttpClient测试
 */
public class TestHttpClient {
    public static void main(String[] args) {
//        HttpThread tt = new HttpThread();
//        tt.start();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1000);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                HttpClientUtils.get("http://localhost:8088/http2/index?name=zhangsan&age=22&sex=nan");
            }
        }, 1, 3, TimeUnit.MILLISECONDS);
    }

}

class HttpThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            get();
        }
    }

    public static void get() {
        try {
            HttpClientUtils.get("http://localhost:8088/http2/index?name=zhangsan&age=22&sex=nan");

//            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
//            parameters.add(new BasicNameValuePair("name", "zhangsan"));
//            parameters.add(new BasicNameValuePair("age", "22"));
//            parameters.add(new BasicNameValuePair("sex", "nan"));
//            HttpClientUtils.post("http://localhost:8088/http2/index", parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
