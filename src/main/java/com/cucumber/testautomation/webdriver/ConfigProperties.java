package com.cucumber.testautomation.webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private Properties properties = new Properties();

    public ConfigProperties(){
    }

    public ConfigProperties(File configFile) {
        try (FileInputStream inputStream = new FileInputStream(configFile)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public Optional<String> getProperty(String key) {
//        String value = properties.getProperty(key);
//        if(value == null)
//            return Optional.empty();
//        return Optional.of(value);
//    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

//    public String get(String key) {
//        return properties.getProperty(key);
//    }
}
