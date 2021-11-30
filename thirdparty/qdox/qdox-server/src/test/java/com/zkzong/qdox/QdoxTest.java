package com.zkzong.qdox;

import cn.hutool.core.util.StrUtil;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
            List<JavaField> fields = javaClass.getFields();
            for (JavaField field : fields) {
                System.out.println("属性名是：" + field.getName());
                System.out.println("属性的 Tags 有哪些：" + field.getTags().stream().map(it -> it.getName() + "->" + it.getValue()).collect(Collectors.joining("\n")));
                System.out.println("属性的注释：" + field.getComment());
                System.out.println("属性的类型：" + field.getType());
                System.out.println("属性的类型的类名：" + field.getType().getName());
            }
        }
    }

    @Test
    public void recursion() throws ClassNotFoundException {
        List<String> fileList1 = new ArrayList<>();

        String[] apis = api();
        for (String api : apis) {
            System.out.println(api);
            recInject("/Users/admin/zong/code/java/thirdparty/qdox/qdox-server", api, null, fileList1);
        }

        System.out.println("------------------------------------------------------");

        List<String> fileList2 = new ArrayList<>();
        List<String> fileList3 = new ArrayList<>();
        List<String> files = files("/Users/admin/zong/code/java/thirdparty/qdox/qdox-server", fileList2);
        for (String api : apis) {
            System.out.println(api);
            for (String file : files) {
                System.out.println(api);
                recInjectFile(file, api, null, fileList3);
            }
        }

    }

    /**
     * 根据目录递归
     *
     * @param modulePath
     * @param className
     * @param methodName
     * @param fileList
     */
    private void recInject(String modulePath, String className, String methodName, List<String> fileList) {

        JavaProjectBuilder builder = new JavaProjectBuilder();
        builder.addSourceTree(new File(modulePath));
        Collection<JavaClass> classes = builder.getClasses();
        for (JavaClass aClass : classes) {
            JavaClass javaClass = aClass;

            String fullClassName = javaClass.getPackageName() + "." + javaClass.getName();

            List<JavaField> fields = javaClass.getFields();

            List<JavaMethod> methods = javaClass.getMethods();

            for (JavaField field : fields) {
                String fieldName = field.getName();
                JavaClass fieldType = field.getType();

                for (JavaMethod method : methods) {
                    String sourceCode = method.getSourceCode();

                    // todo 优化继承关系判断 className.toUpperCase().contains(fieldName.toUpperCase())
                    if ((className.equals(fieldType.toString()) || className.toUpperCase().contains(fieldName.toUpperCase())) && sourceCode.contains(fieldName + "." + (methodName == null ? "" : methodName))) {
                        if (javaClass.getPackageName().contains("service") || javaClass.getPackageName().contains("mapper")) {
                            recInject(modulePath, fullClassName, method.getName(), fileList);
                        } else {
                            System.out.println(fullClassName + "." + method.getName());
                            fileList.add(fullClassName + "." + method.getName());
                        }
                    }
                }
            }
        }
    }

    /**
     * 根据文件递归
     *
     * @param file
     * @param className
     * @param methodName
     * @param fileList
     */
    private void recInjectFile(String file, String className, String methodName, List<String> fileList) {

        JavaProjectBuilder builder = new JavaProjectBuilder();

        int i = StrUtil.ordinalIndexOf(file, "/", 9);

        builder.addSourceTree(new File(file.substring(0, i)));
        Collection<JavaClass> classes = builder.getClasses();
        for (JavaClass aClass : classes) {
            JavaClass javaClass = aClass;

            String fullClassName = javaClass.getPackageName() + "." + javaClass.getName();

            List<JavaField> fields = javaClass.getFields();

            List<JavaMethod> methods = javaClass.getMethods();

            for (JavaField field : fields) {
                String fieldName = field.getName();
                JavaClass fieldType = field.getType();

                for (JavaMethod method : methods) {
                    String sourceCode = method.getSourceCode();

                    // todo 优化继承关系判断 className.toUpperCase().contains(fieldName.toUpperCase())
                    if ((className.equals(fieldType.toString()) || className.toUpperCase().contains(fieldName.toUpperCase())) && sourceCode.contains(fieldName + "." + (methodName == null ? "" : methodName))) {
                        if (javaClass.getPackageName().contains("service") || javaClass.getPackageName().contains("mapper")) {
                            recInjectFile(file, fullClassName, method.getName(), fileList);
                        } else {
                            System.out.println(fullClassName + "." + method.getName());
                            fileList.add(fullClassName + "." + method.getName());
                        }
                    }
                }
            }
        }
    }

    /**
     * 根据模块路径，查找模块下的所有类
     *
     * @param path
     * @return
     */
    private List<String> files(String path, List<String> fileList) {
        File filePath = new File(path);
        if (filePath.isDirectory()) {
            File[] files = filePath.listFiles();
            for (File file : files) {
                files(file.getAbsolutePath(), fileList);

                if (file.isFile() && file.toString().contains("main") && file.toString().contains("java") && !file.toString().contains("test") && !file.toString().contains("resources")) {
                    fileList.add(file.toString());
                }
            }
        }
        return fileList;
    }

    @Test
    public void filesTest() {
        List<String> fileList = new ArrayList<>();
        List<String> files = files("/Users/admin/Desktop/code/java/thirdparty/qdox/", fileList);
        for (String file : files) {
            System.out.println(file);
        }
    }

    private String[] api() {
        String[] api = new String[]{
                "com.zkzong.api.QdoxClient"
        };
        return api;
    }

}
