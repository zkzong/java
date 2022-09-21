package org.example.designpattern.zen.proxy.section3;

/**
 * Created by Zong on 2016/11/4.
 */
public class Client {
    public static void main(String[] args) {
        Subject proxy = new RealSubject();
        proxy.request();
    }
}
