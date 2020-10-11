package com.project.management.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DataBaseConnector {


    private static final HikariDataSource ds;


    static {
        HikariConfig config = new HikariConfig();
        final Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            try (InputStream inputStream = classLoader.getResourceAsStream("application.properties")
            ) {
                properties.load(inputStream);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error load application properties");
        }

        config.setJdbcUrl(properties.getProperty("jdbc.url"));
        config.setUsername("jdbc.username");
        config.setPassword("jdbc.password");
        ds= new HikariDataSource(config);
        ds.setMaximumPoolSize(10);
    }


    public static HikariDataSource getConnector() {
        return ds;
    }
}







