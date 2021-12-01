package com.epam.tc.hw9.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static Properties prop;

    public PropertiesReader() {

    }

    public static String getProperty(String getData) {
        String data="";
        try {
            prop = new Properties();
            prop.load(new FileInputStream(System.getProperty("user.dir")
                    + "/src/test/resources/com.epam.tc.hw9/test.properties"));
            data = prop.getProperty(getData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
