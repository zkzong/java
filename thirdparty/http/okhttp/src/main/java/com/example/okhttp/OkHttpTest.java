package com.example.okhttp;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Zong on 2017/4/1.
 * http://www.jianshu.com/p/ca8a982a116b
 */
public class OkHttpTest {
    private final OkHttpClient client = new OkHttpClient();

    private static final String IMGUR_CLIENT_ID = "...";
    public static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

    // 同步GET
    @Test
    public void get() throws IOException {
        Request request = new Request.Builder().url("http://publicobject.com/helloworld.txt").build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }

        System.out.println(response.body().string());
    }

    // 异步GET todo 无输出
    @Test
    public void asynGet() {
        Request request = new Request.Builder().url("http://publicobject.com/helloworld.txt").build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                Headers responseHeaders = response.headers();
                for (int i = 0; i < responseHeaders.size(); i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                System.out.println(response.body().string());
            }
        });
    }

    // Post方式提交String
    @Test
    public void postString() throws IOException {
        String postBody = ""
                + "Releases\n"
                + "--------\n"
                + "\n"
                + " * _1.0_ May 6, 2013\n"
                + " * _1.1_ June 15, 2013\n"
                + " * _1.2_ August 11, 2013\n";

        Request request = new Request.Builder().url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        System.out.println(response.body().string());
    }

    // Post方式提交流
    @Test
    public void postStream() throws IOException {
        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MEDIA_TYPE_MARKDOWN;
            }

            @Override
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.writeUtf8("Numbers\n");
                bufferedSink.writeUtf8("------\n");
                for (int i = 2; i <= 997; i++) {
                    bufferedSink.writeUtf8(String.format(" * %s = %s\n", i, factor(i)));
                }
            }

            private String factor(int n) {
                for (int i = 2; i <= 997; i++) {
                    int x = n / i;
                    if (x * i == n) {
                        return factor(x) + " x " + i;
                    }
                }
                return Integer.toString(n);
            }
        };

        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        System.out.println(response.body().string());
    }

    // Post方式提交文件
    @Test
    public void postFile() throws IOException {
        File file = new File("pom.xml");

        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        System.out.println(response.body().string());
    }

    // Post方式提交表单
    @Test
    public void postForm() throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("search", "zong")
                .build();

        Request request = new Request.Builder()
                .url("https://en.wikipedia.org/w/index.php")
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        System.out.println(response.body().string());
    }

    // Post方式提交分块请求 todo 报错
    @Test
    public void postBlock() throws IOException {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("title", "Square Logo")
                .addFormDataPart("image", "logo-square.jpg",
                        RequestBody.create(MEDIA_TYPE_PNG, new File("logo-square.jpg")))
                .build();

        Request request = new Request.Builder()
                .header("Authorization", "Client-ID " + IMGUR_CLIENT_ID)
                .url("https://api.imgur.com/3/image")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        System.out.println(response.body().string());
    }
}
