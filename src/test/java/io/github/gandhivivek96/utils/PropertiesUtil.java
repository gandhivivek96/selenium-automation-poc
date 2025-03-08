package io.github.gandhivivek96.utils;

import io.github.gandhivivek96.constants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    public static String readProperty(Env env, String property) {

        File propFile = new File(System.getProperty("user.dir")+"/config/"+env+".properties");
        FileReader fileReader = null;
        Properties properties;
        try {
            fileReader = new FileReader(propFile);
           properties = new Properties();
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value = properties.getProperty(property.toUpperCase());

        return value;

    }



}
