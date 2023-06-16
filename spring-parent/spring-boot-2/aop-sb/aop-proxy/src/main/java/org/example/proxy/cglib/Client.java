package org.example.proxy.cglib;

import org.example.proxy.pattern.RealSubject;
import org.example.proxy.pattern.Subject;
import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject = (Subject) enhancer.create();
        subject.hello();
    }
}
