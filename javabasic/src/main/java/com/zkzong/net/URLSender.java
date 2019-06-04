package com.zkzong.net;

import org.junit.Test;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2017/6/22.
 */
public class URLSender {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("www.baidu.com", 80);
            boolean autoflush = true;
            PrintWriter out = new PrintWriter(socket.getOutputStream(), autoflush);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //send an HTTP request to the web server
            out.println("GET / HTTP/1.1");
            out.println("Host: nwu.edu.cn");
            out.println("Connection: Close");
            out.println();
            //read the response
            boolean loop = true;
            StringBuffer sb = new StringBuffer(8096);
            while (loop) {
                if (in.ready()) {
                    int i = 0;
                    while (i != -1) {
                        i = in.read();
                        sb.append((char) i);
                    }
                    loop = false;
                }
                //Thread.currentThread().sleep(50);
            }
            //display the response to the out console
            System.out.println(sb.toString());
            socket.close();
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: Victest.");
            System.exit(1);
        }
    }

    @Test
    public void t() {
        SocketFactory factory = new SSLSocketFactory() {
            @Override
            public String[] getDefaultCipherSuites() {
                return new String[0];
            }

            @Override
            public String[] getSupportedCipherSuites() {
                return new String[0];
            }

            @Override
            public Socket createSocket(Socket socket, String s, int i, boolean b) throws IOException {
                return null;
            }

            @Override
            public Socket createSocket(String s, int i) throws IOException, UnknownHostException {
                return null;
            }

            @Override
            public Socket createSocket(String s, int i, InetAddress inetAddress, int i1) throws IOException, UnknownHostException {
                return null;
            }

            @Override
            public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
                return null;
            }

            @Override
            public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress1, int i1) throws IOException {
                return null;
            }
        };
        try {
            factory.createSocket("www.baidu.com", 80);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
