package com.zkzong.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Zong on 2016/8/7.
 */
public class NioOpt {

    /**
     * 使用IO读取指定文件的前1024个字节的内容
     *
     * @param file 指定文件名称
     * @throws IOException
     */
    public void ioRead(String file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        byte[] b = new byte[1024];
        in.read();
        System.out.println(new String(b));
    }

    /**
     * 使用NIO读取指定文件的前1024个字节的内容
     *
     * @param file 指定文件名称
     * @throws IOException
     */
    public void nioRead(String file) throws IOException {
        //NIO以通道Channel和缓冲区Buffer为基础来实现面向块的IO数据处理
        FileInputStream in = new FileInputStream(file);
        FileChannel channel = in.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        byte[] b = buffer.array();
        System.out.println(new String(b));
    }

}
