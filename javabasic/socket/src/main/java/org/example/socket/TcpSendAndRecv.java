package com.example.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: zong
 * @Date: 2020/1/13
 */
public class TcpSendAndRecv {
    public static void main(String[] args) {
        new Thread(new DD()).start();
        //先开启接收端的线程
        new Thread(new TT()).start();
        //在开启发送端的线程
    }
}

//发送端的代码如下：
class TT implements Runnable {

    @Override
    public void run() {
        try {
            Socket s = new Socket("localhost", 9977);
            //创建一个socket绑定的端口和地址为：9977，本机。
            OutputStream oos = s.getOutputStream();
            //获取到输出流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(oos));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.flush();
                //将内容写到控制台
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}

//接收端的代码
class DD implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9977);
            //创建一个serversocket其端口与发送端的端口是一样的
            Socket s = ss.accept();
            //侦听并接受到此套接字的连接，返回一个socket对象
            InputStream is = s.getInputStream();
            //获取到输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            byte[] buf = new byte[1024];
            //接收收到的数据
            int line = 0;
            while ((line = is.read(buf)) != -1) {
                System.out.println(new String(buf, 0, line));
                //将接收到的数据在控制台输出
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
