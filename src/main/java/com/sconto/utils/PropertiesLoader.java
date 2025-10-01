package com.sconto.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static final String PROF_FILE = "/test.properties";

    private PropertiesLoader() {
    }
    public static String loadProperty(String name) throws IOException {
        Properties properties = new Properties();

        try (InputStream input = PropertiesLoader.class.getResourceAsStream(PROF_FILE)) {
            if (input == null) {
                throw new IOException("Файл свойств не найден: " + PROF_FILE);
            }
            properties.load(input);
        }

        return properties.getProperty(name);
    }
}
