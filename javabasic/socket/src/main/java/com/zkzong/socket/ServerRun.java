package com.zkzong.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: zong
 * @Date: 2020/1/13
 */
public class ServerRun {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(3456);
        System.out.println("-----正在监听3456端口---");
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        // 前8个字节
        byte[] b = new byte[8];
        is.read(b);
        int len = Integer.parseInt(new String(b, "UTF-8"));

        // 用来填充xml
        b = new byte[len];
        is.read(b);

        socket.getOutputStream();

        // 关闭资源
        is.close();
        socket.close();
        server.close();

        String result = new String(b, "UTF-8");
        System.out.println(result);

    }
}
