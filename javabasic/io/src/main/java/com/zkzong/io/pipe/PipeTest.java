package com.zkzong.io.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by Zong on 2016/6/20.
 * 验证管道流
 */

/**
 * 消息发送类
 */
class Send implements Runnable {
    private PipedOutputStream out = null;

    public Send() {
        out = new PipedOutputStream();
    }

    public PipedOutputStream getOut() {
        return this.out;
    }

    @Override
    public void run() {
        String message = "Hello, Rollen";
        try {
            out.write(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 接受消息类
 */
class Receive implements Runnable {
    private PipedInputStream input = null;

    public Receive() {
        this.input = new PipedInputStream();
    }

    public PipedInputStream getInput() {
        return this.input;
    }

    @Override
    public void run() {
        byte[] b = new byte[1000];
        int len = 0;
        try {
            len = this.input.read(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("接受的内容为" + (new String(b, 0, len)));
    }
}

public class PipeTest {
    public static void main(String[] args) {
        Send send = new Send();
        Receive receive = new Receive();
        try {
            send.getOut().connect(receive.getInput());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(send).start();
        new Thread(receive).start();
    }
}
