package com.qatest.reusablecomponents;

import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    static Properties properties = new Properties();

    public static String getPropertyByKey(String key) throws IOException {
        properties.load(new FileReader("src/main/resources/config.properties"));
        String value = properties.getProperty(key);
        if (StringUtils.isEmpty(value)) {
            throw new RuntimeException("Empty value for property key");
        }
        return value;
    }
}
