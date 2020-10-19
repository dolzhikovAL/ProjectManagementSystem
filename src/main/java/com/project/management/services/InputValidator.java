package com.project.management.services;

import com.project.management.console.View;
import com.project.management.database.DataBaseConnector;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputValidator {

    private static final HikariDataSource connector = DataBaseConnector.getConnector();


    public static String validateString(View view) {
        String value = view.read();
        while (value.trim().isEmpty()) {
            view.write("Enter not empty message ");
            value = view.read();
        }
        return value;
    }

    public static LocalDate validateSLocalDate(View view) {
        boolean flag = true;
        LocalDate date = null;
        while (flag) {
            try {
                date = LocalDate.parse(view.read());
                flag = false;
            } catch (DateTimeParseException e) {
                view.write("Enter correct date in format YYYY-MM-DD");
            }
        }
        return date;
    }

    public static int inputInteger(View view) {
        String value = view.read();
        while (!value.matches("[0-9]*")) {
            view.write("Enter correct value -- only numbers available");
            value = view.read();
        }
        return Integer.parseInt(value);

    }

    public static void tableChoseAsk(View view) {
        view.write("Chose WIth Witch table do you want to work: \n" +
                "company \n" +
                "project \n" +
                "customer \n" +
                "developer \n" +
                "or exit for exit");
    }

    public static void tableCrudAsk(View view) {
        view.write("Please tape one of the next command \n" +
                "for create function type (create) \n" +
                "for update function type (update) \n" +
                "for delete function type (delete) \n" +
                "for read function type (read) \n" +
                "or exit for exit");
    }

    public static void writeOUT(String task) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(task)) {
            ResultSet resultSet = statement.executeQuery();
            int columns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columns; i++) {
                    if ((i+columns-1) % columns == 0) {
                        System.out.println("--------------------------");
                    } else System.out.println(resultSet.getString(i));
                }
            }
            statement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

}



