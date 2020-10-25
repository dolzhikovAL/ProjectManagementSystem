package com.project.management.services;

import com.project.management.console.View;
import com.project.management.domain.Developer;
import com.project.management.domainDAO.DataCRUD;
import com.project.management.domainDAO.DeveloperDAO;

import java.sql.SQLException;

import static com.project.management.services.InputValidator.inputInteger;
import static com.project.management.services.InputValidator.validateString;

public class DeveloperService {

    private final View view;
    private final DataCRUD<Developer> DeveloperDAO;

    public DeveloperService(View view) {
        DeveloperDAO = new DeveloperDAO();
        this.view = view;
    }


    public void inputDeveloper() {
              Developer developer = enterPositionDeveloper();
        try {
            DeveloperDAO.create(developer);
        } catch (SQLException e) {
            view.write("Can't create  developer with name -- " +developer.getName() + "  " + e.getMessage());
        }
    }
    public void readDeveloper() throws SQLException {
        view.write("Out Developer in format NAME \n" +
                "Salary \n" +
                "SEX \n" +
                "age");
       DeveloperDAO.read();
    }

    public Developer enterPositionDeveloper() {
        view.write("Enter Developer name");
        String name = validateString(view);
        view.write("Enter  Developer salary only numbers available");
        int salary = inputInteger(view);
        view.write("Enter  Developer sex -- male or female");
        String sex = validateString(view);
        view.write("Enter Developer age only numbers available");
        int age = inputInteger(view);
        return (new Developer(name, salary,sex,age));
    }
    public void deleteDeveloper() {
        view.write("Enter Developer name");
        String name = validateString(view);
        try {
            DeveloperDAO.delete(name);
        } catch (SQLException e) {
            view.write("Can't delete  developer with name -- " + name + "  " + e.getMessage());
        }
    }
}
