package com.zakolenko.epam.project2.controller.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Contains the configuration object.
 *
 * @author Roman Zakolenko
 */
public enum Config {
    CONFIG;

    private static final String CONFIG_FILE = "./src/com/zakolenko/epam/project2/controller/config/config.properties";
    private static final String FILE_PATH = "file.path";
    private static final String KEY_WORDS = "key.words";
    private String filePath;
    private String keyWords;

    Config() {
        load();
    }

    public String getFilePath() {
        return filePath;
    }

    public String getKeyWords() {
        return keyWords;
    }

    private void load() {
        Properties properties = new Properties();
        try (InputStream is = new BufferedInputStream(new FileInputStream(CONFIG_FILE))) {
            properties.load(is);
            this.filePath = properties.getProperty(FILE_PATH);
            this.keyWords = properties.getProperty(KEY_WORDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
