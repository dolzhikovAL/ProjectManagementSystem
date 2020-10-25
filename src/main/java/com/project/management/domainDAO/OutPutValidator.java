package com.project.management.domainDAO;

import com.project.management.database.DataBaseConnector;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OutPutValidator {
    private static final HikariDataSource connector = DataBaseConnector.getConnector();
    private static final Logger LOGGER = LogManager.getLogger(DeveloperDAO.class);

    public static void writeOUT(String task) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(task)) {
            LOGGER.debug(String.format("Start writeOut with task =%s ", task));
            ResultSet resultSet = statement.executeQuery();
            int columns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.println(resultSet.getString(i));
                }
            }
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error(String.format("error in writeOut with task =%s ", task));
            System.out.println(e.getMessage());
        }
    }

    public static void writeOUT(String task, String parameter) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(task)) {
            LOGGER.debug(String.format("Start writeOut report with task =%s ", task));
            statement.setString(1, parameter);
            ResultSet resultSet = statement.executeQuery();
            int columns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                System.out.println();
                for (int i = 1; i <= columns; i++) {
                    System.out.print(resultSet.getString(i) + "    ");
                }
            }
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error(String.format("error in writeOut report with task =%s ", task));
            System.out.println(e.getMessage());
        }
    }
}
