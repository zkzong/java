package com.example.apache.commons.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Created by Zong on 2017/1/15.
 */
public class ConfigurationTest {
    public static void main(String[] args) throws ConfigurationException {
        Configuration configuration = new PropertiesConfiguration("config.properties");
        String background = configuration.getString("colors.background");
        System.out.println(background);
    }
}
