package org.example.apache.commons.beanutils;

import org.apache.commons.beanutils.MethodUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Zong on 2017/2/7.
 */
public class MethodUtilsTest {
    public static void main(String[] args) {
        MethodUtilsTest mut = new MethodUtilsTest();
        mut.getName();
    }

    void getName() {
        try {
            Class c = Class.forName("org.example.apache.commons.beanutils.Value");
            Object o = c.newInstance();
            System.out.println(o);
            String value = (String) MethodUtils.invokeMethod(o, "getValue", null);
            System.out.println("Results from getValue: " + value);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Value {
    public String getValue() {
        return "value";
    }
}
