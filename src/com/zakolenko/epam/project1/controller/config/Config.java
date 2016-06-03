package com.zakolenko.epam.project1.controller.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum Config {
    CONFIG;

    private static final String CONFIG_FILE = "./src/com/zakolenko/epam/project1/controller/config/config.properties";
    private static final String KYIVSTAR_FILE = "kyivstar.tariffs";
    private static final String MTS_FILE = "mts.tariffs";
    private String kyivstarFile;
    private String mtsFile;

    Config() {
        load();
    }

    public String getKyivstarFile() {
        return kyivstarFile;
    }

    public String getMtsFile() {
        return mtsFile;
    }

    private void load() {
        Properties properties = new Properties();
        try (InputStream in = new BufferedInputStream(new FileInputStream(CONFIG_FILE))) {
            properties.load(in);
            kyivstarFile = properties.getProperty(KYIVSTAR_FILE);
            mtsFile = properties.getProperty(MTS_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
