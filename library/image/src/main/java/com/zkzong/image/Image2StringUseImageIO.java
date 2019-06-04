package com.zkzong.image;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Zong on 2017/2/15.
 * 图片和字符串相互转换
 */
public class Image2StringUseImageIO {

    /**
     * 从本地读取图片转成字符串
     *
     * @return
     */
    static String getImageBinary() {
        File f = new File("image/xxy.jpg");
//        File f = new File("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();

            return Base64.encodeBase64String(bytes);
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
        try {
            byte[] bytes = Base64.decodeBase64(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File("copy1.png"); // 可以是jpg,png,gif格式
            ImageIO.write(bi1, "jpg", w2); // 不管输出什么格式图片，此处不需改动

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
     * @param URLName
     * @param type
     * @return
     */
    public static String getImageBase64StringUrl(String URLName, String type) {
        String res = null;
        try {
            int httpResult = 0; // 服务器返回的状态
            URL url = new URL(URLName); // 创建URL
            URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
            urlconn.connect();
            HttpURLConnection httpconn = (HttpURLConnection) urlconn;
            httpResult = httpconn.getResponseCode();
            if (httpResult != HttpURLConnection.HTTP_OK) { // 不等于HTTP_OK则连接不成功
                System.out.print("fail");
            } else {
                BufferedInputStream bis = new BufferedInputStream(urlconn.getInputStream());
                BufferedImage bm = ImageIO.read(bis);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(bm, type, bos);
                bos.flush();
                byte[] data = bos.toByteArray();
                res = Base64.encodeBase64String(data);
                bos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String getImageBase64StringHttpGet(String URLName, String type) {
        String res = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(URLName);
            HttpResponse httpResponse = httpClient.execute(httpGet);

            if (httpResponse.getStatusLine().getStatusCode() != 200) { // 不等于HTTP_OK则连接不成功
                System.out.print("fail");
            } else {
                HttpEntity entity = httpResponse.getEntity();
                BufferedInputStream bis = new BufferedInputStream(entity.getContent());
                BufferedImage bm = ImageIO.read(bis);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(bm, type, bos);
                bos.flush();
                byte[] data = bos.toByteArray();
                res = Base64.encodeBase64String(data);
                bos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * @param URLName 网络图片地址
     * @param type    图片类型
     * @return String  转换结果
     * @throws
     * @Title getImgeHexString
     * @Description 网络图片转换成二进制字符串
     */
    public static String getImgeHexString(String URLName, String type) {
        String res = null;
        try {
            int HttpResult = 0; // 服务器返回的状态
            URL url = new URL(URLName); // 创建URL
            URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
            urlconn.connect();
            HttpURLConnection httpconn = (HttpURLConnection) urlconn;
            HttpResult = httpconn.getResponseCode();
            System.out.println(HttpResult);
            // 不等于HTTP_OK则连接不成功
            if (HttpResult != HttpURLConnection.HTTP_OK) {
                System.out.print("fail");
            } else {
                BufferedInputStream bis = new BufferedInputStream(urlconn.getInputStream());

                BufferedImage bm = ImageIO.read(bis);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(bm, type, bos);
                bos.flush();
                byte[] data = bos.toByteArray();

                res = byte2hex(data);
                bos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 格式化byte
     *
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F'};
        char[] out = new char[b.length * 2];
        for (int i = 0; i < b.length; i++) {
            byte c = b[i];
            out[i * 2] = Digit[(c >>> 4) & 0X0F];
            out[i * 2 + 1] = Digit[c & 0X0F];
        }

        return new String(out);
    }

    /**
     * @param data     生成图片的二进制字符串
     * @param fileName 图片名称(完整路径)
     * @param type     图片类型
     * @return
     * @title 根据二进制字符串生成图片
     */
    public static void saveImage(String data, String fileName, String type) {

        BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_BYTE_BINARY);
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, type, byteOutputStream);
//             byte[] bytes = byteOutputStream.toByteArray();
            byte[] bytes = Base64.decodeBase64(data);
//            byte[] bytes = hex2byte(data);
            System.out.println("path:" + fileName);
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");
            file.write(bytes);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反格式化byte
     *
     * @param s
     * @return
     */
    public static byte[] hex2byte(String s) {
        byte[] src = s.toLowerCase().getBytes();
        byte[] ret = new byte[src.length / 2];
        for (int i = 0; i < src.length; i += 2) {
            byte hi = src[i];
            byte low = src[i + 1];
            hi = (byte) ((hi >= 'a' && hi <= 'f') ? 0x0a + (hi - 'a')
                    : hi - '0');
            low = (byte) ((low >= 'a' && low <= 'f') ? 0x0a + (low - 'a')
                    : low - '0');
            ret[i / 2] = (byte) (hi << 4 | low);
        }
        return ret;
    }
}
