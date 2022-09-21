package org.example.designpattern.zen.DynamicProxy.section2;

import org.example.designpattern.zen.DynamicProxy.section1.RealSubject;
import org.example.designpattern.zen.DynamicProxy.section1.Subject;

/**
 * Created by Zong on 2016/11/9.
 */
public class Client {
    public static void main(String[] args) {
        // 定义一个主题
        Subject subject = new RealSubject();
        // 定义主题的代理
        Subject proxy = SubjectDynamicProxy.newProxyInstance(subject);
        // 代理的行为
        proxy.doSomething("Finish");
    }
}
