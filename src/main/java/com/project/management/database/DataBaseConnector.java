package com.project.management.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DataBaseConnector {


    private static final HikariDataSource ds;
    private static final Logger LOGGER = LogManager.getLogger(DataBaseConnector.class);


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
            LOGGER.error("Error loading application properties");
            throw new RuntimeException("Error load application properties");
        }

        config.setJdbcUrl(properties.getProperty("jdbc.url"));
        config.setUsername(properties.getProperty("jdbc.username"));
        config.setPassword(properties.getProperty("jdbc.password"));
        ds = new HikariDataSource(config);
        ds.setMaximumPoolSize(10);
    }


    public static HikariDataSource getConnector() {
        return ds;
    }
}







