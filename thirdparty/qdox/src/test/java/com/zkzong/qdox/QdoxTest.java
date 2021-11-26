package com.zkzong.qdox;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zong
 * @Date: 2021/11/25
 */
public class QdoxTest {

    @Test
    public void test() throws IOException {
        // 创建 java 项目 builder 对象
        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();

        // 添加 java 源文件
        javaProjectBuilder.addSource(new File("/Users/admin/Desktop/code/java/thirdparty/qdox/src/main/java/com/zkzong/qdox/controller/QdoxController.java"));

        // 获得解析后的类`
        Collection<JavaClass> classes = javaProjectBuilder.getClasses();
        for (JavaClass javaClass : classes) {
            // 打印类相关信息
            System.out.println("类名:" + javaClass.getName());
            String fullClassName = javaClass.getPackageName() + "." + javaClass.getName();
            System.out.println("全类名：" + fullClassName);
            System.out.println("实现了哪些类：" + javaClass.getImplements());
            System.out.println("继承哪个类：" + javaClass.getSuperJavaClass());
            System.out.println("注释：" + javaClass.getComment());
            // 获得方法列表
            List<JavaMethod> methods = javaClass.getMethods();
            for (JavaMethod method : methods) {
                System.out.println("方法名是：" + method.getName());
                System.out.println("方法的 Tags 有哪些：" + method.getTags().stream().map(it -> it.getName() + "->" + it.getValue()).collect(Collectors.joining("\n")));
                System.out.println("方法的参数有哪些：" + method.getParameters());
                System.out.println("方法的返回值有哪些：" + method.getReturns());
                System.out.println("方法的注释：" + method.getComment());
                System.out.println("方法的注解有哪些：" + method.getAnnotations());
                System.out.println("方法的源码：" + method.getSourceCode());
            }

            // 获得属性列表
            final List<JavaField> fields = javaClass.getFields();
            for (JavaField field : fields) {
                System.out.println("属性名是：" + field.getName());
                System.out.println("属性的 Tags 有哪些：" + field.getTags().stream().map(it -> it.getName() + "->" + it.getValue()).collect(Collectors.joining("\n")));
                System.out.println("属性的注释：" + field.getComment());
                System.out.println("属性的类型：" + field.getType());
                System.out.println("属性的类型的类名：" + field.getType().getName());
            }

        }
    }

}
