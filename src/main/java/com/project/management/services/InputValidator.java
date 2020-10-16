package com.project.management.services;

import com.project.management.console.View;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputValidator {


    public static String validateString(View view) {
        String value = view.read();
        while (value.trim().isEmpty()) {
            view.write("Enter not empty message ");
            value=view.read();
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
        view.write("Chose what you want to create: \n" +
                "company \n" +
                "project \n" +
                "customer \n" +
                "developer \n" +
                "or exit for exit");
    }

}



