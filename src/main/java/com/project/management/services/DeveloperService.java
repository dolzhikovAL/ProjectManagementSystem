package com.project.management.services;

import com.project.management.console.View;
import com.project.management.domain.Company;
import com.project.management.domain.Customer;
import com.project.management.domain.Developer;
import com.project.management.domainDAO.CompanyDAO;
import com.project.management.domainDAO.DataCRUD;
import com.project.management.domainDAO.DeveloperDAO;

import java.sql.SQLException;

import static com.project.management.services.InputValidator.inputInteger;
import static com.project.management.services.InputValidator.validateString;

public class DeveloperService {

    private final View view;
    private DataCRUD<Developer> DeveloperDAO;

    public DeveloperService(View view) {
        DeveloperDAO = new DeveloperDAO();
        this.view = view;
    }


    public void inputDeveloper() {

        view.write("Enter Developer name");
        String name = validateString(view);
        view.write("Enter  Developer sex -- male or female");
        String sex = validateString(view);
        view.write("Enter  Developer salary only numbers available");
        int salary = inputInteger(view);
        view.write("Enter Developer age only numbers available");
        int age = inputInteger(view);
        Developer developer = new Developer(name, sex,salary,age);
        try {
            DeveloperDAO.create(developer);
        } catch (SQLException e) {
            view.write("Can't create  customer with name -- " + name + "  " + e.getMessage());
        }
    }
    public void readDeveloper() throws SQLException {
        view.write("Out Customers in format NAME \n" +
                "Salary \n" +
                "SEX \n" +
                "age");
       DeveloperDAO.read();
    }
}
