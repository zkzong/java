package com.zkzong.jvm;

import org.junit.Test;
import sun.misc.Launcher;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Zong on 2016/11/28.
 */
public class ClassLoaderTest {
    /**
     * 根加载器
     */
    @Test
    public void test() {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            URL url = urls[i];
            System.out.println(url.toExternalForm());
        }

        System.out.println(System.getProperty("sun.boot.class.path"));
    }

    /**
     * 类加载器在类相等判断中的影响
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 自定义类加载器
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(fileName);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };
        // 使用ClassLoaderTest的类加载器加载本类
        Object obj1 = ClassLoaderTest.class.getClassLoader().loadClass("com.zkzong.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj1.getClass());
        System.out.println(obj1 instanceof ClassLoaderTest);
        // 使用自定义类加载器加载本类
        Object obj2 = myLoader.loadClass("com.zkzong.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj2.getClass());
        System.out.println(obj2 instanceof ClassLoaderTest);
    }

}
