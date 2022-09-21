package org.example.net;

import javax.net.SocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2017/6/21.
 */
public class TT {
    public static void main(String[] args) throws IOException {
        SocketFactory sf = new SocketFactory() {
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
//        Socket localhost = sf.createSocket("localhost", 8080;
        sf.createSocket("127.0.0.1", 8080);
    }
}
