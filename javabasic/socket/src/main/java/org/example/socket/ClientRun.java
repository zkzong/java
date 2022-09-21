package org.example.socket;

import org.apache.commons.io.IOUtils;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Author: zong
 * @Date: 2020/1/13
 */
public class ClientRun {
    public static void main(String[] args) throws Exception {
        String xml = "<xml>\r\n" +
                "<name>张山</name>\r\n" +
                "<amt>100000</amt>\r\n" +
                "<time>20171011091230</time>\r\n" +
                "<type>支出</type>\r\n" +
                "<opt>信用卡还款</opt>\r\n" +
                "<phone>18940916007</phone>\r\n" +
                "</xml>";
        Socket client = new Socket("127.0.0.1", 3456);
        OutputStream out = client.getOutputStream();

        byte[] b = xml.getBytes("UTF-8");

        out.write(int2Bytes8(b.length));
        out.write(b);
        out.close();

        String s = IOUtils.toString(client.getInputStream(), StandardCharsets.UTF_8);
        System.out.println(s);
        client.close();
    }

    /**
     * @Title: int2Bytes8
     * @Description: 数字[2] 变成八个字节的 ['0' '0' '0' '0' '0' '0' '0' '2']
     * @param: @param num
     * @param: @return
     * @return: byte[]
     */
    public static byte[] int2Bytes8(int num) {
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        int length = 8 - sb.length();
        for (int i = 0; i < length; i++) {
            sb.insert(0, '0');
        }
        return sb.toString().getBytes();
    }
}
