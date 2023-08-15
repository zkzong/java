package com.example.image;

import org.apache.commons.codec.binary.Base64;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Zong on 2017/2/15.
 * 图片和字符串相互转换
 */
public class Image2StringUseIO {

    /**
     * 从本地读取图片转成字符串
     *
     * @return
     */
    static String getImageBinary() {
        File f = new File("image/xxy.jpg");
//        File f = new File("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
        try {
            InputStream in = new FileInputStream(f);
            byte[] data = new byte[in.available()];
            in.read(data);

            return Base64.encodeBase64String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串转图片
     *
     * @param base64String
     */
    static void base64StringToImage(String base64String) {
        OutputStream out = null;
        try {
            byte[] bytes = Base64.decodeBase64(base64String);

            String fileName = "Image" + System.currentTimeMillis() + ".jpg";
            out = new FileOutputStream(fileName);
            out.write(bytes);
            out.flush();

//            if (w2.exists()) { // 删除文件
//                w2.delete();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 网络文件转字符串
     *
     * @param urlName
     * @param type
     * @return
     */
    public static String getImageBase64String(String urlName, String type) {
        String res = null;
        try {
            int httpResult = 0; // 服务器返回的状态
            URL url = new URL(urlName); // 创建URL
            URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
            urlconn.connect();
            HttpURLConnection httpconn = (HttpURLConnection) urlconn;
            httpResult = httpconn.getResponseCode();
            System.out.println(httpResult);
            if (httpResult != HttpURLConnection.HTTP_OK) { // 不等于HTTP_OK则连接不成功
                System.out.print("fail");
            } else {
                // todo 转成图片失败
//                DataInputStream is = new DataInputStream(urlconn.getInputStream());
//                byte[] data = new byte[is.available()];
//                is.read(data);
//
//                return encoder.encodeBuffer(data).trim();

                // 直接保存为图片
                DataInputStream in = new DataInputStream(urlconn.getInputStream());
                // 此处也可用BufferedInputStream与BufferedOutputStream
                DataOutputStream out = new DataOutputStream(new FileOutputStream(new File("a.jpg")));
                // 将参数savePath，即将截取的图片的存储在本地地址赋值给out输出流所指定的地址
                byte[] buffer = new byte[4096];
                int count = 0;
                // 将输入流以字节的形式读取并写入buffer中
                while ((count = in.read(buffer)) > 0) {
                    out.write(buffer, 0, count);
                }
                res = Base64.encodeBase64String(buffer);
                // 后面三行为关闭输入输出流以及网络资源的固定格式
                out.close();
                in.close();
                httpconn.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
