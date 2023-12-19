package org.example.demo.dao;

import java.io.IOException;
import java.util.Properties;

public class ConnectionProperty {
    public static final String CONFIG_NAME = "config.properties";

    public static Properties PROPERTY_CONFIG = new Properties();

    public ConnectionProperty() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        PROPERTY_CONFIG.load(classLoader.getResourceAsStream("org/example/demo/config/" + CONFIG_NAME));
    }

    public static String getProperty (String property){
        return PROPERTY_CONFIG.getProperty(property);
    }

}