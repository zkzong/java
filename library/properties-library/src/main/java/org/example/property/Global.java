package org.example.property;

/**
 * 全局配置类
 */
public class Global {

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader propertiesLoader;

    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        if (propertiesLoader == null) {
            propertiesLoader = new PropertiesLoader("application.properties");
        }
        return propertiesLoader.getProperty(key);
    }

    /**
     * 获取上传文件相对路径跟路径
     *
     * @return
     */
    public static String getUploadPath() {
        return getConfig("uploadPath");
    }

}
